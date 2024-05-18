package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PantallaFinalizar {
    private Stage stage;
    private static final Logger log = LogManager.getLogger(PantallaFinalizar.class);
    @FXML
    protected void continuar() {

        log.info("Arranque de la ventana para ver el árbol genealógico del individuo final");

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("arbol-genealogico-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 1500, 1000);
            stage.setTitle("Arbol genealógico");
            stage.setScene(scene);
            ArbolGenealogicoView p = fxmlLoader.getController();

            p.setStage(stage);
            stage.show();

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El arranque de la ventana para ver el árbol genealógico se ha completado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

