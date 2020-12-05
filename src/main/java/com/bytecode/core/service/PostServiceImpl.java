package com.bytecode.core.service;

import com.bytecode.core.model.Post;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final Log log = LogFactory.getLog((getClass()));
    @Override
    public List<Post> validation(List<Post> posts) throws NullPointerException{
        log.info("Servicio 1");
        for (Post post : posts) {
            if (post.getTitulo() == null) {
                throw new NullPointerException("El titulo esta nulo ");
            }
        }
        return posts;
    }

    @Override
    public void addClass(Class clazz) {
        System.out.println(clazz.getName());
    }
}
