package model.logic;

public class Viaje implements Comparable<Viaje>{

    private int idOrigen;

    private int idDestino;

    private int mes;

    private double tiempoPromedio;

    private double desviacionEstandar;

    private double promedioGeometrico;

    private double desviaciónGeométrica;

    public Viaje(int idOrigen, int idDestino, int mes, double tiempoPromedio, double desviacionEstandar, double promedioGeometrico, double desviaciónGeométrica) {
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.mes = mes;
        this.tiempoPromedio = tiempoPromedio;
        this.desviacionEstandar = desviacionEstandar;
        this.promedioGeometrico = promedioGeometrico;
        this.desviaciónGeométrica = desviaciónGeométrica;
    }

    public int compareTo(Viaje v){
        return 0;
    }
}