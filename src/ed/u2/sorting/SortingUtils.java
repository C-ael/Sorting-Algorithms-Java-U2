package ed.u2.sorting;

public class SortingUtils {

    // constructor privado, evita instanciar esta clase
    private SortingUtils() {}

    // intercambia dos elementos del arreglo
    public static void swap(int[] a, int i, int j) {
        if (a == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }
        if (i < 0 || j < 0 || i >= a.length || j >= a.length) {
            throw new IndexOutOfBoundsException("Índices fuera del rango del arreglo.");
        }

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // imprime el contenido del arreglo en una sola línea
    public static void printArray(int[] a) {
        if (a == null) {
            System.out.println("null");
            return;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // verifica si el arreglo está ordenado de forma ascendente
    public static boolean isSorted(int[] a) {
        if (a == null || a.length < 2) {
            return true;
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // crea una copia exacta del arreglo
    public static int[] copy(int[] a) {
        if (a == null) {
            return null;
        }

        int[] copy = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            copy[i] = a[i];
        }
        return copy;
    }
}
