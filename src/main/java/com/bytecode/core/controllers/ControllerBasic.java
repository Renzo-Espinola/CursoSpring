package com.bytecode.core.controllers;

import com.bytecode.core.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/home")
public class ControllerBasic {

    public List<Post> getPost(){
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post(1,"MONCHI TU CURSO ES DE FRONTEND","http://localhost/img/monchi.png",new Date(),"DESARROLLO FRONTEND"));
        post.add(new Post(2,"MONCHI TU CURSO ES DE FRONTEND","http://localhost/img/monchi.png",new Date(),"DESARROLLO BACKEND"));
        post.add(new Post(3,"MONCHI TU CURSO ES DE FRONTEND","http://localhost/img/monchi.png",new Date(),"DESARROLLO LOLOLOLO"));
        return post;
    }

    @GetMapping(path= {"/post","/"})
    public String saludar(Model model){
        model.addAttribute("posts",this.getPost());
        return "index";}
}
