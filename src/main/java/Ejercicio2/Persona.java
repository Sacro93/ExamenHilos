package Ejercicio2;


//Esta clase  representa a una persona que mezcla colores de pintura, al extender de thread cada persona de ejecutara en un hilo distinto
class Persona extends Thread {
    private final Deposito deposito1;
    private final Deposito deposito2;
    private final String colorSecundario;

    public Persona(String nombre, Deposito d1, Deposito d2, String colorSecundario) {
        super(nombre);
        this.deposito1 = d1;
        this.deposito2 = d2;
        this.colorSecundario = colorSecundario;
    }

    @Override
    public void run() {

        while (true) {
            try {

                synchronized (deposito1) {
                    System.out.println(getName() + " accedio al color : " + deposito1.getColor());

                    synchronized (deposito2) {

                        System.out.println(getName() + " accedio al color : " + deposito2.getColor());


                        System.out.println(getName() + " mezcla " + deposito1.getColor() + " y " +
                                deposito2.getColor() + " para obtener el color " + colorSecundario);

                        Thread.sleep((int) (Math.random() * (500 - 100 + 1)) + 100);
                    }
                }

                System.out.println(getName() + " finalizo la mezcla, obtuvo el color " + colorSecundario);
                Thread.sleep((int) (Math.random() * (2000 - 1000 + 1)) + 1000);  //aca es para esperar

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//uso un bucle infinito
//usarmos synchronized para que otro hilo no acceda al mismo tiempo, evitando dead locks