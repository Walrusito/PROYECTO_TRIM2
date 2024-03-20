package gasolinera;

/**
 * Esta clase se maneja el comportamiento de gestion tipico de una gasolinera
 * 
 * @author Ricardo Delgado
 * @version v.1.0
 */
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Gasolinera {
	private double cantidadRepostar;
	private ProductoInterfaz[] productos;
	private static final int MAXIMO_PRODUCTOS=100;
	private int totalProductos;

	public Gasolinera() {
		productos = new ProductoInterfaz[MAXIMO_PRODUCTOS];
        totalProductos = 0;

        agregarProducto(new Gasolina("Gasolina 95", "Gasolina 95", 100));
        agregarProducto(new Gasolina("Gasolina 98", "Gasolina 98", 100));
        agregarProducto(new Gasolina("Diesel", "Diesel", 100));
	}


	public void agregarProducto(ProductoInterfaz producto) {
        if (totalProductos < MAXIMO_PRODUCTOS) {
            productos[totalProductos] = producto;
            totalProductos++;
        } else {
            System.out.println("La gasolinera está llena. No se pueden agregar más productos.");
        }
    


}

	public void repostar(String tipoCombustible,Cliente cliente) {
		boolean quedaStock = true;

		for (int i = 0; i < totalProductos; i++) {
		    if (tipoCombustible.equalsIgnoreCase(productos[i].getNombre()) && productos[i].getStock() == 0) {
		        quedaStock = false;
		        System.out.println("No queda stock de " + productos[i].getNombre());
		        break; 
		    }
		}

		if (quedaStock) {
		    Scanner scanner = new Scanner(System.in);

		    System.out.println("Presione '1' para comenzar el repostaje...");
		    String input = scanner.nextLine();
		    if (!input.equals("1")) {
		        System.out.println("Repostaje cancelado.");
		        return;
		    }

		    while (quedaStock) {

		        Timer timer = new Timer();
		        timer.scheduleAtFixedRate(new TimerTask() {
		            @Override
		            public void run() {
		                cantidadRepostar += 1; 
		                System.out.println(cantidadRepostar + " Litros");
		            }
		        }, 0, 100);

		        System.out.println("Presione cualquier tecla para detener el repostaje...");
		        scanner.nextLine(); 

		        timer.cancel();
		        quedaStock = false;
		    }



		    double importe;
		    for (ProductoInterfaz gasolina : productos) {
		        if (tipoCombustible.equalsIgnoreCase(gasolina.getNombre())) {
		        	System.out.println(gasolina.getStock());

		            if (cantidadRepostar >= gasolina.getStock()) {
		                System.out.println("Se ha repostado el máximo stock disponible :" + gasolina.getStock() + " L");
		                importe = gasolina.getStock() * gasolina.getPrecio();
		                System.out.println("Su importe es de :" + importe + "€");
		                importe = 0;
		                gasolina.setStock(0);
		                
		                comprarProducto(tipoCombustible,(int)cantidadRepostar,cliente,gasolina.getStock(),importe);
		                cantidadRepostar = 0;
		            } else {
		                int nuevoStock = (int) (gasolina.getStock() - cantidadRepostar);
		                importe = cantidadRepostar * gasolina.getPrecio();
		                System.out.println("Repostaje de " + cantidadRepostar + " litros de " + tipoCombustible + " realizado correctamente.");
		                System.out.println("Su importe es de :" + importe + "€");
		                gasolina.setStock(nuevoStock);
		                comprarProducto(tipoCombustible,(int)cantidadRepostar,cliente,gasolina.getStock(),importe);
		                importe = 0;
		                cantidadRepostar = 0;
		            }
		            break;
		        }
		    }
		}
		}
	public void ejecutar(Cliente cliente) {
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;
		while (!salir) {
			System.out.println("\nBienvenido a la Gasolinera  "+cliente.getNombre());
			System.out.println("***¿Qué desea?***");
			System.out.println("1. Comprar productos ");
			System.out.println("2. Salir");
			System.out.println("3 Repostar");
			System.out.print("Seleccione una opción: ");
			int opcion = scanner.nextInt();
			String tipoCombustible;
			switch (opcion) {
			case 1:
				mostrarProductos();
				System.out.println("Indique el nombre del producto que desea comprar :");
				scanner.nextLine();
				String nombreProducto=scanner.nextLine();;
				System.out.println("Indique la cantidad que desea comprar");
				int cantidadProducto=scanner.nextInt();
				comprarProducto(nombreProducto,cantidadProducto,cliente);
				break;
			case 2:
				salir = true;
				System.out.println("Gracias por utilizar la gasolinera. ¡Hasta luego!");
				break;
			case 3:
				System.out.println("Seleccione el tipo de gasolina:");
				System.out.println("1. Gasolina 95");
				System.out.println("2. Gasolina 98");
				System.out.println("3. Diesel");
				int tipo = scanner.nextInt();
				switch (tipo) {
				case 1:
					System.out.println("Precio :"+productos[0].getPrecio()+ "€");
					tipoCombustible = "Gasolina 95";
					break;
				case 2:
					System.out.println("Precio :"+productos[1].getPrecio()+ "€");
					tipoCombustible = "Gasolina 98";
					break;
				case 3:
					System.out.println("Precio :"+productos[2].getPrecio()+ "€");
					tipoCombustible = "Diesel";
					break;
				default:
					System.out.println("Tipo de gasolina no válido.");
					continue;
				}
				try {
					repostar(tipoCombustible,cliente);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Opción inválida. Inténtelo de nuevo.");
			}
		}
		scanner.close();
		
	}

	public void mostrarProductos() {
	    System.out.println("Productos disponibles con stock:");
	    for (int i = 0; i < totalProductos; i++) {
	        if (productos[i].getStock() > 0) {
	            System.out.println("Producto :" + i);
	            productos[i].mostrarInformacion();
	        }
	    }
	}
	public double comprarProducto(String nombreProducto, int cantidad, Cliente cliente) {
	    double precioTotal = 0;
	    for (int i = 0; i < totalProductos; i++) {
	        String nombreProductoEnInventario = productos[i].getNombre().trim().toLowerCase();
	        String nombreProductoParametro = nombreProducto.trim().toLowerCase(); 

	        if (nombreProductoEnInventario.equalsIgnoreCase(nombreProductoParametro)) {
	            int nuevoStock = productos[i].getStock() - cantidad;
	            if (nuevoStock >= 0) {
	                precioTotal = productos[i].getPrecio() * cantidad;
	                if (cliente.getSaldo() >= precioTotal) {
	                    productos[i].setStock(nuevoStock);
	                    cliente.recargarSaldo(-precioTotal); 
	                    System.out.println("Compra realizada: " + cantidad + " unidades de " + nombreProducto + ", pendiente de pago");
	                    return precioTotal;
	                } else {
	                    System.out.println("Saldo insuficiente para comprar " + cantidad + " unidades de " + nombreProducto);
	                    return 0; 
	                }
	            } else {
	                System.out.println("No hay suficiente stock de " + nombreProducto);
	                return 0;
	            }
	        }
	    }

	    System.out.println("Producto no encontrado: " + nombreProducto);
	    return 0;
	}
	public double comprarProducto(String nombreProducto, int cantidad, Cliente cliente,int stock,double importe) {
	    for (int i = 0; i < totalProductos; i++) {
	        String nombreProductoEnInventario = productos[i].getNombre().trim().toLowerCase();
	        String nombreProductoParametro = nombreProducto.trim().toLowerCase();
	        if (nombreProductoEnInventario.equalsIgnoreCase(nombreProductoParametro)) {
	            int nuevoStock = stock;
	            if (nuevoStock >= 0) {
	                
	                if (cliente.getSaldo() >= importe) {
	                    productos[i].setStock(nuevoStock);
	                    cliente.recargarSaldo(-importe); 
	                    System.out.println("Compra realizada: " + cantidad + " litros de " + nombreProducto );
	                    return importe; 
	                } else {
	                    System.out.println("Saldo insuficiente para comprar " + cantidad + " litros de " + nombreProducto);
	                    return cliente.recargarSaldo(); 
	                }
	            } else {
	                System.out.println("No hay suficiente stock de " + nombreProducto);
	                return 0; 
	            }
	        }
	    }

	    System.out.println("Producto no encontrado: " + nombreProducto);
	    return 0;
	}
}