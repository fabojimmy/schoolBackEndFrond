package com.demoperson.school.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demoperson.school.Wrapper.UsersWrapper;
import com.demoperson.school.model.Users;

@Repository
public interface UsersRes extends JpaRepository<Users,Long>{

    @Query("SELECT u FROM Users u WHERE u.email=:email")
    public Users findUsersEmail(@Param("email") String email);
    @Query("SELECT u FROM Users u WHERE u.number=:number")
    public Users findUsersnumber(@Param("number") String number);
    // @Query("SELECT u FROM Users u WHERE u.id=:id")
    public UsersWrapper findUsersId(@Param("id") Long id);
    // @Query("SELECT u FROM Users u")
    public List<UsersWrapper> usersAll();
 
    
}
