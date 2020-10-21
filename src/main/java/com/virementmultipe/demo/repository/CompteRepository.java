package com.virementmultipe.demo.repository;

import com.virementmultipe.demo.entities.Beneficiare;
import com.virementmultipe.demo.entities.Compte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends CrudRepository<Compte,Long> {
    Iterable<Compte> findAllByAbonneLeader(String username);

    Compte findCompteByNumeroCompte(String numeroCompte);

}
