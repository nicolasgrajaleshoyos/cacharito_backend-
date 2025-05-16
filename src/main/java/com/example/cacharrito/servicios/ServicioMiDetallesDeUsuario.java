package com.example.cacharrito.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cacharrito.modelo.Administrador;
import com.example.cacharrito.repositorio.RepositorioAdministrador;

import java.util.Collections; 

@Service
public class ServicioMiDetallesDeUsuario implements UserDetailsService {

    @Autowired
    private RepositorioAdministrador repositorioAdministrador;

    private final PasswordEncoder passwordEncoder;

    ServicioMiDetallesDeUsuario(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrador user = repositorioAdministrador.findByUsuario(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsuario())    
                .password(user.getContraseña()) 
                .authorities(Collections.emptyList())
                .build();
    }
    
    public Administrador crearAdministrador(String username, String password) {
        Administrador usuario = new Administrador();
        usuario.setUsuario(username);;
        usuario.setContraseña(passwordEncoder.encode(password));
   
       return repositorioAdministrador.save(usuario);
    }
    
}

