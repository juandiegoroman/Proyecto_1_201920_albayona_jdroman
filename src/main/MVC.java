package main;
import controller.Controller;
import model.logic.MVCModelo;

public class MVC {
	
	public static void main(String[] args) 
	{
		Controller controler = new Controller();
//		controler.run();

		MVCModelo m = new MVCModelo();
		m.cargarDatos("./data/bogota-cadastral-2018-1-All-MonthlyAggregate.csv");

	if (2==2);
	}
}
