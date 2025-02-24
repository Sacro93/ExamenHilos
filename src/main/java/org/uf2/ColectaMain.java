package org.uf2;

public class ColectaMain {
    public static void main(String[] args) {
        Colecta colecta = new Colecta();
        Recolector recolector1 = new Recolector(colecta, "Recolector 1");
        Recolector recolector2 = new Recolector(colecta, "Recolector 2");
        Recolector recolector3 = new Recolector(colecta, "Recolector 3");
        Recolector recolector4 = new Recolector(colecta, "Recolector 4");

        recolector1.start();
        recolector2.start();
        recolector3.start();
        recolector4.start();

        try {
            recolector1.join();
            recolector2.join();
            recolector3.join();
            recolector4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Termino la colecta . Total recolectado : " + colecta.getCantidadTotal() + " litros.");
    }
}

/*
Clase Colecta:
	Variable cantidadtotal: almacena la cantidad recolectada.
	Se utiliza synchronized en los métodos para evitar accesos concurrentes inseguros.
	agregarCantidad(int, String): Suma la cantidad recolectada y verifica si se alcanzó la meta.
*/