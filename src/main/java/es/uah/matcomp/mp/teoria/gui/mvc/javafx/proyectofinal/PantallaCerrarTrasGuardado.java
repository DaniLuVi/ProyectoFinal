package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PantallaCerrarTrasGuardado {
    @FXML
    private Button si;
    @FXML
    private Button no;
    private Stage stage;
    private static final Logger log = LogManager.getLogger(PantallaCerrarTrasGuardado.class);

    @FXML
    protected void ButtonSi() {

        log.info("Evento que finaliza el programa");

        stage.close();
        Platform.exit();

        log.info("Enviando traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        log.info("El programa ha finalizado con éxito");

    }
    @FXML
    protected void ButtonNo() {

        log.info("Evento que cierra la ventana para finalizar el programa");

        stage.close();

        log.info("Enviando traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        log.info("La ventana para finalizar el programa se ha cerrado con éxito");

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
