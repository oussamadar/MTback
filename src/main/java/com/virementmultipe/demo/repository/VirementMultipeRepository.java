package com.virementmultipe.demo.repository;

import com.virementmultipe.demo.entities.VirementMultipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirementMultipeRepository extends CrudRepository<VirementMultipe,Long> {
}
