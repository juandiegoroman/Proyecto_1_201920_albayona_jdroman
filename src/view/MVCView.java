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
			System.out.println("4. Comparar consultas de zona X con zona dada.");
			System.out.println("5. Tabla ASCII.");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
}
