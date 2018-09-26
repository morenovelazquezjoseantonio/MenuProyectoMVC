package controller;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

public class CtrEquipos {

	public static String idPrimaryKeyp, idPrimaryKeyc, idPrimaryKeye;
	public static int filaActivap, filaActivac, filaActivae;

	public static void inicio() {
		try {
			new view.FrmEquipos();
			actualizarJTableProyectos();
			actualizarJTableEquipos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void actualizarJTableCargosSelect() {
		new view.FrmSelectCargo();
		try {
			// obtener Datos de la BD
			CachedRowSet datos = logic.LogicEquipos.leerCargos();
			// con los datos obtenidos generar un Modelo de JTable
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			// Pintar el JTable
			view.FrmSelectCargo.table.setModel(modelo);
		} catch (Exception e) {
		}
	}

	public static void actualizarJTableEmpleadosSelect() {
		new view.FrmSelectEmpleado();
		try {
			// obtener Datos de la BD
			CachedRowSet datos = logic.LogicEmpleados.leerEmpleados();
			// con los datos obtenidos generar un Modelo de JTable
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			// Pintar el JTable
			view.FrmSelectEmpleado.table.setModel(modelo);
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
			view.FrmEquipos.tableProyectos.setModel(modelo);
		} catch (Exception e) {
		}
	}

	public static void capturarDatosProyecto() {
		filaActivap = view.FrmEquipos.tableProyectos.getSelectedRow();
		try {
			CachedRowSet datosp = logic.LogicProyectos.leerProyectos();
			datosp.next();
			idPrimaryKeyp = view.FrmEquipos.tableProyectos.getValueAt(filaActivap, 0).toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void capturarDatosCargos() {
		filaActivac = view.FrmSelectCargo.table.getSelectedRow();
		try {
			CachedRowSet datosc = logic.LogicEquipos.leerCargos();
			datosc.next();
			idPrimaryKeyc = view.FrmSelectCargo.table.getValueAt(filaActivac, 0).toString();
			capturarDatosEqiposProyectos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void capturarDatosEmpleados() {
		filaActivae = view.FrmSelectEmpleado.table.getSelectedRow();
		try {
			CachedRowSet datose = logic.LogicEmpleados.leerEmpleados();
			datose.next();
			idPrimaryKeye = view.FrmSelectEmpleado.table.getValueAt(filaActivae, 0).toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void capturarDatosEqiposProyectos() {
		try {
			logic.LogicEquipos.guardarEquipos(idPrimaryKeyp, idPrimaryKeye, idPrimaryKeyc);
			actualizarJTableEquipos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void actualizarJTableEquipos() {

		try {
			// obtener Datos de la BD
			CachedRowSet datos = logic.LogicEquipos.getConsultaEquipos(idPrimaryKeyp);
			// con los datos obtenidos generar un Modelo de JTable
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			// Pintar el JTable
			view.FrmEquipos.tableEquipos.setModel(modelo);
		} catch (Exception e) {
		}
	}
	
public static void borrarCompEquipo() {
		
		int filaActiva = view.FrmEquipos.tableEquipos.getSelectedRow();
		String idPrimaryKey = view.FrmEquipos.tableEquipos.getValueAt(filaActiva, 0).toString();
		try {
			logic.LogicEquipos.borrarEquipo(idPrimaryKey);
			actualizarJTableEquipos();
			} catch (Exception e) {
		}
	}
}
