package controller;

import java.util.Scanner;

import model.logic.MVCModelo;
import view.MVCView;

public class Controller {



	/* Instancia del Modelo*/
	private MVCModelo modelo;
	
	/* Instancia de la Vista*/
	private MVCView view;


	
	/**
	 * Crear la vista y el modelo del proyecto
	 */
	public Controller (){
		modelo = new MVCModelo();
		view = new MVCView();
	}

		
	public void run()
	{

		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		
		 int trimestre = -1;

		while( !fin ) {
			view.printMenu();

			int option = lector.nextInt();

			switch (option) {
				case 1:

                    try {
                        System.out.println("--------- \nIngresar el trimestre: ");
                        trimestre = lector.nextInt();
                    }
                    catch(Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

					modelo.cargarDatosPorTrimiestre(trimestre);

					System.out.println("Para el trimestre " + trimestre + " del 2018 se leyeron las siguientes cantidades de viajes por mes: " + modelo.datos().datosMes().tamano() + "\n");
					System.out.println("Para el trimestre " + trimestre + " del 2018 se leyeron las siguientes cantidades de viajes por día: " + modelo.datos().datosDia().tamano() + "\n");
					System.out.println("Para el trimestre " + trimestre + " del 2018 se leyeron las siguientes cantidades de viajes por hora: " + modelo.datos().datosHora().tamano() + "\n");

                    System.out.println("El menor identificador hallado en todos los arhivos del trimestre seleccionado es: " + modelo.darMenorIdentificador());
                    System.out.println("El mayor identificador hallado en todos los arhivos del trimestre seleccionado es: " + modelo.darMayorIdentificador());
					System.out.println();
					break;

                default:{
                    System.out.println("Opcion invalida");
                }
			}
		}
	}

}
