package com.demoperson.school.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demoperson.school.Wrapper.RoleWrapper;
import com.demoperson.school.model.Role;
import com.demoperson.school.model.Users;
import com.demoperson.school.respository.RoleRes;
import com.demoperson.school.respository.UsersRes;
import com.demoperson.school.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService  {


    @Autowired
    public UsersRes usersRes;
    
    @Autowired
    public RoleRes roleRes;
    
    @Autowired
    public PasswordEncoder passwordEncoder; 

    @SuppressWarnings("unused")
    @Override
    public ResponseEntity<?> adduser(Map<String, String> reqMap) {
        // TODO Auto-generated method stub
       
        Users user=new Users();

        System.out.println(new Date() + "--"+reqMap);
        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(this.formatDate(reqMap.get("dateNais"))));
            user.setMatricule(reqMap.get("matricule"));
            user.setEmail(reqMap.get("email"));
            user.setNumber(reqMap.get("number"));
            user.setLastname(reqMap.get("lastname"));
            user.setFirstname(reqMap.get("firstname"));
            user.setDateNais(date);

            Optional<Role> role=roleRes.findById(Long.parseLong(reqMap.get("role_id")));
            if(Objects.isNull(role)){

                return new ResponseEntity<>("Ce role n'excite pas",HttpStatus.NOT_ACCEPTABLE);
            }
            user.setRole(role.get());
            user.setPassword(passwordEncoder.encode(reqMap.get("password")));

            Object userObjEm=usersRes.findUsersEmail(reqMap.get("email"));
            Object userObjnum=usersRes.findUsersnumber(reqMap.get("number"));
            
            if(!Objects.isNull(userObjEm))
            {
                return new ResponseEntity<>("{\"message\":\""+"Email existe déjà"+"\"}",HttpStatus.NOT_ACCEPTABLE);
            }
            if(!Objects.isNull(userObjnum))
            {
                return new ResponseEntity<>("{\"message\":\""+"Ce numéro excite déjà"+"\"}",HttpStatus.NOT_ACCEPTABLE);
            }
            
            usersRes.save(user);

            
            
            return new ResponseEntity<>("{\"message\":\""+"informations bien enregistré"+"\"}",HttpStatus.OK);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
       
    }


    public String formatDate(String dateString){
        LocalDate date=LocalDate.parse(dateString);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate=date.format(formatter);
        return formattedDate;
    }


    @SuppressWarnings("unchecked")
    @Override
    public ResponseEntity<List<Role>> roleUser() {
        // TODO Auto-generated method stub
        // role
        try{

            return new ResponseEntity<List<Role>>(roleRes.findAll(),HttpStatus.OK);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;

        // return new ResponseEntity<List<?>>(null,null);
    }
   
    
}
