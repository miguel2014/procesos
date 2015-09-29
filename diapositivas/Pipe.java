package diapositivas;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Pipe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> comandos1=new ArrayList<String>();
		comandos1.add("ls");
		comandos1.add("-l");
		ProcessBuilder pbuilder1=new ProcessBuilder(comandos1);
		File directorio=new File("/home/matinal/");
		pbuilder1.directory(directorio);
		BufferedReader in1=null;
		try {
			Process proceso1=pbuilder1.start();
			in1=new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
			String linea=null;
			while ((linea=in1.readLine())!=null) {
				System.out.println(linea);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
