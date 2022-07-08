package com.CardonaLoginRegister.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CardonaLoginRegister.entity.Role;

@Repository
public interface RoleRepositorio extends CrudRepository<Role, Long>{

}
