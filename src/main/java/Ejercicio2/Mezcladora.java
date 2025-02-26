package Ejercicio2;

public class Mezcladora {
    public static void main(String[] args) {
        Deposito cian = new Deposito("Cian");
        Deposito magenta = new Deposito("Magenta");
        Deposito amarillo = new Deposito("Amarillo");

        Persona rojo = new Persona("Juan", amarillo, magenta, "Rojo");
        Persona azul = new Persona("Fran",magenta, cian, "Azul");
        Persona verde = new Persona("Agustin" , amarillo, cian, "Verde");


        rojo.start();
        azul.start();
        verde.start();
    }
}
