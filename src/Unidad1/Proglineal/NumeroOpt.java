
package Unidad1.Proglineal;

public class NumeroOpt {
    private int listanum[];

    public NumeroOpt(int[] listanum) {
        this.listanum = listanum;
    }
public int resolver(){
    int indice = -1;
    int valor = Integer.MAX_VALUE;
    for (int i = 0; i < listanum.length; i++){
      if (listanum[i] < 0 && listanum[i] < valor) {
          valor = listanum[i];
          indice = i;
      }
    }
    
    
    return indice == -1 ? -1 : indice;
    
}
}
