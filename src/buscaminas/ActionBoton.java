package buscaminas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas. De alguna
 * manera tendrá que poder acceder a la ventana principal. Se puede lograr
 * pasando en el constructor la referencia a la ventana. Recuerda que desde la
 * ventana, se puede acceder a la variable de tipo ControlJuego
 * 
 * @author Alejandro Crespo Cobos
 *
 */
public class ActionBoton implements ActionListener {

	VentanaPrincipal v;
	private int i;
	private int j;
	private boolean porExplosion;

	public ActionBoton(VentanaPrincipal v, int i, int j) {
		this.v = v;
		this.i = i;
		this.j = j;

	}

	/**
	 * Acción que ocurrirá cuando pulsamos uno de los botones.
	 * Si cuando abrimos una casilla y no hay una mina, nos mostara las minas de alrededor, ira sumando la puntuacion y si legas al final, acabara el juego.
	 * Si cuando abres una casilla hay una mina habra terminado el juego.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (v.juego.abrirCasilla(i, j)) {
			v.mostrarNumMinasAlrededor(i, j);
			porExplosion = false;
			v.mostrarFinJuego(porExplosion);
			v.actualizarPuntuacion();

		} else {
			porExplosion = true;
			v.mostrarFinJuego(porExplosion);

		}
	}
}
