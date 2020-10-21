package com.virementmultipe.demo.repository;

import com.virementmultipe.demo.entities.Abonne;
import com.virementmultipe.demo.entities.Virement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirementRepository extends CrudRepository<Virement,Long> {

    @Override
    Iterable<Virement> findAll();
}
