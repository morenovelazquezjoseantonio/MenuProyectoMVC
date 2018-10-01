package model;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase Proyecto
 * @since 24-09-2018
 * @version V-1
 * private String nombre
 * private String presupuesto
 * private String fechainicio
 * private String fechafin
 */
public class Proyecto {

	private String nombre;
	private String presupuesto;
	private String fechainicio;
	private String fechafin;

	public Proyecto() {
		super();
	}

	public Proyecto(String nombre, String presupuesto, String fechainicio, String fechafin) {
		super();
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	@Override
	public String toString() {
		return "Proyecto - " + nombre + " - " + presupuesto + " - " + fechainicio + " - " + fechafin + " ";
	}

}
