package com.example.cacharrito.controlador;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class ControladorAdministrador{

	
	  

    @PostMapping("/login")
    public void login() {
                      
    }
}