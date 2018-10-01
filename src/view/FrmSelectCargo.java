package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase FrmSelectCargo
 * @since 24-09-2018
 * @version V-1
 * Crea la ventana seleccion de cargos
 */
public class FrmSelectCargo extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTable table;
	public static JScrollPane scrollPane = new JScrollPane();

	public FrmSelectCargo() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));

		// setModal(true);
		setTitle("VENTANA SELECCION DE CARGOS");
		setBounds(0, 0, 450, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		setResizable(false);

		JButton btnSelect = new JButton("Seleccionar");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrEquipos.capturarDatosCargos();
				dispose();
				}
		});

		btnSelect.setBounds(160, 220, 120, 40);
		getContentPane().add(btnSelect);
		table = new JTable();
		getContentPane().add(scrollPane);
		scrollPane.setBounds(50, 30, 350, 160);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);

		setVisible(true);

	}

}
