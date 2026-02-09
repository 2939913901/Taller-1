import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    static ArrayList<ArrayList<Object>> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: registrarPrestamo();
                break;
                case 2: mostrarPrestamos();
                break;
                case 3: buscarPrestamoPorId(); 
                break;
                case 4: actualizarPrestamo(); 
                break;
                case 5: eliminarPrestamo();
                break;
                case 6: calcularTotalMultas();
                break;
                case 7: System.out.println("Saliendo...");
                break;
                default: System.out.println("Opción inválida.");
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
    static void registrarPrestamo() { 
        System.out.println("");
    }
    static void mostrarPrestamos() { 
        System.out.println("");
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
                
                String nuevoNombre = leerTexto("Nuevo nombre de usuario: ");
                prestamo.set(1, nuevoNombre);
                
                String nuevoTitulo = leerTexto("Nuevo titulo del libro: ");
                prestamo.set(2, nuevoTitulo);
                
                int nuevosDias = leerEntero("Nuevos dias de prestamo: ");
                prestamo.set(3, nuevosDias);
                
                int nuevaMulta = leerEntero("Nueva multa por dia: ");
                prestamo.set(4, nuevaMulta);
                
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
        System.out.println(""); 
    }

    static void calcularTotalMultas() { 
        System.out.println("");
    }
    static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Ingrese un entero valido.");
            }
        }
    }

    static String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}