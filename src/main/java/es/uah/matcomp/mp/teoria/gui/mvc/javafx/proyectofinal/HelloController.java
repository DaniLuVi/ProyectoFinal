package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private ParametrosModelo parametrosData = new ParametrosModelo(0, 0, 0, 0, 0, 0);
    private ParametrosModeloProperties modeloGUIparametros = new ParametrosModeloProperties(parametrosData);

    @FXML
    protected void onMiBotonNuevaVentanaParametros() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("parametros-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Establezca parametros: ");
            stage.setScene(scene);
            ParameterController p = fxmlLoader.getController();
            p.CargarDatosUsuario(this.modeloGUIparametros);
            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onMiBotonNuevaVentanaCargadoPartida() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("carga-partida-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Cargar partida.");
            stage.setScene(scene);
            CargaPartidaController p = fxmlLoader.getController();

            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Inicio de la ejecución del controlador\n");
    }
}