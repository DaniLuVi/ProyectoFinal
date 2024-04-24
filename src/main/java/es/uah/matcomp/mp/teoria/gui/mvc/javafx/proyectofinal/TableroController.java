package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TableroController implements Initializable {
    private Stage scene;
    private ParametrosModeloProperties model;
    @FXML
    private GridPane tableroDeJuego;
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
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button casilla = new Button("Celda" + i + "," + j);
                casilla.setMinSize(30, 30);
                casilla.setStyle("-fx-border-color: black; -fx-text-alignment: center");
                tableroDeJuego.add(casilla, i, j);
            }
        }
    }
    public void CargaDatosUsuario(ParametrosModeloProperties parametrosModeloProperties) {
        this.model = parametrosModeloProperties;

    }
    public void setStage(Stage s) {
        this.scene = s;
    }

}
