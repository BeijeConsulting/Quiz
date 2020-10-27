package it.beije.quiz.controller.rest.old;

import it.beije.quiz.entity.User;
import it.beije.quiz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller to handle all requests regarding Login functions
 */
@RestController
@RequestMapping("/api")
public class LoginRestController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     * REST Get method which returns the User given his email.
     * @param email the email of the User searched
     * @return a User object or null if no User with email is found
     */
    @GetMapping("/login/getUserByEmail/{email}/")
    public User emailExist(@PathVariable String email){
        log.debug("Rest controller for User by email: " + email);
        return userService.loadByEmail(email);
    }
}
