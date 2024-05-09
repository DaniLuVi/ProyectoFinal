package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Celda;
import clases_a_utilizar_de_datos.TipoAvanzado;
import clases_a_utilizar_de_datos.TipoBasico;
import clases_a_utilizar_de_datos.TipoNormal;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementosCasillaController implements Initializable{
    private Celda celda;
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
    private Button Básico;
    @FXML
    private Button Normal;
    @FXML
    private Button Avanzado;
    @FXML
    private Button Agua;
    @FXML
    private Button Comida;
    @FXML
    private Button Montaña;
    @FXML
    private Button Biblioteca;
    @FXML
    private Button Tesoro;
    @FXML
    private Button Pozo;
    protected StringProperty texto1 = new SimpleStringProperty("--");
    protected StringProperty texto2 = new SimpleStringProperty("--");
    protected StringProperty texto3 = new SimpleStringProperty("--");
    protected StringProperty texto4 = new SimpleStringProperty("--");
    protected StringProperty texto5 = new SimpleStringProperty("--");
    protected StringProperty texto6 = new SimpleStringProperty("--");
    private static final Logger log = LogManager.getLogger(ElementosCasillaController.class);
    public void onOk() {

        log.info("Evento para cerrar la ventana de los elementos de una casilla");

        scene.close();

        log.info("La ventana de los elementos de una casilla se ha cerrado correctamente");

    }
    @FXML
    protected void ponerBasico() {

    }
    @FXML
    protected void ponerNormal() {

    }
    @FXML
    protected void ponerAvanzado() {

    }
    @FXML
    protected void ponerAgua() {

    }
    @FXML
    protected void ponerComida() {

    }
    @FXML
    protected void ponerMontaña() {

    }
    @FXML
    protected void ponerBiblioteca() {

    }
    @FXML
    protected void ponerTesoro() {

    }
    @FXML
    protected void ponerPozo() {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        log.info("Se ejecuta el controlador de los elementos de una casilla.");

        this.updateTextoMenu();
    }

    protected void updateTextoMenu() {
        individuo1.textProperty().bind(texto1);
        individuo2.textProperty().bind(texto2);
        individuo3.textProperty().bind(texto3);
        recurso1.textProperty().bind(texto4);
        recurso2.textProperty().bind(texto5);
        recurso3.textProperty().bind(texto6);
    }
    public void setStage(Stage s) {
        this.scene = s;
    }

}
