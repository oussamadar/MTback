package com.virementmultipe.demo.repository;

import com.virementmultipe.demo.entities.VirementMultipeBenificiare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirementMultipeBenificiareRepository extends CrudRepository<VirementMultipeBenificiare,Long> {
    VirementMultipeBenificiare findByBeneficiare_NumeroCompte(String numeroCompte);

    @Override
    Iterable<VirementMultipeBenificiare> findAll();
}
