package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase FrmEquipo
 * @since 24-09-2018
 * @version V-1
 * Crea la ventana equipos
 */

public class FrmEquipos extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTable tableEquipos;
	public static JScrollPane scrollPaneEquipos;
	public static JTable tableProyectos;
	public static JScrollPane scrollPaneProyectos;

	public FrmEquipos() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));
		
		setTitle("VENTANA EQUIPOS");
		setBounds(0, 0, 550, 350);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);

		JLabel lblProyectos = new JLabel("PROYECTOS");
		lblProyectos.setBounds(250, 20, 80, 20);
		getContentPane().add(lblProyectos);

		JLabel lblEquipos = new JLabel("EQUIPOS");
		lblEquipos.setBounds(250, 150, 60, 20);
		getContentPane().add(lblEquipos);

		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrEquipos.actualizarJTableEmpleadosSelect();

			}
		});
		btnAnadir.setBounds(35, 270, 90, 30);
		getContentPane().add(btnAnadir);

		JButton btnEdit = new JButton("Editar");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.CtrEquipos.actualizarJTableCargosSelect();

			}
		});
		btnEdit.setBounds(430, 270, 90, 30);
		getContentPane().add(btnEdit);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrEquipos.borrarCompEquipo();
			}
		});
		btnBorrar.setBounds(235, 270, 90, 30);
		getContentPane().add(btnBorrar);

		// Proyectos
		scrollPaneProyectos = new JScrollPane();
		scrollPaneProyectos.setBounds(35, 48, 452, 94);
		getContentPane().add(scrollPaneProyectos);
		tableProyectos = new JTable();
		scrollPaneProyectos.setColumnHeaderView(tableProyectos);
		scrollPaneProyectos.setViewportView(tableProyectos);
		tableProyectos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
				controller.CtrEquipos.capturarDatosProyecto();
				controller.CtrEquipos.actualizarJTableEquipos();
				}
			});

		// Equipos
		scrollPaneEquipos = new JScrollPane();
		scrollPaneEquipos.setBounds(35, 181, 452, 78);
		getContentPane().add(scrollPaneEquipos);
		tableEquipos = new JTable();
		scrollPaneEquipos.setColumnHeaderView(tableEquipos);
		scrollPaneEquipos.setViewportView(tableEquipos);
		
		
		setVisible(true);

	}
}
