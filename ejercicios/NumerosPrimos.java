package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumerosPrimos {
	public static void main(String[] args) {
		//Leer los long y almacenarlos en un arraylist
		long inicio=System.currentTimeMillis();
		File inFile=new File("/media/matinal/2_DAM/Servicios y Procesos/T2 Hilos/numeros_primos.txt");
		int nucleos = Runtime.getRuntime().availableProcessors();
		//System.out.println("Numero de procesadores: "+nucleos);
		//Agrupa los hilos
		ExecutorService executor=Executors.newFixedThreadPool(nucleos);
		Scanner in=null;
		try {
			in=new Scanner(inFile);
			//Vamos a leer los datos
			long numero;
			//Definimos la coleccion que contendra los numeros
			List <Long> lista=new ArrayList<Long>();
			while (in.hasNextLong()) {
				numero=in.nextLong();
				Runnable worker=new NumeroPrimo(numero);
				executor.execute(worker);
				//lista.add(numero);
			}
			executor.shutdown();
			while(!executor.isTerminated()){
			}
			
			long fin=System.currentTimeMillis();
			System.out.println("Tiempo de ejecucion: "+(fin-inicio));
			//System.out.println(lista);
			//Probamos que los hilos funcionan
			//Thread hilo=new Thread(new NumeroPrimo(30023972593L));
			//hilo.start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se encuentra el fichero: "+inFile.getName());
		}
		finally{
			if (in!=null)
			in.close();
		}
	}
}
class NumeroPrimo implements Runnable{
	private long valor;
	
	public NumeroPrimo(long valor) {
		this.valor = valor;
	}
	private boolean esPrimo(){
		long n=this.valor;
	    if (n <= 3) {
	        return n > 1;
	    } else if (n % 2 == 0 || n % 3 == 0) {
	        return false;
	    } else {
	        for (long i = 5; i * i <= n; i += 6) {
	            if (n % i == 0 || n % (i + 2) == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.valor+" ¿Es primo? "+esPrimo());
	}
}