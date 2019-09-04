package model.logic;

import model.data_structures.IListaIterador;
import model.data_structures.ListaEncadenada;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private DatosCSV datos;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new DatosCSV();
	}

	public DatosCSV datos() {
		return datos;
	}

	public double tiempoPromedioDeViajeYDesviacionEstandarDeUnMes(int mes)
	{
		return 1;
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
    	return 1;
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

    public void cargarDatosPorTrimiestre(int trimestre){
		datos.cargarTodos(trimestre);
	}

	public int darMayorIdentificador()
	{

		IListaIterador<Viaje> iter1 = datos.datosDia().iterador();
		IListaIterador<Viaje> iter2 = datos.datosHora().iterador();
		IListaIterador<Viaje> iter3 = datos.datosMes().iterador();

		int mayor = 0;

		mayor = darMayor(iter1, mayor);

		mayor = darMayor(iter2, mayor);

		mayor = darMayor(iter3, mayor);

		return mayor;
	}

	private int darMayor(IListaIterador<Viaje> iter1, int mayor) {
		while (iter1.haySiguiente()) {
			Viaje actual = iter1.siguiente();
			if (actual.darIdOrigen() > mayor) {
				mayor = actual.darIdOrigen();
			}
		}
		return mayor;
	}

	public int darMenorIdentificador()
	{

		IListaIterador<Viaje> iter1 = datos.datosDia().iterador();
		IListaIterador<Viaje> iter2 = datos.datosHora().iterador();
		IListaIterador<Viaje> iter3 = datos.datosMes().iterador();

		int menor = Integer.MAX_VALUE;

		menor = darMenor(iter1, menor);
		menor = darMenor(iter2, menor);
		menor = darMenor(iter3, menor);

		return menor;
	}

	private int darMenor(IListaIterador<Viaje> iter1, int menor) {
		while (iter1.haySiguiente()) {
			Viaje actual = iter1.siguiente();
			if (actual.darIdOrigen() < menor) {
				menor = actual.darIdOrigen();
			}
		}
		return menor;
	}



}