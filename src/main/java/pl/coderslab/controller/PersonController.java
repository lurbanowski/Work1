package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Person;
import pl.coderslab.repository.PersonRepository;
import javax.validation.Valid;
import javax.validation.Validator;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    Validator validator;
   @Autowired
    private PersonRepository personRepository;

    /**wyciagam wszystkie osoby z bazy i przekazuję do metod JSP**/
    @ModelAttribute("persons")
    private List<Person> getPersons(){ return  personRepository.findAll();}

    /** Przekazuje do widoku formularza pola obiektu Person**/
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("person", new Person());
        return "/person/addPerson";
    }


    /**Odbranie danych z formularza do obiektu book**/
    /**Wyświetlenie wszystkich osób**/
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String save(@Valid Person person, BindingResult result){

        if(result.hasErrors()){
            return "/person/addPerson";
        }
        personRepository.save(person);
        return "redirect:all";
    }

    /**wyciągam wszystkie osoby i przekazuje do widoku**/
    @RequestMapping("/all")
    private String all(Model model){
        List<Person> personList = personRepository.findAll();
        model.addAttribute("person", personList);
        return "/person/personIndex";
    }

    /**wyciagam jedną osobe po id**/
    @RequestMapping("/single/{id}")
    private String singlePerson(@PathVariable("id") Long id, Model model){
        Person person = personRepository.findOne(id);
        model.addAttribute("person", person);
        return "/person/personViewSingel";
    }

    /** Przekazuje do widoku formularza pola jednego obiektu po ID Person**/
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable ("id") Long id, Model model){
        Person person = personRepository.findOne(id);
        model.addAttribute("person", new Person());
        return "/person/editSinglePerson";
    }

    /**Odbranie danych z formularza do obiektu person**/
    /**Wyświetlenie wszystkich osób**/
    @RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
    public String edit(@Valid Person person, @PathVariable("id") Long id, BindingResult result){

        if(result.hasErrors()){
            return "/person/editSinglePerson";
        }
        personRepository.save(person);
        return "forward:/person/all";
    }

    /**Usuwanie konkretnej osoby(dezaktywacja)**/
//    @RequestMapping("/delete/{id}")
//    public String delete(@PathVariable ("id") Long id){
//        Person person = personRepository.findOne(id);
//        person.setStatus(9);
//        person.setAlive(false);
//        person.setFamily(true);
//        person.setFirstName(null);
//        person.setGender("NN");
//        person.setLastName(null);
//        person.setMaiden_name(null);
//        personRepository.save(person);
//        return "forward:/person/all";
//
//    }

}
