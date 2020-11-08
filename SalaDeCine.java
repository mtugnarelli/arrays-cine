
public class SalaDeCine {
	
	private boolean[][] lugaresLibres;
	
	/**
	 * post: sala con 40 lugares libres, distribuidos 
	 *       en 5 filas de 8 asientos cada una.
	 */
	public SalaDeCine() {
		
		lugaresLibres = new boolean[5][];

		for (int i = 0; i < lugaresLibres.length; i++) {
			
			lugaresLibres[i] = new boolean[(i*2) + 3];
		}

		inicializarTodosLibres();
	}
	
	private void inicializarTodosLibres() {

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
		
		if ((fila < 1) || (fila > lugaresLibres.length)) {
		
			throw new Error("El número de fila no existe: " + fila);
		}
		return (fila - 1);
	}
	
	private int posicionarAsiento(int asiento) {
		
		if ((asiento < 1) || (asiento > lugaresLibres[0].length)) {
			
			throw new Error("El número de asiento no existe: " + asiento);
		}
		
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
		
		int libres = 0;
		
		for (int i = 0; i < lugaresLibres.length; i++) {
			
			for (int j = 0; j < lugaresLibres[i].length; j++) {
				
				if (lugaresLibres[i][j]) {
					
					libres++;
				}
			}
		}
		
		return libres;
	}
}
