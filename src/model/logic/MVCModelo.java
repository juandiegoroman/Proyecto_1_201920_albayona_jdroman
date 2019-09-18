package model.logic;

import model.data_structures.IComparador;
import model.data_structures.IListaIterador;
import model.data_structures.ListaEncadenada;

/**
 * Definicion del modelo del mundo
 */
public class MVCModelo {
    /**
     * Atributos del modelo del mundo
     */
    private ListaEncadenada<Viaje> datosPorMes;
    private ListaEncadenada<Viaje> datosPorDia;
    private ListaEncadenada<Viaje> datosPorHora;

    public final static String MES = "mes";
    public final static String DIA = "dia";
    public final static String HORA = "hora";

    /**
     * Constructor del modelo del mundo con capacidad predefinida
     */
    public MVCModelo() {
        datosPorMes = new ListaEncadenada<>();
        datosPorDia = new ListaEncadenada<>();
        datosPorHora = new ListaEncadenada<>();
    }

    public ListaEncadenada<Viaje> datosPorMes() {
        return datosPorMes;
    }

    public ListaEncadenada<Viaje> datosPorDia() {
        return datosPorDia;
    }

    public ListaEncadenada<Viaje> datosPorHora() {
        return datosPorHora;
    }

    public void cargarDatosPorTrimiestre(int trimestre) {

        CargadorCSV d = new CargadorCSV(datosPorMes, datosPorDia, datosPorHora);
        d.cargarTodos(trimestre);
    }


