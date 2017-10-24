/*
  Clase: DemoElevador"
Función: Eleva en un 10% el salario y le agrega un bono cuando es pasado
         a un método estático.
Autor: H Tejeda
Fecha: 10 nov 2011
*/
public class AverSiSale{

	public static void main( String[] args ) {
		double miSalario = 5000.00;
		System.out.println("Mostrando algunos incrementos y bono");
		double nuevoSalario = prediceIncremento( miSalario );
		System.out.println(miSalario + " con incremento y bono es " + 
			nuevoSalario);
		System.out.println("$4000 con incremento y bono es " + 
			prediceIncremento( 4000.00 ) );
		System.out.println("$4000 con incremento, bono y $500 de descuento es " + 
			(prediceIncremento( 4000.00 )-500.0) );
	}

	public static double prediceIncremento( double cantidadDinero ) {
		double nuevaCantidad;
		double cantidadBono;
		final double INCREMENTO = 1.10;
		nuevaCantidad = cantidadDinero * INCREMENTO;
		cantidadBono = calculaBono( nuevaCantidad );
		nuevaCantidad = nuevaCantidad + cantidadBono;
		return nuevaCantidad;
	}

	public static double calculaBono( double salario ) {
		final double BONO = 50.00;
		salario = salario + BONO;
		return salario;
	}
}