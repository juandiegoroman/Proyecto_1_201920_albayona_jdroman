package model.logic;

public class Viaje {

    private int idOrigen;

    private int idDestino;

    private int indicadorTemporal;

    private double tiempoPromedio;

    private double desviacionEstandar;

    private double promedioGeometrico;

    private double desviacionGeometrica;

    public Viaje(int idOrigen, int idDestino, int indicadorTemporal, double tiempoPromedio, double desviacionEstandar, double promedioGeometrico, double desviacionGeometrica) {
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.indicadorTemporal = indicadorTemporal;
        this.tiempoPromedio = tiempoPromedio;
        this.desviacionEstandar = desviacionEstandar;
        this.promedioGeometrico = promedioGeometrico;
        this.desviacionGeometrica = desviacionGeometrica;
    }

    public int darIndicadorTemporal() {
        return indicadorTemporal;
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

        return "" + tiempoPromedio;
    }
}