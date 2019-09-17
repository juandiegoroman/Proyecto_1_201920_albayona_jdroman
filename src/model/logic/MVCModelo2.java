//package model.logic;
//
//import model.data_structures.IListaIterador;
//import model.data_structures.ListaEncadenada;
//
///**
// * Definicion del modelo del mundo
// *
// */
//public class MVCModelo2 {
//	/**
//	 * Atributos del modelo del mundo
//	 */
//	private CargadorCSV datos;
//
//	/**
//	 * Constructor del modelo del mundo con capacidad predefinida
//	 */
//	public MVCModelo2()
//	{
//		datos = new CargadorCSV();
//	}
//
//	public CargadorCSV datos() {
//		return datos;
//	}
//
//
//	public int informacionNViajesConMayorTiempoPromedioMes(int mes, int NViajes)
//	{
//		return 1;
//	}
//
//    public int informacionNviajesConMayorTiempoPromedioDia(int dia, int NViajes)
//    {
//    	return 1;
//    }
//    public ListaEncadenada<Viaje> viajesDeUnaZonaDadaAZonaXDia()
//    {
//    	ListaEncadenada<Viaje> temp = new ListaEncadenada<Viaje>();
//    	return temp;
//    }
//
//    public ListaEncadenada<Viaje> viajesDeUnaZonaXAUnaZonaDadaDia()
//    {
//    	ListaEncadenada<Viaje> temp = new ListaEncadenada<Viaje>();
//    	return temp;
//    }
//
//    public void cargarDatosPorTrimiestre(int trimestre){
//		datos.cargarTodos(trimestre);
//	}
//
//	public int darMayorIdentificador()
//	{
//
//		IListaIterador<Viaje> iter1 = datos.datosDia().iterador();
//		IListaIterador<Viaje> iter2 = datos.datosHora().iterador();
//		IListaIterador<Viaje> iter3 = datos.datosMes().iterador();
//
//		int mayor = 0;
//
//		mayor = darMayor(iter1, mayor);
//
//		mayor = darMayor(iter2, mayor);
//
//		mayor = darMayor(iter3, mayor);
//
//		return mayor;
//	}
//
//	private int darMayor(IListaIterador<Viaje> iter1, int mayor) {
//		while (iter1.haySiguiente()) {
//			Viaje actual = iter1.siguiente();
//			if (actual.darIdOrigen() > mayor) {
//				mayor = actual.darIdOrigen();
//			}
//		}
//		return mayor;
//	}
//
//	public int darMenorIdentificador()
//	{
//
//		IListaIterador<Viaje> iter1 = datos.datosDia().iterador();
//		IListaIterador<Viaje> iter2 = datos.datosHora().iterador();
//		IListaIterador<Viaje> iter3 = datos.datosMes().iterador();
//
//		int menor = Integer.MAX_VALUE;
//
//		menor = darMenor(iter1, menor);
//		menor = darMenor(iter2, menor);
//		menor = darMenor(iter3, menor);
//
//		return menor;
//	}
//
//
//	public double tiempoPromedioDeViajesYDesviacionEstandarDia(int pDia, int pOrigen, int pDestino)
//	{
//		int cont = 0;
//		int total = 0;
//		double promedio = 0;
//		IListaIterador<Viaje> iter= datos.datosMes().iterador();
//		while(iter.haySiguiente())
//		{
//			Viaje actual = iter.siguiente();
//			if( actual.darIndicadorTemporal() == pDia &&  actual.darIdOrigen() > pOrigen && actual.darIdDestino() < pDestino)
//			{
//				cont+=actual.darTiempoPromedio();
//				total++;
//			}
//		}
//		if(iter.haySiguiente() == false)
//		{
//			promedio = 0;
//		}
//		promedio = cont/total;
//		return promedio;
//	}
//
//	public ListaEncadenada<Viaje> viajesDeUnaZonaDadaAZonaXMes(int zonaReferencia, int zonaInicial, int zonaFinal)
//	{
//		IListaIterador<Viaje> iter = datos.datosMes().iterador();
//		ListaEncadenada<Viaje> rta = new ListaEncadenada<Viaje>();
//		while(iter.haySiguiente())
//		{
//			Viaje actual= iter.siguiente();
//			if(actual.darIdOrigen()== zonaReferencia && estaEnElRango(actual.darIdDestino(),zonaInicial, zonaFinal))
//			{
//				rta.insertarFinal(actual);
//			}
//		}
//
//		return 	rta;
//	}
//
//	public ListaEncadenada<Viaje> viajesDeUnaZonaXAUnaZonaDadaMes(int zonaReferencia, int zonaInicial, int zonaFinal)
//	{
//		ListaEncadenada<Viaje> rta = new ListaEncadenada<Viaje>();
//		IListaIterador<Viaje> iter = datos.datosMes().iterador();
//		while(iter.haySiguiente())
//		{
//			Viaje actual= iter.siguiente();
//			if(actual.darIdDestino()== zonaReferencia && estaEnElRango(actual.darIdOrigen(), zonaInicial, zonaFinal))
//			{
//				rta.insertarFinal(actual);
//			}
//		}
//		return rta;
//	}
//
//	public
//
//
//
//	private int darMenor(IListaIterador<Viaje> iter1, int menor) {
//		while (iter1.haySiguiente()) {
//			Viaje actual = iter1.siguiente();
//			if (actual.darIdOrigen() < menor) {
//				menor = actual.darIdOrigen();
//			}
//		}
//		return menor;
//	}
//
//
//
//}