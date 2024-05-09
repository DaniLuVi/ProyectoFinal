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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementosCasillaController {
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
    protected StringProperty texto1 = new SimpleStringProperty("MenuButton");
    protected StringProperty texto2 = new SimpleStringProperty("MenuButton");
    protected StringProperty texto3 = new SimpleStringProperty("MenuButton");
    protected StringProperty texto4 = new SimpleStringProperty("MenuButton");
    protected StringProperty texto5 = new SimpleStringProperty("MenuButton");
    protected StringProperty texto6 = new SimpleStringProperty("MenuButton");
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
                texto1.set("Básico");
                TipoBasico individuo = new TipoBasico();
                celda.addIndividuo(individuo);
            }
        });
        Normal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto2.set("Normal");
                TipoNormal individuo = new TipoNormal();
                celda.addIndividuo(individuo);
            }
        });
        Avanzado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto3.set("Avanzado");
                TipoAvanzado individuo = new TipoAvanzado();
                celda.addIndividuo(individuo);
            }
        });
        this.updateTextoMenu();
    }
    public void modificarTextoEntornos() {
        Agua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto2.set("Agua");
            }
        });
        Comida.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto2.set("Comida");
            }
        });
        Montaña.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto2.set("Montaña");
            }
        });
        Biblioteca.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto2.set("Biblioteca");
            }
        });
        Tesoro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto2.set("Tesoro");
            }
        });
        Pozo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto2.set("Pozo");
            }
        });
    }

    public void initialize(int i, int j) {

        log.info("Se ejecuta el controlador de los elementos de una casilla.");

        Celda celda = new Celda(i, j);
        this.updateTextoMenu();
    }

    protected void updateTextoMenu() {
        Individuo1.textProperty().bind(texto1);
        Individuo2.textProperty().bind(texto1);
        Individuo3.textProperty().bind(texto1);
        Recurso1.textProperty().bind(texto2);
        Recurso2.textProperty().bind(texto2);
        Recurso3.textProperty().bind(texto2);
    }
    public void setStage(Stage s) {
        this.scene = s;
    }

}
