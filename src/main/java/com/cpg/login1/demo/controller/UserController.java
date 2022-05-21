package com.cpg.login1.demo.controller;

import com.cpg.login1.demo.model.User;
import com.cpg.login1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model)
    {
        model.addAttribute("registerObject",new User ());
        return "register_page";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute User user)
    {
        System.out.println("register object:"+ user);
        User registerUser = userService.registerUser(user);

        if (registerUser== null)
        {

            return  "error_page";
        } else {

            return  "redirect:/login";
        }

    }

    @GetMapping("/login")
    public String loginPage(Model model)
    {
        model.addAttribute("loginObject",new User());
        return  "login_page";
    }
    @PostMapping("/login")
    public  String login(@ModelAttribute User user,Model model){

        System.out.println("login params:"+ user);

      User loginUser = userService.authenticate(user.getUsername(),user.getPassword());

      if (loginUser !=null){
          model.addAttribute("loggedInUser",loginUser.getUsername());
          return "mypage";
      }else {
          return  "error_page";
      }
    }

}
