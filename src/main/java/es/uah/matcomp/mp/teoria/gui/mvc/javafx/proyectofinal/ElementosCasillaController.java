package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
    @FXML
    private MenuItem Básico;
    @FXML
    private MenuItem Normal;
    @FXML
    private MenuItem Avanzado;
    @FXML
    private MenuItem Agua;
    @FXML
    private MenuItem Comida;
    @FXML
    private MenuItem Montaña;
    @FXML
    private MenuItem Biblioteca;
    @FXML
    private MenuItem Tesoro;
    @FXML
    private MenuItem Pozo;
    protected StringProperty texto = new SimpleStringProperty("MenuButton");
    private static final Logger log = LogManager.getLogger(ElementosCasillaController.class);
    public void onOk() {

        log.info("Evento para cerrar la ventana de los elementos de una casilla");

        scene.close();

        log.info("La ventana de los elementos de una casilla se ha cerrado correctamente");

    }
    public void modificarTextoIndividuos() {

        Básico.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto.set("Básico");
            }
        });
        Normal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Individuo1.setText("Normal");
            }
        });
        Avanzado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Individuo1.setText("Avanzado");
            }
        });
        this.updateTextoMenu();
    }
    public void modificarTextoEntornos() {
        Agua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Recurso1.setText("Agua");
            }
        });
        Comida.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Recurso1.setText("Comida");
            }
        });
        Montaña.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Recurso1.setText("Montaña");
            }
        });
        Biblioteca.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Recurso1.setText("Biblioteca");
            }
        });
        Tesoro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Recurso1.setText("Tesoro");
            }
        });
        Pozo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Recurso1.setText("Pozo");
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Se ejecuta el controlador de los elementos de una casilla.");
        this.updateTextoMenu();
    }

    protected void updateTextoMenu() {
        Individuo1.textProperty().bind(texto);
        Individuo2.textProperty().bind(texto);
        Individuo3.textProperty().bind(texto);
        Recurso1.textProperty().bind(texto);
        Recurso2.textProperty().bind(texto);
        Recurso3.textProperty().bind(texto);
    }
    public void setStage(Stage s) {
        this.scene = s;
    }
    protected String getTexto() {
        return texto.toString();
    }

}
