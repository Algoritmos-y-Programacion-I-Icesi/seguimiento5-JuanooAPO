package model;

public class JuegosInfantiles extends Atraccion {
     private int edadMaximaPermitida;
    private boolean supervisionPermanente;

    public JuegosInfantiles(String nombre, String zonaUbicacion,
                            int capacidadMaxima, int edadMinimaAnios,
                            int visitantesPorDia, double precioEntrada,
                            int edadMaximaPermitida, boolean supervisionPermanente) {

        super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios,
              visitantesPorDia, precioEntrada);

        this.edadMaximaPermitida = edadMaximaPermitida;
        this.supervisionPermanente = supervisionPermanente;
    }

    /**
     * Calcula ingreso diario.
     */
    @Override
    public double calcularIngresoDiario() {

        double ingresoBase = visitantesPorDia * precioEntrada;

        if (supervisionPermanente) {
            ingresoBase += visitantesPorDia * 50000;
        }

        return ingresoBase;
    }

    /**
     * Verifica mantenimiento.
     */
    @Override
    public boolean esNecesarioMantenimiento() {
        return !supervisionPermanente || visitantesPorDia > capacidadMaxima;
    }

    /**
     * Si es recomendada para niños.
     */
    @Override
    public boolean esRecomendadaParaNinos() {
        return edadMinimaAnios <= 12;
    }

    /**
     * Representación textual.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nTipo                  : Juego Infantil" +
                "\nEdad maxima permitida : " + edadMaximaPermitida +
                "\nSupervision permanente: " + (supervisionPermanente ? "SI" : "NO");
    }

    // Getters
    public int getEdadMaximaPermitida() {
        return edadMaximaPermitida;
    }

    public boolean isSupervisionPermanente() {
        return supervisionPermanente;
    }

    // Setters
    public void setEdadMaximaPermitida(int edadMaximaPermitida) {
        this.edadMaximaPermitida = edadMaximaPermitida;
    }

    public void setSupervisionPermanente(boolean supervisionPermanente) {
        this.supervisionPermanente = supervisionPermanente;
    }

}


    