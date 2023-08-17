package ar.com.mp.dao;

import ar.com.mp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdaoPerson extends JpaRepository<Person, Long>{
    //This repository  generates automatically the most common methods when is working with
    // the objects identity of Person  (READ,UPDATE,DELETE,SELECT)
    
    
}
