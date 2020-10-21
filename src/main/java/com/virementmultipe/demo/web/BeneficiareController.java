package com.virementmultipe.demo.web;

import com.virementmultipe.demo.entities.Abonne;
import com.virementmultipe.demo.entities.Beneficiare;
import com.virementmultipe.demo.service.BeneficiareService;
import com.virementmultipe.demo.validator.ErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/beneficiare")
@CrossOrigin
public class BeneficiareController{

    @Autowired
    private BeneficiareService beneficiareService;
    @Autowired
    private ErrorValidation errorValidation;
    @PostMapping("/{username}")
    public ResponseEntity<?> saveBenif(@Valid @RequestBody Beneficiare beneficiare, BindingResult result,@PathVariable String username ){
        ResponseEntity<?> errorMap = errorValidation.MapValidationService(result);
        if(errorMap != null) return errorMap;
        beneficiareService.saveBenef(beneficiare,username);
        return new ResponseEntity<Beneficiare>(beneficiare, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public Iterable<Beneficiare> getAllBeneficiare(@PathVariable String username ){
        return beneficiareService.getAllBeneficiare(username);
    }


}
