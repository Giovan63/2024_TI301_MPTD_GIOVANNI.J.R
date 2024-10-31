
package Modelo;

public class BackendCM {
      int demanda;
      int sumi;

    public BackendCM(int demanda, int sumi) {
        this.demanda = demanda;
        this.sumi = sumi;
    }
      
    public int[][] resolverCostoMinimo(int[] oferta, int[] demanda, int[][] costos) {
        int n = oferta.length;
        int m = demanda.length;
        int[][] transporte = new int[n][m];

        while (!todosSatisfechos(oferta, demanda)) {

            int[] posicion = encontrarCeldaMenorCosto(costos, oferta, demanda);
            int i = posicion[0];
            int j = posicion[1];

            int asignacion = Math.min(oferta[i], demanda[j]);
            transporte[i][j] = asignacion;

            oferta[i] -= asignacion;
            demanda[j] -= asignacion;

            if (oferta[i] == 0) {
                eliminarFila(costos, i);
            }
            if (demanda[j] == 0) {
                eliminarColumna(costos, j);
            }
        }
        return transporte;
    }

    public int[] encontrarCeldaMenorCosto(int[][] costos, int[] oferta, int[] demanda) {
        int minCosto = Integer.MAX_VALUE;
        int[] posicion = new int[2];

        for (int i = 0; i < costos.length; i++) {
            for (int j = 0; j < costos[i].length; j++) {
                if (oferta[i] > 0 && demanda[j] > 0 && costos[i][j] < minCosto) {
                    minCosto = costos[i][j];
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        return posicion;
    }

    public boolean todosSatisfechos(int[] oferta, int[] demanda) {
        for (int o : oferta) {
            if (o > 0) {
                return false;
            }
        }
        for (int d : demanda) {
            if (d > 0) {
                return false;
            }
        }
        return true;
    }

    public void eliminarFila(int[][] costos, int fila) {
        for (int j = 0; j < costos[0].length; j++) {
            costos[fila][j] = Integer.MAX_VALUE;
        }
    }

    public void eliminarColumna(int[][] costos, int columna) {
        for (int i = 0; i < costos.length; i++) {
            costos[i][columna] = Integer.MAX_VALUE;
        }
    }

  public static String convertirArregloABlString(int[][] arreglo) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (int i = 0; i < arreglo.length; i++) {
            sb.append("[");
            for (int j = 0; j < arreglo[i].length; j++) {
                sb.append(arreglo[i][j]);
                if (j < arreglo[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            sb.append("\n");
            if (i < arreglo.length - 1) {
                sb.append(", ");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
}

