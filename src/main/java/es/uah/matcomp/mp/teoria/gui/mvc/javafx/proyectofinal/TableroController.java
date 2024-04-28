package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TableroController {
    private Stage scene;
    // creo que se va a hacer utilizando de alguna manera el model, para conseguir lo del tablero
    private ParameterController model = new ParameterController();
    @FXML
    private GridPane tableroDeJuego;
    private ParametrosModelo parametrosModelo = new ParametrosModelo(2, 2, 2 ,2 , 2, 2);
    private ParametrosModeloProperties parametrosModeloProperties = new ParametrosModeloProperties(parametrosModelo);
    @FXML
    protected void onCasillaVerDatos() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("elementos-casillas-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 220, 220);
            stage.setTitle("Vista de los elementos de una casilla");
            stage.setScene(scene);
            ElementosCasillaController p = fxmlLoader.getController();

            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void play() {

    }
    @FXML
    protected void pause() {

    }
    @FXML
    protected void guardarDatosPartida() {

    }

    public void initialize(int k, int x) {
        System.out.println("Se ejecuta el controlador del tablero.\n");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < x; j++) {
                Button casilla = new Button("Celda" + i + "," + j);
                casilla.setMinSize(30, 30);
                casilla.setStyle("-fx-border-color: black; -fx-text-alignment: center");
                tableroDeJuego.add(casilla, i, j);
            }
        }
    }
    public void CargaDatosUsuario(ParametrosModeloProperties parametrosData) {
        this.parametrosModeloProperties = parametrosData;

    }
    public void setStage(Stage s) {
        this.scene = s;
    }

}
