package ed.u2.sorting;

import java.util.Arrays;

public class InsertionSort {

    // constructor privado, evita crear objetos de esta clase
    private InsertionSort() {}

    // método principal sin trazas
    public static void sort(int[] a) {
        sort(a, false);
    }

    // ordena el arreglo con opción de mostrar trazas
    public static void sort(int[] a, boolean trace) {

        // valida que el arreglo no sea nulo
        if (a == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }

        int n = a.length;

        // si tiene 0 o 1 elemento, ya está ordenado
        if (n < 2) {
            if (trace) {
                System.out.println("El arreglo ya está ordenado (tamaño menor a 2).");
                SortingUtils.printArray(a);
            }
            return;
        }

        // muestra el arreglo original antes de comenzar
        if (trace) {
            System.out.print("Arreglo original: ");
            SortingUtils.printArray(a);
        }

        // recorremos desde el segundo elemento
        for (int i = 1; i < n; i++) {
            int key = a[i];      // elemento que se va a insertar
            int j = i - 1;       // posición previa

            // mueve elementos mayores una posición a la derecha
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }

            // coloca el elemento en su posición correcta
            a[j + 1] = key;

            // mostramos la iteración (aunque no haya cambios visibles)
            if (trace) {
                System.out.print("iteración " + i + ": ");
                SortingUtils.printArray(a);
            }
        }

        if (trace) {
            System.out.println("Ordenamiento por inserción completado.");
        }
    }

    // genera trazas del algoritmo sin imprimir en consola
    public static String getTrace(int[] a) {

        // copia para no modificar el arreglo original
        int[] copy = a.clone();
        int n = copy.length;

        StringBuilder sb = new StringBuilder();
        sb.append("Arreglo original: ").append(Arrays.toString(copy)).append("\n");

        // si tiene 0 o 1 elemento, ya está ordenado
        if (n < 2) {
            sb.append("Arreglo con menos de 2 elementos, no requiere ordenamiento.\n");
            return sb.toString();
        }

        // recorremos desde el segundo elemento
        for (int i = 1; i < n; i++) {
            int key = copy[i];
            int j = i - 1;

            // mueve elementos mayores
            while (j >= 0 && copy[j] > key) {
                copy[j + 1] = copy[j];
                j--;
            }

            // coloca el elemento en su posición correcta
            copy[j + 1] = key;

            // agrega la traza
            sb.append("iteración ").append(i).append(": ").append(Arrays.toString(copy)).append("\n");
        }
        return sb.toString();
    }
}
