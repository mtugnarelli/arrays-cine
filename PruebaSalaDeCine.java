
import org.junit.Assert;
import org.junit.Test;


public class PruebaSalaDeCine {

	private SalaDeCine sala;
	
	@Test
	public void crearLaSalaConTodosLosLugaresLibres() {
		
		sala = new SalaDeCine();
		
		Assert.assertEquals(40, sala.contarLugaresLibres());
	}
	
	@Test
	public void ocuparEnLaFila1ElAsiento4() {
		
		sala = new SalaDeCine();
		
		sala.ocupar(1, 4);
		
		Assert.assertFalse(sala.tieneLibre(1, 4));
		Assert.assertTrue(sala.tieneLibre(1, 3));
		Assert.assertTrue(sala.tieneLibre(1, 5));
		Assert.assertTrue(sala.tieneLibre(2, 4));
	}
	
	@Test
	public void ocuparEnLaFila5ElAsiento8() {
		
		sala = new SalaDeCine();
		
		sala.ocupar(5, 8);
		
		Assert.assertFalse(sala.tieneLibre(5, 8));
		Assert.assertTrue(sala.tieneLibre(5, 7));
		Assert.assertTrue(sala.tieneLibre(4, 7));
		Assert.assertTrue(sala.tieneLibre(4, 8));
	}
	
	@Test
	public void ocuparEnLaFila3LosAsiento3Al5() {
		
		sala = new SalaDeCine();
		
		sala.ocupar(3, 3);
		sala.ocupar(3, 4);
		sala.ocupar(3, 5);
		
		Assert.assertFalse(sala.tieneLibre(3, 3));
		Assert.assertFalse(sala.tieneLibre(3, 4));
		Assert.assertFalse(sala.tieneLibre(3, 5));
		Assert.assertTrue(sala.tieneLibre(3, 2));
		Assert.assertTrue(sala.tieneLibre(3, 6));
	}
	
	@Test
	public void ocupar4CasillerosDejan36LugaresLibres() {
		
		
		sala = new SalaDeCine();
		
		sala.ocupar(4, 1);
		sala.ocupar(4, 2);
		sala.ocupar(4, 3);
		sala.ocupar(4, 4);
		
		Assert.assertEquals(36, sala.contarLugaresLibres());
	}
	
}
