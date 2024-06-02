package com.demoperson.school.restimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demoperson.school.model.Niveau;
import com.demoperson.school.model.Users;
import com.demoperson.school.rest.NiveauRest;
import com.demoperson.school.service.NiveauService;
import com.demoperson.school.service.UsersService;

@Service
public class NiveauRestImpl implements NiveauRest{

    @Autowired
    private NiveauService niveauService;

    @Autowired
    private UsersService usersService;

    @Override
    public ResponseEntity<List<Niveau>> getNivea() {
        // TODO Auto-generated method stub

        try {

            return niveauService.getNivea();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

   

    @Override
    public ResponseEntity<String> addNiv(Map<String,String>requestMap) {
        try {
            // TODO Auto-generated method stub
            return niveauService.addNivea(requestMap);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ResponseEntity<String> updateNive(Map<String, String> requestMap) {
        // TODO Auto-generated method stub
       try {
        System.out.println(requestMap.get("id"));
        return niveauService.updateNive(requestMap);
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
       }
       return null;
    }

    @Override
    public ResponseEntity<String> supprimerNiveau(String id) {
        // TODO Auto-generated method stub
        try {

            return niveauService.supprimerNiveau(Long.parseLong(id));
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'supprimerNiveau'");
    }

    @Override
    public ResponseEntity<Niveau> getByid(String id) {
        // TODO Auto-generated method stub
        System.out.println(id);
        try {
            return niveauService.getByid(Long.parseLong(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
