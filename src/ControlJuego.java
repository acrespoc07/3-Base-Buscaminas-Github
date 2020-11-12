import java.util.ArrayList;
import java.util.Random;

/**
 * Clase gestora del tablero de juego. Guarda una matriz de enteros representado
 * el tablero. Si hay una mina en una posición guarda el número -1 Si no hay una
 * mina, se guarda cuántas minas hay alrededor. Almacena la puntuación de la
 * partida
 * 
 * @author jesusredondogarcia
 *
 */
public class ControlJuego {
	private final static int MINA = -1;
	final int MINAS_INICIALES = 20;
	final int LADO_TABLERO = 10;

	private int[][] tablero;
	private int puntuacion;

	public ControlJuego() {
		// Creamos el tablero:
		tablero = new int[LADO_TABLERO][LADO_TABLERO];

		// Inicializamos una nueva partida
		inicializarPartida();
		depurarTablero();
	}

	/**
	 * Método para generar un nuevo tablero de partida:
	 * 
	 * @pre: La estructura tablero debe existir.
	 * @post: Al final el tablero se habrá inicializado con tantas minas como marque
	 *        la variable MINAS_INICIALES. El resto de posiciones que no son minas
	 *        guardan en el entero cuántas minas hay alrededor de la celda
	 */
	public void inicializarPartida() {

		// Por cada ciclo del bucle genero dos aleatorios y se los meto al tablero y en
		// esas posiciones me pondrá una MINA.
		for (int i = 0; i < 20; i++) {
			Random random1 = new Random();
			int r1 = random1.nextInt(10);

			Random random2 = new Random();
			int r2 = random2.nextInt(10);
			tablero[r1][r2] = MINA;

		}

		// TODO: Repartir minas e inicializar puntaci�n. Si hubiese un tablero anterior,
		// lo pongo todo a cero para inicializarlo.

		// Al final del m�todo hay que guardar el n�mero de minas para las casillas que
		// no son mina:
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] != MINA) {
					tablero[i][j] = calculoMinasAdjuntas(i, j);

				}
			}
		}
	}

	/**
	 * Cálculo de las minas adjuntas: Para calcular el número de minas tenemos que
	 * tener en cuenta que no nos salimos nunca del tablero. Por lo tanto, como
	 * mucho la i y la j valdrán LADO_TABLERO-1. Por lo tanto, como poco la i y la j
	 * valdrán 0.
	 * 
	 * @param i: posición vertical de la casilla a rellenar
	 * @param j: posición horizontal de la casilla a rellenar
	 * @return : El número de minas que hay alrededor de la casilla [i][j]
	 **/
	private int calculoMinasAdjuntas(int i, int j) {
		int contMinasAlrededor = 0;

		int iInicial = Math.max(0, i - 1);
		int iFinal = Math.min(LADO_TABLERO - 1, i + 1);

		int jInicial = Math.max(0, j - 1);
		int jFinal = Math.min(LADO_TABLERO - 1, j + 1);

		for (int vertical = iInicial; vertical <= iFinal; vertical++) {
			for (int horizontal = jInicial; horizontal <= jFinal; horizontal++) {
				if (tablero[vertical][horizontal] == MINA) {
					contMinasAlrededor++;
				}
			}

		}

		return contMinasAlrededor;
	}

	/**
	 * Método que nos permite
	 * 
	 * @pre : La casilla nunca debe haber sido abierta antes, no es controlado por
	 *      el ControlJuego. Por lo tanto siempre sumaremos puntos
	 * @param i: posición verticalmente de la casilla a abrir
	 * @param j: posición horizontalmente de la casilla a abrir
	 * @return : Verdadero si no ha explotado una mina. Falso en caso contrario.
	 */
	public boolean abrirCasilla(int i, int j) {
		if (tablero[i][j] != MINA) {// Si No tiene mina
			puntuacion++;
			return true;
		} else {// Si tiene mina
			return false;
		}
	}

	/**
	 * Método que checkea si se ha terminado el juego porque se han abierto todas
	 * las casillas.
	 * 
	 * @return Devuelve verdadero si se han abierto todas las celdas que no son
	 *         minas.
	 **/
	public boolean esFinJuego() {
		if (puntuacion == (LADO_TABLERO * LADO_TABLERO - MINAS_INICIALES)) {
			return true;
		} else { 
			return false;
		}

	}

	/**
	 * Método que pinta por pantalla toda la información del tablero, se utiliza
	 * para depurar
	 */
	public void depurarTablero() {
		System.out.println("---------TABLERO--------------");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("\nPuntuación: " + puntuacion);
	}

	/**
	 * Método que se utiliza para obtener las minas que hay alrededor de una celda
	 * 
	 * @pre : El tablero tiene que estar ya inicializado, por lo tanto no hace falta
	 *      calcularlo, símplemente consultarlo
	 * @param i : posición vertical de la celda.
	 * @param j : posición horizontal de la cela.
	 * @return Un entero que representa el número de minas alrededor de la celda
	 */
	public int getMinasAlrededor(int i, int j) {
		return calculoMinasAdjuntas(i, j);
	}

	/**
	 * Método que devuelve la puntuación actual
	 * 
	 * @return Un entero con la puntuación actual
	 */
	public int getPuntuacion() {
		return puntuacion;
	}

}
