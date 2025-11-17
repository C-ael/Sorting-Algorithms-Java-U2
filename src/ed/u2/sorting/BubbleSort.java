package ed.u2.sorting;

import java.util.Arrays;

public class BubbleSort {

    // evita instanciar esta clase
    private BubbleSort() {}

    // ordena el arreglo sin mostrar trazas
    public static void sort(int[] a) {
        sort(a, false);
    }

    // ordena el arreglo usando burbuja y opcionalmente muestra trazas
    public static void sort(int[] a, boolean trace) {

        if (a == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }

        int n = a.length;

        // si tiene 0 o 1 elemento, ya está ordenado
        if (n < 2) {
            if (trace) {
                System.out.println("El arreglo ya está ordenado (menos de 2 elementos).");
                SortingUtils.printArray(a);
            }
            return;
        }

        boolean swapped;
        int iteration = 0;

        // muestra el arreglo original
        if (trace) {
            System.out.print("Arreglo original: ");
            SortingUtils.printArray(a);
        }

        // pasadas del algoritmo
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            iteration++;

            // compara elementos vecinos y los intercambia si es necesario
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    SortingUtils.swap(a, j, j + 1);
                    swapped = true;
                }
            }

            // muestra cada iteración si se pide traza
            if (trace) {
                System.out.print("iteración " + iteration + ": ");
                SortingUtils.printArray(a);
            }

            // si no hubo intercambios, el arreglo ya está ordenado
            if (!swapped) {
                if (trace) {
                    System.out.println("Corte temprano: sin intercambios en iteración " + iteration + ".");
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
        int[] copy = a.clone();
        int n = copy.length;

        StringBuilder sb = new StringBuilder();
        sb.append("Arreglo original: ").append(Arrays.toString(copy)).append("\n");

        // arreglos pequeños no requieren iteraciones
        if (n < 2) {
            sb.append("Arreglo con menos de 2 elementos, no requiere ordenamiento.\n");
            return sb.toString();
        }

        boolean swapped;
        int iteration = 0;

        // misma lógica de burbuja, pero guarda los pasos en un String
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            iteration++;

            for (int j = 0; j < n - 1 - i; j++) {
                if (copy[j] > copy[j + 1]) {
                    SortingUtils.swap(copy, j, j + 1);
                    swapped = true;
                }
            }

            // agrega la iteración a la traza
            sb.append("iteración ").append(iteration).append(": ").append(Arrays.toString(copy)).append("\n");

            if (!swapped) {
                sb.append("Corte temprano en iteración ").append(iteration).append(" (sin intercambios)\n");
                break;
            }
        }

        return sb.toString();
    }
}
