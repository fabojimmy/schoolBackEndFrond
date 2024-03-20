package com.demoperson.school.restimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.demoperson.school.filters.JwtUtils;
import com.demoperson.school.model.Users;
import com.demoperson.school.respository.UsersRes;
import com.demoperson.school.rest.AuthentificationSchool;

@Service
public class AuthentificationSchoolRestImpl implements AuthentificationSchool{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsersRes usersre;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public ResponseEntity<?> login(Map<String, String> reqMap) {
      try {
          // TODO Auto-generated method stub
            List<GrantedAuthority> Lister=new ArrayList<>();

            Users users=usersre.findUsersEmail(reqMap.get("email"));
            Lister.add(new SimpleGrantedAuthority(users.getRole().getLibelle()));


             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqMap.get("email"),reqMap.get("password"),Lister));
              System.out.println(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqMap.get("email"),reqMap.get("password"),Lister)));              

              String token = jwtUtils.generateToken(reqMap.get("email"),users.getRole().getLibelle());
              
              return new ResponseEntity<>("{\"token\":\""+token+"\"}",HttpStatus.ACCEPTED);


        } catch (Exception e) {
            e.printStackTrace();
    }
      
      return null;
    }


    
}
