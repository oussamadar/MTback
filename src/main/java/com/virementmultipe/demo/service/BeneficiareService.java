package com.virementmultipe.demo.service;

import com.virementmultipe.demo.entities.Abonne;
import com.virementmultipe.demo.entities.Beneficiare;
import com.virementmultipe.demo.exception.BenficireNotExistException;
import com.virementmultipe.demo.exception.UsernameAlreadyExistsException;
import com.virementmultipe.demo.repository.AbonneRepository;
import com.virementmultipe.demo.repository.BeneficiareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class BeneficiareService {

    @Autowired
    private BeneficiareRepository beneficiareRepository;

    @Autowired
    private AbonneRepository abonneRepository;

    public Beneficiare saveBenef(Beneficiare beneficiare,String username){
        try{
            Abonne abonne = abonneRepository.findAbonneByUsername(username);
            beneficiare.setAbonneLeader(username);
            beneficiare.setAbonne(abonne);
            return beneficiareRepository.save(beneficiare);
        }catch(Exception e){
            throw new UsernameAlreadyExistsException("Username " +username+" already exists");
        }
    }
    //Verfie si le Benef exist ou pas

    public Beneficiare findBenfi(Beneficiare beneficiare){
        try{
            Beneficiare beneficiare1= beneficiareRepository.findBeneficiareByNumeroCompte(beneficiare.getNumeroCompte());

            if(beneficiare1==null){
                throw new BenficireNotExistException("Beneficiare n exist pas ");
            }
            return  beneficiare1;
        }catch (Exception e){
            throw new BenficireNotExistException("Beneficiare n exist pas ");
        }

    }

    public Iterable<Beneficiare> getAllBeneficiare(String username ) {
        return beneficiareRepository.findAllByAbonneLeader(username);
    }
}
