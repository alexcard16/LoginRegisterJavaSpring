package com.CardonaLoginRegister.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CardonaLoginRegister.entity.Usuario;
import com.CardonaLoginRegister.repository.UsuarioRepositorio;

@Service
public class UsuarioServicesImplement implements ServicioUsuario{

	@Autowired
	UsuarioRepositorio repositorio;
	
	@Override
	public Iterable<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	
	private boolean checkCedulaExist(Usuario usuario) throws Exception {
		Optional<Usuario> usuarioEncontrado= repositorio.findByCedula(usuario.getCedula());
		if(usuarioEncontrado.isPresent()) {
			throw new Exception("La cedula ya existe");
		}
		
		return true;
	}
	
	private boolean checkPasswordIgual(Usuario usuario) throws Exception {
		if(!(usuario.getPassword()).equals(usuario.getComfirPassword())) {
			throw new Exception("Password y Confirmar Password son diferentes");
		}
		return true;
	}
	
	private boolean checkEmailIgual(Usuario usuario) throws Exception {
		if(!usuario.getEmail().equals(usuario.getComfirEmail())) {
			throw new Exception("email y Confirmar email son diferentes");
		}
		return true;
	}


	@Override
	public Usuario crearUsuario(Usuario usuario) throws Exception {
		if(checkCedulaExist(usuario) && checkPasswordIgual(usuario) && checkEmailIgual(usuario)) {
			usuario=repositorio.save(usuario);
			throw new Exception("Registro exitoso");
		}
		return usuario;
	}
}
