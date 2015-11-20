package diapositivas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ping2 {
	public static void main(String[] args) {
		//Pasamos como argumentos el host al que vamos a hacer ping
		BufferedReader in=null;
		List <String> listadatos1=new ArrayList<String>(); //Para el csv
		List <String> listadatos2=new ArrayList<String>(); //Para datos ,min,max y media
		int tamanoInicial;
		int tamanoFinal;
		
		String linea;
		List <String> comandos=new ArrayList<String>();
		ProcessBuilder pBuilder=null;
		final String paquetes="4";
		String[] campos=null;
		
			comandos.add("ping");
			comandos.add("www.google.es");
			comandos.add("-c");
			comandos.add(paquetes);
			pBuilder=new ProcessBuilder(comandos);
		
		try {
			Process proceso=pBuilder.start();
			in=new BufferedReader	(new InputStreamReader(proceso.getInputStream()));
			in.readLine();
			linea=null;
			while ((linea=in.readLine())!=null) {
				listadatos1.add(linea);
			}
			//If que comprueba si se hace el ping mal
			if (listadatos1.isEmpty()) {
				System.out.println("Se introdujo mal la URL ");
				System.exit(0);
			}
			
			
			
			
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
