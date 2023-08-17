package ar.com.mp.service;

import ar.com.mp.dao.IdaoPerson;
import ar.com.mp.domain.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Without this anotation, I wont be able of inyect this class as and implementatioon of the interface ServicePerson into Spring controler
public class ServicePersonImpl implements ServicePerson {

    @Autowired
    private IdaoPerson daoPerson;

    @Override
    @Transactional(readOnly = true) // I use this one because here I'm only reading the information of the DB
    public List<Person> listPeople() {
        return (List<Person>) daoPerson.findAll();//cast is necessary to be done because the method findall return an object and I need a list
    }

    @Override
    @Transactional
    public void save(Person person) {
        daoPerson.save(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        daoPerson.delete(person);
    }

    @Override
    public Person findPerson(Long idPerson) {

        return daoPerson.findById(idPerson).orElse(null);
    }

}
