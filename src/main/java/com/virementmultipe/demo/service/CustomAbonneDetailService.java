package com.virementmultipe.demo.service;

import com.virementmultipe.demo.entities.Abonne;
import com.virementmultipe.demo.repository.AbonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomAbonneDetailService implements UserDetailsService {

    @Autowired
    private AbonneRepository abonneRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Abonne abonne = abonneRepository.findAbonneByUsername(username);
        if (abonne==null) throw new UsernameNotFoundException("Abonne Not Found ");
        return abonne;
    }
}
