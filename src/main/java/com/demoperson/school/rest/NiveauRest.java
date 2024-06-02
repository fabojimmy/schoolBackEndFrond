package com.demoperson.school.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoperson.school.model.Niveau;
import com.demoperson.school.model.Users;

/**
 * Niveau
 */

 @RestController
 @RequestMapping("niveau")
public interface NiveauRest {

    @PostMapping("/add")
    public ResponseEntity<String>addNiv(@RequestBody Map<String,String>requestMap);

    @GetMapping("/getNivea")
    public ResponseEntity<List<Niveau>>getNivea();

    @PostMapping("/updateNivea")
    public ResponseEntity<String>updateNive(@RequestBody Map<String,String>requestMap);
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>supprimerNiveau(@PathVariable String id);
    @GetMapping ("/getByid/{id}")
    public ResponseEntity<Niveau>getByid(@PathVariable String id);

    
}