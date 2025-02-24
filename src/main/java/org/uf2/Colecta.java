package org.uf2;

class Colecta {
    private int cantidadTotal = 0;
    private final int maximo = 2000;

    public synchronized boolean agregarCantidad(int cantidad, String nombreHilo) {
        if (cantidadTotal >= maximo) {
            return false;
        }

        cantidadTotal += cantidad;
        System.out.println(nombreHilo + " recolectó" + cantidad + " Total: " + cantidadTotal);

        if (cantidadTotal >= maximo) {
            System.out.println("Maximo a recolectar alcanzado!  Se recolectaron " + cantidadTotal );
            return false;
        }
        return true;
    }

    public synchronized int getCantidadTotal() {
        return cantidadTotal;
    }
}

/*
* ColectaMain
	Creación de una instancia de Colecta
	Se crean 4 hilos Recolector, que reciben la instancia de Colecta.
	Inicio de hilos con star()
	Uso de join() para que el hilo principal espere a que todos los recolectores terminen.
*/

