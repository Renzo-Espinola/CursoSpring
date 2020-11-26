package com.bytecode.core;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.model.Conexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {
	@Autowired
	@Qualifier("beanConexion")
	private Conexion conexion;

	@Autowired
	@Qualifier("com.bytecode.core.components.postComponent")
    public PostComponent postComponent;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		postComponent.getPosts().forEach(p->{
			System.out.println(p.getDescripcion());
		});
	}
}
