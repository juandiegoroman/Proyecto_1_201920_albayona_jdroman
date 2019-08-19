package model.logic;

import com.opencsv.CSVReader;
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