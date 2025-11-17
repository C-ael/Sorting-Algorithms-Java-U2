# Sorting-Algorithms-Java-U2
Inserción, Selección, Burbuja, manejo de archivos, trazas y validaciones.

---

## Tabla de contenidos
1. [Descripción](#descripción)  
2. [Ejecución del programa](#ejecución-del-programa)  
3. [Estructura del proyecto](#estructura-del-proyecto)   
4. [Decisiones de diseño](#decisiones-de-diseño)  
5. [Casos borde considerados](#casos-borde-considerados)

---

## Descripción

Este proyecto implementa los algoritmos básicos de ordenamiento **Inserción**, **Selección** y **Burbuja**, permitiendo observar su funcionamiento paso a paso mediante trazas completas.

El programa permite:

1. Ingresar manualmente un arreglo y visualizar todas las iteraciones del algoritmo en consola.  
2. Procesar automáticamente todos los archivos `.txt` dentro de la carpeta `datasets/`, generando las trazas completas en la carpeta `evidencias/`.

El objetivo es analizar el comportamiento real de cada algoritmo, mostrando sus pasos internos, movimientos e intercambios hasta obtener el resultado final ordenado.

---

## Ejecución del programa

### Requisitos
- Java 8+  
- IntelliJ IDEA o cualquier IDE sin dependencias externas  
- Carpetas `datasets/` y `evidencias/` en la raíz del proyecto  

### Cómo ejecutar
1. Abrir el proyecto.  
2. Ejecutar la clase principal: `ed.u2.sorting.SortingDemo`  
3. Elegir una opción del menú:

   1. Ingresar arreglo manualmente  
   2. Procesar archivos `.txt` desde `datasets/`  
   3. Salir  

La opción **1** muestra trazas en consola.  
La opción **2** genera archivos en `evidencias/` con todas las iteraciones.  
El programa valida entradas incorrectas y nunca se cierra inesperadamente.

---

## Estructura del proyecto

### Paquete `src`
#### Paquete `ed/u2/sorting/`
- `InsertionSort` — Algoritmo de Inserción, mostrando la construcción progresiva del subarreglo ordenado.
- `SelectionSort` — Algoritmo de Selección, indicando cada intercambio real detectado.
- `BubbleSort` — Algoritmo de Burbuja estándar con corte temprano y trazas completas por cada pasada del algoritmo.
- `SortingUtils` — swap, impresión, verificación de ordenamiento, validaciones.
- `SortingDemo` — Control del menú y flujo general.

### Paquete `datasets`
— Contiene los archivos .txt que pueden ser cargados en el programa.

### Paquete `evidencias`
— Contiene los archivos .txt generados automáticamente tras la ejecución de la opción 2, para mostrar los resultados obtenidos en base a los archivos cargados en el paquete 'datasets'.

---

## Decisiones de diseño

### Separación por responsabilidades
- `SortingDemo` gestiona la interacción con el usuario, el menú y la lectura/escritura de archivos.  
- Cada algoritmo está aislado en su propia clase para facilitar claridad y mantenimiento.  
- `SortingUtils` evita duplicación de código y centraliza funciones comunes.

### Iteraciones completas
Se decidió mostrar **todas las iteraciones** para cumplir con los requerimientos del taller y facilitar el análisis del comportamiento del algoritmo.

### Manejo automático de datasets
El programa detecta cualquier archivo `.txt` dentro de `datasets/` y genera automáticamente sus evidencias sin modificar el código.

### Robustez
Se implementaron validaciones para evitar errores comunes y permitir que el programa siga ejecutándose sin fallos y sea amigable con el usuario.

---

## Casos borde considerados

- Entrada manual con caracteres no numéricos  
- Arreglos vacíos o de un solo elemento  
- Archivos `.txt` vacíos 
- Archivos con espacios múltiples o saltos de línea irregulares  
- Carpetas `datasets/` o `evidencias/` ausentes (creadas automáticamente)  
- Errores de lectura o escritura manejados sin cerrar el programa  
- Validaciones antes de imprimir o procesar información  