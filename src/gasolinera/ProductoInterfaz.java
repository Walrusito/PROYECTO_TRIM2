package gasolinera;

/**
 * Esta interfaz maneja diferentes metodos a usar por las diferentes clases donde se implemente y
 * 
 * @author Ricardo Delgado
 * @version v.1.0
 */

interface ProductoInterfaz {
    void mostrarInformacion();

	double getPrecio();

	String getNombre();

	int getStock();

	void setStock(int nuevoStock);






}