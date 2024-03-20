package gasolinera;

/**
 * Esta clase simula el comportamiento de la gasolinera y como se podría 
 * usar el programa.
 * 
 * @author Ricardo Delgado
 * @version v.1.0
 */

public class App {

	public static void main(String[] args) {

		Producto producto1 = new Producto("Aceite de motor", 15.99, 50);
		Comida comida1 = new Comida("Galletas", 2.5, "SNACK", 100);
        Comida comida2 = new Comida("Refresco", 1.8, "BEBIDA", 80);
        Comida comida3 = new Comida("Chocolate", 3.0, "DULCE", 120);
        Comida comida4 = new Comida("Manzana", 0.5, "FRUTA", 150);
        Comida comida5 = new Comida("Sandwich", 4.5, "OTRO", 90);
        Cliente usuario1=new Cliente("Ricardo","3123123",100);
       
        
        
        
        
        
		Gasolinera gasolinera1=new Gasolinera();

		
		 gasolinera1.agregarProducto(producto1);
	     gasolinera1.agregarProducto(comida1);
	     gasolinera1.agregarProducto(comida2);
	     gasolinera1.agregarProducto(comida3);
	     gasolinera1.agregarProducto(comida4);
	     gasolinera1.agregarProducto(comida5);
	        
		gasolinera1.ejecutar(usuario1);
		
		
		
		
	}
}


