package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PantallaFinalizar {
    private Stage stage;

    @FXML
    protected void continuar() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("arbol-genealogico-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 850, 450);
            stage.setTitle("Arbol genealógico");
            stage.setScene(scene);
            ArbolGenealogicoView p = fxmlLoader.getController();

            p.setStage(stage);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

