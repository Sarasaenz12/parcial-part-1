package org.example.aplication;

import org.example.aplication.service.CalzadoService;
import org.example.aplication.service.CalzadoServiceImpl;
import org.example.domain.Calzado;
import org.example.infraestructure.repository.CalzadoRepositoryImpl;
import org.example.interfaces.CalzadoRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static CalzadoService calzadoService;

    static {
        CalzadoRepository calzadoRepository = new CalzadoRepositoryImpl();
        calzadoService = new CalzadoServiceImpl(calzadoRepository);
    }

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Listar calzados");
            System.out.println("2. Crear calzado");
            System.out.println("3. Actualizar calzado");
            System.out.println("4. Eliminar calzodo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    listarCalzado();
                    break;
                case 2:
                    crearCalzado();
                    break;
                case 3:
                    actualizarCalzado();
                    break;
                case 4:
                    eliminarCalzado();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private static void listarCalzado() {
        List<Calzado> calzados = calzadoService.findAll();
        if (calzados.isEmpty()) {
            System.out.println("No hay calzado registrados.");
        } else {
            System.out.println("Listado de calzados:");
            for (Calzado calzado : calzados) {
                System.out.println(calzados);
            }
        }
    }

    private static void crearCalzado() {
        System.out.print("Ingrese el iD del calzado: ");
        int id  = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la  marca del calzado: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el precio del calzado: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        Calzado calzado = new Calzado(id, marca, precio);
        calzado.setId(id);
        calzado.setMarca(marca);
        calzado.setPrecio(precio);

        try {
            calzadoService.save(calzado);
            System.out.println("Calzado creado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void actualizarCalzado() {
        System.out.print("Ingrese el ID del calzado a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Calzado calzado = calzadoService.findById(id);
        if (calzado == null) {
            System.out.println("No se encontró el Calzado con ID " + id);
            return;
        }

        System.out.print("Ingrese la nueva marca (dejar en blanco para no cambiar): ");
        String marca= scanner.nextLine();
        if (!marca.isEmpty()) {
            calzado.setMarca(marca);
        }

        System.out.print("Ingrese el nuevo precio del calzado (0 para no cambiar): ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        if (precio > 0) {
            calzado.setPrecio(precio);
        }

        try {
            calzadoService.update(calzado);
            System.out.println("Calzado actualizado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void eliminarCalzado() {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Calzado calzado = calzadoService.findById(id);
        if (calzado == null) {
            System.out.println("No se encontró el Calzado con ID " + id);
            return;
        }

        calzadoService.delete(id);
        System.out.println("Producto eliminado exitosamente.");
    }
}
