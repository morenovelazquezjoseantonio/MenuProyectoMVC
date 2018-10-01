package util;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase Gui
 * @since 24-09-2018
 * @version V-1
 */
public class Gui {

	/**
	 * Nombre del metodo generarModelo()
	 * @param CachedRowSet resultadoL
	 * Recibe los datos de la consulta
	 * Genera un modelo para insertar en la tabla
	 * @return modelo , tipo DefaultTableModel
	 */
	
	public static DefaultTableModel generarModelo(CachedRowSet resultado) throws SQLException {

		DefaultTableModel modelo = new DefaultTableModel();
		ResultSetMetaData md = resultado.getMetaData();
	
		int totalCampos = md.getColumnCount();
		for (int i = 1; i <= totalCampos; i++) {
			modelo.addColumn(md.getColumnName(i));
		}
		String[] campo = new String[totalCampos];
		while (resultado.next()) {
			for (int i = 1; i <= totalCampos; i++) {
				campo[i - 1] = resultado.getString(i);
			}
			modelo.addRow(campo);
		}
		return modelo;
	}
}
