
package Unidad1.Proglineal;

import Unidad1.Proglineal.GaussR;

public class GaussRTest {

    public static void main(String[] args) {
        double [][] pl = {{1,60,-30,-20,0,0,0,0,0},
                          {0,8,6,1,1,0,0,0,48},
                          {0,4,2,1.5,0,1,0,0,20,},
                          {0,2,1.5,0.5,0,0,1,0,8},
                          {0,0,1,0,0,0,0,1,5}};
         GaussR p = new GaussR(pl, 3, 1);
         p.resolver();
         p.print();
    }
   
}
