package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar los viajes para el trimiestre seleccionado.");
			System.out.println("2. Tiempo promedio y desviacion estandar en rango indicado.");
			System.out.println("3. Dar N viajes con mayor tiempo promedio.");
			System.out.println("4. Comparar consultas en ambos sentidos.");
			System.out.println("5. Generar  gráfica ASCII de tiempo promedio por cada hora.");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
}
