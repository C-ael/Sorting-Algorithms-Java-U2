package ed.u2.sorting;

import java.util.Arrays;

public class SelectionSort {

    // evita crear objetos de la clase
    private SelectionSort() {}

    // método sin trazas
    public static void sort(int[] a) {
        sort(a, false);
    }

    // ordena el arreglo usando el método de selección
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

        // mostramos el arreglo original antes de ordenar
        if (trace) {
            System.out.print("Arreglo original: ");
            SortingUtils.printArray(a);
        }

        int swapCount = 0;

        // recorre cada posición del arreglo
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;   // índice del menor valor encontrado

            // busca el valor más pequeño en la parte no ordenada
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // si se encontró un valor menor, intercambia
            if (minIndex != i) {
                SortingUtils.swap(a, i, minIndex);
                swapCount++;
            }

            // mostramos siempre la iteración, independientemente de si hubo o no intercambio
            if (trace) {
                System.out.print("iteración " + (i + 1) + ": ");
                SortingUtils.printArray(a);
            }
        }

        if (trace) {
            System.out.println("Ordenamiento por selección completado. Intercambios realizados: " + swapCount);
        }
    }

    // genera trazas del algoritmo sin imprimir en consola
    public static String getTrace(int[] a) {

        // copia para no modificar el original
        int[] copy = a.clone();
        int n = copy.length;

        StringBuilder sb = new StringBuilder();
        sb.append("Arreglo original: ").append(Arrays.toString(copy)).append("\n");

        // si tiene menos de 2 elementos no necesita ordenamiento
        if (n < 2) {
            sb.append("Arreglo con menos de 2 elementos, no requiere ordenamiento.\n");
            return sb.toString();
        }

        int swapCount = 0;

        // recorre cada posición del arreglo
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // busca el valor más pequeño en la zona no ordenada
            for (int j = i + 1; j < n; j++) {
                if (copy[j] < copy[minIndex]) {
                    minIndex = j;
                }
            }

            // intercambia si corresponde
            if (minIndex != i) {
                SortingUtils.swap(copy, i, minIndex);
                swapCount++;
            }

            // mostramos siempre la iteración
            sb.append("iteración ").append(i + 1).append(": ")
                    .append(Arrays.toString(copy)).append("\n");
        }

        sb.append("Intercambios realizados: ").append(swapCount).append("\n");
        return sb.toString();
    }
}
