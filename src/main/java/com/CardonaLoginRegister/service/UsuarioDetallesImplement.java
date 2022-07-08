package com.CardonaLoginRegister.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CardonaLoginRegister.entity.Role;
import com.CardonaLoginRegister.repository.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioDetallesImplement implements UserDetailsService {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String cedula) throws UsernameNotFoundException {
		
		com.CardonaLoginRegister.entity.Usuario appUser = 
                usuarioRepositorio.findByCedula(cedula).orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));
		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
		for (Role roles: appUser.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roles.getDescripcion());
            grantList.add(grantedAuthority);       
		}
		UserDetails usuario = (UserDetails) new User(cedula,appUser.getPassword(),grantList);
		
		return usuario;
	}

}
