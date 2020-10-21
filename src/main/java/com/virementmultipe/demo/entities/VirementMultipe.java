package com.virementmultipe.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VirementMultipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    @NotNull(message = "Please Enter nombre de benefecier")
    private Integer nombrBeneficiare;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "virementMultipe",orphanRemoval = true)
    private List<VirementMultipeBenificiare> virementMultipeBenificiareList= new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="virement_id",nullable = false)
    @JsonIgnore
    private Virement virement;


    public Virement getVirement() {
        return virement;
    }

    public VirementMultipe setVirement(Virement virement) {
        this.virement = virement;
        return this;
    }

    public List<VirementMultipeBenificiare> getVirementMultipeBenificiareList() {
        return virementMultipeBenificiareList;
    }

    public VirementMultipe setVirementMultipeBenificiareList(List<VirementMultipeBenificiare> virementMultipeBenificiareList) {
        this.virementMultipeBenificiareList = virementMultipeBenificiareList;
        return this;
    }

    public Long getId() {
        return Id;
    }

    public VirementMultipe setId(Long id) {
        Id = id;
        return this;
    }

    public Integer getNombrBeneficiare() {
        return nombrBeneficiare;
    }

    public VirementMultipe setNombrBeneficiare(Integer nombrBeneficiare) {
        this.nombrBeneficiare = nombrBeneficiare;
        return this;
    }
}
