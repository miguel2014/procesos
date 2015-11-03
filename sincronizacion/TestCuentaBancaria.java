package sincronizacion;

public class TestCuentaBancaria {
	public static void main(String[] args) {
		CuentaBancaria cuenta=new CuentaBancaria(1_000);
		Thread hiloparaIngresar;
		Thread hiloRetirar;
		for (int  i= 0; i < 5; i++) {
			hiloparaIngresar=new IngresarDinero(cuenta, 10);
			hiloRetirar=new RetirarDinero(cuenta, 100);
			hiloparaIngresar.start();
			hiloRetirar.start();
			
		}
	}

	
}
class CuentaBancaria{
	private  double saldo;
	//private volatile double saldo;
	public CuentaBancaria(double saldo) {
			this.saldo = saldo;
	}
	public synchronized void ingresarDinero(double cantidad){
		this.saldo+=cantidad;
		System.out.println("INGRESANDO "+cantidad+" : "+this.saldo);
	}
	public synchronized void retirarDinero(double cantidad){
		this.saldo-=cantidad;
		System.out.println("RETIRANDO "+cantidad+" : "+this.saldo);
	}
}
class RetirarDinero extends Thread{
	private CuentaBancaria cuenta;
	private double cantidad;
	public RetirarDinero(CuentaBancaria cuenta, double cantidad) {
		this.cuenta = cuenta;
		this.cantidad = cantidad;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*try {
			Thread.sleep((long) (Math.random()*1_000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.cuenta.retirarDinero(this.cantidad);
	}	
}
class IngresarDinero extends Thread{
	private CuentaBancaria cuenta;
	private double cantidad;
	public IngresarDinero(CuentaBancaria cuenta, double cantidad) {
		this.cuenta = cuenta;
		this.cantidad = cantidad;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		this.cuenta.ingresarDinero(this.cantidad);
	}	
}
