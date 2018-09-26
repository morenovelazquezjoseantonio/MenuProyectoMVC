package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicEmpleados {

	public static CachedRowSet leerEmpleados() throws SQLException {
		return databasemanager.DBsqlServer.consultaSQL("SELECT * FROM FBtrabajador");
	}

	public static void guardarEmpleados(String dni, String nombre, String apellidos, String genero)
			throws SQLException {
		String sql = "INSERT INTO FBtrabajador(DNI,Nombre,Apellidos,Genero) VALUES ('" + dni + "','" + nombre + "','"
				+ apellidos + "','" + genero + "')";
		databasemanager.DBsqlServer.executeDML(sql);
	}

	public static void borrarEmpleado(String idPrimaryKey) throws SQLException {
		String sql = "DELETE FROM FBproyecto WHERE IDPROYECTO=" + idPrimaryKey;
		databasemanager.DBsqlServer.executeDML(sql);
	}

	public static void modificarEmpleados(String idPrimaryKey, String dni, String nombre, String apellidos,
			String genero) throws SQLException {
		String sql = "UPDATE FBtrabajador SET DNI='" + dni + "', Nombre='" + nombre + "' ,Apellidos='" + apellidos
				+ "', Genero='" + genero + "' WHERE ID_Trabajador='" + idPrimaryKey + "'";
		databasemanager.DBsqlServer.executeDML(sql);
	}
}