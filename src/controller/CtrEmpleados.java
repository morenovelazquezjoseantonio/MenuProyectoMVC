package controller;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.FrmEditEmpleado;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase CtrEmpleados (Controller Empleados)
 * @since 25-09-2018
 * @version V-1
 *
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
 * Conocer de la fila seleccionada en el JTable (filaActiva), la primera columna (contiene la PK (idPrimaryKey) del proyecto que quiero borrar
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
 * Nombre del metodo actualizar
 * 
 * 
 */
	public static void actualizarJTableEmpleados() {
		try {
			// obtener Datos de la BD
			CachedRowSet datos = logic.LogicEmpleados.leerEmpleados();
			// con los datos obtenidos generar un Modelo de JTable
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			// Pintar el JTable
			view.FrmEmpleados.table.setModel(modelo);
			} catch (Exception e) {
		}
	}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha selecccionado nada");
		}
	}

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha selecccionado nada");
		}
	}

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha selecccionado nada");
		}
	}

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha selecccionado nada");
		}
	}

}
