import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Clase que implementa el listener de los botones del Buscaminas. De alguna
 * manera tendrá que poder acceder a la ventana principal. Se puede lograr
 * pasando en el constructor la referencia a la ventana. Recuerda que desde la
 * ventana, se puede acceder a la variable de tipo ControlJuego
 * 
 * @author jesusredondogarcia
 **
 */
public class ActionBoton implements ActionListener {

	VentanaPrincipal v;
	private int i;
	private int j;
	private boolean porExplosion;
	private JButton aux = new JButton();

	public ActionBoton(VentanaPrincipal v, int i , int j ) {
		this.v = v;
		this.i = i;
		this.j= j;
		
	}

	/**
	 * Acción que ocurrirá cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/* aux = (JButton) e.getSource();
		for (i = 0; i < v.getJuego().LADO_TABLERO; i++) {
			for (j = 0; j < v.getJuego().LADO_TABLERO; j++) { */
				/* if (aux == v.botonesJuego[i][j]) { */
					if (v.juego.abrirCasilla(i, j)) {
						v.mostrarNumMinasAlrededor(i, j);
						porExplosion = false;
						v.mostrarFinJuego(porExplosion);
						v.actualizarPuntuacion();

					} else {
						porExplosion = true;
						v.mostrarFinJuego(porExplosion);

					}
				/* } */
	/* 		}
		} */
	}
}
