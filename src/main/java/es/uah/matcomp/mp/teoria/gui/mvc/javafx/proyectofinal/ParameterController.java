package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
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
    private ParametrosModeloProperties model;
    private Stage scene;
    @FXML
    protected void onBotonIniciarClick() {
        model.commit();
        // crear la nueva pantalla en la que se crea el tablero
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Se ejecuta el controlador de parámetros.\n");
        if (model != null)
            this.updateGUIwithModel();
    }
    protected void updateGUIwithModel() {
        sliderFilas.valueProperty().bindBidirectional(model.filasProperty());
        sliderColumnas.valueProperty().bindBidirectional(model.columnasProperty());
        sliderVidas.valueProperty().bindBidirectional(model.vidasProperty());
        sliderReproduccion.valueProperty().bindBidirectional(model.reproduccionProperty());
        sliderClonado.valueProperty().bindBidirectional(model.clonadoProperty());
    }
    public void CargarDatosUsuario(ParametrosModeloProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }
    public void setStage(Stage s) {
        this.scene = s;
    }

}
