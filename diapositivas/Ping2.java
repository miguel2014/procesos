package diapositivas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ping2 {
	public static void main(String[] args) {
		//Pasamos como argumentos el host al que vamos a hacer ping
		BufferedReader in=null;
		List <String> listadatos1=new ArrayList<String>();
		List <String> listadatos2=new ArrayList<String>();
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
			String linea=null;
			while ((linea=in.readLine())!=null) {
				listadatos1.add(linea);
				if (listadatos2.size()<4) {
					listadatos2.add(linea);	
				}	
			}
			
			campos=listadatos1.get(6).split("\\s");
			//System.out.println(listadatos1.get(6));
			int tamañoinicial=Integer.parseInt(campos[0]);
			int tamañofinal=Integer.parseInt(campos[3]);
			String tiempo=campos[9];
			if (tamañoinicial !=tamañofinal) {
				System.out.println("Se produjo un fallo en la conexión");
				System.exit(0);
			}
			else{
			for (int i = 0; i < listadatos2.size(); i++) {
				campos=listadatos2.get(i).split("\\s");
				System.out.println(campos[7].substring(5,campos[7].length()));
			}
			System.out.println(listadatos2);
			}
			System.out.println(tiempo);
			
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
