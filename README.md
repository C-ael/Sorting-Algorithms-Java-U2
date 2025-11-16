# Sorting-Algorithms-Java-U2
Inserción, Selección, Burbuja, manejo de archivos, trazas y validaciones.

---

## Tabla de contenidos
1. [Descripción](#descripción)
2. [Ejecución del programa](#ejecución-del-programa)
3. [Estructura del proyecto](#estructura-del-proyecto)
4. [Datasets y evidencias](#datasets-y-evidencias)
5. [Decisiones de diseño](#decisiones-de-diseño)
6. [Casos borde considerados](#casos-borde-considerados)

---

## Descripción

Este proyecto implementa tres algoritmos básicos de ordenamiento: Inserción, Selección y Burbuja.

El programa permite:
1. Ingresar manualmente un arreglo, mostrando las trazas directamente en consola.
2. Procesar automáticamente todos los archivos .txt dentro de la carpeta datasets/, generando trazas completas en la carpeta evidencias/.

El objetivo es observar el comportamiento paso a paso de cada algoritmo y documentar los resultados de forma automatizada.

---

## Ejecución del programa

### Requisitos
- Java 8+
- IntelliJ IDEA o cualquier IDE sin Maven
- Carpetas datasets/ y evidencias/ ubicadas en la raíz del proyecto

### Cómo ejecutar
1. Abrir el proyecto en IntelliJ IDEA.
2. Ejecutar la clase principal: ed.u2.sorting.SortingDemo
3. Seleccionar una opción en el menú:

1.Ingresar arreglo manualmente
2.Procesar archivos .txt desde datasets/
3.Salir

La opción 1 muestra trazas en consola.  
La opción 2 genera archivos .txt con todas las iteraciones.  
El programa siempre vuelve al menú y no se cierra por errores de entrada.

---

## Estructura del proyecto
src/
└── ed/u2/sorting/
├── SortingDemo.java
├── SortingUtils.java
├── InsertionSort.java
├── SelectionSort.java
└── BubbleSort.java

datasets/ ← archivos .txt de entrada
evidencias/ ← salidas generadas automáticamente
README.md

---

## Datasets y evidencias

### datasets/
Contiene los archivos .txt con los números a ordenar.  
Ejemplo de contenido: 10 3 6 1 9 2

El programa procesa todos los archivos .txt presentes sin necesidad de modificar el código.

### evidencias/
El programa genera automáticamente tres archivos por cada dataset:

trazas_insertion_<dataset>.txt
trazas_selection_<dataset>.txt
trazas_bubble_<dataset>.txt

Cada archivo incluye:
- Las iteraciones del algoritmo
- Movimientos o intercambios realizados
- El resultado final ordenado

---

## Decisiones de diseño

### Separación por responsabilidades
- SortingDemo gestiona el menú, la interacción y el procesamiento de archivos.
- Cada algoritmo está implementado en su propia clase para mantener claridad.
- SortingUtils agrupa utilidades para evitar duplicación de código.

### Sistema escalable
El programa detecta automáticamente todos los archivos .txt dentro de datasets/, permitiendo añadir nuevos archivos sin cambiar el código.

### Evidencias independientes
Cada ejecución genera archivos separados por algoritmo, lo que permite analizar sus diferencias de forma clara.

### Robustez
Se aplicaron validaciones para evitar que entradas inválidas o archivos corruptos detengan la ejecución.

---

## Casos borde considerados

- Ingreso de texto no numérico durante la entrada manual.
- Cantidad de elementos menor o igual a cero.
- Archivos .txt vacíos o sin números válidos.
- Archivos con espacios múltiples, líneas vacías o formatos irregulares.
- Carpeta datasets/ inexistente, creada automáticamente.
- Problemas de lectura o escritura en evidencias/, manejados sin cerrar el programa.
- Arreglos de un solo elemento o vacíos.