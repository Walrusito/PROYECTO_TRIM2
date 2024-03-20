package gasolinera;

/**
 * Esta clase maneja a los objetos comida extendiendo la clase producto y implementando la interfaz ProductoInterfaz
 * 
 * @author Ricardo Delgado
 * @version v.1.0
 * 
 */

class Comida extends Producto implements ProductoInterfaz {
    private String tipo; 

    public Comida(String nombre, double precio, String tipo,int stock) {
        super(nombre, precio, stock);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

	@Override
    public void mostrarInformacion() {
        System.out.println(getNombre() + " - Tipo: " + tipo + " - Precio: €" + getPrecio()+"- Stock : "+getStock() );
    }
	@Override
	public void setStock(int nuevoStock) {
	    this.stock = nuevoStock;
	}

}