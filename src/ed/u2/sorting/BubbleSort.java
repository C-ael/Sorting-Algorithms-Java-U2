package ed.u2.sorting;

import java.util.Arrays;

public class BubbleSort {

    // evita crear objetos de esta clase
    private BubbleSort() {}

    // método sin trazas
    public static void sort(int[] a) {
        sort(a, false);
    }

    // ordena el arreglo usando el método burbuja
    public static void sort(int[] a, boolean trace) {

        // valida que el arreglo no sea nulo
        if (a == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }

        int n = a.length;

        // si tiene 0 o 1 elemento, no hay nada que ordenar
        if (n < 2) {
            if (trace) {
                System.out.println("El arreglo ya está ordenado (tamaño menor a 2).");
                SortingUtils.printArray(a);
            }
            return;
        }

        boolean swapped;       // indica si hubo intercambios en una pasada
        int iteration = 0;

        // muestra el arreglo original antes de las pasadas
        if (trace) {
            System.out.print("Arreglo original: ");
            SortingUtils.printArray(a);
        }

        // recorre el arreglo hasta que no haya intercambios
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            iteration++;

            // compara elementos adyacentes y los intercambia si están en orden incorrecto
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    SortingUtils.swap(a, j, j + 1);
                    swapped = true;
                }
            }

            // solo muestra la iteración si realmente hubo cambios
            if (trace && swapped) {
                System.out.print("iteración " + iteration + ": ");
                SortingUtils.printArray(a);
            }

            // si no hubo intercambios, el arreglo ya está ordenado
            if (!swapped) {
                if (trace) {
                    System.out.println("Corte temprano: no hubo intercambios en la iteración " + iteration + ".");
                }
                break;
            }
        }

        if (trace) {
            System.out.println("Ordenamiento por burbuja completado.");
        }
    }

    // genera trazas del algoritmo sin imprimir en consola
    public static String getTrace(int[] a) {

        // copia del arreglo
        int[] copy = a.clone();
        int n = copy.length;
        StringBuilder sb = new StringBuilder();
        sb.append("Arreglo original: ")
                .append(Arrays.toString(copy)).append("\n");

        if (n < 2) {
            sb.append("Arreglo con menos de 2 elementos, no requiere ordenamiento.\n");
            return sb.toString();
        }

        boolean swapped;
        int iteration = 0;

        // burbuja con corte temprano
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            iteration++;

            for (int j = 0; j < n - 1 - i; j++) {
                if (copy[j] > copy[j + 1]) {
                    SortingUtils.swap(copy, j, j + 1);
                    swapped = true;
                }
            }

            // agrega traza
            sb.append("iteración ").append(iteration).append(": ")
                    .append(Arrays.toString(copy)).append("\n");

            // si no hubo intercambios, el arreglo ya está ordenado
            if (!swapped) {
                sb.append("Corte temprano en iteración ")
                        .append(iteration).append(" (sin intercambios)\n");
                break;
            }
        }
        return sb.toString();
    }
}
