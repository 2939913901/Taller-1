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

    static void registrarPrestamo() { System.out.println("(Función registrarPrestamo pendiente de copiar del código 1)"); }
    static void mostrarPrestamos() { System.out.println("(Función mostrarPrestamos pendiente de copiar del código 1)"); }
    static void buscarPrestamoPorId() { System.out.println("(Función buscarPrestamoPorId pendiente de copiar del código 2)"); }
    static void actualizarPrestamo() { System.out.println("(Función actualizarPrestamo pendiente de copiar del código 2)"); }
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