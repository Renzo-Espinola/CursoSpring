package com.bytecode.core.service;

import com.bytecode.core.model.Post;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceDecorado")
@Scope("singleton")
public class PostServiceDecoradoImp implements PostService {
    private final Log log = LogFactory.getLog((getClass()));
    @Autowired
    private PostServiceImpl postServiceImpl;
    @Autowired
    private PostServiceDosImpl postServiceDosImpl;

    @Override
    public List<Post> validation(List<Post> posts) throws NullPointerException {
        log.debug(posts);
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
        //System.out.println("Esta es la clase decorada");
        return posts;
    }

    @Override
    public void addClass(Class clazz) {
        System.out.println(clazz.getName());
    }
}

