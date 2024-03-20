package com.demoperson.school.model;

import java.util.List;

import jakarta.persistence.CascadeType;
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
@NoArgsConstructor
@Data
@Entity
@SuperBuilder
@Builder
public class Role {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    public Long id;

    public String libelle;



     @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private List<Users> users;
}
