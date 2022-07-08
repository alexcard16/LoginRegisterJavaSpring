package com.CardonaLoginRegister.service;

import com.CardonaLoginRegister.entity.Usuario;

public interface ServicioUsuario {
	
	public Iterable<Usuario> getAllUsuarios();

	public Usuario crearUsuario(Usuario usuario) throws Exception;

}
