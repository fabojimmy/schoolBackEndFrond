package com.demoperson.school.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface NiveauService {

    public ResponseEntity<?>add(Map<String,String>reqMap);
}
