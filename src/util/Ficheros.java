package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jose Antonio Moreno Velazquez
 * clase Ficheros
 * @since 24-09-2018
 * @version V-1
 */
public class Ficheros {
	/**
	 * Nombre del metodo cargarFicheroCFG()
	 * Lee el fichero de texto, conexion.txt
	 * @return cfg , tipo List<String> 
	 */
	
	public static List<String> cargarFicheroCFG() throws Exception {
		List<String> cfg = new ArrayList<String>();

		FileReader fch = new FileReader("conexion.txt");
		BufferedReader b = new BufferedReader(fch);

		for (int i = 1; i <= 5; i++) {
			cfg.add(b.readLine());
		}
		b.close();

		return cfg;
	}
}
