package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementosCasillaController implements Initializable {
    private Stage scene;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Se ejecuta el controlador de los elementos de una casilla.");

    }
    public void setStage(Stage s) {
        this.scene = s;
    }


}
