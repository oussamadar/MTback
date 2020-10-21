package com.virementmultipe.demo.web;

import com.virementmultipe.demo.entities.Beneficiare;
import com.virementmultipe.demo.entities.Compte;
import com.virementmultipe.demo.repository.CompteRepository;
import com.virementmultipe.demo.service.BeneficiareService;
import com.virementmultipe.demo.service.CompteService;
import com.virementmultipe.demo.validator.ErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin
public class CompteController {


    @Autowired
    private CompteService  compteService;
    @Autowired
    private ErrorValidation errorValidation;

    @PostMapping("{username}")
    public ResponseEntity<?> saveCompte(@Valid @RequestBody Compte compte, BindingResult result, @PathVariable String username ){
        ResponseEntity<?> errorMap = errorValidation.MapValidationService(result);
        if(errorMap != null) return errorMap;
        compteService.saveCompte(compte,username);
        return new ResponseEntity<Compte>(compte, HttpStatus.CREATED);
    }
    @GetMapping("/{username}")
    public Iterable<Compte> getAllCompte(@PathVariable String username ){
        return compteService.getAllCompte(username);
    }
}
