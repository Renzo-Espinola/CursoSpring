package com.bytecode.core.service;

import com.bytecode.core.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceDecorado")
public class PostServiceDecoradoImp implements PostService {
    @Autowired
    private PostServiceImpl postServiceImpl;
    @Autowired
    private PostServiceDosImpl postServiceDosImpl;

    @Override
    public List<Post> validation(List<Post> posts) {
        posts = postServiceImpl.validation(posts);
        posts = postServiceDosImpl.validation(posts);
        for (Post post : posts) {
            if (post.getDescripcion() == null) {
                throw new NullPointerException("La descripcion esta null ");
            }
            if (post.getFecha() == null) {
                throw new NullPointerException("La fecha esta null ");
            }
        }
        System.out.println("Esta es la clase decorada");
        return posts;
    }
}

