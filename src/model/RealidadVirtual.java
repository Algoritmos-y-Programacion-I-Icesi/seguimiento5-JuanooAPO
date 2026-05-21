package model;

public class RealidadVirtual extends Atraccion implements ClasificableRiesgo {

    private int numeroEstaciones;
    private boolean requiereAnteojos;

    public RealidadVirtual(String nombre, String zonaUbicacion,
                           int capacidadMaxima, int edadMinimaAnios,
                           int visitantesPorDia, double precioEntrada,
                           int numeroEstaciones, boolean requiereAnteojos) {

        super(nombre, zonaUbicacion, capacidadMaxima,
              edadMinimaAnios, visitantesPorDia, precioEntrada);

        this.numeroEstaciones = numeroEstaciones;
        this.requiereAnteojos = requiereAnteojos;
    }

    /**
     * Calcula ingreso diario.
     */
    @Override
    public double calcularIngresoDiario() {

        double ingresoBase = visitantesPorDia * precioEntrada;

        if (!requiereAnteojos) {
            ingresoBase -= ingresoBase * 0.10;
        }

        return ingresoBase;
    }

    /**
     * Verifica mantenimiento.
     */
    @Override
    public boolean esNecesarioMantenimiento() {
        return numeroEstaciones > 20 || visitantesPorDia > capacidadMaxima;
    }

    /**
     * Si es recomendada para niños.
     */
    @Override
    public boolean esRecomendadaParaNinos() {
        return edadMinimaAnios <= 12;
    }

    /**
     * Clasifica nivel de riesgo.
     */
    @Override
    public String clasificarRiesgo() {

        if (requiereAnteojos && numeroEstaciones > 20) {
            return "ALTO";
        } else if (requiereAnteojos || numeroEstaciones > 20) {
            return "MEDIO";
        } else {
            return "BAJO";
        }
    }

    /**
     * Representación textual.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nTipo               : Realidad Virtual" +
                "\nNumero estaciones  : " + numeroEstaciones +
                "\nRequiere anteojos  : " + (requiereAnteojos ? "SI" : "NO") +
                "\nNivel de riesgo    : " + clasificarRiesgo();
    }

    // Getters
    public int getNumeroEstaciones() {
        return numeroEstaciones;
    }

    public boolean isRequiereAnteojos() {
        return requiereAnteojos;
    }

    // Setters
    public void setNumeroEstaciones(int numeroEstaciones) {
        this.numeroEstaciones = numeroEstaciones;
    }

    public void setRequiereAnteojos(boolean requiereAnteojos) {
        this.requiereAnteojos = requiereAnteojos;
    }
}