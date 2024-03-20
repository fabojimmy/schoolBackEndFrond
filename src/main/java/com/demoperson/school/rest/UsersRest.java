package com.demoperson.school.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoperson.school.Wrapper.RoleWrapper;
import com.demoperson.school.model.Role;

@RestController
@RequestMapping("users")
public interface UsersRest {
    @PostMapping(path = "/adduser")
    public ResponseEntity<?>adduser(@RequestBody Map<String,String>reqMap);
    @GetMapping(path = "/roleUser")
    public ResponseEntity<List<Role>> roleUser();
}
