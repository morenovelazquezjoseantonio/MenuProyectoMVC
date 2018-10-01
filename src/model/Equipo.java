package model;

/**
 * @author Jose Antonio Moreno Velazquez
 * clase Equipo
 * @since 24-09-2018
 * @version V-1
 * Proyecto proyecto
 * Empleado empleado
 * Cargos puesto
 */

public class Equipo {

	Proyecto proyecto;
	Empleado empleado;
	Cargos puesto;

	public Equipo() {
		super();
	}

	public Equipo(Proyecto proyecto, Empleado empleado, Cargos puesto) {
		super();
		this.proyecto = proyecto;
		this.empleado = empleado;
		this.puesto = puesto;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cargos getPuesto() {
		return puesto;
	}

	public void setPuesto(Cargos puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "Equipo [proyecto=" + proyecto + ", empleadi=" + empleado + ", puesto=" + puesto + "]";
	}

}
