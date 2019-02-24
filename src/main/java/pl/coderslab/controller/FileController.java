package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.model.File;
import pl.coderslab.model.Person;
import pl.coderslab.repository.FileRepository;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static pl.coderslab.config.SpringDiApplication.TMP_FOLDER;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileRepository fileRepository;

    @ModelAttribute("file")
    public List<File> getFile(){ return fileRepository.findAll();}

    /** Przekazuje do widoku formularza pola obiektu Person**/
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("file", new File());
        return "/file/test";
    }


    /**Odebranie danych z formularza do obiektu book**/
    /**Wyświetlenie wszystkich osób**/
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String save(@Valid File f, BindingResult result,
                       @RequestParam("file") MultipartFile file,
                       ModelMap modelMap) throws IOException {
        if(result.hasErrors()){
            return "/file/test";
        }
        //   modelMap.addAttribute("file", file);

        byte[] bytes = file.getBytes();
        Path path = Paths.get(TMP_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);
        fileRepository.save(f);
        return "/index";
    }

    @RequestMapping("/show")
    public String show(Model model){

        return "";
    }

}
