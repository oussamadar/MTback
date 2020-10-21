package com.virementmultipe.demo.web;

import com.virementmultipe.demo.entities.Abonne;
import com.virementmultipe.demo.entities.Beneficiare;
import com.virementmultipe.demo.payload.JWTLoginSuccessResponse;
import com.virementmultipe.demo.payload.LoginRequest;
import com.virementmultipe.demo.repository.AbonneRepository;
import com.virementmultipe.demo.security.JwtTokenProvider;
import com.virementmultipe.demo.service.AbonneService;
import com.virementmultipe.demo.validator.ErrorValidation;
import com.virementmultipe.demo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

import static com.virementmultipe.demo.security.SecurityConstant.TOKEN_PREFIX;

@RestController
@RequestMapping("api/abonne")
@CrossOrigin
public class AbonneController {

    @Autowired
    private AbonneService abonneService;

    @Autowired
    private ErrorValidation errorValidation;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserValidator userValidator;

    @PostMapping("/register")
    public ResponseEntity<?> saveAbonne(@Valid @RequestBody Abonne abonne, BindingResult result){
        userValidator.validate(abonne,result);
        ResponseEntity<?> errorMap = errorValidation.MapValidationService(result);
        if(errorMap != null) return errorMap;
        abonneService.saveAbonne(abonne);
        return new ResponseEntity<Abonne>(abonne, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        // Validate passwords match
        ResponseEntity<?> errorMap = errorValidation.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Authentication authentication  = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt =TOKEN_PREFIX+jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTLoginSuccessResponse(true,jwt));

    }

    @GetMapping("/all")
    public Iterable<Abonne> getAllAbonne(){
        return abonneService.getAllAbonne();
    }
}
