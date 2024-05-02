package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

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

public class TableroController {
    private Stage scene;
    private ParameterController model = new ParameterController();
    @FXML
    private GridPane tableroDeJuego;
    private ParametrosModelo parametrosModelo = new ParametrosModelo(2, 2, 2 ,2 , 2, 2);
    private ParametrosModeloProperties parametrosModeloProperties = new ParametrosModeloProperties(parametrosModelo);
    @FXML
    protected EventHandler<ActionEvent> onCasillaVerDatos() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("elementos-casillas-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 220, 220);
            stage.setTitle("Vista de los elementos de una casilla");
            stage.setScene(scene);
            ElementosCasillaController p = fxmlLoader.getController();
            Button button = new Button();
            button.setOnAction(onCasillaVerDatos());
            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @FXML
    protected void play() {

    }
    @FXML
    protected void pause() {

    }
    @FXML
    protected void guardarDatos() {
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
    }


    public static <T> void guardarDatosPartida(String rutaArchivo, T objeto) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(int k, int x) {
        System.out.println("Se ejecuta el controlador del tablero.\n");
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= x; j++) {
                Button casilla = new Button("Celda" + i + "," + j);
                casilla.setStyle("-fx-border-color: black; -fx-text-alignment: center");
                casilla.onActionProperty();
                tableroDeJuego.add(casilla, i, j);
            }
        }
    }
    public void CargaDatosUsuario(ParametrosModeloProperties parametrosData) {
        this.parametrosModeloProperties = parametrosData;

    }
    public void setStage(Stage s) {
        this.scene = s;
    }

}
