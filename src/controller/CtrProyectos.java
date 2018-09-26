package controller;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.FrmEditProyecto;
import view.FrmProyectoNuevo;

public class CtrProyectos {

	public static String nombre, presupuesto, fechaInicio, fechaFin, idPrimaryKey;

	public static void inicio() {

		try {
			new view.FrmProyectos();
			actualizarJTableProyectos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

	public static void mostrarNuevo() {
		new FrmProyectoNuevo();
		actualizarJTableProyectos();
	}

	public static void borrarProyecto() {
		// conocer de la fila seleccionada en el JTable, la primera columna (contiene la
		// PK del proyecto que quiero borrar
		int filaActiva = view.FrmProyectos.table.getSelectedRow();
		String idPrimaryKey = view.FrmProyectos.table.getValueAt(filaActiva, 0).toString();

		try {

			logic.LogicProyectos.borrarProyecto(idPrimaryKey);

			actualizarJTableProyectos();
		} catch (Exception e) {
		}

	}

	public static void actualizarJTableProyectos() {
		try {
			// obtener Datos de la BD
			CachedRowSet datos = logic.LogicProyectos.leerProyectos();
			// con los datos obtenidos generar un Modelo de JTable
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			// Pintar el JTable
			view.FrmProyectos.table.setModel(modelo);
		} catch (Exception e) {
		}
	}

	public static void editarProyecto() {

		int filaActiva = view.FrmProyectos.table.getSelectedRow();

		if (filaActiva >= 0) {

			// String idPrimaryKey = view.FrmProyectos.table.getValueAt(filaActiva,
			// 0).toString();

			try {
				CachedRowSet datos = logic.LogicProyectos.leerProyectos();
				datos.next();

				nombre = view.FrmProyectos.table.getValueAt(filaActiva, 1).toString();
				presupuesto = view.FrmProyectos.table.getValueAt(filaActiva, 2).toString();
				fechaInicio = view.FrmProyectos.table.getValueAt(filaActiva, 3).toString();
				fechaFin = view.FrmProyectos.table.getValueAt(filaActiva, 4).toString();

				new view.FrmInfoProyecto();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se ha selecccionado nada");
		}
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
