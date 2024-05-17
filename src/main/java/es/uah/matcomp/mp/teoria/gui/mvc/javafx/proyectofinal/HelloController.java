package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;


import clases_a_utilizar_de_datos.Individuo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloController implements Initializable {

    private ParametrosModelo parametrosData = new ParametrosModelo(3, 3, 0, 0, 5, 50, 50, 0, 0,50, 50, 50, 50, 50, 50);
    private ParametrosModeloProperties modeloGUIparametros = new ParametrosModeloProperties(parametrosData);
    private static final Logger log = LogManager.getLogger(HelloController.class);
    @FXML
    protected void onMiBotonNuevaVentanaParametros() {

        log.info("Arranque de la ventana de parámetros");

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("parametros-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Establezca parametros: ");
            stage.setScene(scene);
            ParameterController p = fxmlLoader.getController();
            p.CargarDatosUsuario(this.modeloGUIparametros);
            p.setStage(stage);
            stage.show();

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El arranque de la ventana de parámetros ha sido completado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onMiBotonNuevaVentanaCargadoPartida() {

        log.info("Arranque de la ventana de cargado de partidas");

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("carga-partida-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Cargar partida.");
            stage.setScene(scene);
            CargaPartidaController p = fxmlLoader.getController();
            p.setStage(stage);
            stage.show();

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El arranque de la ventana de cargado de partidas ha sido completado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        log.info("Inicio de la ejecución del controlador de la ventana de inicio\n");

    }
}