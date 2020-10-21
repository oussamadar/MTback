package com.virementmultipe.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "Numero de compte est obligatoire ")
    @Column(nullable = false,unique = true,updatable = false)
    private String numeroCompte ;

    private String Intitule;

    private BigDecimal soldeComptable;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "compte", orphanRemoval = true)
    @JsonIgnore
    private List<Virement> virementList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Abonne abonne;

    private  String abonneLeader;


    public String getAbonneLeader() {
        return abonneLeader;
    }

    public Compte setAbonneLeader(String abonneLeader) {
        this.abonneLeader = abonneLeader;
        return this;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public Compte setAbonne(Abonne abonne) {
        this.abonne = abonne;
        return this;
    }

    public Long getId() {
        return Id;
    }

    public Compte setId(Long id) {
        Id = id;
        return this;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public Compte setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
        return this;
    }

    public String getIntitule() {
        return Intitule;
    }

    public Compte setIntitule(String intitule) {
        Intitule = intitule;
        return this;
    }

    public BigDecimal getSoldeComptable() {
        return soldeComptable;
    }

    public Compte setSoldeComptable(BigDecimal soldeComptable) {
        this.soldeComptable = soldeComptable;
        return this;
    }

    public List<Virement> getVirementList() {
        return virementList;
    }

    public Compte setVirementList(List<Virement> virementList) {
        this.virementList = virementList;
        return this;
    }
}
