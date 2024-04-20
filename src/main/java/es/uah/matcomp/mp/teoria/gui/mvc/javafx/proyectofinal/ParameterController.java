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
    @FXML
    private TextField textfieldNombre;
    @FXML
    private ParametrosModeloProperties model;
    @FXML
    private Stage scene;
    @FXML
    protected void onBotonInciarClick() {
        model.commit();
    }
    @Override
    public void inicialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Se ejecuta el controlador de parámetros.\n");
        if (model != null)
            this.updateGUIwithModel();
    }
    protected void updateGUIwithModel() {

    }
    public void CargarDatosUsuario(ParametrosModeloProperties parametrosData) {

    }
    public void setStage(Stage s) {
        this.scene = s;
    }

}
