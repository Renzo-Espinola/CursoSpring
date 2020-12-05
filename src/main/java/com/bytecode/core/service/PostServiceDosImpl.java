package com.bytecode.core.service;

import com.bytecode.core.model.Post;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceDos")
public class PostServiceDosImpl implements PostService {
    private final Log log = LogFactory.getLog((getClass()));
    @Override
    public List<Post> validation(List<Post> posts) throws NullPointerException{
        log.info("service 2");
        for (Post post : posts) {
            if (post.getId() == 0) {
                throw new NullPointerException("El id esta nulo ");
            }
        }
        return posts;
    }

    @Override
    public void addClass(Class clazz) {
        System.out.println(clazz.getName());
    }
}

