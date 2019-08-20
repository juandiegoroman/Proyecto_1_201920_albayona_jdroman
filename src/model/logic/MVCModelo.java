package model.logic;

import com.opencsv.CSVReader;

import model.data_structures.IIterador;
import model.data_structures.ListaEncadenada;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ListaEncadenada<Viaje> datos;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new ListaEncadenada();
	}
	
	public int totalViajesReportados()
	{
		return datos.tamano();
	}
	
	public int totalViajesPorMes(int Mes)
	{
		int total = 0;
		IIterador<Viaje> iter = datos.darIteradore();
		Viaje actual = iter.siguiente();
		while(iter.tieneSiguiente())
		{
			if(actual.darMes() == Mes)
			{
				total++;
			}
		}
		return total;
	}
	
	public String cantidadYPorcentaje(int Mes, int Origen)
	{
		double promedio = 0;
		int cantReq = 0;
		int total = 0;
		IIterador<Viaje> iter = datos.darIteradore();
		Viaje actual = iter.siguiente();
		while(iter.tieneSiguiente())
		{
			if(actual.darMes() == Mes && actual.darIdOrigen() == Origen)
			{
				cantReq++;
			}
			total++;
		}
		promedio = (cantReq/total)*100;
		return "La cantidad de viajes reportados por el mes y la zona de origen de consultaes:"+cantReq+"y su respectuvo porcentaje con respecto al total de viajes del mes es:"+promedio;
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Viaje dato)
	{
		datos.insertarFinal(dato);
	}



	public void cargarDatos(String ruta){
		CSVReader reader = null;
		try {

			reader = new CSVReader(new FileReader(ruta));

			Iterator iter = reader.iterator();
			iter.next();

			while (iter.hasNext()){

				agregar(crearViaje((String[]) iter.next()));
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public Viaje crearViaje(String[] datos ){

		return new Viaje(Integer.valueOf(datos[0]), Integer.valueOf(datos[1]),Integer.valueOf(datos[2]), Double.valueOf(datos[3]),Double.valueOf(datos[4]), Double.valueOf(datos[5]), Double.valueOf(datos[6]));

	}



}