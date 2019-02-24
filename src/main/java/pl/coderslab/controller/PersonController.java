package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.config.SpringDiApplication;
import pl.coderslab.model.Document;
import pl.coderslab.model.Person;
import pl.coderslab.repository.DocumentRepository;
import pl.coderslab.repository.PersonRepository;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;
import javax.validation.Validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static pl.coderslab.config.SpringDiApplication.TMP_FOLDER;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    Validator validator;
   @Autowired
    private PersonRepository personRepository;
   @Autowired
   private DocumentRepository documentRepository;



    /**wyciagam wszystkie osoby z bazy i przekazuję do metod JSP**/
    @ModelAttribute("dokumenty")
    private List<Document> getDocument(){ return  documentRepository.findAll();}

    /** Przekazuje do widoku formularza pola obiektu Person**/
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("person", new Person());
        return "/person/addPerson";
    }


    /**Odebranie danych z formularza do obiektu book**/
    /**Wyświetlenie wszystkich osób**/
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String save(@Valid Person person, BindingResult result,
                      // @RequestParam("file") MultipartFile file,
                       ModelMap modelMap) throws IOException {
        if(result.hasErrors()){
            return "/person/addPerson";
        }
     //   modelMap.addAttribute("file", file);

//        byte[] bytes = file.getBytes();
//        Path path = Paths.get(TMP_FOLDER + file.getOriginalFilename());
//        Files.write(path, bytes);
       // List<Document> ld = (List<Document>) file;
       // person.setDocument((List<Document>) file);
        personRepository.save(person);
        return "redirect:all";
    }

    /**wyciągam wszystkie osoby i przekazuje do widoku**/
    @RequestMapping("/all")
    private String all(Model model){
      //  List<Person> personList = personRepository.findAll();
        List<Person> personList = personRepository.findAllByActiveIsTrue();
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
        model.addAttribute("person", person);
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
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable ("id") Long id){
        Person person = personRepository.findOne(id);
        person.setActive(false);
        personRepository.save(person);
        return "forward:/person/all";

    }

}
