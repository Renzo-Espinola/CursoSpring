package com.bytecode.core.controllers;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.configuration.Pages;
import com.bytecode.core.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/home")
public class ControllerBasic {

    /*public List<Post> getPosts(){
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post(1,"MONCHI TU CURSO ES DE FRONTEND","/img/monchi.png",new Date(),"DESARROLLO FRONTEND"));
        post.add(new Post(2,"MONCHI TU CURSO ES DE FRONTEND","/img/monchi.png",new Date(),"DESARROLLO BACKEND"));
        post.add(new Post(3,"MONCHI TU CURSO ES DE FRONTEND","/img/monchi.png",new Date(),"DESARROLLO LOLOLOLO"));
        return post;
    }*/

    @Autowired
    private PostComponent _postComponent;


    @GetMapping(path= {"/posts","/"})
    public String saludar(Model model){
        model.addAttribute("posts",this._postComponent.getPosts());
        return "index";}
    
    /*@GetMapping(path="/public")
    public ModelAndView post (){
        ModelAndView modelAndView = new ModelAndView(Pages.HOME);
        modelAndView.addObject("posts",this.getPost());
        return modelAndView;
    }*/
    @GetMapping(path={"/post","/post/p/{post}"})
    public ModelAndView getPostIndividual (
        @RequestParam(defaultValue = "1", name = "id", required = false) int id
        /*@PathVariable(required = true, name = "post") int id*/

    ){
    ModelAndView modelAndView = new ModelAndView(Pages.POST);
    List <Post> postFiltrado = this._postComponent.getPosts().stream()
                                .filter((p)->{return p.getId()==id;}).collect(Collectors.toList());
    modelAndView.addObject("post",postFiltrado.get(0));
    return  modelAndView;
    }
    
    @GetMapping(path="/postNew")
    public ModelAndView getForm(){
        return new ModelAndView("form").addObject("post", new Post());
    }
    
    @PostMapping("/addNewPost")
    public String AddNewPost (Post post, Model model) {
        List<Post> posts = this._postComponent.getPosts();
        posts.add(post);
        model.addAttribute("posts",post);
        return "index";
    }
    
    
    

}
