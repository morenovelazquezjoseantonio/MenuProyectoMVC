package controller;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.FrmEditEmpleado;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase CtrEmpleados
 * @since 24-09-2018
 * @version V-1
 */

public class CtrEmpleados {

	public static String nombre, apellidos, dni, genero, idPrimaryKey;
/**
 * Nombre del metodo Inicio()
 * Inicia la clase FrmEmpleados(ventana empleados)
 * Actualiza tabla de empleados (actualizarJtableEmpleados())
 */
	public static void inicio() {

		try {
			new view.FrmEmpleados();
			actualizarJTableEmpleados();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/**
 * Nombre de metodo GuardarEmpleado
 * Recoge los datos de la pantalla FrmNuevoEmpleado(dni,nombre,apellidos,genero)
 * Los envia a la clase LogicEmpleados al metodo  guardarEmpleados() 
 * Actualiza tabla de empleados (actualizarJtableEmpleados())
 */
	public static void guardarEmpleado() {
		dni = view.FrmEmpleadoNuevo.tfDni.getText();
		nombre = view.FrmEmpleadoNuevo.tfNombre.getText();
		apellidos = view.FrmEmpleadoNuevo.tfApellidos.getText();
		genero = view.FrmEmpleadoNuevo.tfGenero.getText();

		try {
			logic.LogicEmpleados.guardarEmpleados(dni, nombre, apellidos, genero);
			actualizarJTableEmpleados();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/**
 * Nombre de metodo mostrarNuevo
 * Inicia la clase FrmEmpleadosNuevo(ventana nuevo empleados) 
 * Actualiza tabla de empleados (actualizarJtableEmpleados())
 */
	public static void mostrarNuevo() {
		new view.FrmEmpleadoNuevo();
		actualizarJTableEmpleados();
	}
/**
 * Nombre del metodo borrarEmpleado
 * Conocer de la fila seleccionada en el JTable (filaActiva), la primera columna
 * (contiene la PK (idPrimaryKey) del empleado que quiero borrar
 * Actualiza tabla de empleados (actualizarJtableEmpleados())
 */
	public static void borrarEmpleado() {
		
		int filaActiva = view.FrmEmpleados.table.getSelectedRow();
		idPrimaryKey = view.FrmEmpleados.table.getValueAt(filaActiva, 0).toString();
		try {
			logic.LogicEmpleados.borrarEmpleado(idPrimaryKey);
			actualizarJTableEmpleados();
			} catch (Exception e) {
		}
	}
/**
 * Nombre del metodo actualizarJTableEmpleados
 * Obtiene datos de la base de datos
 * Genera un modelo con los datos
 * Envia los datos a la tabla
 */
	public static void actualizarJTableEmpleados() {
		try {
			CachedRowSet datos = logic.LogicEmpleados.leerEmpleados();
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			view.FrmEmpleados.table.setModel(modelo);
			view.FrmEmpleados.table.getColumnModel().getColumn(0).setMaxWidth(0);
			view.FrmEmpleados.table.getColumnModel().getColumn(0).setMinWidth(0);
			view.FrmEmpleados.table.getColumnModel().getColumn(0).setPreferredWidth(0);
			} catch (Exception e) {
		}
	}
	/**
	 * Nombre del metodo selectEmpleado
	 * Realiza una consulta a la base de datos a la table empleados
	 * Selecciona un empleado de la tabla empleados
	 * Recoge los datos de los campos dni,nombre,apellidos y genero
	 * Sino se selecciona algun empleado de la tabla
	 * muestra un mensaje de error
	 * lanza la ventana de SelectEmpleado
	 */
	public static void selectEmpleado() {

		int filaActiva = view.FrmEmpleados.table.getSelectedRow();
		if (filaActiva >= 0) {
			try {
				CachedRowSet datos = logic.LogicEmpleados.leerEmpleados();
				datos.next();
				dni = view.FrmEmpleados.table.getValueAt(filaActiva, 1).toString();
				nombre = view.FrmEmpleados.table.getValueAt(filaActiva, 2).toString();
				apellidos = view.FrmEmpleados.table.getValueAt(filaActiva, 3).toString();
				genero = view.FrmEmpleados.table.getValueAt(filaActiva, 4).toString();
				new view.FrmSelectEmpleado();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha selecccionado nada");
		}
	}
	/**
	 * Nombre del metodo editarEmpleado
	 * Realiza una consulta a la base de datos a la table empleados
	 * Selecciona un empleado de la tabla empleados
	 * Recoge los datos de los campos dni,nombre,apellidos y genero
	 * Sino se selecciona algun empleado de la tabla
	 * muestra un mensaje de error
	 * lanza la ventana de infoEmpleado
	 */
	public static void editarEmpleado() {
		int filaActiva = view.FrmEmpleados.table.getSelectedRow();
		if (filaActiva >= 0) {
			try {
				CachedRowSet datos = logic.LogicEmpleados.leerEmpleados();
				datos.next();
				dni = view.FrmEmpleados.table.getValueAt(filaActiva, 1).toString();
				nombre = view.FrmEmpleados.table.getValueAt(filaActiva, 2).toString();
				apellidos = view.FrmEmpleados.table.getValueAt(filaActiva, 3).toString();
				genero = view.FrmEmpleados.table.getValueAt(filaActiva, 4).toString();
				new view.FrmInfoEmpleado();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha selecccionado nada");
		}
	}

	/**
	 * Nombre del metodo modificarEmpleado
	 * Realiza una consulta a la base de datos a la table empleados
	 * Selecciona un empleado de la tabla empleados
	 * Recoge los datos de los campos dni,nombre,apellidos y genero
	 * Sino se selecciona algun empleado de la tabla
	 * muestra un mensaje de error
	 * lanza la ventana de EditEmpleado
	 */
	public static void modificarEmpleado() {

		int filaActiva = view.FrmEmpleados.table.getSelectedRow();

		if (filaActiva >= 0) {

			try {
				CachedRowSet datos = logic.LogicEmpleados.leerEmpleados();
				datos.next();
				idPrimaryKey = view.FrmEmpleados.table.getValueAt(filaActiva, 0).toString();
				dni = view.FrmEmpleados.table.getValueAt(filaActiva, 1).toString();
				nombre = view.FrmEmpleados.table.getValueAt(filaActiva, 2).toString();
				apellidos = view.FrmEmpleados.table.getValueAt(filaActiva, 3).toString();
				genero = view.FrmEmpleados.table.getValueAt(filaActiva, 4).toString();
				new view.FrmEditEmpleado();
				} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha selecccionado nada");
		}
	}

	/**
	 * Nombre del metodo capturarEmpleado
	 * Realiza una consulta a la base de datos a la table empleados
	 * Selecciona un empleado de la tabla empleados
	 * Recoge los datos de los campos idPrimaryKey,dni,nombre,apellidos y genero
	 * Sino se selecciona algun empleado de la tabla
	 * muestra un mensaje de error
	 * Modifica la tabla de empleados con los nuevos datos 
	 * recogidos de la ventana editEmpleado
	 * Actualiza los datos de la tabla empleados
	 */
	public static void capturarDatos() {

		int filaActiva = view.FrmEmpleados.table.getSelectedRow();
		if (filaActiva >= 0) {
			try {
				CachedRowSet datos = logic.LogicEmpleados.leerEmpleados();
				datos.next();
				idPrimaryKey = view.FrmEmpleados.table.getValueAt(filaActiva, 0).toString();
				dni = FrmEditEmpleado.tfDni.getText();
				nombre = FrmEditEmpleado.tfNombre.getText();
				apellidos = FrmEditEmpleado.tfApellidos.getText();
				genero = FrmEditEmpleado.tfGenero.getText();
				logic.LogicEmpleados.modificarEmpleados(idPrimaryKey, dni, nombre, apellidos, genero);
				actualizarJTableEmpleados();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha selecccionado nada");
		}
	}

}
