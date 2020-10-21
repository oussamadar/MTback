package com.virementmultipe.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
* author @kamal Abderhmane
* */
@Entity
public class Beneficiare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    @NotBlank(message = "Nom est obligatoire")
    private String nom ;

    @NotBlank(message = "prenom  est Obligatoire")
    private String prenom ;


    @Column(unique = true,nullable = false)
    private Integer numeroCompte;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "beneficiare", orphanRemoval = true)
    @JsonIgnore
    private List<VirementMultipeBenificiare> virementMultipeBenificiareList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Abonne abonne;

    private String abonneLeader;

    public String getAbonneLeader() {
        return abonneLeader;
    }

    public Beneficiare setAbonneLeader(String abonneLeader) {
        this.abonneLeader = abonneLeader;
        return this;
    }



    public Abonne getAbonne() {
        return abonne;
    }

    public Beneficiare setAbonne(Abonne abonne) {
        this.abonne = abonne;
        return this;
    }

    public Integer getNumeroCompte() {
        return numeroCompte;
    }

    public List<VirementMultipeBenificiare> getVirementMultipeBenificiareList() {
        return virementMultipeBenificiareList;
    }

    public Beneficiare setVirementMultipeBenificiareList(List<VirementMultipeBenificiare> virementMultipeBenificiareList) {
        this.virementMultipeBenificiareList = virementMultipeBenificiareList;
        return this;
    }

    public Beneficiare setNumeroCompte(Integer numeroCompte) {
        this.numeroCompte = numeroCompte;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Beneficiare setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Beneficiare setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public Beneficiare setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }
}
