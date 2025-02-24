package Ejercicio2;

class Persona extends Thread {
    private final Deposito deposito1;
    private final Deposito deposito2;
    private final String colorSecundario;

    public Persona(Deposito d1, Deposito d2, String colorSecundario) {
        this.deposito1 = d1;
        this.deposito2 = d2;
        this.colorSecundario = colorSecundario;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (deposito1) {
                    System.out.println(getName() + " obtuvo acceso a " + deposito1.getColor());
                    synchronized (deposito2) {
                        System.out.println(getName() + " obtuvo acceso a " + deposito2.getColor());
                        System.out.println(getName() + " está mezclando " + deposito1.getColor() + " y " + deposito2.getColor() + " para crear " + colorSecundario);

                        /*Cada Persona (hilo) siempre adquiere los depósitos en el mismo orden en cada ejecución.
                        Cuando un hilo accede a los depósitos, bloquea primero deposito1 y luego deposito2.
                        Como todos los hilos siguen la misma regla al tomar los bloqueos, nunca ocurre que un hilo tome deposito1
                        mientras otro hilo tomó deposito2 y ambos estén esperando al otro.*/


                        Thread.sleep((int) (Math.random() * (500 - 100 + 1)) + 100);
                    }
                }

                System.out.println(getName() + " ha terminado de mezclar " + colorSecundario);
                Thread.sleep((int) (Math.random() * (2000 - 1000 + 1)) + 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}