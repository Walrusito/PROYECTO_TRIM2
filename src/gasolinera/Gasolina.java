package gasolinera;

/**
 * Esta clase maneja a los objetos gasolina extendiendo la clase producto y implementando la interfaz ProductoInterfaz
 * 
 * @author Ricardo Delgado
 * @version v.1.0
 */

public class Gasolina extends Producto implements ProductoInterfaz {
    private String tipo;
    private final static double PRECIO_GASOLINA95 = 1.5;
    private final static double PRECIO_GASOLINA98 = 1.8;
    private final static double PRECIO_DIESEL = 1.2;

    public Gasolina(String nombre, String tipo, int stock) {
        super(nombre, obtenerPrecio(tipo), stock);
        this.tipo = tipo;
    }

    public static double obtenerPrecio(String tipo) {
        switch (tipo) {
            case "Gasolina 95":
                return PRECIO_GASOLINA95;
            case "Gasolina 98":
                return PRECIO_GASOLINA98;
            case "Diesel":
                return PRECIO_DIESEL;
            default:
                throw new IllegalArgumentException("Tipo de gasolina no válido.");
        }
    }
    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(getNombre() + " - Tipo: " + tipo + " - Precio: €" + getPrecio() + " - Stock: " + getStock() + " Litros");
    }



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
	    return this.tipo;
	}

	@Override
	public void setStock(int nuevoStock) {
	    this.stock = nuevoStock;
	}
}