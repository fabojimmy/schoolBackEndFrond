package com.demoperson.school.restimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demoperson.school.rest.NiveauRest;
import com.demoperson.school.service.NiveauService;

@Service
public class NiveauRestImpl implements NiveauRest{

    @Autowired
    private NiveauService niveauService;

    @Override
    public ResponseEntity<?> add(Map<String, String> reqMap) {
        // TODO Auto-generated method stub

        try {

            return niveauService.add(reqMap);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
    
}
