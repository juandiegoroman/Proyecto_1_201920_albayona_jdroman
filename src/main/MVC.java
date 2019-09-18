package main;
import controller.Controller;
import model.data_structures.ListaEncadenada;
import model.logic.MVCModelo;
import model.logic.Viaje;


public class MVC {


	public static void main(String[] args)
	{

//		Controller controler = new Controller();
//		controler.run();

		MVCModelo mod = new MVCModelo();

		mod.cargarDatosPorTrimiestre(1);
		int[] a = mod.datosGrafica(0,50);

		mod =null;



	}
}
