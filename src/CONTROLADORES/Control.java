package CONTROLADORES;

import Modelo.BackendEN;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mptdfx.MPTDFX;

public class Control {

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnLeer;

    @FXML
    private Button btnLimpiar;
    
    @FXML
    private Button btnsiguiente;

    @FXML
    private TextField txtCostos;

    @FXML
    private TextField txtDemandas;

    @FXML
    private TextField txtSuministro;

    @FXML
    private TextField txtnDemanda;

    @FXML
    private TextField txtnSuministro;

    @FXML
    private TextArea txtpantalla;

    @FXML
    void Borrar(ActionEvent event) {
        txtCostos.setText("");
        txtDemandas.setText("");
        txtSuministro.setText("");
        txtnDemanda.setText("");
        txtnSuministro.setText("");

    }

    @FXML
    void Leer(ActionEvent event) {
        int nSuministro = Integer.parseInt(txtnSuministro.getText());
        int nDemanda = Integer.parseInt(txtnDemanda.getText());
        String OfertaS[] = new String[nSuministro];
        OfertaS = (txtSuministro.getText().split(","));
        int Oferta[] = new int[OfertaS.length];
        for (int i = 0; i < OfertaS.length; i++) {
            Oferta[i] = Integer.parseInt(OfertaS[i].trim());
        }
        String DemandasS[] = new String[nDemanda];
        DemandasS = (txtDemandas.getText().split(","));
        int Demanda[] = new int[DemandasS.length];
        for (int i = 0; i < DemandasS.length; i++) {
            Demanda[i] = Integer.parseInt(DemandasS[i].trim());
        }
        int Costos[][] = new int [nSuministro+1][nDemanda+1];
        String[] cosST= (txtCostos.getText().split(","));
        int lugar = 0;
        for (int i = 0; i < nSuministro; i++) {
            for (int j = 0; j < nDemanda; j++) {
                Costos[i][j] = Integer.parseInt(cosST[lugar]);
                if (lugar != ((nDemanda * nSuministro)-1)){
                lugar++;
            }
                
            }
        }
        if (lugar == nDemanda * nSuministro){
            lugar--;
            }
        
        BackendEN p1 = new BackendEN(nSuministro,nDemanda);
        p1.setS(Oferta);
        p1.setD(Demanda);
        p1.setCostos(Costos);
        p1.resolver();
        txtpantalla.setText(p1.imprimir());
    }

    @FXML
    void limpiar(ActionEvent event) {
        txtpantalla.setText("");
    }
    @FXML
    void siguiente(ActionEvent event) {
       try {
            MPTDFX.showView("Vista2.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
