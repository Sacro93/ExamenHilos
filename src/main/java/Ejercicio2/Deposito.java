package Ejercicio2;

class Deposito {
    private final String color;

    public Deposito(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

// deposito de pintura para los colores primarios
//color es final,por lo que cada depósito tendrá siempre el mismo color