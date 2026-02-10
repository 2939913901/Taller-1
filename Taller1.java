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
                case 1: registrarPrestamo();
                case 2: mostrarPrestamos();
                case 3: buscarPrestamoPorId();
                case 4: actualizarPrestamo();
                case 5: eliminarPrestamo();
                case 6: calcularTotalMultas();
                case 7: System.out.println("Saliendo...");
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

    // ====== CRUD (por implementar) ======
    static void registrarPrestamo() { /* TODO */ }
    static void mostrarPrestamos() { /* TODO */ }
    static void buscarPrestamoPorId() { /* TODO */ }
    static void actualizarPrestamo() { /* TODO */ }
    static void eliminarPrestamo() { 
        
        System.out.println("Ingrese el ID del préstamo a eliminar: ")
        int idPrestamo=sc.nextInt();
        boolean eliminado = false;

for (int i = 0; i < prestamos.size(); i++) {
        if (prestamos.get(i).getIdPrestamo() == idBuscado) {
            prestamos.remove(i);
            eliminado = true;
            System.out.println("Préstamo eliminado correctamente");
            break;
        }
    }

    if (!eliminado) {
        System.out.println("No existe un préstamo con ese ID");
    }


     }


    // ====== Cálculo (por implementar) ======
    static void calcularTotalMultas() { 
        int diasUsados;
        System.out.println("Digite los dias que uso el libro");
        diasUsados=sc.nextInt;

        if(diasUsados>diasPrestamo){
        multas=(diasUsados-diasPrestamos)*multaPorDia 
        System.out.println("El total de la multa es: "+multas);
        } else{
            System.out.println("No cuenta con multa");
        }
    }
    

    // ====== Utilidades mínimas ======
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