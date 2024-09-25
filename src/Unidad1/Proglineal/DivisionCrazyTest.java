
package Unidad1.Proglineal;


public class DivisionCrazyTest {

    public static void main(String[] args) {
        double columna1[] = {1,-1};
        double columna2[] = {-1,1};
        DivisiónCrazy prueba = new DivisiónCrazy(columna1, columna2);
        System.out.println("Indice: "+prueba.resolver());
        prueba.print();
    }
    
}
