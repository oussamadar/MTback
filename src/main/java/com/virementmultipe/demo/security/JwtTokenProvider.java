package com.virementmultipe.demo.security;

import com.virementmultipe.demo.entities.Abonne;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.virementmultipe.demo.security.SecurityConstant.EXPIRATION_TIME;
import static com.virementmultipe.demo.security.SecurityConstant.SECRET;

@Component
public class JwtTokenProvider  {

    //generate token
    public String generateToken(Authentication authentication){
        Abonne user = (Abonne) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME);
        String userId=Long.toString((user.getId()));
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",Long.toString(user.getId()));
        claims.put("username",user.getUsername());
        claims.put("nom",user.getNom());

        return Jwts.builder().setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,SECRET)
                .compact();
    }

    //valid Token
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            System.out.println("Invalid JWT Signature");
        }catch (MalformedJwtException ex){
            System.out.println("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            System.out.println("Expired JWT token");
        }catch (UnsupportedJwtException ex){
            System.out.println("Unsupported JWT token");
        }catch (IllegalArgumentException ex){
            System.out.println("JWT claims string is empty");
        }
        return false;
    }



    public String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return (String) claims.get("username");
    }

}
