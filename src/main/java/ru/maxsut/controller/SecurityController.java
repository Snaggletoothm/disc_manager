package ru.maxsut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.maxsut.domain.User;
import ru.maxsut.domain.UserProfile;
import ru.maxsut.domain.UserProfileType;
import ru.maxsut.lib.InfrastructControllers;
import ru.maxsut.service.CustomService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Максим on 09.08.2015.
 */

@Controller
@RequestMapping("/")
public class SecurityController {

    @Autowired
    CustomService service;

    @Autowired
    InfrastructControllers inf;

    @RequestMapping(value = {"/", "/start"}, method = RequestMethod.GET)
    public String startView(ModelMap model) {
        return "auth/startPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(User user, @RequestParam(value = "error", required = false) String error) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }

        User emptyUser = new User();
        model.addObject("user", emptyUser);
        model.setViewName("auth/login");

        return model;
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.GET)
    public String check(@ModelAttribute User user, HttpSession httpSession){

        httpSession.setAttribute("sessionUserName", inf.getUsername());
        return "redirect:/home/present";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String exit(@ModelAttribute User user, HttpSession httpSession){
        httpSession.removeAttribute("sessionUserName");
        return "auth/startPage";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user){

        ModelAndView model = new ModelAndView();
        String msgAccess = "У вас нет доступа к запрошенной странице";
        if(user != null){
            model.addObject("errorMsg", user.getName() + "! " + msgAccess);
        } else {
            model.addObject("errorMsg", ". " + msgAccess);
        }
        model.setViewName("auth/error");
        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterForm(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "auth/registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, ModelMap model, HttpSession success){

        if(result.hasErrors()){
            return "auth/registration";
        }

        Set<UserProfile> userProfiles = new HashSet<UserProfile>();
        UserProfile userProfile = service.findUserProfileByType(UserProfileType.USER.getUserProfileType());
        userProfiles.add(userProfile);
        user.setUserProfile(userProfiles);
        service.saveUser(user);
        success.setAttribute("success", user.getName());
        return "redirect:/start";
    }
}
