
public class SalaDeCine {
	
	private boolean[][] lugaresLibres;
	
	/**
	 * post: sala con 35 lugares libres, distribuidos 
	 *       en 5 filas de 3,5,7,9 y 11 asientos respectivamente.
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
	 * pre : 'fila' está en el ranto [1..5] y 'asiento' entre 
	 *       [1..3],[1..5],[1..7],[1..9],[1..11] respectivamente.
	 * 
	 * post: devuelve si la sala tiene libre el lugar 
	 *       identificado por el número de fila y número de asiento.
	 */
	public boolean tieneLibre(int fila, int asiento) {
		
		int indiceFila = posicionarFila(fila);
		int indiceAsiento = posicionarAsiento(indiceFila, asiento);
		
		return lugaresLibres[indiceFila][indiceAsiento];
	}
	
	private int posicionarFila(int fila) {
		
		if ((fila < 1) || (fila > lugaresLibres.length)) {
		
			throw new Error("El número de fila no existe: " + fila);
		}
		return (fila - 1);
	}
	
	private int posicionarAsiento(int indiceFila, int asiento) {
		
		if ((asiento < 1) || (asiento > lugaresLibres[indiceFila].length)) {
			
			throw new Error("El número de asiento no existe: " + asiento);
		}
		
		return (asiento - 1);
	}
	
	/**
	 * pre : 'fila' está en el ranto [1..5] y 'asiento'  entre 
	 *       [1..3],[1..5],[1..7],[1..9],[1..11] respectivamente.
	 *       El asiento indicado está libre.
	 *        
	 * post: ocupa el lugar en la sala identificado por el número
	 *       de fila y asiento.
	 */
	public void ocupar(int fila, int asiento) {

		int indiceFila = posicionarFila(fila);
		int indiceAsiento = posicionarAsiento(indiceFila, asiento);

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
