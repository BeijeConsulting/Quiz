//package it.beije.quiz.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class AuthController {
//
//    @GetMapping("/auth")
//    public String getAuth(){
//        return "auth";
//    }
//
//    @PostMapping("/login")
//    public String postLogin(HttpServletRequest request,
//                            HttpSession session){
//        //login
//        // if valid, return home
//        // else return login (with error in model)
////        session.setAttribute("user", user);
//        return null;
//    }
//
//    @PostMapping("/register")
//    public String postRegister(HttpServletRequest request,
//                               HttpSession session){
//        //register
//        // if valid, return home
//        // else return register (with error in model model)
//        return null;
//    }
//}
