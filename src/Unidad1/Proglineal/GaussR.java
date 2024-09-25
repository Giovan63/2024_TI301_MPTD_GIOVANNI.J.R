
package Unidad1.Proglineal;

public class GaussR {
    private double pl[][];
    private int r;
    private int c;
    public GaussR(double[][] pl, int r, int c) {
        this.pl = pl;
        this.r = r;
        this.c = c;
    }
    public void resolver (){
        double pivote = pl[r][c];
        for (int j = 0; j < pl[0].length; j++) {
               pl[r][j] /= pivote;
        }
        for (int i = 0; i < pl.length; i++) {
        if (i != r) {
        double factor = pl[i][c];
        for (int j = 0; j < pl[0].length; j++) {
            pl[i][j] -= factor * pl[r][j];
        }
    }
}
    }
    public void print (){
        for (int i = 0; i < pl.length; i++){
          for (int j = 0; j < pl[i].length; j++){
              System.out.printf("%06.3f ", pl[i][j]);
          }  
            System.out.println();
        }
    }
}
