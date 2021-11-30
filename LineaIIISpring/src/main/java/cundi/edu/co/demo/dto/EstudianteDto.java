package cundi.edu.co.demo.dto;

public class EstudianteDto {
	
	private String nombre;
	
	private String apellido;
	
	public EstudianteDto() {
		
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

	public EstudianteDto(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
}
