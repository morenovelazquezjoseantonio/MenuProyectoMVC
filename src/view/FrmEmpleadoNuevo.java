package view;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import java.awt.Toolkit;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase FrmEmpleadoNuevo
 * @since 24-09-2018
 * @version V-1
 * Crea la ventana nuevo empleado
 */
public class FrmEmpleadoNuevo extends JDialog {
	public static String sentencia;
	public static TextField tfDni;
	public static TextField tfNombre;
	public static TextField tfApellidos;
	public static TextField tfGenero;

	private static final long serialVersionUID = 1L;

	public FrmEmpleadoNuevo() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));

		setModal(true);
		setTitle("Ventana Nuevo Empleado");
		setBounds(0, 0, 370, 360);
		getContentPane().setLayout(null);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
		Label lbDni = new Label();
		lbDni.setText("Dni");
		lbDni.setBounds(10, 50, 70, 20);
		Label lbNombre = new Label();
		lbNombre.setBounds(10, 100, 70, 20);
		lbNombre.setText("Nombre");
		Label lbApellidos = new Label();
		lbApellidos.setBounds(10, 150, 70, 20);
		lbApellidos.setText("Apellidos");
		Label lbGenero = new Label();
		lbGenero.setBounds(10, 200, 70, 20);
		lbGenero.setText("Genero");

		tfDni = new TextField();
		tfDni.setBounds(150, 50, 150, 20);
		tfNombre = new TextField();
		tfNombre.setBounds(150, 100, 150, 20);
		tfApellidos = new TextField();
		tfApellidos.setBounds(150, 150, 150, 20);
		tfGenero = new TextField();
		tfGenero.setBounds(150, 200, 150, 20);

		Button btnCancelar = new Button();
		btnCancelar.setLabel("Cancelar");
		btnCancelar.setBounds(200, 250, 100, 40);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();

			}

			private void cancelar() {
				// TODO Auto-generated method stub
				tfDni.getText();
				tfDni.setText("");
				tfNombre.getText();
				tfNombre.setText("");
				tfApellidos.getText();
				tfApellidos.setText("");
				tfGenero.getText();
				tfGenero.setText("");

				dispose();

			}
		});

		Button btnGuardar = new Button();

		btnGuardar.setLabel("Guardar");
		btnGuardar.setBounds(50, 250, 100, 40);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.CtrEmpleados.guardarEmpleado();

				dispose();

			}
		});

		getContentPane().add(lbDni);
		getContentPane().add(tfDni);
		getContentPane().add(lbNombre);
		getContentPane().add(tfNombre);
		getContentPane().add(lbApellidos);
		getContentPane().add(tfApellidos);
		getContentPane().add(lbGenero);
		getContentPane().add(tfGenero);
		getContentPane().add(btnGuardar);
		getContentPane().add(btnCancelar);
		setVisible(true);
	}

}
