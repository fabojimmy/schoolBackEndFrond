package com.demoperson.school.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demoperson.school.model.Niveau;

@Service
public interface NiveauService {

    public ResponseEntity<List<Niveau>> getNivea();
    public ResponseEntity<String>addNivea(Map<String,String>requestMap);
    public ResponseEntity<String>updateNive(Map<String,String>requestMap);
    public ResponseEntity<String>supprimerNiveau(Long id);
    public ResponseEntity<Niveau>getByid(Long id);


}
