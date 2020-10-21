package com.virementmultipe.demo.web;

import com.virementmultipe.demo.entities.*;
import com.virementmultipe.demo.service.VirementService;
import com.virementmultipe.demo.validator.ErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("api/virement")
@CrossOrigin
public class VirementController {

    public Virement virement = new Virement();
    @Autowired
    private VirementService virementService;

    @Autowired
    private ErrorValidation errorValidation;

    @PostMapping("")
    public ResponseEntity<?> saveVirement(@Valid @RequestBody Virement virement, BindingResult result){
        ResponseEntity<?> errorMap = errorValidation.MapValidationService(result);
        if(errorMap != null) return errorMap;
        //tester les erreur
        virementService.saveVirement(virement);
        this.virement=virement;
        return new ResponseEntity<>(this.virement, HttpStatus.OK);
    }

    @PostMapping("/verification")
    public Virement Verification(@Valid @RequestBody VerificationClass password, Principal principal){
        return virementService.VerificationPassword(password.getVerificationPass(),principal.getName(),this.virement);
    }

    @GetMapping("")
    public Iterable<Virement> getVirement(){
        return virementService.getAllVirement();
    }
}
