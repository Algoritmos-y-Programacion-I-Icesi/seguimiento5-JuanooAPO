package model;

public class EspectaculoPirotecnico extends Atraccion implements ClasificableRiesgo {

    private int duracionMinutos;
    private boolean usaMaterialPeligroso;

    public EspectaculoPirotecnico(String nombre, String zonaUbicacion,
                                  int capacidadMaxima, int edadMinimaAnios,
                                  int visitantesPorDia, double precioEntrada,
                                  int duracionMinutos, boolean usaMaterialPeligroso) {

        super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios,
              visitantesPorDia, precioEntrada);

        this.duracionMinutos = duracionMinutos;
        this.usaMaterialPeligroso = usaMaterialPeligroso;
    }

    @Override
    public double calcularIngresoDiario() {
        double ingresoBase = visitantesPorDia * precioEntrada;

        if (usaMaterialPeligroso) {
            return ingresoBase + (ingresoBase * 0.20);
        }

        return ingresoBase;
    }

    @Override
    public boolean esNecesarioMantenimiento() {
        return usaMaterialPeligroso || duracionMinutos > 60;
    }

    @Override
    public String clasificarRiesgo() {
        if (usaMaterialPeligroso) {
            return "ALTO";
        } else if (duracionMinutos > 60) {
            return "MEDIO";
        } else {
            return "BAJO";
        }
    }

    @Override
    public boolean esRecomendadaParaNinos() {
        return !usaMaterialPeligroso && edadMinimaAnios <= 12;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo           : Espectaculo Pirotecnico" +
                "\nDuracion       : " + duracionMinutos + " minutos" +
                "\nMaterial peligroso certificado: " + (usaMaterialPeligroso ? "SI" : "NO") +
                "\nNivel de riesgo: " + clasificarRiesgo();
    }
}