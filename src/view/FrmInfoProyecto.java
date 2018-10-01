package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Toolkit;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase FrmInfoProyecto
 * @since 24-09-2018
 * @version V-1
 * Crea la ventana info proyecto
 */
public class FrmInfoProyecto extends JDialog {

	private static final long serialVersionUID = 1L;

	public FrmInfoProyecto() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));

		setModal(true);
		setTitle("Ventana Info Proyectos");
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

		JLabel lblGetNombre = new JLabel("");
		lblGetNombre.setBounds(200, 40, 150, 20);
		getContentPane().add(lblGetNombre);
		lblGetNombre.setText(controller.CtrProyectos.nombre);

		JLabel lblGetPresupuesto = new JLabel("");
		lblGetPresupuesto.setBounds(200, 80, 150, 20);
		getContentPane().add(lblGetPresupuesto);
		lblGetPresupuesto.setText(controller.CtrProyectos.presupuesto);

		JLabel lblGetFechaInicio = new JLabel("");
		lblGetFechaInicio.setBounds(200, 120, 150, 20);
		getContentPane().add(lblGetFechaInicio);
		lblGetFechaInicio.setText(controller.CtrProyectos.fechaInicio);

		JLabel lblGetFechaFin = new JLabel("");
		lblGetFechaFin.setBounds(200, 160, 150, 20);
		getContentPane().add(lblGetFechaFin);
		lblGetFechaFin.setText(controller.CtrProyectos.fechaFin);

		setVisible(true);
	}
}
