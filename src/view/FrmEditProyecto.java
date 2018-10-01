package view;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Toolkit;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase FrmEditProyecto
 * @since 24-09-2018
 * @version V-1
 * Crea la ventana editar proyecto
 */
public class FrmEditProyecto extends JDialog {

	private static final long serialVersionUID = 1L;

	public static TextField tfNombre, tfPresupuesto, tfFechaInicio, tfFechaFin;

	public FrmEditProyecto() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));

		setModal(true);
		setTitle("Ventana Edicion Proyectos");
		setBounds(0, 0, 370, 360);
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel lbNombre = new JLabel("Nombre.:");
		lbNombre.setBounds(50, 40, 80, 20);
		getContentPane().add(lbNombre);

		JLabel lblPresupuesto = new JLabel("Presupuesto.:");
		lblPresupuesto.setBounds(50, 80, 80, 20);
		getContentPane().add(lblPresupuesto);

		JLabel lblFechaInicio = new JLabel("Fecha Inicio.:");
		lblFechaInicio.setBounds(50, 120, 80, 20);
		getContentPane().add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("Fecha Fin.:");
		lblFechaFin.setBounds(50, 160, 80, 20);
		getContentPane().add(lblFechaFin);

		tfNombre = new TextField("");
		tfNombre.setBounds(200, 40, 150, 20);
		getContentPane().add(tfNombre);
		tfNombre.setText(controller.CtrProyectos.nombre);

		tfPresupuesto = new TextField("");
		tfPresupuesto.setBounds(200, 80, 150, 20);
		getContentPane().add(tfPresupuesto);
		tfPresupuesto.setText(controller.CtrProyectos.presupuesto);

		tfFechaInicio = new TextField("");
		tfFechaInicio.setBounds(200, 120, 150, 20);
		getContentPane().add(tfFechaInicio);
		tfFechaInicio.setText(controller.CtrProyectos.fechaInicio);

		tfFechaFin = new TextField("");
		tfFechaFin.setBounds(200, 160, 150, 20);
		getContentPane().add(tfFechaFin);
		tfFechaFin.setText(controller.CtrProyectos.fechaFin);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controller.CtrProyectos.capturarDatosProyectos();

				dispose();
			}
		});
		btnModificar.setBounds(130, 250, 100, 50);
		getContentPane().add(btnModificar);

		setVisible(true);
	}
}
