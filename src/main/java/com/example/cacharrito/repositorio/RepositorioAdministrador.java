package com.example.cacharrito.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cacharrito.modelo.Administrador;


@Repository
public interface RepositorioAdministrador extends JpaRepository<Administrador,Long> {
   public Administrador findByUsuario(String usuario);


}