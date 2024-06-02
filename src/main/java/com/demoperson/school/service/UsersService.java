package com.demoperson.school.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.demoperson.school.Wrapper.RoleWrapper;
import com.demoperson.school.Wrapper.UsersWrapper;
import com.demoperson.school.model.Role;
import com.demoperson.school.model.Users;


public interface UsersService {
    
    public ResponseEntity<?> adduser(Map<String,String>reqMap);
    public ResponseEntity<List<RoleWrapper>> roleUser();
    public List<UsersWrapper> getalluser();
    public ResponseEntity<String>updateUser(Map<String,String>reqMap);
    public ResponseEntity<String>deleteUser(Long id);
    public ResponseEntity<UsersWrapper>getUserId(Long id);


}
