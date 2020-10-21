package com.virementmultipe.demo.service;

import com.virementmultipe.demo.entities.Abonne;
import com.virementmultipe.demo.entities.Beneficiare;
import com.virementmultipe.demo.entities.Compte;
import com.virementmultipe.demo.exception.CompteNotExistException;
import com.virementmultipe.demo.exception.VirementMontantException;
import com.virementmultipe.demo.repository.AbonneRepository;
import com.virementmultipe.demo.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private AbonneRepository abonneRepository;

    public Compte saveCompte(Compte compte, String username) {
        Abonne abonne = abonneRepository.findAbonneByUsername(username);
        if(findCompte(compte)!=null){
           throw new CompteNotExistException("compte deja Exist ");
        }
        compte.setAbonne(abonne);
        compte.setAbonneLeader(username);
        return compteRepository.save(compte);
    }

    public Compte findCompte(Compte compte){
        Compte compte1= compteRepository.findCompteByNumeroCompte(compte.getNumeroCompte());
        return compte1;
    }
    public BigDecimal setMontant(BigDecimal compteMontant,BigDecimal beneMontant){

        if(beneMontant.compareTo(BigDecimal.ZERO) <= 0){
            throw  new VirementMontantException("Montant à Verifier");
        }
            if(compteMontant.compareTo(beneMontant)<0 ){
                throw  new VirementMontantException("Votre solde est insufusant ");
            }
         return compteMontant.subtract(beneMontant);
        }
    public Compte VirementOperation(Compte compte, BigDecimal montant){
        Compte compte1=findCompte(compte);
        if(compte1==null){
            throw new CompteNotExistException("Selectionnez un Compte  ");

        }
        compte1.setSoldeComptable(setMontant(compte1.getSoldeComptable(),montant));
        return compte1;
    }



        public Iterable<Compte> getAllCompte(String username) {
            return compteRepository.findAllByAbonneLeader(username);
    }
}
