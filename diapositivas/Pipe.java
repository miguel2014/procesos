package diapositivas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Pipe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> comandos1=new ArrayList<String>();
		comandos1.add("ls");
		comandos1.add("-l");
		List<String> comandos2=new ArrayList<String>();
		comandos2.add("grep");
		comandos2.add("android");
		ProcessBuilder pbuilder1=new ProcessBuilder(comandos1);
		ProcessBuilder pbuilder2=new ProcessBuilder(comandos2);
		File directorio=new File("/home/matinal/");
		pbuilder1.directory(directorio);
		BufferedReader in1,in2=null;
		PrintWriter out=null;
		try {
			Process proceso1=pbuilder1.start();
			Process proceso2=pbuilder2.start();
			out=new PrintWriter(proceso2.getOutputStream());
			in1=new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
			String linea1=null;
			while ((linea1=in1.readLine())!=null) {
				//System.out.println(linea1);
				out.write(linea1);
			}
			in2=new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
			out.close();
			String linea2=null;
			while ((linea2=in2.readLine())!=null) {
				System.out.println(linea2);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
