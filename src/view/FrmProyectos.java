package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;

public class FrmProyectos extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTable table;
	public static JScrollPane scrollPane = new JScrollPane();

	public FrmProyectos() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));

		setTitle("VENTANA PROYECTOS");

		setBounds(0, 0, 450, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// controller.CtrProyectos.nuevoProyecto();
				controller.CtrProyectos.mostrarNuevo();

			}
		});
		btnNuevo.setBounds(21, 227, 89, 23);
		getContentPane().add(btnNuevo);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.CtrProyectos.borrarProyecto();
			}
		});
		btnBorrar.setBounds(128, 227, 89, 23);
		getContentPane().add(btnBorrar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.CtrProyectos.modificarProyecto();

			}
		});
		btnEditar.setBounds(238, 227, 89, 23);
		getContentPane().add(btnEditar);

		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.CtrProyectos.editarProyecto();

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
