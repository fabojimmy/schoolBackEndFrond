package com.demoperson.school.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoperson.school.Wrapper.RoleWrapper;
import com.demoperson.school.Wrapper.UsersWrapper;
import com.demoperson.school.model.Role;
import com.demoperson.school.model.Users;


@RestController
@RequestMapping("users")
// @CrossOrigin("*")
public interface UsersRest {
    @PostMapping(path = "/adduser")
    public ResponseEntity<?>adduser(@RequestBody Map<String,String>reqMap);
    @GetMapping(path = "/roleUser")
    public ResponseEntity<List<RoleWrapper>> roleUser();
    @GetMapping(path = "/get")
    public List<UsersWrapper> getalluser();
    @PostMapping(path="/updateuser")
    public ResponseEntity<String>updateUser(@RequestBody Map<String,String>reqMap);
    @DeleteMapping(path="/deleteuser/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable String id);
    @GetMapping(path="/getUser/{id}")
    public ResponseEntity<UsersWrapper>getUserId(@PathVariable String id);
}
