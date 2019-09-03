package model.logic;

public class Viaje implements Comparable<Viaje>{

    private int idOrigen;

    private int idDestino;

    private int mes;

    private int dia;

    private int hora;

    private double tiempoPromedio;

    private double desviacionEstandar;

    private double promedioGeometrico;

    private double desviacionGeometrica;

 
    public int darMes()
    {
    	return mes;
    }

    public int darIdOrigen()
    {
    	return idOrigen;
    }

    public int darIdDestino() {
        return idDestino;
    }

    public double darTiempoPromedio() {
        return tiempoPromedio;
    }

    public double darDesviacionEstandar() {
        return desviacionEstandar;
    }

    public double darPromedioGeometrico() {
        return promedioGeometrico;
    }

    public double darDesviacionGeometrica() {
        return desviacionGeometrica;
    }

    public int compareTo(Viaje v){
        return 0;
    }

    public String toString(){

        return "" + idOrigen;
    }
}