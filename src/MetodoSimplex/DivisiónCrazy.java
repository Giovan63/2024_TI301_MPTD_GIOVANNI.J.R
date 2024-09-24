package MetodoSimplex;




public class DivisiónCrazy {
    private double columna1[];
    private double columna2[];
    private double div[];

    public DivisiónCrazy(double[] columna1, double[] columna2) {
        this.columna1 = columna1;
        this.columna2 = columna2;
        div = new double[columna1.length];
    }
   public int resolver(){
   for (int i = 1; i < columna1.length; i++){
     this.div[i]=columna2[i]/columna1[i]; 
   }
   int indice = -1;
   double valor = -1;
     for (int i = 1; i < div.length; i++){
        if (div [i]>0){
         valor = div[i];
         indice = i;
         break;
        } 
     }
      if (indice == -1){
          return -1;
      }
      for (int i = indice+1; i < div.length; i++){
          if (div[i] > 0 && div[i] < valor){
             valor = div[i];
             indice = i;
          }
      }
      return indice;
     } 
   public void print (){
       for (int i = 0; i < div.length; i++){
           System.out.println(columna1[i]+"\t"+columna2[i]+"\t"+div[i]);
       }
   }
}

