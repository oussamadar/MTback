package com.virementmultipe.demo.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Abonne implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    private String nom;

    private String prenom;

    @NotBlank(message = "Username is required")
    @Column(unique = true,nullable = false)
    private String username ;



    @NotBlank(message = "Password field is required")
    private String password;

    @Transient
    private String confirmPassword;


    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "abonne", orphanRemoval = true)
    private List<Beneficiare>  beneficiareList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "abonne", orphanRemoval = true)
    private List<Compte>  compteList = new ArrayList<>();


    public List<Beneficiare> getBeneficiareList() {
        return beneficiareList;
    }

    public Abonne setBeneficiareList(List<Beneficiare> beneficiareList) {
        this.beneficiareList = beneficiareList;
        return this;
    }

    public List<Compte> getCompteList() {
        return compteList;
    }

    public Abonne setCompteList(List<Compte> compteList) {
        this.compteList = compteList;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Abonne setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public Abonne setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public Long getId() {
        return Id;
    }

    public Abonne setId(Long id) {
        Id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Abonne setUsername(String username) {
        this.username = username;
        return this;
    }
    public String getPassword() {
        return password;
    }

    public Abonne setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public Abonne setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
