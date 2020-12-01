package com.bytecode.core;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.model.Conexion;
import com.bytecode.core.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {
    @Autowired
    @Qualifier("beanConexion")
    private Conexion conexion;

    @Autowired
    @Qualifier("com.bytecode.core.components.postComponent")
    public PostComponent postComponent;

    @Autowired
    @Qualifier("ServiceDecorado")
    public PostService postService;

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
		/*postComponent.getPosts().forEach(p->{
			System.out.println(p.getDescripcion());*/
        try {
            postService.validation(postComponent.getPosts()).forEach((post -> {
                System.out.println(post.getTitulo());
            }));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
