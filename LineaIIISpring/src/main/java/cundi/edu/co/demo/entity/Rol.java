package cundi.edu.co.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	private Integer idRol;

	@Column(name = "nombre", length = 20)
	private String nombre;

	@Column(name = "descripcion", length = 30)
	private String descripcion;
	
	public Rol() {
		
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
