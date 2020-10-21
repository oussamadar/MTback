package com.virementmultipe.demo.service;

import com.virementmultipe.demo.entities.*;
import com.virementmultipe.demo.exception.*;
import com.virementmultipe.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class VirementService {


    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private VirementRepository virementRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AbonneRepository abonneRepository;

    @Autowired
    private CompteService compteService;

    @Autowired
    private VirementMultipeBeneficiareService virementMultipeBeneficiareService;



    public void saveVirement(Virement virement) {
        if(virement.getVirementMultipe().getNombrBeneficiare()==null||
                virement.getVirementMultipe().getVirementMultipeBenificiareList().size()!=virement.getVirementMultipe().getNombrBeneficiare()){
            throw new VirementMultipeException("verifie votre nombre de beneficiare ");
        }

        Compte compte = compteService.VirementOperation(virement.getCompte(),virement.getMontant());
        virement.setCompte(compte);
        VirementMultipe virementMultipe = new VirementMultipe();
        virementMultipe.setNombrBeneficiare(virement.getVirementMultipe().getNombrBeneficiare());

        // function return List
        List<VirementMultipeBenificiare> multipeBenificiareList=virementMultipeBeneficiareService.VirementMultipeBeneficiare(
                virement.getVirementMultipe().getVirementMultipeBenificiareList(),virementMultipe,virement.getMontant());

        //sauvegarder les donnees
        virementMultipe.setVirementMultipeBenificiareList(multipeBenificiareList);
        virement.setVirementMultipe(virementMultipe);
        virementMultipe.setVirement(virement);
    }
    public Iterable<Virement> getAllVirement() {
        return virementRepository.findAll();
    }

    public Virement VerificationPassword(String password,String username,Virement virement){
        if(password==null){
            throw new PasswordValidationException("Password Invalid");
        }
        Abonne abonne = abonneRepository.findAbonneByUsername(username);
        if(bCryptPasswordEncoder.matches(password,abonne.getPassword())) {
            saveVirement(virement);
            return virementRepository.save(virement);
        }
        else throw new PasswordValidationException("Password Invalid");
    }
}
