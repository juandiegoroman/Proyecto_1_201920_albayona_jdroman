package controller;

import java.text.DecimalFormat;
import java.util.Scanner;

import model.data_structures.IListaIterador;
import model.data_structures.ListaEncadenada;
import model.logic.MVCModelo;
import model.logic.Viaje;
import view.MVCView;

public class Controller {


	public final static String DATOS_PRIMER_TRIMESTRE = "./data/bogota-cadastral-2018-1-All-MonthlyAggregate.csv";
	public final static String DATOS_SEGUNDO_TRIMESTRE = "./data/bogota-cadastral-2018-2-All-MonthlyAggregate.csv";


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
		String dato = "";
		String respuesta = "";
		
		 int mesConsulta = -1;

		 int zonaOrigenConsulta = -1;



		while( !fin ) {
			view.printMenu();

			int option = lector.nextInt();

			switch (option) {
				case 1:
					modelo.cargarDatos(DATOS_PRIMER_TRIMESTRE);
					modelo.cargarDatos(DATOS_SEGUNDO_TRIMESTRE);

					System.out.println("Para el primer semestre del 2018 se leyeron las siguientes cantidades de viajes por mes: \n");
					System.out.println("Enero: " + modelo.totalViajesPorMes(1));
					System.out.println("Marzo: " + modelo.totalViajesPorMes(2));
					System.out.println("Abril: " + modelo.totalViajesPorMes(3));
					System.out.println("Mayo: " + modelo.totalViajesPorMes(4));
					System.out.println("Junio: " + modelo.totalViajesPorMes(5));
					System.out.println("Julio: " + modelo.totalViajesPorMes(6));
					System.out.println("\n");

					break;

				case 2:

					
					try {
					System.out.println("--------- \nIngresar el número del mes de consulta: ");
					mesConsulta = lector.nextInt();
					System.out.println("--------- \nIngresar el número de la zona de origen de consulta: ");
					zonaOrigenConsulta = lector.nextInt();
					}
					catch(Exception e) {
						
						System.out.print("Debe ingresar un número.\n");
					}
							
					break;

				case 3:

					if(modelo.darDatos().tamano() == 0) {
						
						System.out.print("Aún no se han cargado los datos. \n");
					}
					
					else if(mesConsulta == -1 || zonaOrigenConsulta == -1) {
						System.out.print("Debe ingresar datos de consulta. \n");
						
					
					}
					
					else {
						ListaEncadenada<Viaje> lista = modelo.darListaViajesPorMesYOrigen(mesConsulta, zonaOrigenConsulta);
						IListaIterador<Viaje> iter = lista.iterador();
						Viaje actual = iter.siguiente();


						if (lista.tamano() == 0) {

							System.out.println("No se encontraron resultados con los parámetros dados. \n");
							
						} else {
							
							
							System.out.println("-----------------------------------------------------------------------------");
							System.out.printf("%10s %10s  %20s  %20s", "Origen", "Destino", "Tiempo promedio", "Desviación estándar");
							System.out.println();
							System.out.println("-----------------------------------------------------------------------------");

					
							while (iter.haySiguiente()) {
								actual = iter.siguiente();
								System.out.format("%10s %10s  %20s  %20s", actual.darIdOrigen(), actual.darIdDestino(), actual.darTiempoPromedio(), actual.darDesviacionEstandar());
								System.out.println();
							}
							System.out.println();
						}
					}
				
					break;

				case 4:

					if(modelo.darDatos().tamano() == 0) {
						
						System.out.print("Aún no se han cargado los datos. \n");
					}
					
					else if(mesConsulta == -1 || zonaOrigenConsulta == -1) {
						System.out.print("Debe ingresar datos de consulta. \n");
							
					}
					
					else {
						int totalViajes = modelo.totalViajesReportados();
						

						DecimalFormat d = new DecimalFormat("0.00");
						
						String porcentaje1 = d.format((modelo.porcentajePorMes(mesConsulta) + " %"));
						String porcentaje2 = d.format(((modelo.porcentajePorOrigen(zonaOrigenConsulta)) + " %"));

						System.out.println("El total de viajes reportados en el semestre: " + totalViajes);
						System.out.println("El total de viajes reportados para el mes de consulta: " + modelo.porcentajePorMes(mesConsulta));
						System.out.println("El porcentaje de viajes para el mes de consulta con respecto al total de viajes del semestre: " + porcentaje1);
						System.out.println("El total de viajes reportados para el origen de consulta: " + modelo.totalViajesPorOrigen(zonaOrigenConsulta));
						System.out.println("El porcentaje de viajes para el el origen  de consulta con respecto al total de viajes del semestre: " + porcentaje2);
						System.out.println();
					
					}
			}
		}
	}

}
