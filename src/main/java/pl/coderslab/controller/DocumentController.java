package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.model.Document;
import pl.coderslab.model.File;
import pl.coderslab.model.Person;
import pl.coderslab.repository.DocumentRepository;
import pl.coderslab.repository.FileRepository;
import pl.coderslab.repository.PersonRepository;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static pl.coderslab.config.SpringDiApplication.TMP_FOLDER;

@Controller
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private DocumentRepository documentRepository;

    /**wyciagam wszystkie osoby z bazy i przekazuję do metod JSP**/
    @ModelAttribute("persons")
    private List<Person> getPerson(){ return  personRepository.findAllByActiveIsTrue();}

    /**wyciagam wszystkie file z bazy i przekazuję do metod JSP**/
    @ModelAttribute("plik")
    private List<File> getFile(){
       return new ArrayList<>();
    }

    /** Przekazuje do widoku formularza pola obiektu Document**/
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("dokument", new Document());
        return "/document/addDocument";
    }

    /**Odebranie danych z formularza do obiektu book**/
    /**Wyświetlenie wszystkich osób**/
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String save(@Valid Document document, BindingResult result,
                       @RequestParam("file") MultipartFile[] file,
                       @RequestParam List<String> name
                      ) throws IOException, FileAlreadyExistsException {
        if(result.hasErrors()){
            return "/document/addDocument";
        }
        String p = TMP_FOLDER + "/" + document.getName() +"/"; //budowa ścieżki
        Files.createDirectory(Paths.get(p)); //tworzenie nowego folderu na pliki
        List<File> lf = new ArrayList<>();
        for(int i=0;i<file.length;i++){ //petla na kilka plikow
            if(file[i].isEmpty()) {
            break;
            }else{
           byte[] bytes = file[i].getBytes();
            Path path = Paths.get(p + file[i].getOriginalFilename());
            Files.write(path, bytes);
            File f = new File();
            f.setName(name.get(i));
            f.setPath(path.toString());
            lf.add(f);
        }
        }
        document.setFiles(lf);
        document.setPath(p);
        documentRepository.save(document);
        /**Jeden plik**/
//        byte[] bytes = file.getBytes();
//        String p = TMP_FOLDER + "/" + document.getName() +"/"; //budowa ścieżki
//        Files.createDirectory(Paths.get(p)); //tworzenie nowego folderu na pliki
//        Path path = Paths.get(p + file.getOriginalFilename());
//        Files.write(path, bytes);
//        document.setPath(path.toString());//zapisanie ścieżki do pliku
//        documentRepository.save(document);
        return "/index";
    }

    @RequestMapping("/viewFile")
    public String view(ModelMap modelMap){
        List<Document> documents = documentRepository.findAll();
        modelMap.addAttribute("documents", documents);
        return "/document/viewAllDocuments";
    }
    @RequestMapping("/viewGallery/{id}")
    public String view(@PathVariable String id, ModelMap modelMap){
        List<Document> pathes = documentRepository.findFirstByIdOrderByPath(id);
        modelMap.addAttribute("pathes", pathes);
        return "/document/gallery";
    }

    @RequestMapping("/viewGallery2")
    public String test(){
        return "/document/gallery";
    }

}
