package CONTROLADORES;

import Modelo.BackendCM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mptdfx.MPTDFX;

public class Control2 {

    @FXML
    private TextField Costostxt;

    @FXML
    private TextField Demandastxt;

    @FXML
    private TextField Suministrostxt;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnResolver;

    @FXML
    private Button btnSig;

    @FXML
    private Button btnatras;

    @FXML
    private TextArea mostrartxt;
     @FXML
    private TextField nDemandatxt;

    @FXML
    private TextField nSuministrotxt;

   
    

    @FXML
    void Resolver(ActionEvent event) {
        int nSuminis = Integer.parseInt(nSuministrotxt.getText());
        int ndeman = Integer.parseInt(nDemandatxt.getText());
    String suministros [] = Suministrostxt.getText().split(",");
    int ofertas [] = new int [suministros.length];
    for (int i = 0; i < suministros.length; i++){
        ofertas [i] = Integer.parseInt(suministros[i]);
    }
    String demandas [] = Demandastxt.getText().split(",");
    int demand [] = new int [demandas.length];
    for (int i = 0; i < demandas.length; i++){
     demand [i] = Integer.parseInt(demandas[i]);
    }
    String Cos [] = Costostxt.getText().split(",");
    int Costos [][] = new int [ofertas.length][demand.length];
    int lugar = 0;
    for (int i = 0; i < Costos.length; i++){
        for (int j = 0; j < Costos[i].length; j++){
           Costos [i][j] = Integer.parseInt(Cos[lugar]);
        }
    }
    BackendCM p1 = new BackendCM(ndeman, nSuminis);
//    p1.resolverCostoMinimo(ofertas, demand, Costos);
    mostrartxt.setText(p1.convertirArregloABlString(p1.resolverCostoMinimo(ofertas, demand, Costos)));
    
    }

    @FXML
    void atras(ActionEvent event) {
try {
            MPTDFX.showView("Vista1.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void limpiar(ActionEvent event) {
    nSuministrotxt.setText("");
    nDemandatxt.setText("");
    Demandastxt.setText("");
    Suministrostxt.setText("");
    Costostxt.setText("");
    mostrartxt.setText("");
   }

    @FXML
    void siguiente(ActionEvent event) {
        try {
            MPTDFX.showView("Vista3.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
