package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Empleado;
import javax.sql.rowset.CachedRowSet;

public class LogicPrincipal {

	public static CachedRowSet consultaGenerica(String strSQL) throws SQLException {
		return databasemanager.DBsqlServer.consultaSQL(strSQL);
	}

	public static List<String> getLista() throws SQLException {
		CachedRowSet listado = logic.LogicPrincipal.consultaGenerica("SELECT nombre FROM PROYECTOS ORDER BY 1");
		List<String> lst = new ArrayList<String>();
		while (listado.next()) {
			lst.add(listado.getString(1));
		}
		return lst;
	}

	public static List<Empleado> getListaEmpleados() throws SQLException {
		CachedRowSet listado = logic.LogicPrincipal.consultaGenerica("SELECT * FROM FBtrabajador ORDER BY 1");
		List<Empleado> lstEmpleados = new ArrayList<Empleado>();
		Empleado e;
		while (listado.next()) {

			e = new Empleado(listado.getString("dni"), listado.getString("nombre"), listado.getString("apellido"),
					listado.getString("genero"));

			lstEmpleados.add(e); // (listado.getString(1));
		}
		return lstEmpleados;
	}
}