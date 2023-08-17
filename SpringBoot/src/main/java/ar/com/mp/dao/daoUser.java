package ar.com.mp.dao;

import ar.com.mp.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface daoUser extends JpaRepository<User, Long>{//This repository  generates automatically the most common methods when is working with
    // the objects identity of User  
    //Type has to be long because the primary key type is Long
    //This method is reuqested by SpringBoot Security Framework
      Usuario findByUsername(String username);
}
