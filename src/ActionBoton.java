import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas.
 * De alguna manera tendrá que poder acceder a la ventana principal.
 * Se puede lograr pasando en el constructor la referencia a la ventana.
 * Recuerda que desde la ventana, se puede acceder a la variable de tipo ControlJuego
 * @author jesusredondogarcia
 **
 */
public class ActionBoton implements ActionListener{

	VentanaPrincipal v = new VentanaPrincipal();
	ControlJuego juego = new ControlJuego();
	private int i;
	private int j;
	private boolean porExplosion;

	public ActionBoton() {
		//TODO
	}
	
	/**
	 *Acción que ocurrirá cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO
		for ( i = 0; i < v.botonesJuego.length; i++) {
			for (j = 0; j < v.botonesJuego[i].length; j++) {
				v.botonesJuego[i][j].addActionListener(new ActionListener(){
					  int iLis = i;
					  int jLis = j;

					@Override
					public void actionPerformed(ActionEvent e){
						if (juego.abrirCasilla(iLis, jLis)) {
							v.mostrarNumMinasAlrededor(iLis, jLis);
							porExplosion = false;
							v.mostrarFinJuego(porExplosion);
							v.refrescarPantalla();
							v.actualizarPuntuacion();


						} else {
							if(!juego.abrirCasilla(iLis, jLis)){
								porExplosion = true;
								v.mostrarFinJuego(porExplosion);
							}
							
						}

					}
				});
				
			}
		}
	}

}
