package com.bytecode.core.service;

import com.bytecode.core.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public List<Post> validation(List<Post> posts) {
        System.out.println("Primer servicio");
        for (Post post : posts) {
            if (post.getTitulo() == null) {
                throw new NullPointerException("El titulo esta nulo ");
            }
        }
        return posts;
    }
    }
