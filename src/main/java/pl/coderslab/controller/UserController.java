package pl.coderslab.controller;

import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.SessionScope;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;
;

@Controller
@RequestMapping("/user")
@SessionAttributes("userSesion")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    Validator validator;
    /** Przekazuje do formularza pola login i password obiektu User**/
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String add(Model model ){
        model.addAttribute("user", new User());
        return "../header";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String email,
                        @RequestParam String password,
                       // @ModelAttribute User user,
                        HttpSession userSesion,
                        Model model){

        User usersByEmail = userRepository.findFirstByEmail(email);//znajdowanie użytkownika o podanym mailu
        String imieUrzytkownika = usersByEmail.getUserFirstName();
        String aktualneHAslo = usersByEmail.getPassword();


        if(usersByEmail==null){
            System.out.println("nie ma takiego urzytkownika");
            return "/index";
        }else if(email==null || password==null){

            System.out.println("wprowadzi email lub haslo");
            return "/index";
        }else if(BCrypt.checkpw(password, aktualneHAslo)){
            System.out.println("Witaj ktos tam");
            userSesion.setAttribute("userSesion", usersByEmail.getId());
            model.addAttribute("imie", imieUrzytkownika);
            return "/index";
        } else {
            System.out.println("podaj poprawny email lub haslo");
            return "/index";
        }
    }

    @RequestMapping("/logout")
    public String logout(SessionScope userSesion, HttpSession userSesion2){//@ModelAttribute("userSesion") LinkedList<User> userSesion){
            userSesion.remove("userSesion");
       // userSesion2.setAttribute("userSesion", null);
        userSesion2.removeAttribute("userSesion");
       // userSesion2.removeValue("userSesion");
        userSesion2.invalidate();

        System.out.println("Wylogowano");
        return "redirect:/";
    }


    /** Przekazuje do formularza pola login i password obiektu User**/
    @RequestMapping(value = "/registr", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("user", new User());
        return "/user/registerUserForm";
    }

    @RequestMapping( value = "/registr", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "/user/registerUserForm";
        }
        String haslo = user.getPassword();
        String hashHaslo = BCrypt.hashpw(haslo, BCrypt.gensalt(12));
        user.setPassword(hashHaslo);
        userRepository.save(user);
        return "/index";
    }
}
