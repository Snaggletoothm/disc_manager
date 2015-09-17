package ru.maxsut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.maxsut.domain.Disc;
import ru.maxsut.service.CustomService;

import java.util.List;

/**
 * Created by Максим on 15.08.2015.
 */

@Controller
@RequestMapping(value = "/profile")
@SessionAttributes("sessionUserName")
public class UserProfileController {

    @Autowired
    CustomService service;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getProfileView(@ModelAttribute("sessionUserName") String userName, Model model){
        List<Disc> discs = service.findAllDiscsByOwnerName(userName);
        model.addAttribute("discs", discs);
        return "profile/myprofile";
    }
}
