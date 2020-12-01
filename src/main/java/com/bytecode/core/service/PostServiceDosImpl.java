package com.bytecode.core.service;

import com.bytecode.core.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ServiceDos")
public class PostServiceDosImpl implements PostService {
    @Override
    public List<Post> validation(List<Post> posts) {
        System.out.println("Segundo servicio");
        for (Post post : posts) {
            if (post.getId() == 0) {
                throw new NullPointerException("El id esta nulo ");
            }
        }
        return posts;
    }
}

