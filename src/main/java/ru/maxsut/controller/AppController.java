package ru.maxsut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ru.maxsut.domain.Comment;
import ru.maxsut.domain.Disc;
import ru.maxsut.lib.InfrastructControllers;
import ru.maxsut.service.CustomService;
import ru.maxsut.viewModel.DiscInfo;

import java.util.List;

@Controller
@RequestMapping(value = "/app")
@SessionAttributes("sessionUserName")
public class AppController {

    @Autowired
    CustomService service;

    @Autowired
    InfrastructControllers inf;

    @RequestMapping(value = "/free", method = RequestMethod.GET)
    public String getFreeDiscs(Model model){

        List<Disc> discs = service.getFreeDiscs();
		model.addAttribute("discs", discs);
        model.addAttribute("genData", getGeneralData(discs));
        return "freeDiscs";
    }

    @RequestMapping(value = "/hired", method = RequestMethod.GET)
    public ModelAndView getHiredDiscs(){

        List<Disc> discs = service.getHiredDiscsByUserName(inf.getUsername());

        ModelAndView model = new ModelAndView();
        model.addObject("discs", discs);
        model.addObject("genData", getGeneralData(discs));
        model.setViewName("hiredDiscs");

        return model;
    }

    @RequestMapping(value = "/given", method = RequestMethod.GET)
    public ModelAndView getGivenAwayDiscs(){

        List<Disc> discs = service.getGivenDiscsByUserName(inf.getUsername());

        ModelAndView model = new ModelAndView();
        model.addObject("discs", discs);
        model.addObject("genData", getGeneralData(discs));
        model.setViewName("givenAwayDiscs");

        return model;
    }

    @RequestMapping(value = { "/change-disc-{id}" }, method = RequestMethod.GET)
    public String showChangeDisc(@PathVariable int id, ModelMap model){

        Disc disc = service.findFreeDiscById(id);
        model.addAttribute("commentCount", disc.getComments().size());
        model.addAttribute("hasCurrUser", inf.hasDiscCurrentUser(disc, inf.getUsername()));
        model.addAttribute("disc", disc);
        model.addAttribute("comment", new Comment());
        return "profile/discsProfile";
    }

    @RequestMapping(value = { "/take-{id}-{title}" }, method = RequestMethod.GET)
    public String takeDisc(@PathVariable int id, @PathVariable String title){

        service.moveDisc(inf.getUsername(), id);
        return "redirect:/app/free";
    }

    @RequestMapping(value = { "/giveAway-{id}" }, method = RequestMethod.GET)
    public String giveAwayDisc(@PathVariable int id){
        service.moveDisc(inf.getUsername(), id);
        return "redirect:/app/hired";
    }

    @RequestMapping(value = { "/return-{id}" }, method = RequestMethod.GET)
    public String returnOwnDisc(@PathVariable int id){

        service.moveDisc(inf.getUsername(), id);
        return "redirect:/app/given";
    }

    @RequestMapping(value = {"/add-comment-for-disc/{id}"}, method = RequestMethod.POST)
    public String createComment(@PathVariable int id, Comment comment){

        Disc disc = service.findDiscById(id);

        comment.setUserName(getAuthUser());
        comment.setDisc(disc);
        service.saveCommentForDisc(comment, id);
        return "redirect:/app/change-disc-" + id + "";
    }

    @RequestMapping(value = {"del-comment/{discId}/{commentId}"}, method = RequestMethod.GET)
    public String delComment(@PathVariable int discId, @PathVariable int commentId){

        service.deleteComment(commentId);
        return "redirect:/app/change-disc-" + discId + "";
    }

    private DiscInfo getGeneralData(List<Disc> discs){

        String username = inf.getUsername();
        DiscInfo discInfo = new DiscInfo();
        discInfo.setOwnDiscAmount(service.ownDiscAmountByUserName(username));
        discInfo.setHiredDiscAmount(service.hiredDiscAmountByUserName(username));
        discInfo.setName(username);
        discInfo.setDiscs(discs);
        return discInfo;
    }

    private String getAuthUser(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }
}























