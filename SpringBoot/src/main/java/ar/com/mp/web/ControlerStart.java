package ar.com.mp.web;

import ar.com.mp.domain.Person;
import ar.com.mp.service.ServicePerson;
import jakarta.validation.Valid;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@EnableJpaRepositories
@Slf4j // like this i have acces automatically to the car Log
public class ControlerStart {

    @Autowired//Inyect the necessary dependencies
    private ServicePerson servicePerson;//Implementing the class in order to call the methods need it of the implementation

    @GetMapping("/")//because the path is in blank, the start method will be executed
    public String start(Model model,@AuthenticationPrincipal User user) {
       
       ArrayList<Person> persons = (ArrayList<Person>) servicePerson.listPeople();
        log.info("Executing the controller Spring MVC");
        log.info("User that loging: "+ user);
        model.addAttribute("persons", persons);
     double totalBudget = 0D;
        for( Person p: persons){
            totalBudget += p.getBudget();
        }
         model.addAttribute("totalBudget", totalBudget);
        model.addAttribute("clients", persons.size());
        return "index"; //is not returning a simple string, is calling the page with the same file name
    }
    
    
    @GetMapping("/add")
    public String add (Person person){
      return "modify";//is not returning a simple string, is calling the page with the same file name
    }
    
    @PostMapping("/save")
    public String save( @Valid Person person, Errors errors){//@Valid anotation is necessary because when I call the method I need to recover also the errors
       if(errors.hasErrors()){
       return "modify";
       }
        servicePerson.save(person);
        return "redirect:/";//it returns the main page
    }
  
    @GetMapping("/edit/{idPerson}")//it use the specific value of the id to find the user that it needs to be edited
    public String edit(@PathVariable Long idPerson, Model model){
     Person person=servicePerson.findPerson(idPerson);
     model.addAttribute("person", person);
        return "modify";
    }
    
    @GetMapping("/delete")
    public String delete (Person person){
    
        servicePerson.delete(person);
        return "redirect:/";
    }
    
}
