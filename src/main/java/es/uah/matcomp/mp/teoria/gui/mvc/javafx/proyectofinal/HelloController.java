package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onMiBotonNuevaVentanaParametros() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("parametros-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 620, 440);
            stage.setTitle("Establezca parametros: ");
            stage.setScene(scene);
            ParameterController p = fxmlLoader.getController();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onInicalizarAMiNombreBtnClick() {
        welcomeText.setText("Daniel Luque Villa");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}