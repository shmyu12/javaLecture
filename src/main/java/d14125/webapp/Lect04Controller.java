/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d14125.webapp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;

/**
 *
 * @author d14125
 */
@Controller
@RequestMapping("/lect04")
public class Lect04Controller {
    
    public List<String> commentList;
    
    public Lect04Controller() {
        this.commentList = new ArrayList<>();
    }
    
    @RequestMapping("/bbs")
    public String bbs(ModelMap modelMap) {
        modelMap.addAttribute("commentList", commentList);
        return "lect04/bbs";
    }
    
    @RequestMapping("/add_comment")
    public String addComment(@RequestParam("comment") String comment) {
        this.commentList.add(comment);
        //return "lect04/add_comment";
        return "redirect:/lect04/bbs";
    }
    
    
    public List<BbsComment> commentList2 = new ArrayList<>();

    @RequestMapping("/bbs2")
    public String bbs2(ModelMap modelMap) {
        modelMap.addAttribute("commentList", commentList2);
        return "lect04/bbs2";
    }

    @RequestMapping("/add_comment2")
    public String addComment2(@RequestParam("comment") String comment, @RequestParam("name") String name) {
        BbsComment bbsComment = new BbsComment();
        bbsComment.comment = comment;
        bbsComment.name = name;
        bbsComment.date = new Date();
        this.commentList2.add(bbsComment);
        return "redirect:/lect04/bbs2";
    }
    
    @RequestMapping("/del_comment")
    public String delComment() {
        this.commentList2.clear();
        return "redirect:/lect04/bbs2";
    }
}
