package com.CardonaLoginRegister.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.CardonaLoginRegister.entity.Usuario;
import com.CardonaLoginRegister.repository.RoleRepositorio;
import com.CardonaLoginRegister.service.ServicioUsuario;



@Controller
public class UserController {
	
	@Autowired
	ServicioUsuario serviciousuario;
	
	@Autowired
	RoleRepositorio rolerepositorio;

	@GetMapping({"/","/login"})
	public String index() {
		return"index";
		
	}
	
	@GetMapping("/userForm")
	public String userForm(Model modelo) {
		modelo.addAttribute("userList", serviciousuario.getAllUsuarios());
		modelo.addAttribute("userForm", new Usuario());
		modelo.addAttribute("roles", rolerepositorio.findAll());
		return"user-form";
		
	}
	
	@PostMapping("/userForm")
	public String crearUsuario(@Valid @ModelAttribute("userForm") Usuario usuario,BindingResult resultado,ModelMap modelo) {
		if(resultado.hasErrors()) {
			modelo.addAttribute("userForm", usuario);
			
		}else {
			try {
				serviciousuario.crearUsuario(usuario);
				modelo.addAttribute("userForm",new Usuario());
			} catch (Exception e) {
				modelo.addAttribute("formErrorMessage",e.getMessage());
				modelo.addAttribute("userForm", usuario);
				modelo.addAttribute("userList", serviciousuario.getAllUsuarios());
				modelo.addAttribute("roles", rolerepositorio.findAll());
			}
			
		}
		modelo.addAttribute("roles", rolerepositorio.findAll());
		modelo.addAttribute("userList", serviciousuario.getAllUsuarios());
		modelo.addAttribute("userForm", usuario);
		
		return "user-form";
	}
}

