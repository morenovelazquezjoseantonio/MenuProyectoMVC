package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Toolkit;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase FrmInfoEmpleado
 * @since 24-09-2018
 * @version V-1
 * Crea la ventana info empleado
 */
public class FrmInfoEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;

	public FrmInfoEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));

		setModal(true);
		setTitle("Ventana Info Empleados");
		setBounds(0, 0, 370, 360);
		setResizable(false);

		getContentPane().setLayout(null);

		JLabel lbDni = new JLabel("Dni.:");
		lbDni.setBounds(50, 40, 80, 20);
		getContentPane().add(lbDni);

		JLabel lblNombre = new JLabel("Nombre.:");
		lblNombre.setBounds(50, 80, 80, 20);
		getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos.:");
		lblApellidos.setBounds(50, 120, 80, 20);
		getContentPane().add(lblApellidos);

		JLabel lblGenero = new JLabel("Genero.:");
		lblGenero.setBounds(50, 160, 80, 20);
		getContentPane().add(lblGenero);

		JLabel lblGetDni = new JLabel("");
		lblGetDni.setBounds(200, 40, 150, 20);
		getContentPane().add(lblGetDni);
		lblGetDni.setText(controller.CtrEmpleados.dni);

		JLabel lblGetNombre = new JLabel("");
		lblGetNombre.setBounds(200, 80, 150, 20);
		getContentPane().add(lblGetNombre);
		lblGetNombre.setText(controller.CtrEmpleados.nombre);

		JLabel lblGetApellidos = new JLabel("");
		lblGetApellidos.setBounds(200, 120, 150, 20);
		getContentPane().add(lblGetApellidos);
		lblGetApellidos.setText(controller.CtrEmpleados.apellidos);

		JLabel lblGetGenero = new JLabel("");
		lblGetGenero.setBounds(200, 160, 150, 20);
		getContentPane().add(lblGetGenero);
		lblGetGenero.setText(controller.CtrEmpleados.genero);

		setVisible(true);
	}
}
