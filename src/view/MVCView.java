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
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
}
