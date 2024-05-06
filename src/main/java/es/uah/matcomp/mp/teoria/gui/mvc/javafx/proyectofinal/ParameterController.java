package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

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
    private ListaDoblementeEnlazada listaDoblementeEnlazada;
    private ParametrosModeloProperties model;
    private Stage scene;
    protected IntegerProperty valorFilas = new SimpleIntegerProperty(0);
    protected IntegerProperty valorColumnas = new SimpleIntegerProperty(0);
    protected IntegerProperty valorVidas = new SimpleIntegerProperty(0);
    protected IntegerProperty valorReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty valorClonado = new SimpleIntegerProperty(0);
    protected IntegerProperty valorV = new SimpleIntegerProperty(0);
    private ParametrosModelo parametrosModelo = new ParametrosModelo(0, 0, 0, 0, 0, 0);
    private ParametrosModeloProperties parametrosModeloProperties = new ParametrosModeloProperties(parametrosModelo);

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
            p.CargaDatosUsuario(parametrosModeloProperties);
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Se ejecuta el controlador de parámetros.\n");
        if (model != null) {
            this.updateGUIwithModel();
        }
    }
    protected void updateGUIwithModel() {
        sliderFilas.valueProperty().bindBidirectional(valorFilas);
        sliderColumnas.valueProperty().bindBidirectional(valorColumnas);
        sliderVidas.valueProperty().bindBidirectional(valorVidas);
        sliderReproduccion.valueProperty().bindBidirectional(valorReproduccion);
        sliderClonado.valueProperty().bindBidirectional(valorClonado);
        sliderV.valueProperty().bindBidirectional(valorV);
        labelValorFilas.textProperty().bind(valorFilas.asString());
        labelValorColumnas.textProperty().bind(valorColumnas.asString());
        labelValorVidas.textProperty().bind(valorVidas.asString());
        labelValorReproduccion.textProperty().bind(valorReproduccion.asString());
        labelValorClonado.textProperty().bind(valorClonado.asString());
        labelValorV.textProperty().bind(valorV.asString());
        model.setFilas(valorFilas);
        model.setColumnas(valorColumnas);
        model.setVidas(valorVidas);
        model.setReproduccion(valorReproduccion);
        model.setClonado(valorClonado);
        model.setV(valorV);
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
