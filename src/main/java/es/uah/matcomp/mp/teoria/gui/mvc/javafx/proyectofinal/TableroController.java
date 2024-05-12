package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.*;
import com.google.gson.Gson;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ElementoLDE;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;
import estructuras_de_datos_implementadas.listaSimple.ListaSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TableroController {
    ListaSimple<ListaSimple<Celda>> listaX;
    private ListaDoblementeEnlazada<Celda> listaCeldas = new ListaDoblementeEnlazada<>();
    private int num_individuos = 0;
    private Stage scene;
    @FXML
    private GridPane tableroDeJuego;
    @FXML
    private Button pausa;
    private DatosTablero modelo;
    private CeldaProperties modelCelda = new CeldaProperties();
    private ParametrosModeloProperties model;
    private static final Logger log = LogManager.getLogger(TableroController.class);
    @FXML
    protected void onCasillaVerDatos(Celda celda) {

        log.info("Arranque de la ventana para ver los datos de la casilla");

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("elementos-casillas-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 704, 600);
            stage.setTitle("Vista de los elementos de una casilla");
            stage.setScene(scene);

            ElementosCasillaController p = fxmlLoader.getController();
            p.CargaDatosTablero(model);
            p.CargaDatosCelda(modelCelda);
            p.setInfo();
            p.setStage(stage);
            stage.show();

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El arranque de la ventana para ver los datos de la casilla ha sido completado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void BucleDeControl() {
        while (getNum_individuos() > 1) {
            vida_individuo();
            tiempo_recurso();
            movimiento_individuo();
            mejoras();
            hay_reproduccion();
            hay_clonacion();
            hay_individuos_a_desaparecer();
            habra_nuevos_recursos();
            if (hacer_pausa() == true) {
                pause();
            }
        }
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("simulacion-terminada.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 400, 300);
            stage.setTitle("Simulación terminada");
            stage.setScene(scene);
            PantallaFinalizar p = fxmlLoader.getController();

            p.setStage(stage);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void vida_individuo() {
        for (int i = 0; i < listaX.getElemento(i).getData().getNumeroElementos(); i++) {
            int k = 0;
            for (int j = 0; j < listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos(); j++) {
                int vidas_actuales = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato().getVidas();
                listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato().setVidas(vidas_actuales - 1);
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato().getVidas() == 0) {
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(k);
                }
                k++;
            }
        }
    }
    private void tiempo_recurso() {
        for (int i = 0; i < listaX.getElemento(i).getData().getNumeroElementos(); i++) {
            int k = 0;
            for (int j = 0; j < listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos(); j++) {
                int tiempo_actual = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(k).getDato().getTiempo_aparicion();
                listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(k).getDato().setTiempo_aparicion(tiempo_actual - 1);
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(k).getDato().getTiempo_aparicion() == 0) {
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(k);
                }
                k++;
            }
        }
    }
    private void movimiento_individuo() {
        for (int i = 0; i < listaX.getElemento(i).getData().getNumeroElementos(); i++) {
            int k = 0;
            for (int j = 0; j < listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos(); j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoBasico) {

                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoNormal) {

                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoAvanzado) {

                }
                k++;
            }
        }
    }
    private void mejoras() {
        for (int i = 0; i < listaX.getElemento(i).getData().getNumeroElementos(); i++) {
            int k = 0;
            for (int j = 0; j < listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos(); j++) {


                k++;
            }
        }
    }
    private void hay_reproduccion() {
        for (int i = 0; i < listaX.getElemento(i).getData().getNumeroElementos(); i++) {
            for (int j = 0; j < listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos(); j++) {
                if (listaCeldas.getElemento(i).getDato().getListaIndividuos().getNumeroElementos() == 2) {
                    int reproduccion_primero = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getReproduccion();
                    int reproduccion_segundo = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getReproduccion();
                    if (reproduccion_primero + reproduccion_segundo >= 100) {
                        if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoBasico == listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoBasico) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoBasico());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoNormal == listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoNormal) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoNormal());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoAvanzado == listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoAvanzado) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoBasico != listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoNormal) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoNormal());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoBasico != listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoAvanzado) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoNormal != listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoBasico) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoNormal());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoNormal != listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoAvanzado) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoAvanzado != listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoBasico) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoAvanzado != listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoNormal) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado());
                        }
                    }
                    listaCeldas.getElemento(i).getDato().getListaIndividuos().getElemento(1).getDato().setReproduccion(reproduccion_segundo - 10);
                    listaCeldas.getElemento(i).getDato().getListaIndividuos().getElemento(0).getDato().setReproduccion(reproduccion_primero - 10);
                }
            }
        }
    }
    private void hay_clonacion() {
        for (int i = 0; i < listaX.getElemento(i).getData().getNumeroElementos(); i++) {
            int k = 0;
            for (int j = 0; j < listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos(); j++) {
                Random num_random = new Random();
                int valor = num_random.nextInt(0, 100);
                int pro_clonado = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato().getClonacion();
                if (valor <= pro_clonado) {
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoBasico) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                    } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoNormal) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                    } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoAvanzado) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                    }
                }
                listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato().setClonacion(pro_clonado - 10);

                k++;
            }
        }
    }
    private void hay_individuos_a_desaparecer() {
        for (int i = 0; i < listaX.getElemento(i).getData().getNumeroElementos(); i++) {
            for (int j = 0; j < listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos(); j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() > 2) {
                    if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas() > listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas()) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas() > listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato().getVidas())) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(0);
                    } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas() > listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas()) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas() > listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato().getVidas())) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(1);
                    } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato().getVidas() > listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas()) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato().getVidas() > listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas())) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(2);
                    }
                }
            }
        }
    }
    private void habra_nuevos_recursos() {
        for (int i = 0; i < listaCeldas.getNumeroElementos(); i++) {
            int k = 0;
            for (int j = 0; j < listaCeldas.getElemento(i).getDato().getListaEntornos().getNumeroElementos(); j++) {
                Random random = new Random();
                int valor = random.nextInt(0, 100);
                int pro_V = listaCeldas.getElemento(i).getDato().getListaEntornos().getElemento(k).getDato().getV();
                if (valor == pro_V) {
                    // no se como se decide que recurso tengo que añadir
                }
                k++;
            }
        }
    }
    private int getNum_individuos() {
        for (int i = 0; i < listaX.getElemento(i).getData().getNumeroElementos(); i++) {
            for (int j = 0; j < listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos(); j++) {
                num_individuos++;
            }
        }
        return num_individuos;
    }
    @FXML
    protected void play() {
        BucleDeControl();
    }
    private boolean hacer_pausa() {
        if (pausa.isPressed()) {
            return true;
        } else{
            return false;
        }
    }
    @FXML
    protected void pause() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("parametros-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Establezca parametros: ");
            stage.setScene(scene);
            ParameterController p = fxmlLoader.getController();
            p.CargarDatosUsuario(this.model);
            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void guardarDatos() {      // hacer de una manera que sea facil cargar despues

        log.info("Se guardan los datos del modelo en un fichero JSON");

        ListaDoblementeEnlazada a = new ListaDoblementeEnlazada<>();
        ElementoLDE<Integer> filas = new ElementoLDE<>(model.original.getFilas());
        ElementoLDE<Integer> columnas = new ElementoLDE<>(model.original.getColumnas());
        ElementoLDE<Integer> vidas = new ElementoLDE<>(model.original.getVidas());
        ElementoLDE<Integer> reproduccion = new ElementoLDE<>(model.original.getReproduccion());
        ElementoLDE<Integer> clonado = new ElementoLDE<>(model.original.getClonado());
        ElementoLDE<Integer> v = new ElementoLDE<>(model.original.getV());
        a.add(filas);
        a.add(columnas);
        a.add(vidas);
        a.add(reproduccion);
        a.add(clonado);
        /*a.add(v);
        for(int i = 0; i < listaCeldas.getNumeroElementos(); i++) {
            a.add(listaCeldas.getElemento(i).getDato());
        }
        o tambien hacer esta otra forma
        for(Celda celda: listaXCeldas) {
            a.add(celda);
        }*/

        ParametrosModelo parameterController = new ParametrosModelo(filas.getDato(), columnas.getDato(), vidas.getDato(), reproduccion.getDato(), clonado.getDato(), v.getDato());

        ParametrosModelo datos = parameterController;

        String rutaArchivo = "DatosCargaPartida.json";
        // va a haber que guardar la informacion entera de la variable: listaX     (creo que se ve a poder hacer creando un método que recorra la lista)
        guardarDatosPartida(rutaArchivo, datos);

        log.info("Los datos se han guardado al fichero");
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


    public static <T> void guardarDatosPartida(String rutaArchivo, T objeto) {

        log.info("Proceso para guardar los datos del programa a un fichero");

        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("El proceso para guardar los datos del programa al fichero se ha realizado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(int k, int x) {

        log.info("Se ejecuta el controlador del tablero.\n");

        listaX = new ListaSimple<>(k);
        for (int i = 1; i <= k; i++) {
            ListaSimple<Celda> listaY = new ListaSimple<>(x);
            for (int j = 1; j <= x; j++) {

                Button casilla = new Button();
                Celda celda = new Celda(i, j);
                listaY.add(celda);
                listaCeldas.add(celda);
                casilla.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        modelCelda.setOriginal(celda);
                        onCasillaVerDatos(celda);
                    }
                });
                casilla.setMinSize(300 * 2/ k, 400 / x);
                casilla.setMaxSize(300 * 2/ k, 400 / x);
                casilla.setStyle("-fx-border-color: black; -fx-text-alignment: center");
                tableroDeJuego.add(casilla, i, j);
            }
            listaX.add(listaY);
        }

        log.info("Enviando traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        log.info("El controlador de la ventana del tablero de juego se ha ejecutado correctamente");

    }
    public void CargaDatosUsuario(ParametrosModeloProperties parametrosData) {
        this.model = parametrosData;
        model.commit();
    }
    public void setStage(Stage s) {
        this.scene = s;
    }

}
