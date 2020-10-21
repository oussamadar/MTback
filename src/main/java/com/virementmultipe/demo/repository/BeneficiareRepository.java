package com.virementmultipe.demo.repository;

import com.virementmultipe.demo.entities.Beneficiare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiareRepository extends CrudRepository<Beneficiare,Long> {
    Iterable<Beneficiare> findAllByAbonneLeader(String username);
    @Override
    Iterable<Beneficiare> findAll();
    Beneficiare findBeneficiareByNumeroCompte(Integer numeroCompte);
}
