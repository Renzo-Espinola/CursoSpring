package com.bytecode.core.beans;

import com.bytecode.core.model.Conexion;
import com.bytecode.core.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CreandoConexion {

    @Bean(name="beanUsuario")
    public Usuario getUsuario(){
        return new Usuario(); }

    @Bean(name="beanConexion")
    public Conexion getConexion(){
        Conexion conexion = new Conexion();
        conexion.setDb("mySql");
        conexion.setUrl("localhost");
        return conexion;
    }
}
