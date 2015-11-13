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
		String[] campos=null;
		if (args.length>0) {
			comandos.add("ping");
			comandos.add("www.google.es");
			comandos.add("-c4");
			pBuilder=new ProcessBuilder(comandos);
		}
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
			campos=listadatos1.get(6).split("\\s");
			tamanoInicial=Integer.parseInt(campos[0]);
			tamanoFinal=Integer.parseInt(campos[3]);
			
			if (tamanoInicial !=tamanoFinal) {
				System.out.println("Se produjo un fallo en la conexión");
				System.exit(0);
			}
			//Bucle que meten datos a lista2
			
			for (int i = 0; i < 4; i++) {
				campos=listadatos1.get(i).split("\\s");
				linea=campos[7].substring(5, campos[7].length());
				listadatos2.add(linea);
				}
			Collections.sort(listadatos2);
			System.out.println(listadatos2);
			System.out.println("Min: "+listadatos2.get(0)+" ms.");
			System.out.println("Max: "+listadatos2.get((listadatos2.size()-1))+" ms.");
			double suma=0;
			for (int i = 0; i < listadatos2.size(); i++) {
				suma+=Double.parseDouble(listadatos2.get(i));
			}
			System.out.println("Media: "+Math.rint((suma/listadatos2.size())*100)/100 +" ms.");
			
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
