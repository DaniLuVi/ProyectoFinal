package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TableroController implements Initializable {
    private Stage scene;
    @FXML
    protected void play() {

    }
    @FXML
    protected void pause() {

    }
    @FXML
    protected void guardarDatosPartida() {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Se ejecuta el controlador del tablero.\n");

    }
    public void setStage(Stage s) {
        this.scene = s;
    }

}
