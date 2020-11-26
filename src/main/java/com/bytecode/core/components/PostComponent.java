package com.bytecode.core.components;

import com.bytecode.core.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("com.bytecode.core.components.postComponent")
public class PostComponent {

    public List<Post> getPosts(){
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post(1,"MONCHI TU CURSO ES DE FRONTEND","/img/monchi.png",new Date(),"DESARROLLO FRONTEND"));
        post.add(new Post(2,"MONCHI TU CURSO ES DE FRONTEND","/img/monchi.png",new Date(),"DESARROLLO BACKEND"));
        post.add(new Post(3,"MONCHI TU CURSO ES DE FRONTEND","/img/monchi.png",new Date(),"DESARROLLO LOLOLOLO"));
        return post;
    }
}
