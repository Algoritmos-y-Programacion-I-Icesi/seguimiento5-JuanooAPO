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
 public void registrarVisitantes(String nombreAtraccion, int visitantesPorDia) {
        Atraccion atraccionEncontrada = buscarAtraccionPorNombre(nombreAtraccion);

        if (atraccionEncontrada == null) {
            System.out.println("No se encontro una atraccion con el nombre: " + nombreAtraccion);
        } else {
            atraccionEncontrada.setVisitantesPorDia(visitantesPorDia);
            System.out.println("Visitantes registrados correctamente.");
        }
    }

    public Atraccion buscarAtraccionPorNombre(String nombreAtraccion) {
        for (Atraccion atraccion : atracciones) {
            if (atraccion.getNombre().equalsIgnoreCase(nombreAtraccion)) {
                return atraccion;
            }
        }

        return null;
    }

    public double calcularIngresoTotalDiario() {
        double total = 0;

        for (Atraccion atraccion : atracciones) {
            total += atraccion.calcularIngresoDiario();
        }

        return total;
    }

    public void mostrarIngresosDiarios() {
        System.out.println("\n--- INGRESOS DIARIOS ---");

        for (Atraccion atraccion : atracciones) {
            System.out.println(
                    atraccion.getNombre() + ": $" +
                    String.format("%,.2f", atraccion.calcularIngresoDiario())
            );
        }

        System.out.println("Ingreso total del parque: $" +
                String.format("%,.2f", calcularIngresoTotalDiario()));
    }

    public void generarReporteOperaciones() {
        System.out.println("\n--- REPORTE DE OPERACIONES ---");

        for (Atraccion atraccion : atracciones) {
            System.out.println(atraccion);
            System.out.println("Mantenimiento necesario: " +
                    (atraccion.esNecesarioMantenimiento() ? "SI" : "NO"));
        }
    }

    public void mostrarAtraccionesClasifRiesgo() {
        System.out.println("\n--- ATRACCIONES CON CLASIFICACION DE RIESGO ---");

        for (Atraccion atraccion : atracciones) {
            if (atraccion instanceof ClasificableRiesgo) {
                ClasificableRiesgo riesgo = (ClasificableRiesgo) atraccion;

                System.out.println(
                        atraccion.getNombre() +
                        " - Riesgo: " +
                        riesgo.clasificarRiesgo()
                );
            }
        }
    }

    public void generarReporteAlertasCapacidad() {
        System.out.println("\n--- ALERTAS DE CAPACIDAD ---");

        boolean hayAlertas = false;

        for (Atraccion atraccion : atracciones) {
            if (atraccion.tieneAlertaCapacidad()) {
                hayAlertas = true;

                System.out.println(
                        atraccion.getNombre() +
                        " excedio la capacidad por " +
                        atraccion.calcularVisitantesExcedidos() +
                        " visitantes. Sobreocupacion: " +
                        String.format("%.2f", atraccion.calcularPorcentajeSobreocupacion()) +
                        "%"
                );
            }
        }

        if (!hayAlertas) {
            System.out.println("No hay atracciones con alerta de capacidad.");
        }
    }

    public void mostrarAtraccionesConMantenimiento() {
        System.out.println("\n--- ATRACCIONES QUE REQUIEREN MANTENIMIENTO ---");

        for (Atraccion atraccion : atracciones) {
            if (atraccion.esNecesarioMantenimiento()) {
                System.out.println(atraccion.getNombre());
            }
        }
    }
}


