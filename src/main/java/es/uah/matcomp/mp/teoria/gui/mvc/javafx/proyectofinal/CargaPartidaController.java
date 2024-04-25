package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CargaPartidaController implements Initializable {
    private Stage scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Se ejecuta el controlador para la carga de partida.");

    }
    public void setStage(Stage s) {
        this.scene = s;
    }
}
