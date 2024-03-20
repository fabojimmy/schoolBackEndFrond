package com.demoperson.school.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Niveau
 */

 @RestController
 @RequestMapping("/niveau")
public interface NiveauRest {

    @PostMapping("/add")
    public ResponseEntity<?>add(@RequestBody Map<String,String>reqMap);

    
}