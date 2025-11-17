package ed.u2.sorting;

import java.io.*;
import java.util.*;

public class SortingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("****[ DEMOSTRACIÓN DE MÉTODOS DE ORDENAMIENTO ]****");
            boolean running = true;
            while (running) {
                int option = readMenuOption(sc);
                switch (option) {
                    case 1: {
                        int[] userArray = readUserArray(sc);
                        runManualSorting(userArray);
                        break;
                    }
                    case 2: {
                        handleDatasetFiles();
                        break;
                    }
                    case 3: {
                        System.out.println("Saliendo del programa...");
                        running = false;
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // lee la opción del menú y evita errores de entrada
    private static int readMenuOption(Scanner sc) {
        int option = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Ingresar un arreglo manualmente");
                System.out.println("2. Leer conjuntos de archivos .txt (carpeta datasets/)");
                System.out.println("3. Salir");
                System.out.print("Opción: ");
                option = sc.nextInt();
                sc.nextLine();

                if (option >= 1 && option <= 3) {
                    valid = true;
                } else {
                    System.out.println("Opción inválida, intente nuevamente.\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.\n");
                sc.nextLine();
            }
        }
        return option;
    }

    // permite al usuario ingresar un arreglo manualmente
    private static int[] readUserArray(Scanner sc) {
        int size;

        while (true) {
            try {
                System.out.print("Ingrese la cantidad de elementos: ");
                size = sc.nextInt();
                sc.nextLine();

                if (size > 0) break;
                System.out.println("El número debe ser mayor que cero.\n");

            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número entero.\n");
                sc.nextLine();
            }
        }

        int[] array = new int[size];
        System.out.println("Ingrese los " + size + " elementos:");
        int index = 0;

        while (index < size) {
            try {
                array[index] = sc.nextInt();
                index++;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Ingrese un entero:");
                sc.nextLine();
            }
        }

        System.out.println("Arreglo ingresado correctamente:");
        SortingUtils.printArray(array);
        return array;
    }

    // maneja la lectura de archivos dentro de datasets/
    private static void handleDatasetFiles() {
        File folder = new File("datasets");

        // si no existe se crea para evitar errores
        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("Se creó la carpeta 'datasets'. Agregue sus archivos y vuelva a intentar.\n");
            return;
        }

        File[] files = folder.listFiles((d, name) -> name.toLowerCase().endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No se encontraron archivos .txt en la carpeta datasets/.");
            return;
        }

        System.out.println("\nArchivos encontrados:");
        for (File f : files) System.out.println(" - " + f.getName());

        File evidences = new File("evidencias");
        if (!evidences.exists()) evidences.mkdirs();

        for (File file : files) {
            String baseName = file.getName().replace(".txt", "");
            System.out.println("\nProcesando archivo: " + file.getName());

            int[] array = readArrayFromFile(file.getPath());
            if (array == null) {
                System.out.println("No se pudo leer este archivo. Se omite.");
                continue;
            }
            SortingUtils.printArray(array);
            runSortingWithEvidence(array, baseName);
        }
        System.out.println("\nRevise la carpeta 'evidencias/' para ver los resultados.");
    }

    // carga datos desde un archivo .txt
    private static int[] readArrayFromFile(String path) {
        List<Integer> numbers = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(path))) {
            while (sc.hasNextInt()) numbers.add(sc.nextInt());
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + path);
            return null;
        }

        if (numbers.isEmpty()) {
            System.out.println("El archivo está vacío.");
            return null;
        }

        int[] array = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++)
            array[i] = numbers.get(i);

        return array;
    }

    private static String generateInsertionTrace(int[] original) {
        StringBuilder sb = new StringBuilder();
        sb.append("***[ ALGORITMO DE INSERCIÓN ]***\n");
        int[] copy = SortingUtils.copy(original);
        sb.append(InsertionSort.getTrace(copy));
        InsertionSort.sort(copy);

        sb.append("Resultado final: ").append(Arrays.toString(copy)).append("\n");
        return sb.toString();
    }

    private static String generateSelectionTrace(int[] original) {
        StringBuilder sb = new StringBuilder();
        sb.append("***[ ALGORITMO DE SELECCIÓN ]***\n");
        int[] copy = SortingUtils.copy(original);
        sb.append(SelectionSort.getTrace(copy));
        SelectionSort.sort(copy);

        sb.append("Resultado final: ").append(Arrays.toString(copy)).append("\n");
        return sb.toString();
    }

    private static String generateBubbleTrace(int[] original) {
        StringBuilder sb = new StringBuilder();
        sb.append("***[ ALGORITMO DE BURBUJA ]***\n");
        int[] copy = SortingUtils.copy(original);
        sb.append(BubbleSort.getTrace(copy));
        BubbleSort.sort(copy);

        sb.append("Resultado final: ").append(Arrays.toString(copy)).append("\n");
        return sb.toString();
    }

    // guarda cada resultado en un archivo dentro de evidencias/
    private static void runSortingWithEvidence(int[] original, String baseName) {
        saveTraces("evidencias/trazas_insertion_" + baseName + ".txt",
                generateInsertionTrace(original));

        saveTraces("evidencias/trazas_selection_" + baseName + ".txt",
                generateSelectionTrace(original));

        saveTraces("evidencias/trazas_bubble_" + baseName + ".txt",
                generateBubbleTrace(original));
    }

    // utilidad para escribir archivos
    private static void saveTraces(String path, String content) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(path))) {
            w.write(content);
            System.out.println("Evidencia guardada en: " + path);
        } catch (IOException e) {
            System.out.println("No se pudo guardar " + path + ": " + e.getMessage());
        }
    }

    // ejecuta los tres algoritmos de forma visual para el usuario
    private static void runManualSorting(int[] original) {
        if (original == null || original.length == 0) {
            System.out.println("El arreglo está vacío, no hay nada que ordenar.");
            return;
        }

        System.out.println("\n===*[ RESULTADOS DE ALGORITMOS DE ORDENAMIENTO ]*===");

        int[] a1 = SortingUtils.copy(original);
        System.out.println("\n---{ INSERCIÓN }---");
        InsertionSort.sort(a1, true);
        validateSorting(a1);

        int[] a2 = SortingUtils.copy(original);
        System.out.println("\n---{ SELECCIÓN }---");
        SelectionSort.sort(a2, true);
        validateSorting(a2);

        int[] a3 = SortingUtils.copy(original);
        System.out.println("\n---{ BURBUJA }---");
        BubbleSort.sort(a3, true);
        validateSorting(a3);
    }

    // verifica si el resultado quedó ordenado
    private static void validateSorting(int[] array) {
        boolean sorted = SortingUtils.isSorted(array);
        if (sorted)
            System.out.println("Resultado final ordenado correctamente:");
        else
            System.out.println("Advertencia: el arreglo no quedó totalmente ordenado.");
        SortingUtils.printArray(array);
    }
}
