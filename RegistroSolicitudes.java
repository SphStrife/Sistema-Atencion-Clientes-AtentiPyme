
import java.io.*;
import java.util.*;

public class RegistroSolicitudes {

    static class Solicitud {
        int ticketId;
        String cliente;
        String tipo;
        String prioridad;
        String descripcion;

        public Solicitud(int ticketId, String cliente, String tipo, String prioridad, String descripcion) {
            this.ticketId = ticketId;
            this.cliente = cliente;
            this.tipo = tipo;
            this.prioridad = prioridad;
            this.descripcion = descripcion;
        }

        @Override
        public String toString() {
            return ticketId + ";" + cliente + ";" + tipo + ";" + prioridad + ";" + descripcion;
        }

        public static Solicitud fromString(String line) {
            String[] parts = line.split(";");
            if (parts.length == 5) {
                try {
                    int ticketId = Integer.parseInt(parts[0]);
                    return new Solicitud(ticketId, parts[1], parts[2], parts[3], parts[4]);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            return null;
        }
    }

    private static final String ARCHIVO = "solicitudes.txt";
    private static int contadorTickets = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Solicitud> solicitudes = cargarSolicitudes();

        // Ajustar contador según solicitudes existentes
        if (!solicitudes.isEmpty()) {
            contadorTickets = solicitudes.get(solicitudes.size() - 1).ticketId + 1;
        }

        while (true) {
            System.out.println("\nBienvenido a AtentiPyme - Registro de Solicitudes");
            System.out.println("1. Registrar nueva solicitud");
            System.out.println("2. Ver solicitudes registradas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String cliente = scanner.nextLine();

                    System.out.print("Tipo de solicitud: ");
                    String tipo = scanner.nextLine();

                    System.out.print("Prioridad (Alta, Media, Baja): ");
                    String prioridad = scanner.nextLine();

                    System.out.print("Descripcion del problema: ");
                    String descripcion = scanner.nextLine();

                    Solicitud nueva = new Solicitud(contadorTickets++, cliente, tipo, prioridad, descripcion);
                    solicitudes.add(nueva);
                    guardarSolicitudes(solicitudes);
                    System.out.println("Solicitud registrada correctamente. Tu numero de ticket es: " + nueva.ticketId);
                    break;
                case 2:
                    System.out.println("\nSolicitudes registradas:");
                    for (Solicitud s : solicitudes) {
                        System.out.println("\nTicket #" + s.ticketId);
                        System.out.println("Cliente: " + s.cliente);
                        System.out.println("Tipo: " + s.tipo);
                        System.out.println("Prioridad: " + s.prioridad);
                        System.out.println("Descripcion: " + s.descripcion);
                    }
                    break;
                case 3:
                    System.out.println("Gracias por usar AtentiPyme.");
                    return;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }
    }

    private static void guardarSolicitudes(List<Solicitud> solicitudes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Solicitud s : solicitudes) {
                writer.write(s.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar solicitudes.");
        }
    }

    private static List<Solicitud> cargarSolicitudes() {
        List<Solicitud> solicitudes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Solicitud s = Solicitud.fromString(line);
                if (s != null) {
                    solicitudes.add(s);
                }
            }
        } catch (IOException e) {
            // Archivo no existe la primera vez, no hay problema
        }
        return solicitudes;
    }
}
