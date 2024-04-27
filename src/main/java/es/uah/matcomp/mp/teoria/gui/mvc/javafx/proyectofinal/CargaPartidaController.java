package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CargaPartidaController implements Initializable {
    private Stage scene;
    @FXML
    private MenuButton partidas;
    private int num_partidas;
    public int getNum_partidas() {
        // for (MenuButton boton: ) {}
        return 0;
    }
    public void aparecen_num_partidas_guardadas() {
        for (int i = 0; i < num_partidas; i++) {
            MenuItem partida_guardada = new MenuItem("Partida " + i);
            partidas.getItems();
        }
    }
    @FXML
    protected void onCargaPartida() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tablero-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 620, 460);
            stage.setTitle("Tablero de juego");
            stage.setScene(scene);
            TableroController p = fxmlLoader.getController();

            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Se ejecuta el controlador para la carga de partida.");

    }
    public void setStage(Stage s) {
        this.scene = s;
    }
}
