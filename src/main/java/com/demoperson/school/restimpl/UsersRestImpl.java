package com.demoperson.school.restimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demoperson.school.Wrapper.RoleWrapper;
import com.demoperson.school.Wrapper.UsersWrapper;
import com.demoperson.school.model.Role;
import com.demoperson.school.model.Users;
import com.demoperson.school.rest.UsersRest;
import com.demoperson.school.serviceimpl.UsersServiceImpl;


// @RestController
// @RequestMapping(path = "/users")
@Service
public class UsersRestImpl implements UsersRest{

    @Autowired
    UsersServiceImpl usersSe;

    @Override
    @PostMapping(path = "/adduser")
    public ResponseEntity<?> adduser(@RequestBody Map<String, String> reqMap) {
        // TODO Auto-generated method stub

        try {

            System.out.println(reqMap.get("dateNais"));
            
           return usersSe.adduser(reqMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public ResponseEntity<List<RoleWrapper>> roleUser() {
        // TODO Auto-generated method stub

        try {
           return usersSe.roleUser();
        } catch (Exception e) {
            // TODO: handle exception

            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'roleUser'");
    }

    @Override
    public List<UsersWrapper> getalluser() {
        // TODO Auto-generated method stub
        try {
           return usersSe.getalluser();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseEntity<String> updateUser(Map<String, String> reqMap) {
        // TODO Auto-generated method stub
        try {


            return usersSe.updateUser(reqMap);
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public ResponseEntity<String> deleteUser(String id) {
        // TODO Auto-generated method stub
        try {
            return usersSe.deleteUser(Long.parseLong(id));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public ResponseEntity<UsersWrapper> getUserId(String id) {
       try {
         // TODO Auto-generated method stub
         return usersSe.getUserId(Long.parseLong(id));
       } catch (Exception e) {
        // TODO: handle exception
          e.printStackTrace();
       }
        throw new UnsupportedOperationException("Unimplemented method 'getUserId'");
    }
    
}
