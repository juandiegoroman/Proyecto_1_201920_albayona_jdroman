package main;
import controller.Controller;
import model.data_structures.IListaIterador;
import model.data_structures.ListaEncadenada;
import model.logic.MVCModelo;

public class MVC {
	
	public static void main(String[] args) 
	{
		
		Controller controler = new Controller();
		controler.run();
	}
}
