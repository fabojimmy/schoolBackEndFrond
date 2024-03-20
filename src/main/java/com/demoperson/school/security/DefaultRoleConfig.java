package com.demoperson.school.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.demoperson.school.model.Role;
import com.demoperson.school.respository.RoleRes;


@Configuration

public class DefaultRoleConfig implements CommandLineRunner{


    @Autowired
    RoleRes roleRes;
    @SuppressWarnings("static-access")
    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        if(roleRes.findByLibelle("Role_ADMIN")==null)
        {
            Role admin=new Role();
            admin.setLibelle("Role_ADMIN");

            roleRes.save(admin);
        }
        if(roleRes.findByLibelle("Role_APPRENANT")==null)
        {
            Role appre=new Role();
            appre.setLibelle("Role_APPRENANT");

            roleRes.save(appre);
        }
        if(roleRes.findByLibelle("Role_PROFESSION")==null)
        {
            Role profe=new Role();
            profe.setLibelle("Role_PROFESSION");


            roleRes.save(profe);
        }
        if(roleRes.findByLibelle("Role_PARENT")==null)
        {
            Role pare=new Role();
            pare.setLibelle("Role_PARENT");

            roleRes.save(pare);
        }
    
    }
    
}
