package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementosCasillaController implements Initializable {
    private Stage scene;
    @FXML
    private Label individuo1;
    @FXML
    private Label individuo2;
    @FXML
    private Label individuo3;
    @FXML
    private Label recurso1;
    @FXML
    private Label recurso2;
    @FXML
    private Label recurso3;
    @FXML
    private MenuButton Individuo1;
    @FXML
    private MenuButton Individuo2;
    @FXML
    private MenuButton Individuo3;
    @FXML
    private MenuButton Recurso1;
    @FXML
    private MenuButton Recurso2;
    @FXML
    private MenuButton Recurso3;
    protected StringProperty texto = new SimpleStringProperty("MenuButton");
    private static final Logger log = LogManager.getLogger(ElementosCasillaController.class);
    public void onOk() {

        log.info("Evento para cerrar la ventana de los elementos de una casilla");

        scene.close();

        log.info("La ventana de los elementos de una casilla se ha cerrado correctamente");

    }
    public void modificarTexto() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Se ejecuta el controlador de los elementos de una casilla.");
    }
    public void setStage(Stage s) {
        this.scene = s;
    }
    protected String getTexto() {
        return texto.toString();
    }

}
