package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicEquipos {

	public static CachedRowSet leerCargos() throws SQLException {
		return databasemanager.DBsqlServer.consultaSQL("SELECT * FROM FBCargo");
	}

	public static CachedRowSet getConsultaEquipos(String stringpK) throws SQLException {
		String sql = "select e.ID_Equipo,t.Nombre,c.Cargo  from FBTrabajador as t inner join FBEquipo as e on t.ID_Trabajador=e.ID_Trabajador inner join FBcargo as c on e.ID_Cargo=c.ID_Cargo where ID_Proyectos="
				+ stringpK;
		return databasemanager.DBsqlServer.consultaSQL(sql);

	}

	public static CachedRowSet leerEquipos() throws SQLException {
		return databasemanager.DBsqlServer.consultaSQL("SELECT * FROM FBequipo");
	}

	public static void guardarEquipos(String ID_P, String ID_T, String ID_C) throws SQLException {
		String sql = "INSERT INTO FBequipo(ID_Proyectos,ID_Trabajador,ID_Cargo) VALUES ('" + ID_P + "','" + ID_T + "','"
				+ ID_C + "')";
		databasemanager.DBsqlServer.executeDML(sql);
	}

	public static void borrarEquipo(String stringpK) throws SQLException {
		String sql = "DELETE FROM FBequipo WHERE ID_Equipo=" + stringpK;
		databasemanager.DBsqlServer.executeDML(sql);
	}

}
