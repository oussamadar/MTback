package com.virementmultipe.demo.service;

import com.virementmultipe.demo.entities.Abonne;
import com.virementmultipe.demo.exception.UsernameAlreadyExistsException;
import com.virementmultipe.demo.repository.AbonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AbonneService  {

    @Autowired
    private AbonneRepository abonneRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Abonne saveAbonne(Abonne abonne){
        try{
            abonne.setPassword(bCryptPasswordEncoder.encode(abonne.getPassword()));
            abonne.setUsername(abonne.getUsername());
            abonne.setConfirmPassword("");
            return abonneRepository.save(abonne);
        }catch (Exception e){
            throw new UsernameAlreadyExistsException("Username " +abonne.getUsername()+" already exists");
        }

    }

    public Iterable<Abonne> getAllAbonne() {
        return abonneRepository.findAll();
    }
}
