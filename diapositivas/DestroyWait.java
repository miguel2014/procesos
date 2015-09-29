package diapositivas;

import java.io.IOException;

public class DestroyWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Process proceso=new ProcessBuilder("gedit").start();
			System.out.println("Abriendo gedit ");
			//Thread.sleep(10_000);
			proceso.waitFor();//Se queda en modo espera hasta que se cierra el programa
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Acabado programa Java");
	}

	
}
