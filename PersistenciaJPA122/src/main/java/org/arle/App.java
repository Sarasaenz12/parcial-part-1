package org.arle;

import org.arle.entity.Calzado;
import org.arle.service.CalzadoService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final CalzadoService calzadoService = new CalzadoService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- CRUD de Calzado ---");
            System.out.println("1. Crear Calzado");
            System.out.println("2. Leer Calzado");
            System.out.println("3. Actualizar Calzado");
            System.out.println("4. Eliminar Calzado");
            System.out.println("5. Listar todos los Calzado");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> crearCalzado();
                case 2 -> leerCalzado();
                case 3 -> actualizarCalzado();
                case 4 -> eliminarCalzado();
                case 5 -> listarCalzado();
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        }
        calzadoService.cerrar();
        scanner.close();
    }

    private static void crearCalzado() {
        System.out.print("Nombre del calzado: ");
        String marca = scanner.nextLine();
        System.out.print("Precio del producto: ");
        BigDecimal precio = scanner.nextBigDecimal();

        Calzado calzado = new Calzado();
        calzado.setMarca(marca);
        calzado.setPrecio(precio);

        calzadoService.crearCalzado(calzado);
        System.out.println("Calzado creado con éxito");
    }

    private static void leerCalzado() {
        System.out.print("ID del Calzado: ");
        Long id = scanner.nextLong();
        Calzado calzado = calzadoService.obtenerCalzado(id);
        if (calzado != null) {
            System.out.println(calzado);
        } else {
            System.out.println("Calzado no encontrado");
        }
    }

    private static void actualizarCalzado() {
        System.out.print("ID del calzado a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Calzado calzado = calzadoService.obtenerCalzado(id);
        if (calzado != null) {
            System.out.print("Nuevo de la marca (deje en blanco para mantener el actual): ");
            String marca = scanner.nextLine();
            if (!marca.isEmpty()) {
                calzado.setMarca(marca);
            }

            System.out.print("Nuevo precio (0 para mantener el actual): ");
            BigDecimal precio = scanner.nextBigDecimal();
            if (precio.compareTo(BigDecimal.ZERO) != 0) {
                calzado.setPrecio(precio);
            }

            calzadoService.actualizarCalzado(calzado);
            System.out.println("Calzado actualizado con éxito");
        } else {
            System.out.println("Calzado no encontrado");
        }
    }

    private static void eliminarCalzado() {
        System.out.print("ID del calzado a eliminar: ");
        Long id = scanner.nextLong();
        calzadoService.eliminarCalzado(id);
        System.out.println("Calzado eliminado con éxito");
    }

    private static void listarCalzado() {
        List<Calzado> calzados = calzadoService.obtenerTodosLosCalzado();
        if (calzados.isEmpty()) {
            System.out.println("No hay calzados registrados");
        } else {
            for (Calzado calzado : calzados) {
                System.out.println(calzado);
            }
        }
    }
}