package com.demoperson.school.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demoperson.school.model.Role;
import com.demoperson.school.model.Users;
import com.demoperson.school.respository.RoleRes;
import com.demoperson.school.respository.UsersRes;

@Service 
public class UserDetailsLoad implements UserDetailsService {

    @Autowired
    UsersRes res;

    @Autowired
    RoleRes roleRes;

    @SuppressWarnings({ "unused", "null" })
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        Users users= res.findUsersEmail(username);

        System.out.println(users.getEmail());
        if(Objects.isNull(users)){

            throw new UsernameNotFoundException("Cette utilisateur n'est pas");
     }

        String email=String.valueOf(users.getEmail());
        String password=String.valueOf(users.getPassword());
        


        List<GrantedAuthority> Lister=new ArrayList<>();
        Lister.add(new SimpleGrantedAuthority(users.getRole().getLibelle()));

        return new User(email, password, Lister);
    }
    
}
