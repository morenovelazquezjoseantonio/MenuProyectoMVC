package view;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Toolkit;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase FrmProyectoNuevo
 * @since 24-09-2018
 * @version V-1
 * Crea la ventana proyecto nuevo
 */
public class FrmProyectoNuevo extends JDialog {

	private static final long serialVersionUID = 1L;

	public static TextField tfNombre;
	public static TextField tfPresupuesto;
	public static TextField tfFechaInicio;
	public static TextField tfFechaFin;

	public FrmProyectoNuevo() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));

		setModal(true);
		setTitle("Ventana Nuevo Proyecto");
		setBounds(0, 0, 370, 360);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
		Label lbNombre = new Label();
		lbNombre.setText("Nombre");
		lbNombre.setBounds(10, 50, 70, 20);
		Label lbPresupuesto = new Label();
		lbPresupuesto.setBounds(10, 100, 80, 20);
		lbPresupuesto.setText("Presupuesto");
		Label lbFechaInicio = new Label();
		lbFechaInicio.setBounds(10, 150, 70, 20);
		lbFechaInicio.setText("Fecha Inicio");
		Label lbFechaFin = new Label();
		lbFechaFin.setBounds(10, 200, 70, 20);
		lbFechaFin.setText("Fecha Fin");

		tfNombre = new TextField();
		tfNombre.setBounds(150, 50, 150, 20);
		tfPresupuesto = new TextField();
		tfPresupuesto.setBounds(150, 100, 150, 20);
		tfFechaInicio = new TextField();
		tfFechaInicio.setBounds(150, 150, 150, 20);
		tfFechaFin = new TextField();
		tfFechaFin.setBounds(150, 200, 150, 20);

		Button btnCancelar = new Button();
		btnCancelar.setLabel("Cancelar");
		btnCancelar.setBounds(200, 250, 100, 40);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();

			}

			private void cancelar() {

				tfNombre.getText();
				tfNombre.setText("");
				tfPresupuesto.getText();
				tfPresupuesto.setText("");
				tfFechaInicio.getText();
				tfFechaInicio.setText("");
				tfFechaFin.getText();
				tfFechaFin.setText("");
				dispose();

			}
		});

		Button btnGuardar = new Button();

		btnGuardar.setLabel("Guardar");
		btnGuardar.setBounds(50, 250, 100, 40);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrProyectos.guardarProyecto();
				dispose();
			}
		});

		getContentPane().add(lbNombre);
		getContentPane().add(tfNombre);
		getContentPane().add(lbPresupuesto);
		getContentPane().add(tfPresupuesto);
		getContentPane().add(lbFechaInicio);
		getContentPane().add(tfFechaInicio);
		getContentPane().add(lbFechaFin);
		getContentPane().add(tfFechaFin);
		getContentPane().add(btnGuardar);
		getContentPane().add(btnCancelar);
		setVisible(true);
	}
}
