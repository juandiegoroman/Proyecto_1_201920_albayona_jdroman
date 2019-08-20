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
			System.out.println("1. Cargar los viajes agregados por mes de los dos primeros trimestres del año");
			System.out.println("2. Ingresar un mes y una zona de origen para las consultas");
			System.out.println("3. Consultar viajes reportados en el mes y la zona de origen dadas");
			System.out.println("4. Generar estadísticas generales y sobre viajes reportados en el mes y la zona de origen dadas");

		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
}
