package model;

/**
 * @author Jose Antonio Moreno Velazquez
 * clase Empleado
 * @since 24-09-2018
 * @version V-1
 * private String dni
 * private String nombre
 * private String apellidos
 * private String genero
 */
public class Empleado {

	private String dni;
	private String nombre;
	private String apellidos;
	private String genero;

	public Empleado() {
		super();
	}

	public Empleado(String dni, String nombre, String apellidos, String genero) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Empleado  - " + dni + " - " + nombre + " - " + apellidos + " - " + genero + " ";
	}

}
