package com.virementmultipe.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Virement  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    @NotBlank(message = "motif est obligatoire")
    private String motif ;

    private String status ;
    @NotNull(message = "Please enter montant")
    private BigDecimal montant ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateCre;

    //The value of the field or property must be a date in the future.
    @Future
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateExce;
    @NotNull(message = "svp Selectionner un Compte")
    @ManyToOne(fetch = FetchType.EAGER)
    private Compte compte;

    @NotNull(message = "Please enter Virement Multipe")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "virement")
    private VirementMultipe virementMultipe;

    @PrePersist
    protected void onCreate(){
        this.dateCre=new Date();
    }



    public String getStatus() {
        return status;
    }

    public Virement setStatus(String status) {
        this.status = status;
        return this;
    }

    public Compte getCompte() {
        return compte;
    }

    public Virement setCompte(Compte compte) {
        this.compte = compte;
        return this;
    }

    public VirementMultipe getVirementMultipe() {
        return virementMultipe;
    }

    public Virement setVirementMultipe(VirementMultipe virementMultipe) {
        this.virementMultipe = virementMultipe;
        return this;
    }

    public Long getId() {
        return Id;
    }

    public Virement setId(Long id) {
        Id = id;
        return this;
    }

    public String getMotif() {
        return motif;
    }

    public Virement setMotif(String motif) {
        this.motif = motif;
        return this;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public Virement setMontant(BigDecimal montant) {
        this.montant = montant;
        return this;
    }

    public Date getDateCre() {
        return dateCre;
    }

    public Virement setDateCre(Date dateCre) {
        this.dateCre = dateCre;
        return this;
    }

    public Date getDateExce() {
        return dateExce;
    }

    public Virement setDateExce(Date dateExce) {
        this.dateExce = dateExce;
        return this;
    }
}
