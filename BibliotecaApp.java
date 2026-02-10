import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    // prestamo = [idPrestamo, nombreUsuario, tituloLibro, diasPrestamo, multaPorDia]
    static ArrayList<ArrayList<Object>> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: 
                    registrarPrestamo();
                    break;
                case 2: 
                    mostrarPrestamos();
                    break;
                case 3: 
                    buscarPrestamoPorId();
                    break;
                case 4: 
                    actualizarPrestamo();
                    break;
                case 5: 
                    eliminarPrestamo();
                    break;
                case 6: 
                    calcularTotalMultas();
                    break;
                case 7: 
                    System.out.println("Saliendo...");
                    break;
                default: 
                    System.out.println("Opción inválida.");
            }
            System.out.println();
        } while (opcion != 7);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("=== Biblioteca: Gestión de Préstamos ===");
        System.out.println("1. Registrar nuevo préstamo");
        System.out.println("2. Mostrar todos los préstamos");
        System.out.println("3. Buscar préstamo por ID");
        System.out.println("4. Actualizar un préstamo");
        System.out.println("5. Eliminar un préstamo");
        System.out.println("6. Calcular total de multas");
        System.out.println("7. Salir");
    }

    // ====== CRUD ======
    
    static void registrarPrestamo() {
        ArrayList<Object> prestamo = new ArrayList<>();
        int id = leerEntero("ID del préstamo: ");
        String usuario = leerTexto("Nombre del usuario: ");
        String libro = leerTexto("Título del libro: ");
        int dias = leerEntero("Días de préstamo: ");
        int multa = leerEntero("Multa por día: ");

        prestamo.add(id);
        prestamo.add(usuario);
        prestamo.add(libro);
        prestamo.add(dias);
        prestamo.add(multa);

        prestamos.add(prestamo);
        System.out.println("Préstamo registrado correctamente.");
    }

    static void mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        System.out.println("=== Lista de Préstamos ===");
        for (ArrayList<Object> p : prestamos) {
            System.out.println(
                "ID: " + p.get(0) +
                " | Usuario: " + p.get(1) +
                " | Libro: " + p.get(2) +
                " | Días: " + p.get(3) +
                " | Multa/Día: " + p.get(4)
            );
        }
    }

    static void buscarPrestamoPorId() {
        System.out.println("--- Buscar Prestamo ---");
        String idBuscado = leerTexto("Ingrese el ID del prestamo: ");
        boolean encontrado = false;

        for (ArrayList<Object> prestamo : prestamos) {
            if (prestamo.get(0).toString().equals(idBuscado)) {
                System.out.println("El prestamo fue encontrado");
                System.out.println("ID: " + prestamo.get(0));
                System.out.println("Usuario: " + prestamo.get(1));
                System.out.println("Libro: " + prestamo.get(2));
                System.out.println("Dias: " + prestamo.get(3));
                System.out.println("Multa/dia: " + prestamo.get(4));
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningun prestamo con el ID: " + idBuscado);
        }
    }

    static void actualizarPrestamo() {
        System.out.println("--- Actualizar Prestamo ---");
        String idBuscado = leerTexto("Ingrese el ID del prestamo: ");
        boolean encontrado = false;

        for (ArrayList<Object> prestamo : prestamos) {
            if (prestamo.get(0).toString().equals(idBuscado)) {
                System.out.println("Prestamo encontrado. Ingrese los nuevos datos.");
                System.out.println("(Usuario actual: " + prestamo.get(1) + ", Libro actual: " + prestamo.get(2) + ")");
                
                prestamo.set(1, leerTexto("Nuevo nombre de usuario: "));
                prestamo.set(2, leerTexto("Nuevo titulo del libro: "));
                prestamo.set(3, leerEntero("Nuevos dias de prestamo: "));
                prestamo.set(4, leerEntero("Nueva multa por dia: "));
                
                System.out.println("Prestamo actualizado correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se puede actualizar: ID no encontrado.");
        }
    }

    static void eliminarPrestamo() {
        System.out.println("--- Eliminar Préstamo ---");
        String idBuscado = leerTexto("Ingrese el ID del préstamo a eliminar: ");
        boolean eliminado = prestamos.removeIf(p -> p.get(0).toString().equals(idBuscado));

        if (eliminado) {
            System.out.println("Préstamo eliminado correctamente.");
        } else {
            System.out.println("No se encontró el ID.");
        }
    }

    static void calcularTotalMultas() {
        int total = 0;
        for (ArrayList<Object> p : prestamos) {
            int dias = (int) p.get(3);
            int multaDia = (int) p.get(4);
            total += (dias * multaDia);
        }
        System.out.println("Total de multas acumuladas: $" + total);
    }

    // ====== Utilidades ======
    
    static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Ingrese un entero válido.");
            }
        }
    }

    static String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}