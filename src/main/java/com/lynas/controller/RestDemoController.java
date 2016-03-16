package com.lynas.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sazzad on 3/16/16
 */
@RestController
public class RestDemoController {

    @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String getTest(){
        return "{\"success\":true}";
    }

    @RequestMapping(value = "/getTest2", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_USER2')")
    public String getTest2(){
        return "{\"success\":true}";
    }
}
