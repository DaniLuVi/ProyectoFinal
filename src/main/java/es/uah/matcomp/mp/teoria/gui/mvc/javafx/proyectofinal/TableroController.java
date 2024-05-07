package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Celda;
import clases_a_utilizar_de_datos.Individuo;
import com.google.gson.Gson;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ElementoLDE;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TableroController {
    private Stage scene;
    private ParameterController model = new ParameterController();
    @FXML
    private GridPane tableroDeJuego;
    private ParametrosModelo parametrosModelo = new ParametrosModelo(0, 0, 0, 0, 0, 0);
    private ParametrosModeloProperties parametrosModeloProperties = new ParametrosModeloProperties(parametrosModelo);
    private static final Logger log = LogManager.getLogger(TableroController.class);
    @FXML
    protected void onCasillaVerDatos() {

        log.info("Arranque de la ventana para ver los datos de la casilla");

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("elementos-casillas-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 604, 400);
            stage.setTitle("Vista de los elementos de una casilla");
            stage.setScene(scene);
            ElementosCasillaController p = fxmlLoader.getController();

            p.setStage(stage);
            stage.show();

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El arranque de la ventana para ver los datos de la casilla ha sido completado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void BucleDeControl() {

    }
    @FXML
    protected void play() {

    }
    @FXML
    protected void pause() {

    }
    @FXML
    protected void guardarDatos() {      // hacer de una manera que sea facil cargar despues

        log.info("Se guardan los datos del modelo en un fichero JSON");

        ListaDoblementeEnlazada a = new ListaDoblementeEnlazada<>();
        ElementoLDE filas = new ElementoLDE<>(parametrosModeloProperties.original.getFilas());
        ElementoLDE columnas = new ElementoLDE<>(parametrosModeloProperties.original.getColumnas());
        ElementoLDE vidas = new ElementoLDE<>(parametrosModeloProperties.original.getVidas());
        ElementoLDE reproduccion = new ElementoLDE<>(parametrosModeloProperties.original.getReproduccion());
        ElementoLDE clonado = new ElementoLDE<>(parametrosModeloProperties.original.getClonado());
        ElementoLDE v = new ElementoLDE<>(parametrosModeloProperties.original.getV());
        a.add(filas);
        a.add(columnas);
        a.add(vidas);
        a.add(reproduccion);
        a.add(clonado);
        a.add(v);

        ParameterController parameterController = new ParameterController(a);

        ParameterController datos = parameterController;

        String rutaArchivo = "DatosCargaPartida.json";

        guardarDatosPartida(rutaArchivo, datos);

        log.info("Los datos se han guardado al fichero");
        log.info("Arranque de la ventana para cerrar el programa");

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pantalla-cerrar-tras-guardado.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 545, 281);
            stage.setTitle("Salir del programa");
            stage.setScene(scene);
            PantallaCerrarTrasGuardado p = fxmlLoader.getController();

            p.setStage(stage);
            stage.show();

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El arranque de la ventana para el cerrado del programa se ha completado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static <T> void guardarDatosPartida(String rutaArchivo, T objeto) {

        log.info("Proceso para guardar los datos del programa a un fichero");

        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El proceso para guardar los datos del programa al fichero se ha realizado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(int k, int x) {
        log.info("Se ejecuta el controlador del tablero.\n");
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= x; j++) {
                Button casilla = new Button();
                Celda celda = new Celda(i, j);
                casilla.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        onCasillaVerDatos();
                    }
                });
                casilla.setMinSize(300 * 2/ k, 400 / x);
                casilla.setMaxSize(300 * 2/ k, 400 / x);
                casilla.setStyle("-fx-border-color: black; -fx-text-alignment: center");
                tableroDeJuego.add(casilla, i, j);
            }
        }

        log.info("Enviando traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        log.info("El controlador de la ventana del tablero de juego se ha ejecutado correctamente");

    }
    public void CargaDatosUsuario(ParametrosModeloProperties parametrosData) {
        this.parametrosModeloProperties = parametrosData;

    }
    public void setStage(Stage s) {
        this.scene = s;
    }

}
