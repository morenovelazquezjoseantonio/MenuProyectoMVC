package controller;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.FrmEditProyecto;
import view.FrmProyectoNuevo;

public class CtrProyectos {
	/**
	 * @author Jose Antonio Moreno Velazquez
	 * clase CtrProyectos
	 * @since 24-09-2018
	 * @version V-1
	 */
	public static String nombre, presupuesto, fechaInicio, fechaFin, idPrimaryKey;
	/**
	 * Nombre del metodo Inicio()
	 * Inicia la clase FrmProyectos(ventana proyectos)
	 * Actualiza tabla de empleados (actualizarJtableProyectos())
	 */
	public static void inicio() {

		try {
			new view.FrmProyectos();
			actualizarJTableProyectos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Nombre de metodo GuardarProyecto
	 * Recoge los datos de la pantalla FrmNuevoProyecto(nombre,presupuesto,fecha inicio, fecha fin)
	 * Los envia a la clase LogicProyectos al metodo  guardarProyectos() 
	 * Actualiza tabla de proyectos (actualizarJtableProyectos())
	 */
	public static void guardarProyecto() {
		nombre = view.FrmProyectoNuevo.tfNombre.getText();
		presupuesto = view.FrmProyectoNuevo.tfPresupuesto.getText();
		fechaInicio = view.FrmProyectoNuevo.tfFechaInicio.getText();
		fechaFin = view.FrmProyectoNuevo.tfFechaFin.getText();
		try {
			logic.LogicProyectos.guardarProyecto(nombre, presupuesto, fechaInicio, fechaFin);
			actualizarJTableProyectos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Nombre de metodo mostrarNuevo
	 * Inicia la clase FrmProyectoNuevo(ventana nuevo proyecto) 
	 * Actualiza tabla de empleados (actualizarJtableProyectos())
	 */
	public static void mostrarNuevo() {
		new FrmProyectoNuevo();
		actualizarJTableProyectos();
	}
	/**
	 * Nombre del metodo borrarProyecto
	 * Conocer de la fila seleccionada en el JTable (filaActiva), la primera columna (contiene la PK 
	 * (idPrimaryKey) del proyecto que quiero borrar
	 * Actualiza tabla de proyectos (actualizarJtableProyectos())
	 */
	public static void borrarProyecto() {
		int filaActiva = view.FrmProyectos.table.getSelectedRow();
		String idPrimaryKey = view.FrmProyectos.table.getValueAt(filaActiva, 0).toString();
		try {
			logic.LogicProyectos.borrarProyecto(idPrimaryKey);
			actualizarJTableProyectos();
			} catch (Exception e) {
		}
	}
	/**
	 * Nombre del metodo actualizarJTableProyectos
	 * Obtiene datos de la base de datos
	 * Genera un modelo con los datos
	 * Envia los datos a la tabla
	 */
	public static void actualizarJTableProyectos() {
		try {
			CachedRowSet datos = logic.LogicProyectos.leerProyectos();
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			view.FrmProyectos.table.setModel(modelo);
			view.FrmProyectos.table.getColumnModel().getColumn(0).setMaxWidth(0);
			view.FrmProyectos.table.getColumnModel().getColumn(0).setMinWidth(0);
			view.FrmProyectos.table.getColumnModel().getColumn(0).setPreferredWidth(0);
			
			
			
			} catch (Exception e) {
		}
	}
	/**
	 * Nombre del metodo editarProyecto
	 * Realiza una consulta a la base de datos a la table proyectos
	 * Selecciona un proyecto de la tabla proyecto
	 * Recoge los datos de los campos en la ventana proyectos
	 * Sino se selecciona algun empleado de la tabla
	 * muestra un mensaje de error
	 * lanza la ventana de infoProyecto
	 */
	public static void editarProyecto() {

		int filaActiva = view.FrmProyectos.table.getSelectedRow();
		if (filaActiva >= 0) {
			try {
				CachedRowSet datos = logic.LogicProyectos.leerProyectos();
				datos.next();
				nombre = view.FrmProyectos.table.getValueAt(filaActiva, 1).toString();
				presupuesto = view.FrmProyectos.table.getValueAt(filaActiva, 2).toString();
				fechaInicio = view.FrmProyectos.table.getValueAt(filaActiva, 3).toString();
				fechaFin = view.FrmProyectos.table.getValueAt(filaActiva, 4).toString();
				new view.FrmInfoProyecto();
				} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha selecccionado nada");
		}
	}
	/**
	 * Nombre del metodo modificarProyecto
	 * Realiza una consulta a la base de datos a la table proyectos
	 * Selecciona un proyecto de la tabla proyectos
	 * Recoge los datos de los campos de la ventana proyectos
	 * Sino se selecciona algun proyecto de la tabla
	 * muestra un mensaje de error
	 * lanza la ventana de EditProyecto
	 */
	public static void modificarProyecto() {

		int filaActiva = view.FrmProyectos.table.getSelectedRow();

		try {

			CachedRowSet datos = logic.LogicProyectos.leerProyectos();
			datos.next();
			idPrimaryKey = view.FrmProyectos.table.getValueAt(filaActiva, 0).toString();
			nombre = view.FrmProyectos.table.getValueAt(filaActiva, 1).toString();
			presupuesto = view.FrmProyectos.table.getValueAt(filaActiva, 2).toString();
			fechaInicio = view.FrmProyectos.table.getValueAt(filaActiva, 3).toString();
			fechaFin = view.FrmProyectos.table.getValueAt(filaActiva, 4).toString();
			new view.FrmEditProyecto();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Nombre del metodo capturarDatosProyectos
	 * Realiza una consulta a la base de datos a la table proyectos
	 * Selecciona un proyecto de la tabla proyecto
	 * Recoge los datos de los campos de la ventana proyectos
	 * Sino se selecciona algun proyecto de la tabla
	 * muestra un mensaje de error
	 * Modifica la tabla de proyectos con los nuevos datos 
	 * recogidos de la ventana editProyecto
	 * Actualiza los datos de la tabla proyectos
	 */
	public static void capturarDatosProyectos() {

		int filaActiva = view.FrmProyectos.table.getSelectedRow();

		try {

			CachedRowSet datos = logic.LogicProyectos.leerProyectos();
			datos.next();
			idPrimaryKey = view.FrmProyectos.table.getValueAt(filaActiva, 0).toString();

			nombre = FrmEditProyecto.tfNombre.getText();
			presupuesto = FrmEditProyecto.tfPresupuesto.getText();
			fechaInicio = FrmEditProyecto.tfFechaInicio.getText();
			fechaFin = FrmEditProyecto.tfFechaFin.getText();
			logic.LogicProyectos.modificarProyectos(idPrimaryKey, nombre, presupuesto, fechaInicio, fechaFin);
			actualizarJTableProyectos();

			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
