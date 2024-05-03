package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PantallaCerrarTrasGuardado {
    @FXML
    private Button si;
    @FXML
    private Button no;
    private Stage stage;

    @FXML
    protected void ButtonSi() {
        stage.close();
        Platform.exit();
    }
    @FXML
    protected void ButtonNo() {
        stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
