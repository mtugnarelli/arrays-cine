
public class SalaDeCine {
	
	private boolean[][] lugaresLibres;
	
	/**
	 * post: sala con 40 lugares libres, distribuidos 
	 *       en 5 filas de 8 asientos cada una.
	 */
	public SalaDeCine() {
		
		lugaresLibres = new boolean[5][8];
		
		for (int i = 0; i < lugaresLibres.length; i++) {
			for (int j = 0; j < lugaresLibres[i].length; j++) {
				lugaresLibres[i][j] = true;
			}
		}
	}

	/**
	 * pre : 'fila' está en el ranto [1..5] y 'asiento' entre [1..8].
	 * 
	 * post: devuelve si la sala tiene libre el lugar 
	 *       identificado por el número de fila y número de asiento.
	 */
	public boolean tieneLibre(int fila, int asiento) {
		
		int indiceFila = posicionarFila(fila);
		int indiceAsiento = posicionarAsiento(asiento);
		
		return lugaresLibres[indiceFila][indiceAsiento];
	}
	
	private int posicionarFila(int fila) {
		
		return (fila - 1);
	}
	
	private int posicionarAsiento(int asiento) {
		
		return (asiento - 1);
	}
	
	/**
	 * pre : 'fila' está en el ranto [1..5] y 'asiento' entre [1..8].
	 *       El asiento indicado está libre.
	 *        
	 * post: ocupa el lugar en la sala identificado por el número
	 *       de fila y asiento.
	 */
	public void ocupar(int fila, int asiento) {

		int indiceFila = posicionarFila(fila);
		int indiceAsiento = posicionarAsiento(asiento);

		lugaresLibres[indiceFila][indiceAsiento] = false;
	}
	
	/**
	 * post: devuelve la cantidad de lugares que están libres en la sala.
	 */
	public int contarLugaresLibres() {
		
		return 0;
	}
}
