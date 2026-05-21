package model;

import java.util.ArrayList;

/**
 * Clase controladora del sistema MagicWorld.
 * Administra la lista de atracciones y centraliza las operaciones
 * que la interfaz de usuario necesita realizar.
 */
public class ParqueController {

    private String nombre;
    private ArrayList<Atraccion> atracciones;

    /**
     * Constructor del Parque. Inicializa el ArrayList de atracciones.
     */
    public ParqueController(String nombre) {
        this.nombre = nombre;
        this.atracciones = new ArrayList<>();
    }

    /**
     * Retorna la lista completa de atracciones registradas.
     */
    public ArrayList<Atraccion> getAtracciones() {
        return atracciones;
    }

    /*
     * Los visitantes se inicializan en 0 y luego pueden registrarse
     * mediante el metodo registrarVisitantes.
     */
    public void agregarAtraccion(String nombre, String zonaUbicacion, int capacidadMaxima,
                                 int edadMinimaAnios, double precioEntrada) {

        Atraccion atraccion = new Atraccion(
                nombre,
                zonaUbicacion,
                capacidadMaxima,
                edadMinimaAnios,
                0,
                precioEntrada);

         atracciones.add(atraccion);
    }

     /**
     * Busca una atraccion por nombre y registra sus visitantes del dia.
     * @param nombreAtraccion nombre de la atraccion
     * @param visitantesPorDia cantidad de visitantes del dia
     */
    public void registrarVisitantes(String nombreAtraccion, int visitantesPorDia) {
        Atraccion atraccionEncontrada = buscarAtraccionPorNombre(nombreAtraccion);

        if (atraccionEncontrada == null) {
            System.out.println("No se encontro una atraccion con el nombre: " + nombreAtraccion);
        } else {
            atraccionEncontrada.setVisitantesPorDia(visitantesPorDia);
        }
    }

    /**
     * Busca una atraccion por su nombre.
     * 
     * @param nombreAtraccion nombre de la atraccion buscada
     * @return la atraccion encontrada o null si no existe
     */
    public Atraccion buscarAtraccionPorNombre(String nombreAtraccion) {
        for (Atraccion atraccion : atracciones) {
            if (atraccion.getNombre().equalsIgnoreCase(nombreAtraccion)) {
                return atraccion;
            }
        }

        return null;
    }

    // ---------------------------------------------------------------
    // CALCULOS Y REPORTES
    // ---------------------------------------------------------------

    /**
     *
     */
    public double calcularIngresoTotalDiario() {
        //Completar para cumplir con el requerimiento
        return 0;
    }

    /**
     *
     */
    public void mostrarIngresosDiarios() {
        //Completar para cumplir con el requerimiento
    }

    /**
     */
    public void generarReporteOperaciones() {
        //Completar para cumplir con el requerimiento
    }

    public void mostrarAtraccionesClasifRiesgo(){
        //Completar para cumplir con el requerimiento
    }
    public void generarReporteAlertasCapacidad(){
        //Completar para cumplir con el requerimiento
    }

    for(i=0; i<atracciones.size(); i++){
        if(atracciones.get(i).esNecesarioMantenimiento()){
            System.out.println(atracciones.get(i).getNombre());
        }
    }
}
