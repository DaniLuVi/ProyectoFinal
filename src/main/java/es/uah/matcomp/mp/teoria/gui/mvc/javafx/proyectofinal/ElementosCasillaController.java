package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementosCasillaController implements Initializable{
    private Celda celda = new Celda();
    private Tablero tablero;
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
    private ParametrosModeloProperties model;
    private static final Logger log = LogManager.getLogger(ElementosCasillaController.class);
    public void onOk() {

        log.info("Evento para cerrar la ventana de los elementos de una casilla");

        //tablero
        // conseguir que se guarden los datos al modelo de datos
        scene.close();

        log.info("La ventana de los elementos de una casilla se ha cerrado correctamente");

    }
    @FXML
    protected void ponerBasico() throws Exception{
        try {
            TipoBasico individuo = new TipoBasico(0, 0, model.original.vidas, model.original.reproduccion, model.original.clonado);
            if (individuo1.getText() == "--") {
                texto1.set("Tipo Individuo: Básico");
                celda.addIndividuo(individuo);
            } else if (individuo2.getText() == "--") {
                texto2.set("Tipo Individuo: Básico");
                celda.addIndividuo(individuo);
            } else if (individuo3.getText() == "--") {
                texto3.set("Tipo Individuo: Básico");
                celda.addIndividuo(individuo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    protected void ponerNormal() throws Exception{
        try {
            TipoNormal individuo = new TipoNormal(0, 0, model.original.vidas, model.original.reproduccion, model.original.clonado);
            if (individuo1.getText() == "--") {
                texto1.set("Tipo Individuo: Normal");
                celda.addIndividuo(individuo);
            } else if (individuo2.getText() == "--") {
                texto2.set("Tipo Individuo: Normal");
                celda.addIndividuo(individuo);
            } else if (individuo3.getText() == "--") {
                texto3.set("Tipo Individuo: Normal");
                celda.addIndividuo(individuo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerAvanzado() throws Exception{
        try {
            TipoAvanzado individuo = new TipoAvanzado(0, 0, model.original.vidas, model.original.reproduccion, model.original.clonado);
            if (individuo1.getText() == "--") {
                texto1.set("Tipo Individuo: Avanzado");
                celda.addIndividuo(individuo);
            } else if (individuo2.getText() == "--") {
                texto2.set("Tipo Individuo: Avanzado");
                celda.addIndividuo(individuo);
            } else if (individuo3.getText() == "--") {
                texto3.set("Tipo Individuo: Avanzado");
                celda.addIndividuo(individuo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerAgua() throws Exception{
        try {
            Agua entorno = new Agua(3, model.original.V);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Agua");
                celda.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Agua");
                celda.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Agua");
                celda.addEntorno(entorno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerComida() throws Exception{
        try {
            Comida entorno = new Comida(3, model.original.V);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Comida");
                celda.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Comida");
                celda.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Comida");
                celda.addEntorno(entorno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerMontaña() throws Exception{
        try {
            Montaña entorno = new Montaña(3, model.original.V);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Montaña");
                celda.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Montaña");
                celda.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Montaña");
                celda.addEntorno(entorno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerBiblioteca() throws Exception{
        try {
            Biblioteca entorno = new Biblioteca(3, model.original.V);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Biblioteca");
                celda.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Biblioteca");
                celda.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Biblioteca");
                celda.addEntorno(entorno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerTesoro() throws Exception{
        try {
            Tesoro entorno = new Tesoro(3, model.original.V);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Tesoro");
                celda.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Tesoro");
                celda.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Tesoro");
                celda.addEntorno(entorno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerPozo() throws Exception{
        try {
            Pozo entorno = new Pozo(3, model.original.V);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Pozo");
                celda.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Pozo");
                celda.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Pozo");
                celda.addEntorno(entorno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void CargaDatosCelda(Celda celda) {
        this.celda = celda;
    }
    public void CargaDatosTablero(ParametrosModeloProperties parametrosModelo) {
        this.model = parametrosModelo;
        model.commit();
    }

}
