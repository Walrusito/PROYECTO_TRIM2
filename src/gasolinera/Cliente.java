package gasolinera;



/**
 * Esta clase se maneja el comportamiento de gestion de usuarios para una gasolinera
 * 
 * @author Ricardo Delgado
 * @version v.1.0
 */

import java.util.Scanner;

public class Cliente extends Gasolinera {
    private String nombre;
    private String telefono;
    private double saldo;


    public Cliente() {
    	
    }
    
    public Cliente(String nombre, String telefono, double saldoInicial) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.saldo = saldoInicial;
    }

    public void recargarSaldo(double cantidad) {
        saldo += cantidad;
        System.out.println("Saldo recargado correctamente. Nuevo saldo: " + saldo + "€");
    }  
    public double recargarSaldo() {
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("Por favor recargue su saldo para completar la compra :");
    	System.out.println("Introduzca una cantidad en € :");
    	double cantidad=scanner.nextInt();
        saldo += cantidad;
        System.out.println("Saldo recargado correctamente. Nuevo saldo: " + saldo + "€");
		return saldo;
    }


    public double getSaldo() {
        return saldo;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
