package com.demoperson.school.serviceimpl;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demoperson.school.service.NiveauService;

@Service
public class NiveauServiceImp implements NiveauService {

    @Override
    public ResponseEntity<?> add(Map<String, String> reqMap) {
        // TODO Auto-generated method stub
        return new ResponseEntity<>("BonjourNiveau",HttpStatus.OK);
    }
    
}
