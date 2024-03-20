package com.demoperson.school.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@Entity
@SuperBuilder
@Builder

public class Users {

    

    public Users() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    

    public Long id;
    @Column(unique=true,nullable = false)
    public String matricule;
    @Column(unique=false,nullable = false)
    public String Firstname;
    @Column(unique=false,nullable = false)
    public String Lastname;
    @Column(unique=true,nullable = false)
    public String email;
    @Column(unique=true,nullable = true)
    public String number;
    @Column(unique=false,nullable = false)
    public Date dateNais;
    @Column(unique=false,nullable = false)
    public String password;


    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;    




    
}
