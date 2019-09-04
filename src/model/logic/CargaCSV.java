package model.logic;

import com.opencsv.CSVReader;

import model.data_structures.ListaEncadenada;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;






public class CargaCSV {

    public final static String DIRECTORIO = "./data/bogota-cadastral-2018-";
    public final static String MES = "-All-MonthlyAggregate.csv";
    public final static String DIA = "-WeeklyAggregate.csv";
    public final static String HORA = "-All-HourlyAggregate.csv";


    private ListaEncadenada<Viaje> datosPorMes;
    private ListaEncadenada<Viaje> datosPorDia;
    private ListaEncadenada<Viaje> datosPorHora;

    public CargaCSV() {
        datosPorMes = new ListaEncadenada<>();
        datosPorDia = new ListaEncadenada<>();
        datosPorHora = new ListaEncadenada<>();
    }


    public void cargarTodos(int trimestre){

        cargar(DIRECTORIO,trimestre, MES);
        cargar(DIRECTORIO,trimestre, DIA);
        cargar(DIRECTORIO,trimestre, HORA);

    }


    public void cargar(String directorio, int trimestre, String indicadorTemporal){
        CSVReader reader = null;
        try {

            reader = new CSVReader(new FileReader(directorio + trimestre + indicadorTemporal));

            Iterator iter = reader.iterator();

            iter.next();

            while (iter.hasNext()){

                String[] parametros = (String[]) iter.next();

             crearYAgregarViaje(parametros, indicadorTemporal);

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


    public void crearYAgregarViaje(String[] datos , String indicadorTemporal){

        Viaje viaje = new Viaje(Integer.valueOf(datos[0]), Integer.valueOf(datos[1]),Integer.valueOf(datos[2]), Double.valueOf(datos[3]),Double.valueOf(datos[4]), Double.valueOf(datos[5]), Double.valueOf(datos[6]));

        if (indicadorTemporal.equals(MES)){
            datosPorMes.insertarFinal(viaje);
        }
        else if (indicadorTemporal.equals(DIA)){
            datosPorDia.insertarFinal(viaje);
        }
        else if (indicadorTemporal.equals(HORA)){
            datosPorHora.insertarFinal(viaje);
        }
    }


}
