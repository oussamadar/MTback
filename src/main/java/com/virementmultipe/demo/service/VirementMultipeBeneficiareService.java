package com.virementmultipe.demo.service;

import com.virementmultipe.demo.entities.Beneficiare;
import com.virementmultipe.demo.entities.VirementMultipe;
import com.virementmultipe.demo.entities.VirementMultipeBenificiare;
import com.virementmultipe.demo.exception.VirementMontantException;
import com.virementmultipe.demo.repository.BeneficiareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class VirementMultipeBeneficiareService {

    @Autowired
    private BeneficiareService beneficiareService;

    //fucnction traiter la list des VirementMultipe Benef
    public List<VirementMultipeBenificiare> VirementMultipeBeneficiare(List<VirementMultipeBenificiare> multipeBeneficiareServices,VirementMultipe virementMultipe
            , BigDecimal montant){

        List<VirementMultipeBenificiare> multipeBenificiareList = new ArrayList<>();
        BigDecimal somme = BigDecimal.ZERO;
        for(int i=0; i<multipeBeneficiareServices.size(); i++) {
            //verifie si le montant entrant est >=0
            if(multipeBeneficiareServices.get(i).getMontant() == null||multipeBeneficiareServices.get(i).getMontant().compareTo(BigDecimal.ZERO) <= 0){
                throw  new VirementMontantException("Montant à Verifie ");
            }
             somme = somme.add(multipeBeneficiareServices.get(i).getMontant());

            VirementMultipeBenificiare virementMultipeBenificiare = new VirementMultipeBenificiare();
            Beneficiare beneficiare = beneficiareService.findBenfi(
                    multipeBeneficiareServices.get(i).getBeneficiare());
            virementMultipeBenificiare.setBeneficiare(beneficiare);
            virementMultipeBenificiare.setMontant(multipeBeneficiareServices.get(i).getMontant());
            virementMultipeBenificiare.setVirementMultipe(virementMultipe);
            multipeBenificiareList.add(virementMultipeBenificiare);
        }
        if(somme.compareTo(montant)!=0){
            throw new VirementMontantException("montant verser doit etre egal au montants des benef ");
        }

        return multipeBenificiareList;
    }
}
