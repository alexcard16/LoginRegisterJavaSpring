package com.CardonaLoginRegister.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CardonaLoginRegister.entity.Usuario;


@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

	

	public Optional<Usuario> findByCedula(String cedula);

	
	

}
