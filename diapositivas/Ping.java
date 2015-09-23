package diapositivas;

import java.io.IOException;
import java.io.InputStream;

public class Ping {
	public static void main(String[] args) {
		//Pasamos como argumentos el host al que vamos a hacer ping
		String[] comandos=new String[3];
		if (args.length>0) {
			comandos[0]="ping";
			comandos[1]=args[0];
			comandos[2]="-c4";
		}
		else{
			System.out.println("Has de introducir argumentos");
			System.exit(0);
		}
		//Creamos la clase Runtime y Process
		try {
			Process proceso=Runtime.getRuntime().exec(comandos);
			//Recoger el inputStream que genera el proceso
			InputStream in=proceso.getInputStream();
			int c;//variable que lee los distintos bytes
			while ((c=in.read())!=-1){
				System.out.print((char)c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
