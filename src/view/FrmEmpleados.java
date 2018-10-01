package view;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JTable;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Toolkit;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase FrmEmpleado
 * @since 24-09-2018
 * @version V-1
 * Crea la ventana empleado
 */
public class FrmEmpleados extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTable table;
	public static JScrollPane scrollPane = new JScrollPane();

	public FrmEmpleados() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));

		// setModal(true);
		setTitle("VENTANA EMPLEADOS");
		setBounds(0, 0, 450, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		setResizable(false);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controller.CtrEmpleados.mostrarNuevo();
			}
		});

		btnNuevo.setBounds(21, 227, 89, 23);
		getContentPane().add(btnNuevo);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.CtrEmpleados.borrarEmpleado();
			}
		});
		btnBorrar.setBounds(128, 227, 89, 23);
		getContentPane().add(btnBorrar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.CtrEmpleados.modificarEmpleado();

			}
		});
		btnEditar.setBounds(238, 227, 89, 23);
		getContentPane().add(btnEditar);

		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrEmpleados.editarEmpleado();

			}
		});
		btnInfo.setBounds(337, 227, 89, 23);
		getContentPane().add(btnInfo);

		table = new JTable();
		// table.setBounds(50, 30, 350, 160);
		getContentPane().add(scrollPane);
		scrollPane.setBounds(50, 30, 350, 160);
		// getContentPane().add(scrollPane);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);

		setVisible(true);

	}
}
