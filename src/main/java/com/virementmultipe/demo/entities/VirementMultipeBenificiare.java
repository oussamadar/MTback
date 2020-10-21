package com.virementmultipe.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
public class VirementMultipeBenificiare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    @NotNull(message = "montant is required")
    private BigDecimal montant;

    //If you have any lazy loaded properties having a relationship. You can use this annotation at top of the property.
    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Beneficiare beneficiare;

    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore
    private VirementMultipe virementMultipe;



























    public VirementMultipe getVirementMultipe() {
        return virementMultipe;
    }

    public VirementMultipeBenificiare setVirementMultipe(VirementMultipe virementMultipe) {
        this.virementMultipe = virementMultipe;
        return this;
    }



    public Beneficiare getBeneficiare() {
        return beneficiare;
    }

    public VirementMultipeBenificiare setBeneficiare(Beneficiare beneficiare) {
        this.beneficiare = beneficiare;
        return this;
    }

    public Long getId() {
        return Id;
    }

    public VirementMultipeBenificiare setId(Long id) {
        Id = id;
        return this;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public VirementMultipeBenificiare setMontant(BigDecimal montant) {
        this.montant = montant;
        return this;
    }
}
