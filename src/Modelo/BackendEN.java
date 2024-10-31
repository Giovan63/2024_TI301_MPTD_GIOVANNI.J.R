
package Modelo;


public class BackendEN {
     private int nSuministro;
   private int Ndemanda;
   private int S[];
   private int D[];
   private int Costos[][];
   private int Estado[][];

    public BackendEN(int Nsuministro, int Ndemanda) {
        this.nSuministro = Nsuministro;
        this.Ndemanda = Ndemanda;
        this.Estado = new int[Nsuministro][Ndemanda];
    }
  
    public void setS(int[] S) {
        this.S = S;
    }
    public void setD(int[] D) {
        this.D = D;
    }
    public void setCostos(int[][] Costos) {
        this.Costos = Costos;
    }
    public void resolver(){
        int j = 0;
        int i = 0;
        
        while (i < nSuministro && j < Ndemanda) {   
            if (this.S[i] < this.D[j]){
                this.Estado[i][j] = S[i]; 
                D[j] = (D[j]-S[i]);   
                S[i] = S[i] - S[i];
                i++;
             } else{
                this.Estado [i][j] =  D[j];
                S[i] = (S[i] - D[j]);
                D[j] = D[j] - D[j];
                j++;
             } 
        }
    }
    public String imprimir (){
        int f[][] = new int[nSuministro][Ndemanda];
        String str = "";
        for (int i = 0; i < nSuministro; i++) {
            for (int j = 0; j < Ndemanda; j++) {
                f[i][j] = Estado[i][j];
                str += Estado[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }
    public int[][] getEstado() {
        return Estado;
    }
   
    
}


