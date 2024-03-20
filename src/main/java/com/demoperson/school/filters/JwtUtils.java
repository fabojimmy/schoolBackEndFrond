package com.demoperson.school.filters;

import java.security.Key;
import java.util.Date;
import java.util.*;
import java.util.Map;
import java.util.Base64.Decoder;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtils {
     public static final String SECRET="jhqjsjkqhsgpahzulk5qsq5s84sq2s55qs5qshjqvsqyuyuzbauybuyuyquysuysqsqsqjnsk5s69s5sq54s3246sq";

    public String extractUsername(String token)
    {
        return extractClaim(token,Claims::getSubject);
    }
    public Date extractExpiration(String token){

        return extractClaim(token,Claims::getExpiration);
    }

    //Ce code extrait une revendication spécifique d'un jeton JWT en utilisant une fonction de résolution de revendications fourni
    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Ce code extrait toutes les revendications (claims) d'un jeton JWT (JSON Web Token) donné
    private Claims extractAllClaims(String token) {
        return Jwts
        // La méthode parserBuilder() de la classe Jwts retourne un objet JwtParserBuilder qui permet de configurer le parseur JWT.
               .parserBuilder()
        // Ensuite, la méthode setSigningKey(getSignKey()) est utilisée pour spécifier la clé de signature utilisée pour valider le jeton JWT. La méthode getSignKey() est supposée retourner la clé de signature appropriée (vous devrez l'implémenter ou la remplacer par une valeur réelle).
               .setSigningKey(getSignKey())
        //La méthode build() est appelée pour créer un objet JwtParser à partir du JwtParserBuilder configuré.
               .build()
        // La méthode parseClaimsJws(token) est utilisée pour analyser le jeton JWT spécifié et renvoie un objet Jws<Claims> qui contient à la fois les revendications extraites et la signature originale du jeton.
               .parseClaimsJws(token)
        //Enfin, la méthode getBody() est appelée sur l'objet Jws<Claims> pour obtenir un objet Claims contenant les revendications extraites du jeton JWT
               .getBody();
       

    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username,String role) {
            Map<String, Object>claims= new HashMap<>();
            claims.put("role",role);
            return this.createToken(claims, username);
    }

    private String createToken(Map<String,Object>claim,String username) {

        return Jwts.builder()
                  .setClaims(claim)
                  .setSubject(username)
                  .setIssuedAt(new Date(System.currentTimeMillis()))
                  .setExpiration(new Date(System.currentTimeMillis()+1000*60*1))
                  .signWith(getSignKey(),SignatureAlgorithm.HS256).compact();
    

    }

    public Boolean validateToken(String token,UserDetails userDetails){

        final String username=extractUsername(token);
        return(username.equals(userDetails.getUsername())&&!isTokenExpired(token));
    }


    private Key getSignKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
            return Keys.hmacShaKeyFor(keyBytes);
    }         

}
