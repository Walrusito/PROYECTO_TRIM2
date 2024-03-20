package gasolinera;

/**
 * Esta clase maneja a los objetos producto que no sean ni gasolina ni comida e implementando la interfaz ProductoInterfaz
 * 
 * @author Sami Shaio
 * @version %I%, %G%
 */

class Producto implements ProductoInterfaz {
    protected String nombre;
    protected double precio;
	protected int stock;

    public Producto(String nombre, double precio,int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock=stock;
    }
    

    public int getStock() {
		return stock;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }


	@Override
    public void mostrarInformacion() {
        System.out.println(getNombre() + " - Nombre: "  + " - Precio: €" + getPrecio()+"- Stock : "+getStock() );
    }


	@Override
	public void setStock(int nuevoStock) {
	    this.stock = nuevoStock;
	}


	
}