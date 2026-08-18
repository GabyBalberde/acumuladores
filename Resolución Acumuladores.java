package acumuladores;

public class Acumuladores {

    // Ejercicio 1: Verifica si existe alguna fila donde todos sus elementos sean múltiplos del número
    public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
        if (mat == null || mat.length == 0 || num <= 0) {
            return false;
        }

        boolean existeFila = false;
        for (int i = 0; i < mat.length; i++) {
            boolean todosMultiplos = true;
            for (int j = 0; j < mat[i].length; j++) {
                todosMultiplos = todosMultiplos && (mat[i][j] % num == 0);
            }
            existeFila = existeFila || todosMultiplos;
        }
        return existeFila;
    }

    // Ejercicio 2: Verifica si hay intersección fila a fila entre dos matrices
    public boolean hayInterseccionPorFila(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat2 == null || mat1.length == 0 || mat2.length == 0) {
            return false;
        }
        if (mat1.length != mat2.length) {
            return false;
        }

        boolean todasLasFilasConInterseccion = true;
        for (int i = 0; i < mat1.length; i++) {
            boolean hayInterseccionFila = false;
            for (int j = 0; j < mat1[i].length; j++) {
                for (int k = 0; k < mat2[i].length; k++) {
                    hayInterseccionFila = hayInterseccionFila || (mat1[i][j] == mat2[i][k]);
                }
            }
            todasLasFilasConInterseccion = todasLasFilasConInterseccion && hayInterseccionFila;
        }
        return todasLasFilasConInterseccion;
    }

    // Ejercicio 3: Verifica si alguna fila suma más que el total de la columna dada
    public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return false;
        }
        if (nColum < 0 || nColum >= mat[0].length) {
            return false;
        }

        int sumaColumna = 0;
        for (int i = 0; i < mat.length; i++) {
            sumaColumna += mat[i][nColum];
        }

        boolean algunaFilaSumaMas = false;
        for (int i = 0; i < mat.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sumaFila += mat[i][j];
            }
            algunaFilaSumaMas = algunaFilaSumaMas || (sumaFila > sumaColumna);
        }

        return algunaFilaSumaMas;
    }

    // Ejercicio 4: Verifica si hay intersección columna a columna entre dos matrices
    public boolean hayInterseccionPorColumna(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat2 == null || mat1.length == 0 || mat2.length == 0) {
            return false;
        }
        if (mat1[0].length == 0 || mat2[0].length == 0) {
            return false;
        }
        if (mat1[0].length != mat2[0].length) {
            return false;
        }

        int cantCols = mat1[0].length;
        boolean todasLasColsConInterseccion = true;

        for (int j = 0; j < cantCols; j++) {
            boolean hayInterseccionColumna = false;
            for (int i1 = 0; i1 < mat1.length; i1++) {
                for (int i2 = 0; i2 < mat2.length; i2++) {
                    hayInterseccionColumna = hayInterseccionColumna || (mat1[i1][j] == mat2[i2][j]);
                }
            }
            todasLasColsConInterseccion = todasLasColsConInterseccion && hayInterseccionColumna;
        }

        return todasLasColsConInterseccion;
    }
}