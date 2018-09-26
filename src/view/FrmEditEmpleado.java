package view;

import java.awt.TextField;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrmEditEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;

	public static TextField tfNombre, tfDni, tfApellidos, tfGenero;

	public FrmEditEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));

		setModal(true);
		setTitle("Ventana Edicion Empleados");
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

		tfDni = new TextField("");
		tfDni.setBounds(200, 40, 150, 20);
		getContentPane().add(tfDni);
		tfDni.setText(controller.CtrEmpleados.dni);

		tfNombre = new TextField("");
		tfNombre.setBounds(200, 80, 150, 20);
		getContentPane().add(tfNombre);
		tfNombre.setText(controller.CtrEmpleados.nombre);

		tfApellidos = new TextField("");
		tfApellidos.setBounds(200, 120, 150, 20);
		getContentPane().add(tfApellidos);
		tfApellidos.setText(controller.CtrEmpleados.apellidos);

		tfGenero = new TextField("");
		tfGenero.setBounds(200, 160, 150, 20);
		getContentPane().add(tfGenero);
		tfGenero.setText(controller.CtrEmpleados.genero);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controller.CtrEmpleados.capturarDatos();

				dispose();
			}
		});
		btnModificar.setBounds(130, 250, 100, 50);
		getContentPane().add(btnModificar);

		setVisible(true);
	}
}
