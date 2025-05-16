package com.example.cacharrito.configuracion;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.cacharrito.servicios.ServicioMiDetallesDeUsuario;

@Configuration
@EnableWebSecurity
public class ConfiguracionDeSeguridad {

	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	http
        .csrf().disable() // Deshabilitar CSRF si estás trabajando con APIs
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(
            		"/api/usuarios/buscar_id",
            		"/api/usuarios/guardar",
            		"/api/reservaciones/buscar_por_origen_destino_fecha",
                         "/api/reservaciones/ver_todos",
                         "/api/disponibilidad/ver_todos",
                         "/api/automoviles/ver_todos",
                         "/api/disponibilidad/actualizar").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(); // Habilita la autenticación básica

        return http.build();
    }

    @Bean
    public org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration authenticationConfiguration() {
        return new org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration();
    }
    // Bean para exponer el AuthenticationManager
    @Bean
    public org.springframework.security.authentication.AuthenticationManager authenticationManager(
            org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

