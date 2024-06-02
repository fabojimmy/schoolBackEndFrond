package com.demoperson.school.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NamedQuery(name="Users.usersAll",query="SELECT new com.demoperson.school.Wrapper.UsersWrapper(u.id,u.matricule,u.Firstname,u.Lastname,u.email,u.number,u.dateNais,u.password) FROM Users u")
@NamedQuery(name="Users.findUsersId",query="SELECT new com.demoperson.school.Wrapper.UsersWrapper(u.id,u.matricule,u.Firstname,u.Lastname,u.email,u.number,u.dateNais,u.password,u.role.id,u.role.libelle) FROM Users u where u.id=:id")

@AllArgsConstructor
@Data
@Entity
@SuperBuilder
@Builder
@Table(name = "users")
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id")
    private Role role;    


    @OneToMany(mappedBy = "users",cascade=CascadeType.ALL)
    private List<Payment>payments;

    




    
}
