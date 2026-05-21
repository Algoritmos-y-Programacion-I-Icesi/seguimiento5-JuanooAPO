package model;

/**
 * Clase que representa una atraccion del parque MagicWorld.
 */
public abstract class Atraccion {

    protected String nombre;
    protected String zonaUbicacion;
    protected int capacidadMaxima;
    protected int edadMinimaAnios;
    protected int visitantesPorDia;
    protected double precioEntrada;

    /**
     * Constructor de la clase Atraccion
     */
    public Atraccion(String nombre, String zonaUbicacion, int capacidadMaxima,
                     int edadMinimaAnios, int visitantesPorDia, double precioEntrada) {
        this.nombre = nombre;
        this.zonaUbicacion = zonaUbicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.edadMinimaAnios = edadMinimaAnios;
        this.visitantesPorDia = visitantesPorDia;
        this.precioEntrada = precioEntrada;
    }
    public abstract double calcularIngresoDiario();

    public abstract boolean esNecesarioMantenimiento();

    public abstract boolean esRecomendadaParaNinos();

    public boolean tieneAlertaCapacidad() {
        return visitantesPorDia > capacidadMaxima;
    }

    public int calcularVisitantesExcedentes(){
        if(!tieneAlertaCapacidad()){
            return 0;
        } else {
            return visitantesPorDia - capacidadMaxima;
        }
    }

    /**
     * Retorna una representacion en texto de la información de la atracción
     */
    @Override
    public String toString() {
        return "--------------------------------------------" +
                "\nNombre        : " + nombre +
                "\nZona          : " + zonaUbicacion +
                "\nCapacidad max : " + capacidadMaxima + " personas" +
                "\nEdad minima   : " + edadMinimaAnios + " años" +
                "\nVisitantes hoy: " + visitantesPorDia +
                "\nPrecio entrada: $" + String.format("%,.2f", precioEntrada) +
                "\nIngreso diario: $" + String.format("%,.2f", calcularIngresoDiario());
    }

    public double calcularIngresoDiario();

    public abstract boolean esNecesarioMantenimiento();




    
        //Completar para cumplir con el requerimiento
    
    public abstract boolean esRecomendadaParaNinos();


    // Getters
    public void getVisitantesPorDia(int visitantes) {
        visitantesPorDia = visitantes;
    }
    public String getNombre() {
        return nombre;
    }

    public String getZonaUbicacion() {
        return zonaUbicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getEdadMinimaAnios() {
        return edadMinimaAnios;
    }

    public int getVisitantesPorDia() {
        return visitantesPorDia;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    // Setters
    public void setVisitantesPorDia(int visitantes) {
        visitantesPorDia = visitantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setZonaUbicacion(String zonaUbicacion) {
        this.zonaUbicacion = zonaUbicacion;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEdadMinimaAnios(int edadMinimaAnios) {
        this.edadMinimaAnios = edadMinimaAnios;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

}


