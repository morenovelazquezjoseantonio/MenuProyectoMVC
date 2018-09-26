package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicProyectos {

	public static CachedRowSet leerProyectos() throws SQLException {
		return databasemanager.DBsqlServer.consultaSQL("SELECT * FROM FBproyectos");
	}

	public static void guardarProyecto(String nombre, String presupuesto, String fechaIni, String fechaFin)
			throws SQLException {
		String sql = "INSERT INTO FBproyectos(Nombre,Presupuesto,Fecha_Inicio,Fecha_Fin) VALUES  ('" + nombre + "','"
				+ presupuesto + "','" + fechaIni + "','" + fechaFin + "')";
		databasemanager.DBsqlServer.executeDML(sql);
	}

	public static void borrarProyecto(String idPrimaryKey) throws SQLException {
		String sql = "DELETE FROM FBPROYECTOS WHERE ID_PROYECTO=" + idPrimaryKey;
		databasemanager.DBsqlServer.executeDML(sql);
	}

	public static void modificarProyectos(String idPrimaryKey, String nombre, String presupuesto, String fechaInicio,
			String fechaFin) throws SQLException {
		String sql = "UPDATE FBProyectos SET Nombre='" + nombre + "', Presupuesto='" + presupuesto + "' ,Fecha_Inicio='"
				+ fechaInicio + "', Fecha_Fin='" + fechaFin + "' WHERE ID_Proyecto='" + idPrimaryKey + "'";
		databasemanager.DBsqlServer.executeDML(sql);
	}

}
