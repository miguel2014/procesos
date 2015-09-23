package diapositivas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListadoDirectorio {
	public static void main(String[] args) {
		List<String> comandos=new ArrayList<String>();
		comandos.add("ls");
		comandos.add("-lF");
		//Creo un objeto ProcessBuilder
		ProcessBuilder pBuilder=new ProcessBuilder(comandos);
		try {
			File directorio=new File("/home/matinal");
			pBuilder.directory(directorio);
			Process proceso=pBuilder.start();
			BufferedReader in=new BufferedReader
					(new InputStreamReader(proceso.getInputStream()));
			in.readLine();
			String linea=null;
			while ((linea=in.readLine())!=null) {
				System.out.println(linea);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
