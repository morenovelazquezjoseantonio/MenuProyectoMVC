package start;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase Principal
 * @since 24-09-2018
 * @version V-1
 */
public class Principal {
	
	public static void main(String[] args) {
		Principal app = new Principal();
		app.inicio();
		}
	/**
	 * Nombre del metodo Inicio()
	 * Lee el fichero de texto, ejecutando el metodo cargarFicheroCFG()
	 * Construye la cadena de conexion con el metodo crearCadenaConexion()
	 * Comprueba la conexion con el metodo testConexion()
	 * Inicia el metodo inicioApp de la clase CtrPrincipal
	 * Si la conecion falla lanza un mensaje de error
	 * @throws SQLException 
	 */
	private void inicio() {
		List<String> cfg = null;
		try {
			cfg = util.Ficheros.cargarFicheroCFG();
			} catch (Exception e) {			
			}
		databasemanager.DBsqlServer.crearCadenaConexion(cfg.get(0), cfg.get(1), cfg.get(2), cfg.get(3), cfg.get(4));
		if (databasemanager.DBsqlServer.testConexion()) {
			controller.CtrPrincipal.inicioApp();
		} else {
			JOptionPane.showMessageDialog(null, "No se puede establecer la conexión con el servidor.",
					"ERROR DE CONEXION", JOptionPane.ERROR_MESSAGE);
		}

	}

}
