
import org.junit.Assert;
import org.junit.Test;


public class PruebaSalaDeCine {

	private SalaDeCine sala;
	
	@Test
	public void crearLaSalaConTodosLosLugaresLibres() {
		
		sala = new SalaDeCine();
		
		Assert.assertEquals(35, sala.contarLugaresLibres());
	}
	
	@Test
	public void ocuparEnLaFila1ElAsiento2() {
		
		sala = new SalaDeCine();
		
		sala.ocupar(1, 2);
		
		Assert.assertFalse(sala.tieneLibre(1, 2));
		Assert.assertTrue(sala.tieneLibre(1, 1));
		Assert.assertTrue(sala.tieneLibre(1, 3));
		Assert.assertTrue(sala.tieneLibre(2, 2));
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
	public void ocupar4CasillerosDejan31LugaresLibres() {
		
		
		sala = new SalaDeCine();
		
		sala.ocupar(4, 1);
		sala.ocupar(4, 2);
		sala.ocupar(4, 3);
		sala.ocupar(4, 4);
		
		Assert.assertEquals(31, sala.contarLugaresLibres());
	}
	
	@Test(expected = Error.class)
	public void ocuparEnLaFila1ElAsiento9LanzaExcepcionPorqueElAsientoSuperaElMaximo() {
		
		sala = new SalaDeCine();
		
		sala.ocupar(1, 9);
	}
	
	@Test(expected = Error.class)
	public void ocuparEnLaFila6ElAsiento1LanzaExcepcionPorqueLaFilaSuperaElMaximo() {
		
		sala = new SalaDeCine();
		
		sala.ocupar(6, 1);
	}
	
	@Test(expected = Error.class)
	public void ocuparEnLaFila0ElAsiento1LanzaExcepcionPorqueLaFilaNoSuperaElMinimo() {
		
		sala = new SalaDeCine();
		
		sala.ocupar(0, 1);
	}
	
	@Test(expected = Error.class)
	public void ocuparEnLaFila5ElAsiento9LanzaExcepcionPorqueElAsientoSuperaElMaximo() {
		
		sala = new SalaDeCine();
		
		sala.ocupar(5, 9);
	}
}
