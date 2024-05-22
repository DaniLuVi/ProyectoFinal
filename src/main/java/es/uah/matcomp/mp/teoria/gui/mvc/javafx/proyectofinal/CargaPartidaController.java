package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Celda;
import clases_a_utilizar_de_datos.Tablero;
import clases_a_utilizar_de_datos.TableroASerializar;
import com.google.gson.Gson;
import estructuras_de_datos_implementadas.listaSimple.ListaSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CargaPartidaController implements Initializable {
    private Stage scene;
    @FXML
    private MenuButton menuButton = new MenuButton();
    private int num_partidas = 0;
    private TableroProperties tableroProperties = new TableroProperties();
    public int getNum_partidas() {      // + num_partidas +

        log.info("Se obtiene el número de partidas que hay guardadas");

        if (cargarObjetoDesdeArchivo("DatosCargaPartida" + num_partidas + ".json", ParametrosModelo.class) != null) {
            num_partidas++;
        }

        log.info("Se retornan el número de partidas guardadas que hay");

        return num_partidas;
    }
    private static final Logger log = LogManager.getLogger(CargaPartidaController.class);
    @FXML
    protected void onCargaPartida() {

        log.info("Arranque de la ventana del tablero de juego");

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tablero-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
            stage.setTitle("Tablero de juego");
            stage.setScene(scene);
            TableroController p = fxmlLoader.getController();

            Tablero tab = cargarObjetoDesdeArchivo("DatosCargaPartida0.json", Tablero.class);
            tableroProperties.setOriginal(tab);
            tableroProperties.original.ArreglarDatosACargar();
            p.CargaDatosUsuario(tableroProperties.original.parametrosModeloProperties);
            p.CargarDatosTablero(tableroProperties);
            p.cargarTableroGuardado();

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

            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");

            e.printStackTrace();
        }

    }
    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) {

        log.info("Proceso para cargar datos desde un fichero al programa");

        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El proceso de carga de datos desde un fichero ha sido realizado");

            return gson.fromJson(reader, clase);

        } catch (IOException e) {

            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");

            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        log.info("Se ejecuta el controlador para la carga de partida.");
        int valor = getNum_partidas();
        for (int i = 0; i < valor; i++) {

            MenuItem menuItem = new MenuItem("Partida" + num_partidas);

            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    onCargaPartida();
                }
            });
            menuButton.setText("Partidas guardadas");
            menuButton.getItems().add(menuItem);
        }

        log.info("Enviando traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        log.info("El controlador para la ventana de carga de partida se ha ejecutado correctamente");

    }
    public void setStage(Stage s) {
        this.scene = s;
    }
}
