package org.uf2;

class Colecta {
    private int cantidadTotal = 0;
    private final int maximo = 2000;

    public synchronized boolean agregarCantidad(int cantidad, String nombreHilo) {
        if (cantidadTotal >= maximo ) {
            return false;
        }

        if (cantidadTotal + cantidad > maximo + 3) {
            cantidad = (maximo + 3) - cantidadTotal;
        }


        if (cantidad < 4) {
            System.out.println(nombreHilo + " intentó recolectar, pero el máximo permitido ya fue alcanzado.");
            return false;
        }

        cantidadTotal += cantidad;
        System.out.println(nombreHilo + " recolectó " + cantidad + ", el total acumulado es : " + cantidadTotal);


        if (cantidadTotal >= maximo - 3 && cantidadTotal <= maximo + 3) {
            System.out.println("✅ Se alcanzó el límite permitido. Cantidad final: " + cantidadTotal);
            return false;
        }

        return true;
    }

    public synchronized int getCantidadTotal() {
        return cantidadTotal;
    }
}

/*
	Creo la variable cantidadtotal para  almacenar la cantidad recolectada.

	se pidio utilizar  synchronized para evitar problemas de concurrencia cuando  varios hilos intenten acceder al mismo recurso compartido

	agregarCantidad(int, String): Suma la cantidad recolectada y verifica si se alcanzó la meta.


	Variantes a synchronized :



	AtomicInteger =>Para modificar números de forma segura y eficiente.

	Semaphore=>Controla el acceso a un número limitado de recursos.

	ReadWriteLock => permite que múltiples hilos lean simultáneamente, pero solo un hilo puede escribir a la vez.

*/

