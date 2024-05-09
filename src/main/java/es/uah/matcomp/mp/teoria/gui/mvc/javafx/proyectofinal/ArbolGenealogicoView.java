package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArbolGenealogicoView {
    private Stage stage;
    private static final Logger log = LogManager.getLogger(ArbolGenealogicoView.class);

    @FXML
    protected void terminar() {

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

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
