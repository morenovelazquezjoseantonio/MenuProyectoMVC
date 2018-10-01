package databasemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase DBsqlServer
 * @since 24-09-2018
 * @version V-1
 */
public class DBsqlServer {

	public static String cadenaConexion;

	/**
	 * Nombre del metodo crearCadenaConexion()
	 * @param String strIP , recoge la direccion ip
	 * @param String strPort, recoge el puerto
	 * @param String strDatabaseName, recoge el nombre de la base de datos
	 * @param String strUserName , recoge el nombre de ususario
	 * @param String strUserPassword, recoge el password
	 * crea la cadena string para pasar los parametros necesarios
	 * para conectarse con la base de datos 
	 */
	public static void crearCadenaConexion(String strIP, String strPort, String strDatabaseName, String strUserName,
			String strUserPassword) {
		String cadena = "jdbc:sqlserver:";
		cadena += "//" + strIP;
		cadena += ":" + strPort;
		cadena += ";database=" + strDatabaseName;
		cadena += ";user=" + strUserName;
		cadena += ";password=" + strUserPassword;
		cadenaConexion = cadena;
		}
	/**
	 * Nombre del metodo EstablecerConexion()
	 * @return , realiza la conexion con el servidor de base de datos
	 */
	public static Connection establecerConexion() throws SQLException {
		return DriverManager.getConnection(cadenaConexion);
		}
	/**
	 * Nombre del metodo EstablecerConexion()
	 * @param Connection conn
	 * cierra la conexion con el servidor de base de datos
	 */
	
	public static void cerrarConexion(Connection conn) throws SQLException {
		conn.close();
		}
	/**
	 * Nombre del metodo executeDML()
	 * @param String strSQL
	 * Realiza la conexion
	 * Ejecuta la instruccion DML en la base de datos
	 * Cierra la conexion con el servidor de base de datos
	 * @return rowset , devuelve los datos
	 */
	
	public static void executeDML(String strSQL) throws SQLException {
		Connection c = databasemanager.DBsqlServer.establecerConexion();
		Statement s = c.createStatement();
		s.executeUpdate(strSQL);
		databasemanager.DBsqlServer.cerrarConexion(c);
		}
	/**
	 * Nombre del metodo consultaSQL()
	 * @param String strSQL
	 * Realiza la conexion
	 * Ejecuta la consulta en la base de datos
	 * Cierra la conexion con el servidor de base de datos
	 * @return rowset , devuelve los datos 
	 */
	public static CachedRowSet consultaSQL(String strSQL) throws SQLException {
		Connection c = databasemanager.DBsqlServer.establecerConexion();
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery(strSQL);
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet rowset = factory.createCachedRowSet();
		rowset.populate(r);
		databasemanager.DBsqlServer.cerrarConexion(c);
		return rowset;
		}
	/**
	 * Nombre del metodo testConexion()
	 * Comprueba la conexion con el servidor de la base de datos 
	 * @return test , tipo boolean 
	 */
	public static boolean testConexion() {
		boolean test = false;
		try {
			Connection c = establecerConexion();
			cerrarConexion(c);
			test = true;
		} catch (Exception e) {
			test = false;}
		return test;}
}
