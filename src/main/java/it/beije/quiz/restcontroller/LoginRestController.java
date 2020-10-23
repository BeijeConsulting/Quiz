package it.beije.quiz.restcontroller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import it.beije.quiz.model.User;
import it.beije.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class LoginRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/login/getUserByEmail/{email}")
    public Map<String, Boolean> emailExist(@PathVariable String email){
        User u = userService.retrieve(email);
        return u == null ? Collections.singletonMap("success", false) : Collections.singletonMap("success", true);
    }

    @GetMapping("/login/getUser/{email}-{pw}")
    public User getUser(@PathVariable String email,
                              @PathVariable String pw){
        return userService.retrieve(email, pw);
    }
}