    public int darMayorIdentificador() {

        IListaIterador<Viaje> iter1 = datosPorMes.iterador();
        IListaIterador<Viaje> iter2 = datosPorDia.iterador();
        IListaIterador<Viaje> iter3 = datosPorHora.iterador();

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

    public int darMenorIdentificador() {

        IListaIterador<Viaje> iter1 = datosPorMes.iterador();
        IListaIterador<Viaje> iter2 = datosPorDia.iterador();
        IListaIterador<Viaje> iter3 = datosPorHora.iterador();

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


    public ListaEncadenada<Viaje> darNMayoresPorIndicadorTemporal(int n, int codigoIndicadorTemporal, String indicadorTemporal) {

        ListaEncadenada<Viaje> viajesMayores = new ListaEncadenada<>();

        IListaIterador<Viaje> iter = null;

        if (indicadorTemporal.equals(MES)) iter = datosPorMes.iterador();
        else if (indicadorTemporal.equals(DIA)) iter = datosPorDia.iterador();
        else if (indicadorTemporal.equals(HORA)) iter = datosPorHora.iterador();

        while (iter.haySiguiente()) {

            Viaje viaje = iter.siguiente();

            if (viaje.darIndicadorTemporal() == codigoIndicadorTemporal) {

                if (viajesMayores.tamano() == 0) {
                    viajesMayores.insertarFinal(viaje);
                } else {
                    IListaIterador<Viaje> iterMayores = viajesMayores.iterador();

                    Viaje mayorTemp = iterMayores.siguiente();

                    while (iterMayores.haySiguiente() && mayorTemp.darTiempoPromedio() < viaje.darTiempoPromedio()) {
                        mayorTemp = iterMayores.siguiente();
                    }


                        if (mayorTemp.darTiempoPromedio() < viaje.darTiempoPromedio()){
                            viajesMayores.insertarDespues(viaje);
                        }
                        else {
                            viajesMayores.insertarAntes(viaje);
                        }



                    if (viajesMayores.tamano() > n) viajesMayores.sacarPrimero();
                }

            }
        }
        return viajesMayores;
    }


    public double tiempoPromedioDeViajesEnRangoPorIndicadorTemporal(int codigoIndicadorTemporal, int pOrigen, int pDestino, String indicadorTemporal) {
        double cont = 0;
        double total = 0;
        double promedio = 0;
        IListaIterador<Viaje> iter = null;

        if (indicadorTemporal.equals(MES)) iter = datosPorMes.iterador();
        else if (indicadorTemporal.equals(DIA)) iter = datosPorDia.iterador();
        else if (indicadorTemporal.equals(HORA)) iter = datosPorHora.iterador();

        while (iter.haySiguiente()) {
            Viaje actual = iter.siguiente();
            if (actual.darIndicadorTemporal() == codigoIndicadorTemporal && actual.darIdOrigen() > pOrigen && actual.darIdDestino() < pDestino) {
                cont += actual.darTiempoPromedio();
                total++;
            }
        }

        if (total == 0) promedio = 0;

        else promedio = cont / total;

        return promedio;
    }

    public double promedioDesviacionEstandarDeViajesEnRangoPorIndicadorTemporal(int codigoIndicadorTemporal, int pOrigen, int pDestino, String indicadorTemporal) {
        double cont = 0;
        double total = 0;
        double promedio = 0;
        IListaIterador<Viaje> iter = null;

        if (indicadorTemporal.equals(MES)) iter = datosPorMes.iterador();
        else if (indicadorTemporal.equals(DIA)) iter = datosPorDia.iterador();
        else if (indicadorTemporal.equals(HORA)) iter = datosPorHora.iterador();

        while (iter.haySiguiente()) {
            Viaje actual = iter.siguiente();
            if (actual.darIndicadorTemporal() == codigoIndicadorTemporal && actual.darIdOrigen() > pOrigen && actual.darIdDestino() < pDestino) {
                cont += actual.darDesviacionEstandar();
                total++;
            }
        }

        if (total == 0) promedio = 0;

        else promedio = cont / total;

        return promedio;
    }


    public boolean estaEnRango(int x, int a, int b) {
        return x >= a && x <= b;
    }


    public ListaEncadenada<Viaje> viajesDeZonaDadaAZonaXPorIndicadorTemporal(int zonaReferencia, int zonaInicial, int zonaFinal, int codigoIndicadorTemporal, String indicadorTemporal) {
        IListaIterador<Viaje> iter = null;

        if (indicadorTemporal.equals(MES)) iter = datosPorMes.iterador();
        else if (indicadorTemporal.equals(DIA)) iter = datosPorDia.iterador();
        else if (indicadorTemporal.equals(HORA)) iter = datosPorHora.iterador();


        ListaEncadenada<Viaje> buscados = new ListaEncadenada<>();

        while (iter.haySiguiente()) {
            Viaje actual = iter.siguiente();

            if (actual.darIndicadorTemporal() == codigoIndicadorTemporal) {
                if (actual.darIdOrigen() == zonaReferencia && estaEnRango(actual.darIdDestino(), zonaInicial, zonaFinal)) {
                    buscados.insertarFinal(actual);
                }
            }
        }

        IComparador criterio = new ComparadorPorDestino();

        buscados.ordenarPorMergeSort(criterio);

        return buscados;
    }

    private class ComparadorPorDestino implements IComparador<Viaje> {
        @Override
        public int comparar(Viaje o1, Viaje o2) {
            if (o1.darIdDestino() < o2.darIdDestino()) return -1;
            if (o1.darIdDestino() > o2.darIdDestino()) return 1;
            else return 0;
        }
    }

    public int[] datosGrafica(int pOrigen, int pDestino)
    {
        int[] listaPromedios = new int[24];
        double[] total = new double[24];
        double[] cantidad = new double[24];
        IListaIterador<Viaje> iter = datosPorHora.iterador() ;
        while(iter.haySiguiente())
        {
            Viaje actual = iter.siguiente();
            if(actual.darIdOrigen() >= pOrigen && actual.darIdDestino() <= pDestino)
            {
                total[actual.darIndicadorTemporal()] += actual.darTiempoPromedio();
                cantidad[actual.darIndicadorTemporal()]++;
            }

        }
        for(int i = 0; i< cantidad.length; i++)
        {
            listaPromedios[i] = (int) Math.round(total[i]/cantidad[i]);
        }
        return listaPromedios;
    }


    public ListaEncadenada<Viaje> viajesDeZonaXAZonaDadaPorIndicadorTemporal(int zonaReferencia, int zonaInicial, int zonaFinal, int codigoIndicadorTemporal, String indicadorTemporal) {
        IListaIterador<Viaje> iter = null;

        if (indicadorTemporal.equals(MES)) iter = datosPorMes.iterador();
        else if (indicadorTemporal.equals(DIA)) iter = datosPorDia.iterador();
        else if (indicadorTemporal.equals(HORA)) iter = datosPorHora.iterador();


        ListaEncadenada<Viaje> buscados = new ListaEncadenada<>();

        while (iter.haySiguiente()) {
            Viaje actual = iter.siguiente();
            if (actual.darIndicadorTemporal() == codigoIndicadorTemporal) {
                if (estaEnRango(actual.darIdOrigen(), zonaInicial, zonaFinal) && actual.darIdDestino() == zonaReferencia) {
                    buscados.insertarFinal(actual);
                }
            }
        }

        IComparador criterio = new ComparadorPorOrigen();

        buscados.ordenarPorMergeSort(criterio);

        return buscados;
    }

    private class ComparadorPorOrigen implements IComparador<Viaje> {
        @Override
        public int comparar(Viaje o1, Viaje o2) {
            if (o1.darIdOrigen() < o2.darIdOrigen()) return -1;
            if (o1.darIdOrigen() > o2.darIdOrigen()) return 1;
            else return 0;
        }
    }

    public void compararConsultasEnAmbosSentidos(int zonaReferencia, int zonaInicial, int zonaFinal, int codigoIndicadorTemporal, String indicadorTemporal) {

        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("%-60s %-60s", "Tiempo promedio desde ", "Tiempo promedio desde");
        System.out.println();
        System.out.printf("%-60s %-60s", "la zona " + zonaReferencia + " a una zona en el rango [" + zonaInicial + " , " + zonaFinal + "]", "una zona en el rango [" + zonaInicial + " , " + zonaFinal + "]" + " a la zona " + zonaReferencia);
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------");

        ListaEncadenada<Viaje> lista1 = viajesDeZonaDadaAZonaXPorIndicadorTemporal(zonaReferencia, zonaInicial, zonaFinal, codigoIndicadorTemporal, indicadorTemporal);
        ListaEncadenada<Viaje> lista2 = viajesDeZonaXAZonaDadaPorIndicadorTemporal(zonaReferencia, zonaInicial, zonaFinal, codigoIndicadorTemporal, indicadorTemporal);

        IListaIterador<Viaje> iter1 = lista1.iterador();
        IListaIterador<Viaje> iter2 = lista2.iterador();


        String[] viajes1 = new String[zonaFinal - zonaInicial + 1];

        while (iter1.haySiguiente()){
            Viaje temp1 = iter1.siguiente();
            viajes1[temp1.darIdDestino() - zonaInicial] = temp1.darTiempoPromedio() + " segundos de la zona " + temp1.darIdOrigen() + " a la zona " + temp1.darIdDestino();

        }

        String[] viajes2 = new String[zonaFinal - zonaInicial + 1];

        while (iter2.haySiguiente()){
            Viaje temp2 = iter2.siguiente();
            viajes2[temp2.darIdOrigen() - zonaInicial] = temp2.darTiempoPromedio() + " segundos de la zona " + temp2.darIdOrigen() + " a la zona " + temp2.darIdDestino();
        }

        for (int i = zonaInicial; i < zonaFinal + 1; i++) {

            String linea1 = "No hay  viajes de la zona " + zonaReferencia + " a la zona " + i;
            String linea2 = "No hay viajes de la zona " + i + " a la zona " + zonaReferencia;

            if (viajes1[i - zonaInicial] != null){
                linea1 = viajes1[i - zonaInicial];
            }

            if (viajes2[i - zonaInicial] != null){
                linea2 = viajes2[i - zonaInicial];
            }


            System.out.format("%-50s %-5s %5s %-50s", linea1, "vs", "", linea2);
            System.out.println();

        }

    }

}