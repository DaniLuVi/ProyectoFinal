package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Individuo;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParameterController implements Initializable {
    @FXML
    private Slider sliderFilas;
    @FXML
    private Slider sliderColumnas;
    @FXML
    private Slider sliderVidas;
    @FXML
    private Slider sliderReproduccion;
    @FXML
    private Slider sliderClonado;
    @FXML
    private Slider sliderV;
    @FXML
    private Slider sliderAgua;
    @FXML
    private Slider sliderComida;
    @FXML
    private Slider sliderMontaña;
    @FXML
    private Slider sliderBiblioteca;
    @FXML
    private Slider sliderPozo;
    @FXML
    private Slider sliderTesoro;
    @FXML
    private Label labelValorFilas;
    @FXML
    private Label labelValorColumnas;
    @FXML
    private Label labelValorVidas;
    @FXML
    private Label labelValorReproduccion;
    @FXML
    private Label labelValorClonado;
    @FXML
    private Label labelValorV;
    @FXML
    private Label labelProbAgua;
    @FXML
    private Label labelProbComida;
    @FXML
    private Label labelProbMontaña;
    @FXML
    private Label labelProbBiblioteca;
    @FXML
    private Label labelProbPozo;
    @FXML
    private Label labelProbTesoro;
    private ListaDoblementeEnlazada listaDoblementeEnlazada;
    private ParametrosModeloProperties model;
    private Stage scene;
    protected IntegerProperty valorFilas = new SimpleIntegerProperty(0);
    protected IntegerProperty valorColumnas = new SimpleIntegerProperty(0);
    protected IntegerProperty valorVidas = new SimpleIntegerProperty(0);
    protected IntegerProperty valorReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty valorClonado = new SimpleIntegerProperty(0);
    protected IntegerProperty valorV = new SimpleIntegerProperty(0);
    protected IntegerProperty prob_agua = new SimpleIntegerProperty(0);
    protected IntegerProperty prob_comida = new SimpleIntegerProperty(0);
    protected IntegerProperty prob_montaña = new SimpleIntegerProperty(0);
    protected IntegerProperty prob_biblioteca = new SimpleIntegerProperty(0);
    protected IntegerProperty prob_pozo = new SimpleIntegerProperty(0);
    protected IntegerProperty prob_tesoro = new SimpleIntegerProperty(0);

    public ParameterController() {
    }

    public ParameterController(ListaDoblementeEnlazada listaDoblementeEnlazada) {
        this.listaDoblementeEnlazada = listaDoblementeEnlazada;
    }
    private static final Logger log = LogManager.getLogger(ParameterController.class);
    @FXML
    protected void onBotonIniciarClick() {

        log.info("Arranque de la ventana del tablero de juego");

        model.commit();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tablero-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 1550, 1000);
            stage.setTitle("Tablero de juego");
            stage.setScene(scene);
            TableroController p = fxmlLoader.getController();
            p.CargaDatosUsuario(model);
            model.commit();
            int i = 0;
            int j = 0;
            while (i < model.original.getFilas())
                i++;
            while (j < model.original.getColumnas())
                j++;
            p.initialize(i, j);
            p.setStage(stage);
            stage.show();

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El arranque de la ventana del tablero de juego ha sido completado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void reiniciarValores() {
        model.rollback();

        log.info("Se han reiniciado correctamente los valores de los parámetros del juego");
    }
    @FXML
    protected void cerrarVentana() {
        scene.close();

        log.info("Se ha cerrado la ventana de los parámetros");
    }
    @FXML
    protected void guardarDatos() {

        log.info("Se van a guardar los datos de los parámetros");

        model.commit();
        TableroController p = new TableroController();
        p.CargaDatosUsuario(model);

        log.info("Se han guardado los datos para cargar el tablero");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        log.info("Se ejecuta el controlador de la ventana de los parámetros.\n");

        if (model != null) {
            this.updateGUIwithModel();
        }

        log.info("Enviando traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        log.info("El controlador de la ventana de parámetros se ha ejecutado correctamente");

    }
    protected void updateGUIwithModel() {
        sliderFilas.valueProperty().bindBidirectional(valorFilas);
        sliderColumnas.valueProperty().bindBidirectional(valorColumnas);
        sliderVidas.valueProperty().bindBidirectional(valorVidas);
        sliderReproduccion.valueProperty().bindBidirectional(valorReproduccion);
        sliderClonado.valueProperty().bindBidirectional(valorClonado);
        sliderV.valueProperty().bindBidirectional(valorV);
        sliderAgua.valueProperty().bindBidirectional(prob_agua);
        sliderComida.valueProperty().bindBidirectional(prob_comida);
        sliderMontaña.valueProperty().bindBidirectional(prob_montaña);
        sliderBiblioteca.valueProperty().bindBidirectional(prob_biblioteca);
        sliderPozo.valueProperty().bindBidirectional(prob_pozo);
        sliderTesoro.valueProperty().bindBidirectional(prob_tesoro);
        labelValorFilas.textProperty().bind(valorFilas.asString());
        labelValorColumnas.textProperty().bind(valorColumnas.asString());
        labelValorVidas.textProperty().bind(valorVidas.asString());
        labelValorReproduccion.textProperty().bind(valorReproduccion.asString());
        labelValorClonado.textProperty().bind(valorClonado.asString());
        labelValorV.textProperty().bind(valorV.asString());
        labelProbAgua.textProperty().bind(prob_agua.asString());
        labelProbComida.textProperty().bind(prob_comida.asString());
        labelProbMontaña.textProperty().bind(prob_montaña.asString());
        labelProbBiblioteca.textProperty().bind(prob_biblioteca.asString());
        labelProbPozo.textProperty().bind(prob_pozo.asString());
        labelProbTesoro.textProperty().bind(prob_tesoro.asString());
        model.setFilas(valorFilas);
        model.setColumnas(valorColumnas);
        model.setVidas(valorVidas);
        model.setReproduccion(valorReproduccion);
        model.setClonado(valorClonado);
        model.setV(valorV);
        model.setAgua(prob_agua);
        model.setComida(prob_comida);
        model.setMontaña(prob_montaña);
        model.setBiblioteca(prob_biblioteca);
        model.setPozo(prob_pozo);
        model.setTesoro(prob_tesoro);
        model.commit();
    }
    public void CargarDatosUsuario(ParametrosModeloProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }
    public void setStage(Stage s) {
        this.scene = s;
    }
}
