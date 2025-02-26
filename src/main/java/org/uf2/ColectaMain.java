package org.uf2;

public class ColectaMain {
    public static void main(String[] args) {

        //creacion de la clase collecta con 4 recolectores
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

        System.out.println("Termino la colecta . Total recolectado : " + colecta.getCantidadTotal() );
    }
}

/*

* ColectaMain
	Creo una  instancia de colecta, luego creo 4 hilos de recolector que reciben la instancia de colecta, inicio el hilo con star()
	 y el uso de join para que el hilo principal espere a que todos los recolectores terminen
	Se crean 4 hilos Recolector, que reciben la instancia de Colecta.

Si tengo  varios hilos que están ejecutándose en paralelo y no se utiliza join(),
el programa principal podría terminar antes de que los hilos secundarios terminen su trabajo.
        */
