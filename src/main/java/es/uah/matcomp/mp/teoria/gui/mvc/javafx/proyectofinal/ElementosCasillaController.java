package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementosCasillaController implements Initializable{
    private CeldaProperties modelCelda;
    private TableroProperties tablero;
    private Stage scene;
    @FXML
    private Label individuo1;
    @FXML
    private Label individuo2;
    @FXML
    private Label individuo3;
    @FXML
    private Label recurso1;
    @FXML
    private Label recurso2;
    @FXML
    private Label recurso3;

    @FXML
    private Button Básico;
    @FXML
    private Button Normal;
    @FXML
    private Button Avanzado;
    @FXML
    private Button Agua;
    @FXML
    private Button Comida;
    @FXML
    private Button Montaña;
    @FXML
    private Button Biblioteca;
    @FXML
    private Button Tesoro;
    @FXML
    private Button Pozo;
    protected StringProperty texto1 = new SimpleStringProperty("--");
    protected StringProperty texto2 = new SimpleStringProperty("--");
    protected StringProperty texto3 = new SimpleStringProperty("--");
    protected StringProperty texto4 = new SimpleStringProperty("--");
    protected StringProperty texto5 = new SimpleStringProperty("--");
    protected StringProperty texto6 = new SimpleStringProperty("--");
    private ParametrosModeloProperties modelParametros;
    private static final Logger log = LogManager.getLogger(ElementosCasillaController.class);
    public void onOk() {

        log.info("Evento para cerrar la ventana de los elementos de una casilla");

        modelCelda.setV(modelParametros.original.V);
        modelCelda.commit();
        tablero.commit();
        scene.close();

        log.info("La ventana de los elementos de una casilla se ha cerrado correctamente");

    }
    @FXML
    protected void ponerBasico() throws Exception{

        log.info("Se agrega un individuo tipo básico a la celda asignada");

        try {
            TipoBasico individuo = new TipoBasico(tablero.original.ids, tablero.original.num_turnos, modelParametros.original.vidas, modelParametros.original.reproduccion, modelParametros.original.clonado, modelParametros.original.turno_individuo);
            if (individuo1.getText() == "--") {
                texto1.set("Tipo Individuo: Básico");
                modelCelda.original.addIndividuo(individuo);
            } else if (individuo2.getText() == "--") {
                texto2.set("Tipo Individuo: Básico");
                modelCelda.original.addIndividuo(individuo);
            } else if (individuo3.getText() == "--") {
                texto3.set("Tipo Individuo: Básico");
                modelCelda.original.addIndividuo(individuo);
            }
            modelCelda.commit();
            tablero.commit();

            log.info("El individuo de tipo básico se ha agregado");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    protected void ponerNormal() throws Exception{

        log.info("Se agrega un individuo tipo normal a la celda asignada");

        try {
            TipoNormal individuo = new TipoNormal(tablero.original.ids, tablero.original.num_turnos, modelParametros.original.vidas, modelParametros.original.reproduccion, modelParametros.original.clonado, modelParametros.original.turno_individuo);
            if (individuo1.getText() == "--") {
                texto1.set("Tipo Individuo: Normal");
                modelCelda.original.addIndividuo(individuo);
            } else if (individuo2.getText() == "--") {
                texto2.set("Tipo Individuo: Normal");
                modelCelda.original.addIndividuo(individuo);
            } else if (individuo3.getText() == "--") {
                texto3.set("Tipo Individuo: Normal");
                modelCelda.original.addIndividuo(individuo);
            }
            modelCelda.commit();
            tablero.commit();

            log.info("El individuo de tipo normal se ha agregado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerAvanzado() throws Exception{

        log.info("Se agrega un individuo tipo avanzado a la celda asignada");

        try {
            TipoAvanzado individuo = new TipoAvanzado(tablero.original.ids, tablero.original.num_turnos, modelParametros.original.vidas, modelParametros.original.reproduccion, modelParametros.original.clonado, modelParametros.original.turno_individuo);
            if (individuo1.getText() == "--") {
                texto1.set("Tipo Individuo: Avanzado");
                modelCelda.original.addIndividuo(individuo);
            } else if (individuo2.getText() == "--") {
                texto2.set("Tipo Individuo: Avanzado");
                modelCelda.original.addIndividuo(individuo);
            } else if (individuo3.getText() == "--") {
                texto3.set("Tipo Individuo: Avanzado");
                modelCelda.original.addIndividuo(individuo);
            }
            modelCelda.commit();
            tablero.commit();

            log.info("El individuo de tipo avanzado se ha agregado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerAgua() throws Exception{

        log.info("Se agrega un recurso tipo agua a la celda asignada");

        try {
            Agua entorno = new Agua(3, modelParametros.original.agua);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Agua");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Agua");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Agua");
                modelCelda.original.addEntorno(entorno);
            }
            modelCelda.commit();
            tablero.commit();

            log.info("El recurso de tipo agua se ha agregado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerComida() throws Exception{

        log.info("Se agrega un recurso tipo comida a la celda asignada");

        try {
            Comida entorno = new Comida(3, modelParametros.original.comida);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Comida");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Comida");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Comida");
                modelCelda.original.addEntorno(entorno);
            }
            modelCelda.commit();
            tablero.commit();

            log.info("El recurso de tipo comida se ha agregado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerMontaña() throws Exception{

        log.info("Se agrega un recurso tipo montaña a la celda asignada");

        try {
            Montaña entorno = new Montaña(3, modelParametros.original.montaña);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Montaña");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Montaña");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Montaña");
                modelCelda.original.addEntorno(entorno);
            }
            modelCelda.commit();
            tablero.commit();

            log.info("El recurso de tipo montaña se ha agregado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerBiblioteca() throws Exception{

        log.info("Se agrega un recurso tipo biblioteca a la celda asignada");

        try {
            Biblioteca entorno = new Biblioteca(3, modelParametros.original.biblioteca);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Biblioteca");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Biblioteca");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Biblioteca");
                modelCelda.original.addEntorno(entorno);
            }
            modelCelda.commit();
            tablero.commit();

            log.info("El recurso de tipo biblioteca se ha agregado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerTesoro() throws Exception{

        log.info("Se agrega un recurso tipo tesoro a la celda asignada");

        try {
            Tesoro entorno = new Tesoro(3, modelParametros.original.tesoro);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Tesoro");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Tesoro");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Tesoro");
                modelCelda.original.addEntorno(entorno);
            }
            modelCelda.commit();
            tablero.commit();

            log.info("El recurso de tipo tesoro se ha agregado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void ponerPozo() throws Exception{

        log.info("Se agrega un recurso tipo pozo a la celda asignada");

        try {
            Pozo entorno = new Pozo(3, modelParametros.original.pozo);
            if (recurso1.getText() == "--") {
                texto4.set("Entorno: Pozo");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso2.getText() == "--") {
                texto5.set("Entorno: Pozo");
                modelCelda.original.addEntorno(entorno);
            } else if (recurso3.getText() == "--") {
                texto6.set("Entorno: Pozo");
                modelCelda.original.addEntorno(entorno);
            }
            modelCelda.commit();
            tablero.commit();

            log.info("El recurso de tipo pozo se ha agregado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        log.info("Se ejecuta el controlador de los elementos de una casilla.");

        this.updateTextoMenu();
    }

    protected void updateTextoMenu() {
        individuo1.textProperty().bind(texto1);
        individuo2.textProperty().bind(texto2);
        individuo3.textProperty().bind(texto3);
        recurso1.textProperty().bind(texto4);
        recurso2.textProperty().bind(texto5);
        recurso3.textProperty().bind(texto6);
    }
    public void setInfo() {
        if (modelCelda.original.getListaIndividuos().getElemento(0) != null) {
            texto1.set(modelCelda.original.getListaIndividuos().getElemento(0).getDato().toString(modelCelda.original.getListaIndividuos().getElemento(0).getDato()));
        }
        if (modelCelda.original.getListaIndividuos().getElemento(1) != null) {
            texto2.set(modelCelda.original.getListaIndividuos().getElemento(1).getDato().toString(modelCelda.original.getListaIndividuos().getElemento(1).getDato()));
        }
        if (modelCelda.original.getListaIndividuos().getElemento(2) != null) {
            texto3.set(modelCelda.original.getListaIndividuos().getElemento(2).getDato().toString(modelCelda.original.getListaIndividuos().getElemento(2).getDato()));
        }
        if (modelCelda.original.getListaEntornos().getElemento(0) != null) {
            texto4.set(modelCelda.original.getListaEntornos().getElemento(0).getDato().toString(modelCelda.original.getListaEntornos().getElemento(0).getDato()));
        }
        if (modelCelda.original.getListaEntornos().getElemento(1) != null) {
            texto5.set(modelCelda.original.getListaEntornos().getElemento(1).getDato().toString(modelCelda.original.getListaEntornos().getElemento(1).getDato()));
        }
        if (modelCelda.original.getListaEntornos().getElemento(2) != null) {
            texto6.set(modelCelda.original.getListaEntornos().getElemento(2).getDato().toString(modelCelda.original.getListaEntornos().getElemento(2).getDato()));
        }
    }
    public void setStage(Stage s) {
        this.scene = s;
    }
    public void CargaDatosCelda(CeldaProperties model) {
        this.modelCelda = model;
        modelCelda.commit();
    }
    public void CargaDatosUsuario(ParametrosModeloProperties parametrosModelo) {
        this.modelParametros = parametrosModelo;
        modelParametros.commit();
    }
    public void CargaDatosTablero(TableroProperties modeloTablero) {
        this.tablero = modeloTablero;
        tablero.commit();
    }
}
