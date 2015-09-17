package ru.maxsut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.maxsut.domain.Disc;
import ru.maxsut.domain.User;
import ru.maxsut.lib.InfrastructControllers;
import ru.maxsut.service.CustomService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/discManager")
@SessionAttributes("sessionUserName")
public class DiscManagerController {

    @Autowired
    CustomService service;

    @Autowired
    InfrastructControllers inf;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newDisc(ModelMap model){

        Disc disc = new Disc();
        model.addAttribute("disc", disc);

        return "newDisc";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createDisc(Disc disc, ModelMap model){

        User user = service.findUserByName(inf.getUsername());
        disc.setOwner(1);
        disc.setTempOwnerName("");
        disc.setUser(user);
        service.saveDisc(disc);
        return "redirect:/app/free";
    }

    @RequestMapping(value = "/edit-{id}-disc", method = RequestMethod.GET)
    public String editDisc(@PathVariable int id, ModelMap model){

        Disc disc = service.findDiscById(id);
        model.addAttribute("disc", disc);
        return "editDisc";
    }

    @RequestMapping(value = "/edit-disc/{id}", method = RequestMethod.POST)
    public String updateDisc(Disc disc, @PathVariable int id){

        // это костыли - ибо следует передавать все это через hidden поля! Но браузер ругается на <form:hidden path=...
        // пока только так
        Disc savedDisc = service.findDiscById(id);
        disc.setComments(savedDisc.getComments());
        disc.setOwner(savedDisc.getOwner());
        disc.setTempOwnerName(savedDisc.getTempOwnerName());
        disc.setUser(savedDisc.getUser());
        disc.setImgDisc(savedDisc.getImgDisc());
        service.updateDisc(disc);

        return "redirect:/profile/user";
    }

    @RequestMapping(value = "/delete-{id}-disc", method = RequestMethod.GET)
    public String deleteDisc(@PathVariable int id){

        Disc disc = service.findFreeDiscById(id);
        service.deleteDisc(disc);
        return "redirect:/app/free";
    }

    @ModelAttribute("genres")
    public List<String> initGenres(){

        List<String> genres = new ArrayList<String>();
        genres.add("drama");
        genres.add("fantasy");
        genres.add("horror");
        genres.add("comedy");
        genres.add("thriller");
        genres.add("melodrama");
        return genres;
    }

}
