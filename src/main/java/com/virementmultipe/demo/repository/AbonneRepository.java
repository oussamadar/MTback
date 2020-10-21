package com.virementmultipe.demo.repository;

import com.virementmultipe.demo.entities.Abonne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonneRepository extends CrudRepository<Abonne,Long> {
    Abonne findAbonneByUsername(String username);
    @Override
    Iterable<Abonne> findAll();


}
