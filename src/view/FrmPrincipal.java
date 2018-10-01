package view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import javax.swing.JMenu;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.JDialog;

import java.awt.Toolkit;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase FrmPrincipal
 * @since 24-09-2018
 * @version V-1
 * Crea la ventana principal
 */
public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JDialog cuadro;

	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("VENTANA PRINCIPAL");
		setBounds(0, 0, 400, 300);
		getContentPane().setLayout(null);

		JLabel lblFondoPantalla = new JLabel("");
		lblFondoPantalla
				.setIcon(new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));
		lblFondoPantalla.setBounds(78, 35, 225, 182);
		getContentPane().add(lblFondoPantalla);
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("BARRAMENUPRINCIPAL");
		setJMenuBar(menuBar);

		JMenu mnMenuBase = new JMenu("BASE");
		menuBar.add(mnMenuBase);
						
		JMenuItem mnMenuItemProyectos = new JMenuItem("Proyectos");
		mnMenuItemProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrProyectos.inicio();

			}
		});

		mnMenuBase.add(mnMenuItemProyectos);

		JMenuItem mnMenuItemEmpleados = new JMenuItem("Empleados");
		mnMenuItemEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.CtrEmpleados.inicio();

			}
		});
		mnMenuBase.add(mnMenuItemEmpleados);

		JSeparator separator = new JSeparator();
		mnMenuBase.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrPrincipal.salir();
			}
		});
		mnMenuBase.add(mntmSalir);

		JMenu mnMenuGestion = new JMenu("GESTION");
		menuBar.add(mnMenuGestion);

		JMenuItem mntMenuItemEquipos = new JMenuItem("EQUIPOS");
		mnMenuGestion.add(mntMenuItemEquipos);
		mntMenuItemEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.CtrEquipos.inicio();

			}
		});
		JMenu mnMenuAyuda = new JMenu("AYUDA");
		menuBar.add(mnMenuAyuda);
						
		JMenuItem mnMenuItemAyuda = new JMenuItem("Ayuda");
		mnMenuItemAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "EN CONSTRUCCION...");
			}
		});
		
		mnMenuAyuda.add(mnMenuItemAyuda);
		
		setVisible(true);

	}
}
