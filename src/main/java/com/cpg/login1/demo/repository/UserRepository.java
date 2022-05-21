package com.cpg.login1.demo.repository;

import com.cpg.login1.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<User,Long>

{
   Optional<User> findByUsernameAndPassword(String username,String password);
}
