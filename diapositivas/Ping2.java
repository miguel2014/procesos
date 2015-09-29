package diapositivas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ping2 {
	public static void main(String[] args) {
		//Pasamos como argumentos el host al que vamos a hacer ping
		BufferedReader in=null;
		List <String> lista=new ArrayList<String>();
		List <String> comandos=new ArrayList<String>();
		ProcessBuilder pBuilder=null;
		String[] campos=null;
		if (args.length>0) {
			comandos.add("ping");
			comandos.add(args[0]);
			comandos.add("-c4");
			pBuilder=new ProcessBuilder(comandos);
		}
		else{
			System.out.println("Has de introducir argumentos");
			System.exit(0);
		}
		try {
			Process proceso=pBuilder.start();
			in=new BufferedReader
					(new InputStreamReader(proceso.getInputStream()));
			in.readLine();
			String linea=null;
			while ((linea=in.readLine())!=null) {
				if (lista.size()<4) {
					lista.add(linea);	
				}	
			}
			List <String> listaprueba=new ArrayList<String>();
			listaprueba.add("Esta es una frase que quiero dividir");
			listaprueba.add("esta es otra frase");
			for (int i = 0; i < listaprueba.size(); i++) {
				campos=listaprueba.get(i).split("/t");
				System.out.println();
			}
			System.out.println(lista);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
