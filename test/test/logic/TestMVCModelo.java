package test.logic;

import static org.junit.Assert.*;

import model.data_structures.IListaIterador;
import model.data_structures.ListaEncadenada;
import model.logic.MVCModelo;
import model.logic.Viaje;

import org.junit.Before;
import org.junit.Test;

public class TestMVCModelo {

	private MVCModelo modelo;
	private static String DATOS = "./data/Prueba2.csv";

	@Before
	public void setUp1() {
		modelo = new MVCModelo();
	}

	public void setUp2() {
		modelo.cargarDatos(DATOS);
		}
	
	
	
	@Test
	public void testCargar()
	{
		setUp2();
		
		ListaEncadenada<Viaje> lista = modelo.darDatos();
		
		IListaIterador<Viaje> iter =  lista.iterador();
		
		Viaje temp = iter.siguiente();
		
		for (int i = 0; i < 36; i++) {
			assertEquals(i+1,temp.darIdOrigen());
			assertEquals((i+1)*2,temp.darIdDestino());
			assertEquals(((i)%12 +1) ,temp.darMes());
			assertTrue((i+1)*2.5 == temp.darTiempoPromedio());
			assertTrue((i+1)*20.0 == temp.darDesviacionEstandar());
			assertTrue((i+1)*30.0 == temp.darPromedioGeometrico());
			assertTrue((i+1)*0.5 == temp.darDesviacionGeometrica());			
			temp = iter.siguiente();
		}		
	}
	@Test
	public void testTotalViajesPorMes()
	{
		setUp2();
		
		for (int i = 1; i < 13; i++) {
			assertEquals(3, modelo.totalViajesPorMes(i));
		}				
	}
	
	@Test
	public void testTotalViajesPorOrigen()
	{
		setUp2();
		
		for (int i = 1; i < 37; i++) {
			assertEquals(1, modelo.totalViajesPorOrigen(i));
		}				
	}
	
	@Test
	public void testTotalViajesReportados()
	{
		setUp2();
		
			assertEquals(36, modelo.totalViajesReportados());					
	}

	@Test
	public void testListaViajesPorMesYOrigen()
	{
		setUp2();
		
		for (int i = 0; i < 36; i++) {
			 ListaEncadenada< Viaje> lista = modelo.darListaViajesPorMesYOrigen(i%12 +1 ,i + 1);
			 
			 	assertEquals(i+1,lista.buscar(0).darIdOrigen());
				assertEquals((i+1)*2,lista.buscar(0).darIdDestino());
				assertEquals(((i)%12 +1) ,lista.buscar(0).darMes());
				assertTrue((i+1)*2.5 == lista.buscar(0).darTiempoPromedio());
				assertTrue((i+1)*20.0 == lista.buscar(0).darDesviacionEstandar());
				assertTrue((i+1)*30.0 == lista.buscar(0).darPromedioGeometrico());
				assertTrue((i+1)*0.5 == lista.buscar(0).darDesviacionGeometrica());			 
		}				
	}
	
	@Test
	public void testPorcentajePorMes()
	{
		setUp2();
		
		for (int i = 1; i < 7; i++) {
				assertTrue(3.0 / 36.0 *100.0 == modelo.porcentajePorMes(i));			 
		}				
	}
	
	@Test
	public void testPorcentajePorOrigen()
	{
		setUp2();
		
		for (int i = 1; i < 37; i++) {
				assertTrue(1.0 / 36.0 *100.0 == modelo.porcentajePorOrigen(i));			 
		}				
	}
	
	
	
	
}
