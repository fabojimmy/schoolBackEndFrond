package com.demoperson.school.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.demoperson.school.Wrapper.RoleWrapper;
import com.demoperson.school.model.Role;


public interface UsersService {
    
    public ResponseEntity<?> adduser(@RequestBody Map<String,String>reqMap);
    public ResponseEntity<List<Role>> roleUser();
}
