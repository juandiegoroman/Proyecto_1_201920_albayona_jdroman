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
	

	public double tiempoPromedioDeViajeYDesviacionEstandarDeUnMes(int mes)
	{
		return 0.1;
	}

	public int informacionNViajesConMayorTiempoPromedioMes(int mes, int NViajes)
	{
		return 1;
	}
    
    public ListaEncadenada<Viaje> viajesDeUnaZonaDadaAZonaXMes()
    {
    	ListaEncadenada<Viaje> temp = new ListaEncadenada<Viaje>();
    
    	return 	temp;
    }
    
    public ListaEncadenada<Viaje> viajesDeUnaZonaXAUnaZonaDadaMes()
    {
    	ListaEncadenada<Viaje> temp = new ListaEncadenada<Viaje>();
    	return temp;
    }
    
    public double tiempoPromedioDeViajesYDesviacionEstandarDia(int dia)
    {
    	return 0.1;
    }

    public int informacionNviajesConMayorTiempoPromedioDia(int dia, int NViajes)
    {
    	return 1;
    }
    public ListaEncadenada<Viaje> viajesDeUnaZonaDadaAZonaXDia()
    {
    	ListaEncadenada<Viaje> temp = new ListaEncadenada<Viaje>();
    	return temp;
    }

    public ListaEncadenada<Viaje> viajesDeUnaZonaXAUnaZonaDadaDia()
    {
    	ListaEncadenada<Viaje> temp = new ListaEncadenada<Viaje>();
    	return temp;
    }


}