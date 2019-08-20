package model.logic;

import com.opencsv.CSVReader;

import model.data_structures.IListaIterador;
import model.data_structures.ListaEncadenada;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

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
	

    public int totalViajesPorMes(int mes)
    {

        IListaIterador<Viaje> iter = datos.iterador();

        Viaje actual = iter.siguiente();

        int total = 0;
        while(iter.haySiguiente())
        {
            actual = iter.siguiente();

            if (actual.darMes() == mes){
              total++;
            }
        }
        return total;

    }

    public int totalViajesPorOrigen(int origen)
    {

        IListaIterador<Viaje> iter = datos.iterador();

        Viaje actual = iter.siguiente();

        int total = 0;
        while(iter.haySiguiente())
        {
            actual = iter.siguiente();

            if (actual.darIdOrigen() == origen){
                total++;
            }
        }
        return total;

    }

    public ListaEncadenada<Viaje> darListaViajesPorMesYOrigen(int mes, int origen)
    {

        ListaEncadenada<Viaje> lista =  new ListaEncadenada<>();

        IListaIterador<Viaje> iter = datos.iterador();

        Viaje actual = iter.siguiente();

        while(iter.haySiguiente())
        {
            actual = iter.siguiente();

            if (actual.darMes() == mes && actual.darIdOrigen() == origen){
                lista.insertarFinal(actual);
            }
        }
        return lista;
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

				String[] parametros = (String[]) iter.next();

				Viaje v = crearViaje(parametros);

				agregar(v);
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


    public ListaEncadenada<Viaje> darDatos() {
        return datos;
    }
}