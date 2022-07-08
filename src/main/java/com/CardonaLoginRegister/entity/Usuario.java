package com.CardonaLoginRegister.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8176938562455561974L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator= "native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column
	@NotBlank
	@Size(min=5,max=10,message="tamaño del nombre invalido")
	private String nombre;
	
	@Column
	@NotBlank
	private String apellido;
	
	@Column
	@NotBlank
	private String email;
	
	@Transient
	@NotBlank
	private String comfirEmail;
	
	@Column
	@NotBlank
	private String cedula;
	
	@Column
	@NotBlank
	private String password;
	
	@Transient
	@NotBlank
	private String comfirPassword;
	
	@Column
	private String telefono;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="roles_usuarios", joinColumns= @JoinColumn (name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	

	public Usuario() {
		super();
	}

	public Usuario(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComfirEmail() {
		return comfirEmail;
	}

	public void setComfirEmail(String comfirEmail) {
		this.comfirEmail = comfirEmail;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getComfirPassword() {
		return comfirPassword;
	}

	public void setComfirPassword(String comfirPassword) {
		this.comfirPassword = comfirPassword;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", comfirEmail=" + comfirEmail + ", cedula=" + cedula + ", password=" + password + ", comfirPassword="
				+ comfirPassword + ", telefono=" + telefono + ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, cedula, comfirEmail, comfirPassword, email, id, nombre, password, roles,
				telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && cedula == other.cedula
				&& Objects.equals(comfirEmail, other.comfirEmail)
				&& Objects.equals(comfirPassword, other.comfirPassword) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(roles, other.roles)
				&& Objects.equals(telefono, other.telefono);
	}

	
	
	
	

	
}
