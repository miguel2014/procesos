package diapositivas;

import java.io.IOException;

public class EjemploRuntime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creamos un objeto Runtime
		Runtime runTime=Runtime.getRuntime();
		//Creamos un objeto Process
		//En Windows "cmd.exe notepad++.exe");
		//ps aux |grep proceso
		try {
			Process p=runTime.exec( "gedit");
			Process p1=runTime.exec("firefox http://www.genbeta.com/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(20_000);
			System.out.println("Programa principal durmiendo 20 s");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Programa interrumpido");
			e.printStackTrace();
		}
		System.out.println("Fin del programa");
	}
	

}
