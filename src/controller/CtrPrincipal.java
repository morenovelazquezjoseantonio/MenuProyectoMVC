package controller;
/**
 * @author Jose Antonio Moreno Velazquez
 * clase CtrPrincipal
 * @since 24-09-2018
 * @version V-1
 */
public class CtrPrincipal {
	/**
	 * Nombre del metodo InicioApp()
	 * Inicia la clase FrmPrincipal(ventana principal)
	 */
	
	public static void inicioApp() {
		new view.FrmPrincipal();
	}
	
	/**
	 * Nombre del metodo salir()
	 * cierra la ventana principal
	 */
	public static void salir() {
		System.exit(0);
	}
}
