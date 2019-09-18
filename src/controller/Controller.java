package controller;

import java.util.Scanner;

import model.data_structures.IListaIterador;
import model.logic.MVCModelo;
import model.logic.Viaje;
import view.MVCView;

public class Controller {


    /* Instancia del Modelo*/
    private MVCModelo modelo;

    /* Instancia de la Vista*/
    private MVCView view;


    /**
     * Crear la vista y el modelo del proyecto
     */
    public Controller() {
        modelo = new MVCModelo();
        view = new MVCView();
    }


    public void run() {

        Scanner lector = new Scanner(System.in);
        boolean fin = false;


        int trimestre = -1;
        int mes = -1;
        int dia = -1;
        int hora = -1;
        int zonaOrigen = -1;
        int zonaDestino = -1;
        int nViajes = -1;

        int zonaMayor = -1;
        int zonaMenor = -1;


        while (!fin) {
            view.printMenu();

            int option = lector.nextInt();

            switch (option) {
                case 1:

                    try {
                        System.out.println("\nIngresar el trimestre: ");
                        trimestre = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }


                    modelo.cargarDatosPorTrimiestre(trimestre);

                    System.out.println("Para el trimestre " + trimestre + " del 2018 se leyeron las siguientes cantidades de viajes por mes: " + modelo.datosPorMes().tamano() + "\n");
                    System.out.println("Para el trimestre " + trimestre + " del 2018 se leyeron las siguientes cantidades de viajes por día: " + modelo.datosPorDia().tamano() + "\n");
                    System.out.println("Para el trimestre " + trimestre + " del 2018 se leyeron las siguientes cantidades de viajes por hora: " + modelo.datosPorHora().tamano() + "\n");

                    System.out.println("El menor identificador hallado en todos los arhivos del trimestre seleccionado es: " + modelo.darMenorIdentificador());
                    System.out.println("El mayor identificador hallado en todos los arhivos del trimestre seleccionado es: " + modelo.darMayorIdentificador());
                    System.out.println();

                    break;

                case 2:
                    try {
                        System.out.println("\nIngresar la zona de origen: ");
                        zonaOrigen = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar la zona de destino: ");
                        zonaDestino = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar mes: ");
                        mes = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar dia: ");
                        dia = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar hora: ");
                        hora = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    System.out.println("Para el mes " + mes + ", los viajes entre la zona " + zonaOrigen + " y la zona " + zonaDestino + " tienen un promedio de " + modelo.tiempoPromedioDeViajesEnRangoPorIndicadorTemporal(mes, zonaOrigen, zonaDestino, MVCModelo.MES) + " segundos");
                    System.out.println("Para el mes " + mes + ", los viajes entre la zona " + zonaOrigen + " y la zona " + zonaDestino + " tienen un promedio de desviacion estandar de " + modelo.promedioDesviacionEstandarDeViajesEnRangoPorIndicadorTemporal(mes, zonaOrigen, zonaDestino, MVCModelo.MES));
                    System.out.println();
                    System.out.println("Para el dia " + dia + ", los viajes entre la zona " + zonaOrigen + " y la zona " + zonaDestino + " tienen un promedio de " + modelo.tiempoPromedioDeViajesEnRangoPorIndicadorTemporal(dia, zonaOrigen, zonaDestino, MVCModelo.DIA) + " segundos");
                    System.out.println("Para el dia " + dia + ", los viajes entre la zona " + zonaOrigen + " y la zona " + zonaDestino + " tienen un promedio de desviacion estandar de " + modelo.promedioDesviacionEstandarDeViajesEnRangoPorIndicadorTemporal(dia, zonaOrigen, zonaDestino, MVCModelo.DIA));
                    System.out.println();
                    System.out.println("Para la hora " + hora + ", los viajes entre la zona " + zonaOrigen + " y la zona " + zonaDestino + " tienen un promedio de " + modelo.tiempoPromedioDeViajesEnRangoPorIndicadorTemporal(hora, zonaOrigen, zonaDestino, MVCModelo.HORA) + " segundos");
                    System.out.println("Para la hora " + hora + ", los viajes entre la zona " + zonaOrigen + " y la zona " + zonaDestino + " tienen un promedio de desviacion estandar de " + modelo.promedioDesviacionEstandarDeViajesEnRangoPorIndicadorTemporal(hora, zonaOrigen, zonaDestino, MVCModelo.HORA));
                    System.out.println();

                    break;

                case 3:

                    try {
                        System.out.println("\nIngresar la cantidad de viajes con mayor tiempo promedio: ");
                        nViajes = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }


                    try {
                        System.out.println("\nIngresar mes: ");
                        mes = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar dia: ");
                        dia = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar hora: ");
                        hora = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    System.out.print(" \n Para el mes " + mes + ", los " + nViajes + " viajes (si los hay) con mayor tiempo promedio son: \n ");
                    printList(modelo.darNMayoresPorIndicadorTemporal(nViajes, mes, MVCModelo.MES).iterador());
                    System.out.print(" \n Para el dia " + dia + ", los " + nViajes + " viajes (si los hay) con mayor tiempo promedio son: \n ");
                    printList(modelo.darNMayoresPorIndicadorTemporal(nViajes, dia, MVCModelo.DIA).iterador());
                    System.out.print(" \n Para la hora " + hora + ", los " + nViajes + " viajes (si los hay) con mayor tiempo promedio son: \n ");
                    printList(modelo.darNMayoresPorIndicadorTemporal(nViajes, hora, MVCModelo.HORA).iterador());

                    break;

                case 4:
                    try {
                        System.out.println("\nIngresar una zona dada de referencia: ");
                        zonaOrigen = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar la zona menor del rango: ");
                        zonaMenor = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar a zona mayor del rango: ");
                        zonaMayor = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar mes: ");
                        mes = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar dia: ");
                        dia = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    System.out.println("Para el mes " + mes + ", se calculo la siguiente comparacion: ");
                    System.out.println();
                    modelo.compararConsultasEnAmbosSentidos(zonaOrigen, zonaMenor, zonaMayor, mes, MVCModelo.MES);
                    System.out.println();
                    System.out.println("Para el dia " + dia + ", se calculo la siguiente comparacion: ");
                    System.out.println();
                    modelo.compararConsultasEnAmbosSentidos(zonaOrigen, zonaMenor, zonaMayor, dia, MVCModelo.DIA);
                    System.out.println();
                    break;


                case 5:

                    try {
                        System.out.println("\nIngresar la zona de origen: ");
                        zonaOrigen = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }

                    try {
                        System.out.println("\nIngresar la zona de destino: ");
                        zonaDestino = lector.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }



                    System.out.println("Aproximacion en minutos de viajes entre zona origen y zona destino.");
                    System.out.println("Trimestre " + trimestre + " del 2018 detallado por cada hora del día");

                    System.out.println("Zona origen: " + zonaOrigen);
                    System.out.println("Zona destino: " + zonaDestino);
                    System.out.format("%-5s %-1s %-10s" , "Hora", "|", "# de minutos" );
                    System.out.println();
                    
                    int[] promedios = modelo.tiempoPromedioViajePorCadaHora(zonaOrigen, zonaDestino);

                    for (int i = 0; i < promedios.length; i++) {

                        String linea = "hora sin viajes";

                        if(promedios[i] > 0) linea = "";

                        for (int j = 0; j <  promedios[i]; j++) {
                            linea+="*";
                        }

                        System.out.format("%-5s %-1s %-10s", String.format("%02d" , i) ,"|", linea);

                        System.out.println();
                    }
                    
                    break;

                default: {
                    System.out.println("Opcion invalida");
                }
            }
        }
    }

    private void printList(IListaIterador<Viaje> iter) {
        Viaje actual;
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("%3s %10s  %20s  %20s %20s", "#", "Origen", "Destino", "Tiempo promedio", "Desviación estandar");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------");

        int cont = 1;
        while (iter.haySiguiente()) {
            actual = iter.siguiente();
            System.out.format("%3s %10s  %20s  %20s %20s", cont, actual.darIdOrigen(), actual.darIdDestino(), actual.darTiempoPromedio(), actual.darDesviacionEstandar());
            System.out.println();
            cont++;
        }
    }




}
