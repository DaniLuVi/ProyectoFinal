package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import com.google.gson.Gson;
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
    private MenuButton partidas;
    private int num_partidas;
    public int getNum_partidas() {
        cargarObjetoDesdeArchivo("DatosCargaPartida.json", CargaPartidaController.class);

        return 0;
    }
    private static final Logger log = LogManager.getLogger(CargaPartidaController.class);
    @FXML
    protected void onCargaPartida() {

        log.info("Arranque de la ventana de la carga de una partida preguardada");

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tablero-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
            stage.setTitle("Tablero de juego");
            stage.setScene(scene);
            TableroController p = fxmlLoader.getController();

            String rutaArchivo = "DatosCargaPartida.json";

            TableroController tableroController = cargarObjetoDesdeArchivo(rutaArchivo, TableroController.class);
            p.setStage(stage);
            stage.show();

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El arranque de la ventana de la carga de una partida ha sido completado.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Se ejecuta el controlador para la carga de partida.");
        for (int i = 1; i <= num_partidas; i++) {
            MenuButton partida = new MenuButton("Partida guardada " + i);
        }
    }
    public void setStage(Stage s) {
        this.scene = s;
    }
}
