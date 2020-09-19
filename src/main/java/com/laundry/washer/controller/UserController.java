package com.laundry.washer.controller;

import com.laundry.washer.model.PostRequest;
import com.laundry.washer.model.Userbio;
import com.laundry.washer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

// User controller class that handles customers and launderer's details
@Controller
public class UserController {

    @Autowired
    UserService userService;

//    Method handler that directs default call to the index page
    @GetMapping(value = {"/", "/signup"})
    public String index(Model model) {
        Userbio userbio = new Userbio();
        model.addAttribute("user", userbio);
        return "index";
    }

// Method handler that adds users details to database and redirects users to login
    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute("user") Userbio user, BindingResult result) {
        if(result.hasErrors()){
            return "index";
        }
        userService.saveUserData(user);
        return "redirect:/login";
    }

//    Sends login view page
    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

//    Method handler that validates users password and username
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        Userbio user = userService.validateUser(username, password);
        if (user == null) {
            return "redirect:/login";
        }
        session.setAttribute("currentUser", user);
        return "redirect:/home";
    }

//    method handler that add PostRequest data to the model and redirects to home
    @GetMapping("/home")
    public String showHome(PostRequest post, Model model) {
        model.addAttribute("post", post);
        return "home";
    }

}
