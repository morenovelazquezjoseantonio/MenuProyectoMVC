package ayuda;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Ayuda {
	
	/** Ventana secundaria */
	public static JDialog secundaria;

	/** Ventana principal */
	public static JFrame principal;

	/** Item de men� para la ayuda */
	public static JMenuItem itemAyuda;

	/** Boton que despliega la ventana secundaria */
	public static JButton botonMuetraSecundaria;

	/**
	 * Crea una instanacia de esta clase.
	 * 
	 * @param args
	 */
	

	/**
	 * Crea las ventanas, pone la ayuda y visualiza la ventana principal.
	 */
	
	
	public void javaHelp() {
		
		creaVentanaPrincipal();
		creaVentanaSecundaria();

		botonMuetraSecundaria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				secundaria.setVisible(true);
			}
		});

		ponLaAyuda();
		visualizaVentanaPrincipal();
	}

	/**
	 * Con este nombre digo yo que visualizar� la ventana principal.
	 */
	public static void visualizaVentanaPrincipal() {
		principal.pack();
		principal.setVisible(true);
		principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/**
	 * Hace que el item del menu y la pulsacion de F1 visualicen la ayuda.
	 */
	public void ponLaAyuda() {
		try {
			// Carga el fichero de ayuda
			File fichero = new File("../help/help_set.hs");
			URL hsURL = fichero.toURI().toURL();

			// Crea el HelpSet y el HelpBroker
			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();

			// Pone ayuda a item de menu al pulsarlo y a F1 en ventana
			// principal y secundaria.
			hb.enableHelpOnButton(itemAyuda, "aplicacion", helpset);
			hb.enableHelpKey(principal.getContentPane(), "ventana_principal",
					helpset);
			hb.enableHelpKey(secundaria.getContentPane(), "ventana_secundaria",
					helpset);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �Quiz�s crea la ventana principal?
	 */
	public static void creaVentanaPrincipal() {
		principal = new JFrame("Ventana principal");
		JMenuBar menuBar = new JMenuBar();
		itemAyuda = new JMenuItem("Ayuda");
		menuBar.add(itemAyuda);
		botonMuetraSecundaria = new JButton("Pulsame");
		principal.setJMenuBar(menuBar);
		principal.getContentPane().setLayout(new FlowLayout());
		principal.getContentPane().add(botonMuetraSecundaria);
		principal.getContentPane().add(new JTextField(20));
	}

	/**
	 * �Tal vez crea la ventana secundaria?
	 */
	public static void creaVentanaSecundaria() {
		secundaria = new JDialog(principal, "Ventana secundaria");
		secundaria.getContentPane().setLayout(new FlowLayout());
		secundaria.getContentPane().add(new JLabel("Yo no hago nada"));
		secundaria.getContentPane().add(new JTextField(20));
		secundaria.pack();
	}
}



