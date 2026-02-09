import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    // Estructura: [0:id(int), 1:usuario(String), 2:libro(String), 3:dias(int), 4:multa(int)]
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

    // ====== CRUD IMPLEMENTADO ======

    static void registrarPrestamo() {
        System.out.println("--- Registrar Préstamo ---");
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
        System.out.println("--- Buscar Préstamo ---");
        int idBuscado = leerEntero("Ingrese el ID del préstamo: ");
        boolean encontrado = false;

        for (ArrayList<Object> prestamo : prestamos) {
            // Convertimos a entero para comparar
            int idActual = (int) prestamo.get(0);
            
            if (idActual == idBuscado) {
                System.out.println("¡Encontrado!");
                System.out.println("ID: " + prestamo.get(0));
                System.out.println("Usuario: " + prestamo.get(1));
                System.out.println("Libro: " + prestamo.get(2));
                System.out.println("Días: " + prestamo.get(3));
                System.out.println("Multa/Día: " + prestamo.get(4));
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún préstamo con el ID: " + idBuscado);
        }
    }

    static void actualizarPrestamo() {
        System.out.println("--- Actualizar Préstamo ---");
        int idBuscado = leerEntero("Ingrese el ID del préstamo a editar: ");
        boolean encontrado = false;

        for (ArrayList<Object> prestamo : prestamos) {
            int idActual = (int) prestamo.get(0);

            if (idActual == idBuscado) {
                System.out.println("Préstamo encontrado. Ingrese los nuevos datos.");
                
                String nuevoNombre = leerTexto("Nuevo nombre de usuario: ");
                prestamo.set(1, nuevoNombre);
                
                String nuevoTitulo = leerTexto("Nuevo título del libro: ");
                prestamo.set(2, nuevoTitulo);
                
                int nuevosDias = leerEntero("Nuevos días de préstamo: ");
                prestamo.set(3, nuevosDias);
                
                int nuevaMulta = leerEntero("Nueva multa por día: ");
                prestamo.set(4, nuevaMulta);
                
                System.out.println("Préstamo actualizado correctamente.");
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
        int idBuscado = leerEntero("Ingrese el ID del préstamo a eliminar: ");
        boolean eliminado = false;

        for (int i = 0; i < prestamos.size(); i++) {
            int idActual = (int) prestamos.get(i).get(0);
            
            if (idActual == idBuscado) {
                prestamos.remove(i);
                eliminado = true;
                System.out.println("Préstamo eliminado correctamente.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No existe un préstamo con ese ID.");
        }
    }

    static void calcularTotalMultas() {
        System.out.println("--- Calcular Multa ---");
        int idBuscado = leerEntero("Ingrese el ID del préstamo a evaluar: ");
        boolean encontrado = false;

        for (ArrayList<Object> p : prestamos) {
            int idActual = (int) p.get(0);
            
            if (idActual == idBuscado) {
                encontrado = true;
                int diasPactados = (int) p.get(3);
                int multaPorDia = (int) p.get(4);

                System.out.println("Días pactados originalmente: " + diasPactados);
                int diasUsados = leerEntero("Digite los días que usó el libro: ");

                if (diasUsados > diasPactados) {
                    int diasRetraso = diasUsados - diasPactados;
                    int totalMulta = diasRetraso * multaPorDia;
                    System.out.println("¡Retraso de " + diasRetraso + " días!");
                    System.out.println("El total de la multa es: " + totalMulta);
                } else {
                    System.out.println("Entrega a tiempo. No tiene multa.");
                }
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontró el préstamo con ese ID.");
        }
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