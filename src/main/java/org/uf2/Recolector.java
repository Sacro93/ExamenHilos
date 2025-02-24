package org.uf2;

class Recolector extends Thread {
    private final Colecta colecta;

    public Recolector(Colecta colecta, String nombre) {
        super(nombre);
        this.colecta = colecta;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int cantidadRecolectada = (int) (Math.random() * (25 - 4 + 1)) + 4;
                int tiempoEspera = (int) (Math.random() * (200 - 10 + 1)) + 10;

                Thread.sleep(tiempoEspera);

                if (!colecta.agregarCantidad(cantidadRecolectada, getName())) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " ha terminado su trabajo.");
    }
}

/*Clase Recolector:
Al Recolector extender a Thread, permite que cada instancia sea un hilo independiente.
método run():
	Genera una cantidad aleatoria de litros entre 4 y 25.
int cantidadRecolectada = (int) (Math.random() * (25 - 4 + 1)) + 4;
	Espera un tiempo aleatorio entre 10 y 200 ms (Thread.sleep() simula el tiempo de trabajo).
int tiempoEspera = (int) (Math.random() * (200 - 10 + 1)) + 10;

Thread.sleep(tiempoEspera);
	Agrega la cantidad recolectada a la colecta.
if (!colecta.agregarCantidad(cantidadRecolectada, getName())) {
    break;
}
	Si la meta de 2000 litros se alcanza, el hilo finaliza.

*/