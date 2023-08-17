package ar.com.mp.service;

import ar.com.mp.domain.Person;
import java.util.List;

public interface ServicePerson {
    
    public List<Person> listPeople();
    
    public void save (Person person);

    public void delete(Person person);
    
    public Person findPerson (Long idPerson);
    
}
