package com.lynas.controller;

import com.lynas.model.AppUser;
import com.lynas.model.UserRole;
import com.lynas.service.AppUserService;
import com.lynas.service.UserRoleService;
import com.lynas.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sazzad on 2/11/16.
 */
@Controller
public class HomeController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    UserRoleService userRoleService;


    @RequestMapping(value = "/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String home(){

        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/signup")
    public String signup(){
        return "signup";
    }

    @RequestMapping(value = "/test")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String test(){
        return "home";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupForm(@RequestParam String userName, @RequestParam String password){
        UserRole role = userRoleService.getRoleUser();
        List<UserRole> roles = new ArrayList<>();
        roles.add(role);

        appUserService.insertAppUser(new AppUser(userName, Util.encodePassword(password),roles));
        return "redirect:/login";
    }
}
