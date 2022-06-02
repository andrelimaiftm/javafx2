package br.edu.iftm.javafx2;

import br.edu.iftm.javafx2.util.Alerts;
import br.edu.iftm.javafx2.util.RestricoesTela;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private TextField txtnumero1;

    @FXML
    private TextField txtnumero2;

    @FXML
    private Button btSoma;

    @FXML
    private Label labelResult;

    @FXML
    private Button btSubtrair;

    @FXML
    public void onBtSomaClick(){
        try {
            Locale.setDefault(Locale.US);
            double numero1 = Double.parseDouble(txtnumero1.getText());
            double numero2 = Double.parseDouble(txtnumero2.getText());
            double resultado = numero1 + numero2;
            labelResult.setText(String.format("%.2f", resultado));
        }catch (NumberFormatException e){
            Alerts.showAlert("Erro", "Erro de Conversão(Parse)",
                    e.getMessage(), Alert.AlertType.ERROR);

        }
    }

    @FXML
    public void onBtSubtrairClick(){
        try {
            Locale.setDefault(Locale.US);
            double numero1 = Double.parseDouble(txtnumero1.getText());
            double numero2 = Double.parseDouble(txtnumero2.getText());
            double resultado = numero1 - numero2;
            labelResult.setText(String.format("%.2f", resultado));
        }catch (NumberFormatException e){
            Alerts.showAlert("Erro", "Erro de Conversão(Parse)",
                    e.getMessage(), Alert.AlertType.ERROR);

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RestricoesTela.setTextFieldDouble(txtnumero1);
        RestricoesTela.setTextFieldMaxLength(txtnumero1, 14);
        RestricoesTela.setTextFieldDouble(txtnumero2);
        RestricoesTela.setTextFieldMaxLength(txtnumero2, 14);
    }
}