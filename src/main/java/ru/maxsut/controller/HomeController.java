package ru.maxsut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Максим on 09.08.2015.
 */

@Controller
@SessionAttributes("sessionUserName")
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/present", method = RequestMethod.GET)
    public String getHome(@ModelAttribute("sessionUserName") String sessionUserName) {
        return "home";
    }
}
