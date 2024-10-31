package CONTROLADORES;

import Modelo.BackendVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mptdfx.MPTDFX;

public class Control3 {

    @FXML
    private TextField Demandastxt;

    @FXML
    private TextField Ofertastxt;

    @FXML
    private Button btnanterior;

    @FXML
    private Button btnlimpiar;

    @FXML
    private Button btnresolver;

    @FXML
    private Button btnsig;

    @FXML
    private TextField costostxt;

    @FXML
    private TextArea mostrartxt;

    @FXML
    private TextField nDemandastxt;

    @FXML
    private TextField nSuministrotxt;

    @FXML
    void atras(ActionEvent event) {
        try {
            MPTDFX.showView("Vista2.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void limpiar(ActionEvent event) {
        Demandastxt.setText("");
        Ofertastxt.setText("");
        costostxt.setText("");
        mostrartxt.setText("");
        nDemandastxt.setText("");
        nSuministrotxt.setText("");

    }

    @FXML
    void resolver(ActionEvent event) {
        int nOferta = Integer.parseInt(nSuministrotxt.getText());
        int ndemanda = Integer.parseInt(nDemandastxt.getText());
        String [] oferta = Ofertastxt.getText().split(",");
        int [] ofertas = new int [oferta.length];
        for (int i = 0; i < ofertas.length; i++) {
           ofertas [i] = Integer.parseInt(oferta[i]);
        }
        String [] dem = Demandastxt.getText().split(",");
        int [] demandas = new int [dem.length];
        for (int i = 0; i < demandas.length; i++) {
           demandas [i] = Integer.parseInt(dem[i]);
        }
        String C[]= costostxt.getText().split(",");
        int costos [][] = new int [nOferta][ndemanda];
        int lugar = 0;
        for (int i = 0; i < costos.length; i++) {
            for (int j = 0; j < costos[i].length; j++) {
              costos [i][j] = Integer.parseInt(C[lugar]);
              lugar++;
            }
        }
        BackendVO p1 = new BackendVO(nOferta, ndemanda);
        p1.setS(ofertas);
        p1.setD(demandas);
        p1.setC(costos);
        p1.resolverVogel();
        mostrartxt.setText(p1.Resultado());
        
    }

    @FXML
    void siguiente(ActionEvent event) {

    }

}

