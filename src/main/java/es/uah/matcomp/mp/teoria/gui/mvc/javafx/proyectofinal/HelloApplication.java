package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final Logger log = LogManager.getLogger(HelloApplication.class);
    @Override
    public void start(Stage stage) throws IOException {

        log.info("Arranque de inicio de la aplicación con su ventana principal(menú) de inicio.");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 640);
        stage.setTitle("Pantalla incial");
        stage.setScene(scene);
        stage.show();

        log.info("Enviando traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        log.info("El arranque del menú ha sido completado.");

    }

    public static void main(String[] args) {
        launch();
    }
}

