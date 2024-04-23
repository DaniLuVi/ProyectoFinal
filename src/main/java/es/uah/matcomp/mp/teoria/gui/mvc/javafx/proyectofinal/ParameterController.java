package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ParameterController implements Initializable {
    @FXML
    private Slider sliderFilas;
    @FXML
    private Slider sliderColumnas;
    @FXML
    private Slider sliderVidas;
    @FXML
    private Slider sliderReproduccion;
    @FXML
    private Slider sliderClonado;
    @FXML
    private Slider sliderV;
    @FXML
    private Label labelValorFilas;
    @FXML
    private Label labelValorColumnas;
    @FXML
    private Label labelValorVidas;
    @FXML
    private Label labelValorReproduccion;
    @FXML
    private Label labelValorClonado;
    @FXML
    private Label labelValorV;
    private ParametrosModeloProperties model;
    private Stage scene;
    protected IntegerProperty valorFilas = new SimpleIntegerProperty(0);
    @FXML
    protected void onBotonIniciarClick() {
        model.commit();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tablero-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 620, 440);
            stage.setTitle("Tablero de juego");
            stage.setScene(scene);
            TableroController p = fxmlLoader.getController();

            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // crear la nueva pantalla en la que se crea el tablero
    }
    @FXML
    protected void reiniciarValores() {
        model.rollback();
    }
    @FXML
    protected void cerrarVentana() {
        scene.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Se ejecuta el controlador de parámetros.\n");
        if (model != null) {
            this.updateGUIwithModel();
        }
    }
    protected void updateGUIwithModel() {
        sliderFilas.valueProperty().bindBidirectional(model.filasProperty());
        sliderColumnas.valueProperty().bindBidirectional(model.columnasProperty());
        sliderVidas.valueProperty().bindBidirectional(model.vidasProperty());
        sliderReproduccion.valueProperty().bindBidirectional(model.reproduccionProperty());
        sliderClonado.valueProperty().bindBidirectional(model.clonadoProperty());
        sliderV.valueProperty().bindBidirectional(model.VProperty());
       // labelValorFilas.textProperty().bindBidirectional();

    }
    public void CargarDatosUsuario(ParametrosModeloProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }
    public void setStage(Stage s) {
        this.scene = s;
    }
}
