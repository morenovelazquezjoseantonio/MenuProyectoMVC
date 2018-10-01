package controller;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase CtrEquipos
 * @since 24-09-2018
 * @version V-1
 */
public class CtrEquipos {
	public static String idPrimaryKeyp, idPrimaryKeyc, idPrimaryKeye;
	public static int filaActivap, filaActivac, filaActivae;
	/**
	 * Nombre del metodo Inicio()
	 * Inicia la clase FrmEquipos(ventana equipos)
	 * Actualiza tabla de proyectos (actualizarJtableProyetos())
	 * Actualiza tabla de equipos (actualizarJtableEquipos())
	 */
	public static void inicio() {
		try {
			new view.FrmEquipos();
			actualizarJTableProyectos();
			actualizarJTableEquipos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Nombre de metodo actualizarJTableCargosSelect
	 * Inicia la ventana de cargos para seleccionar
	 * Realiza una consulta a la tabla de cargos 
	 * Genera un modelo y lo envia la tabla de la ventana cargos
	 */
	public static void actualizarJTableCargosSelect() {
		new view.FrmSelectCargo();
		try {
			CachedRowSet datos = logic.LogicEquipos.leerCargos();
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			view.FrmSelectCargo.table.setModel(modelo);
						
		} catch (Exception e) {
		}
	}
	/**
	 * Nombre de metodo actualizarJTableEmpleadosSelect
	 * Inicia la ventana de empleados para seleccionar
	 * Realiza una consulta a la tabla de empleados 
	 * Genera un modelo y lo envia la tabla de la ventana empleados
	 */
	public static void actualizarJTableEmpleadosSelect() {
		new view.FrmSelectEmpleado();
		try {
			CachedRowSet datos = logic.LogicEmpleados.leerEmpleados();
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			view.FrmSelectEmpleado.table.setModel(modelo);
			} catch (Exception e) {
		}
	}
	/**
	 * Nombre de metodo actualizarJTableProyectos
	 * Realiza una consulta a la tabla de proyectos 
	 * Genera un modelo y lo envia la tabla de la ventana equipos
	 */
	public static void actualizarJTableProyectos() {
		try {
			CachedRowSet datos = logic.LogicProyectos.leerProyectos();
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			view.FrmEquipos.tableProyectos.setModel(modelo);
			view.FrmEquipos.tableProyectos.getColumnModel().getColumn(0).setMaxWidth(0);
			view.FrmEquipos.tableProyectos.getColumnModel().getColumn(0).setMinWidth(0);
			view.FrmEquipos.tableProyectos.getColumnModel().getColumn(0).setPreferredWidth(0);
			} catch (Exception e) {
		}
	}
	/**
	 * Nombre de metodo capturarDatosProyecto
	 * Realiza una consulta a la tabla de proyectos
	 * Selecciona una fila de la tabla de proyectos
	 * selecciona la idPrimaryKey del proyecto seleccionado
	 */
	public static void capturarDatosProyecto() {
		filaActivap = view.FrmEquipos.tableProyectos.getSelectedRow();
		try {
			CachedRowSet datosp = logic.LogicProyectos.leerProyectos();
			datosp.next();
			idPrimaryKeyp = view.FrmEquipos.tableProyectos.getValueAt(filaActivap, 0).toString();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Nombre de metodo capturarDatosCargos
	 * Realiza una consulta a la tabla de cargos
	 * Selecciona una fila de la tabla de Cargos
	 *  selecciona la idPrimaryKey del proyecto seleccionado
	 * llama al metodo capturarDatosEquiposProyectos
	 */
	public static void capturarDatosCargos() {
		filaActivac = view.FrmSelectCargo.table.getSelectedRow();
		try {
			CachedRowSet datosc = logic.LogicEquipos.leerCargos();
			datosc.next();
			idPrimaryKeyc = view.FrmSelectCargo.table.getValueAt(filaActivac, 0).toString();
			capturarDatosEqiposProyectos();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Nombre de metodo capturarDatosEmpleados
	 * Realiza una consulta a la tabla de empleados
	 * Selecciona una fila de la tabla de empleados
	 * selecciona la idPrimaryKey del empleado seleccionado
	 */
	public static void capturarDatosEmpleados() {
		filaActivae = view.FrmSelectEmpleado.table.getSelectedRow();
		try {
			CachedRowSet datose = logic.LogicEmpleados.leerEmpleados();
			datose.next();
			idPrimaryKeye = view.FrmSelectEmpleado.table.getValueAt(filaActivae, 0).toString();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Nombre de metodo capturarDatosEquiposProyecto
	 * Recoge idPrimaryKey del proyecto,empleado y cargo seleccionado
	 * Realiza un insert en la tabla equipos de las PrimaryKey
	 */
	public static void capturarDatosEqiposProyectos() {
		try {
			logic.LogicEquipos.guardarEquipos(idPrimaryKeyp, idPrimaryKeye, idPrimaryKeyc);
			actualizarJTableEquipos();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Nombre de metodo actualizarJTableEquipos
	 * Recoge idPrimaryKey del proyecto seleccionado
	 * Realiza una consulta a la tabla de equipos
	 * Genera una tabla con los datos y los envia a la ventana equipos
	 */
	public static void actualizarJTableEquipos() {

		try {
			CachedRowSet datos = logic.LogicEquipos.getConsultaEquipos(idPrimaryKeyp);
			DefaultTableModel modelo = util.Gui.generarModelo(datos);
			view.FrmEquipos.tableEquipos.setModel(modelo);
			view.FrmEquipos.tableEquipos.getColumnModel().getColumn(0).setMaxWidth(0);
			view.FrmEquipos.tableEquipos.getColumnModel().getColumn(0).setMinWidth(0);
			view.FrmEquipos.tableEquipos.getColumnModel().getColumn(0).setPreferredWidth(0);					
			} catch (Exception e) {
		}
	}
	/**
	 * Nombre de metodo borrarCompEquipo
	 * selecciona en la tabla equipos
	 * Recoge idPrimaryKey del equipo seleccionado
	 * Realiza un borrado en la tabla equipos
	 * Llama al metodo actuazliarJTableEquipos
	 */
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
