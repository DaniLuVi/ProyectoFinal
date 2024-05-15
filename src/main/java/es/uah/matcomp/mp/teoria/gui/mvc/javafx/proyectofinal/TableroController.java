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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.abs;

public class TableroController {
    ListaSimple<ListaSimple<Celda>> listaX;
    private ListaDoblementeEnlazada<Celda> listaCeldas = new ListaDoblementeEnlazada<>();
    private int num_individuos = 0;
    private int cant_entornos = 0;
    private int num_turnos = 0;
    private int maximo;
    private int max_columnas;
    private Stage scene;
    @FXML
    private GridPane tableroDeJuego;
    @FXML
    private Button pausa;
    @FXML
    private Label turnos;
    private Tablero modelo = new Tablero();
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
        if (getNum_individuos() > 1) {
            vida_individuo();
            tiempo_recurso();
            movimiento_individuo();
            mejoras();
            hay_reproduccion();
            hay_clonacion();
            hay_individuos_a_desaparecer();
            habra_nuevos_recursos();
            num_turnos++;
            turnos.setText("Turnos: " + num_turnos);
            if (hacer_pausa() == true) {
                pause();
            }
        } else {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("simulacion-terminada.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 550, 300);
                stage.setTitle("Simulación terminada");
                stage.setScene(scene);
                PantallaFinalizar p = fxmlLoader.getController();

                p.setStage(stage);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void vida_individuo() {
        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 2) {
                    int vidas_actuales_1 = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas();
                    int vidas_actuales_2 = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().setVidas(vidas_actuales_2 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().setVidas(vidas_actuales_1 - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(0);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(1);
                    }
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 3) {
                    int vidas_actuales_1 = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas();
                    int vidas_actuales_2 = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas();
                    int vidas_actuales_3 = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato().getVidas();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().setVidas(vidas_actuales_2 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().setVidas(vidas_actuales_1 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato().setVidas(vidas_actuales_3 - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(0);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(1);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato().getVidas() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(2);
                    }
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 1) {
                    int vidas_actuales = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().setVidas(vidas_actuales - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(0);
                    }
                }
            }
        }
    }
    private void tiempo_recurso() {
        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 2) {
                    int tiempo_actual_1 = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion();
                    int tiempo_actual_2 = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().getTiempo_aparicion();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().setTiempo_aparicion(tiempo_actual_1 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().setTiempo_aparicion(tiempo_actual_2 - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(0);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().getTiempo_aparicion() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(1);
                    }
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 3) {
                    int tiempo_actual_1 = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion();
                    int tiempo_actual_2 = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().getTiempo_aparicion();
                    int tiempo_actual_3 = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(2).getDato().getTiempo_aparicion();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().setTiempo_aparicion(tiempo_actual_1 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().setTiempo_aparicion(tiempo_actual_2 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(2).getDato().setTiempo_aparicion(tiempo_actual_3 - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(0);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().getTiempo_aparicion() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(1);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(2).getDato().getTiempo_aparicion() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(2);
                    }
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 1) {
                    int tiempo_actual = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().setTiempo_aparicion(tiempo_actual - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion() == 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(0);
                    }
                }
            }
        }
    }
    private void movimiento_individuo() throws ArrayIndexOutOfBoundsException{
        try{
            for (int i = 0; i < maximo; i++) {
                for (int j = 0; j < max_columnas; j++) {
                    for (int k = 0; k < listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos(); k++) {
                        if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoBasico == true) {
                            Random randomBasico = new Random();
                            int opcion = randomBasico.nextInt(1, 4);
                            Individuo individuo_cambiar = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato();
                            if (opcion == 1) {
                                listaX.getElemento(i-1).getData().getElemento(j).getData().getListaIndividuos().add(individuo_cambiar);
                                listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(k);
                            } else if (opcion == 2) {
                                listaX.getElemento(i+1).getData().getElemento(j).getData().getListaIndividuos().add(individuo_cambiar);
                                listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(k);
                            } else if (opcion == 3) {
                                listaX.getElemento(i).getData().getElemento(j-1).getData().getListaIndividuos().add(individuo_cambiar);
                                listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(k);
                            } else if (opcion == 4) {
                                listaX.getElemento(i).getData().getElemento(j+1).getData().getListaIndividuos().add(individuo_cambiar);
                                listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(k);
                            }
                      //  } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoNormal == true) {
                      //      Random randomNormal = new Random();
                        //    int opcion = randomNormal.nextInt(0, cant_entornos);

                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoAvanzado == true) {
                            //este tipo de movimiento lo tengo que implementar a partir de un grafo
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }
    private void mejoras() {
        for (int i = 0; i < maximo; i++) {
            int k = 0;
            for (int j = 0; j < max_columnas; j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos() != null) {
                    for (int l = 0; l < listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos(); l++) {
                        if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato() instanceof Agua == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato().modificarIndividuo(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato() instanceof Comida == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato().modificarIndividuo(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato() instanceof Montaña == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato().modificarIndividuo(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato() instanceof Biblioteca == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato().modificarIndividuo(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato() instanceof Pozo == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato().modificarIndividuo(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato() instanceof Tesoro == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(l).getDato().modificarIndividuo(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                        }
                    }
                }
                k++;
            }
        }
    }
    private void hay_reproduccion() {
        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 2) {
                    int reproduccion_primero = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getReproduccion();
                    int reproduccion_segundo = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getReproduccion();
                    if (reproduccion_primero + reproduccion_segundo >= 100) {
                        if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoBasico == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoBasico == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoBasico());
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoNormal == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoNormal == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoNormal());
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoAvanzado == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoAvanzado == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado());
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoBasico == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoNormal == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoNormal());
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoBasico == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoAvanzado == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado());
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoNormal == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoBasico == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoNormal());
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoNormal == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoAvanzado == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado());
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoAvanzado == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoBasico == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado());
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoAvanzado == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoNormal == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado());
                        }
                    }
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().setReproduccion(reproduccion_segundo - 10);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().setReproduccion(reproduccion_primero - 10);
                }
            }
        }
    }
    private void hay_clonacion() {
        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                for (int k = 0; k < listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos(); k++) {
                    Random num_random = new Random();
                    int valor = num_random.nextInt(0, 100);
                    int pro_clonado = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato().getClonacion();
                    if (valor <= pro_clonado) {
                        if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoBasico == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoNormal == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoAvanzado == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato());
                        }
                    }
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato().setClonacion(pro_clonado - 10);
                }
            }
        }
    }
    private void hay_individuos_a_desaparecer() {
        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
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
        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                for (int k = 0; k < listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos(); k++) {
                    Random random = new Random();
                    int valor = random.nextInt(0, 100);
                    int pro_V = listaX.getElemento(i).getData().getElemento(j).getData().getV();
                    if (valor == pro_V) {
                        if ((abs(pro_V - model.original.agua) <= abs(pro_V - model.original.comida)) && ((abs(pro_V - model.original.agua) <= abs(pro_V - model.original.montaña))) && ((abs(pro_V - model.original.agua) <= abs(pro_V - model.original.biblioteca))) && ((abs(pro_V - model.original.agua) <= abs(pro_V - model.original.pozo))) && ((abs(pro_V - model.original.agua) <= abs(pro_V - model.original.tesoro)))) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().add(new Agua(3, model.original.agua));
                        } else if ((abs(pro_V - model.original.comida) <= abs(pro_V - model.original.agua)) && ((abs(pro_V - model.original.comida) <= abs(pro_V - model.original.montaña))) && ((abs(pro_V - model.original.comida) <= abs(pro_V - model.original.biblioteca))) && ((abs(pro_V - model.original.comida) <= abs(pro_V - model.original.pozo))) && ((abs(pro_V - model.original.comida) <= abs(pro_V - model.original.tesoro)))) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().add(new Comida(3, model.original.comida));
                        } else if ((abs(pro_V - model.original.montaña) <= abs(pro_V - model.original.agua)) && ((abs(pro_V - model.original.montaña) <= abs(pro_V - model.original.comida))) && ((abs(pro_V - model.original.montaña) <= abs(pro_V - model.original.biblioteca))) && ((abs(pro_V - model.original.montaña) <= abs(pro_V - model.original.pozo))) && ((abs(pro_V - model.original.montaña) <= abs(pro_V - model.original.tesoro)))) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().add(new Montaña(3, model.original.montaña));
                        } else if ((abs(pro_V - model.original.biblioteca) <= abs(pro_V - model.original.agua)) && ((abs(pro_V - model.original.biblioteca) <= abs(pro_V - model.original.comida))) && ((abs(pro_V - model.original.biblioteca) <= abs(pro_V - model.original.montaña))) && ((abs(pro_V - model.original.biblioteca) <= abs(pro_V - model.original.pozo))) && ((abs(pro_V - model.original.biblioteca) <= abs(pro_V - model.original.tesoro)))) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().add(new Biblioteca(3, model.original.biblioteca));
                        } else if ((abs(pro_V - model.original.pozo) <= abs(pro_V - model.original.agua)) && ((abs(pro_V - model.original.pozo) <= abs(pro_V - model.original.comida))) && ((abs(pro_V - model.original.pozo) <= abs(pro_V - model.original.montaña))) && ((abs(pro_V - model.original.pozo) <= abs(pro_V - model.original.biblioteca))) && ((abs(pro_V - model.original.pozo) <= abs(pro_V - model.original.tesoro)))) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().add(new Pozo(3, model.original.pozo));
                        } else if ((abs(pro_V - model.original.tesoro) <= abs(pro_V - model.original.agua)) && ((abs(pro_V - model.original.tesoro) <= abs(pro_V - model.original.comida))) && ((abs(pro_V - model.original.tesoro) <= abs(pro_V - model.original.montaña))) && ((abs(pro_V - model.original.tesoro) <= abs(pro_V - model.original.biblioteca))) && ((abs(pro_V - model.original.tesoro) <= abs(pro_V - model.original.pozo)))) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().add(new Tesoro(3, model.original.tesoro));
                        }
                    }
                }
            }
        }
    }
    private int getNum_individuos() {    // va a haber que mejorarlo un poco
        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 1) {
                    num_individuos++;
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 2) {
                    num_individuos = num_individuos + 2;
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 3) {
                    num_individuos = num_individuos + 3;
                }
            }
        }
        return num_individuos;
    }
    private int getCant_entornos() {
        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 1) {
                    cant_entornos++;
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 2) {
                    cant_entornos = cant_entornos + 2;
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 3) {
                    cant_entornos = cant_entornos + 3;
                }
            }
        }
        return cant_entornos;
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
        /* a.add(num_turnos);
        a.add(listaX.getNumeroElementos());
        a.add(filas.getDato());
        a.add(columnas.getDato());
        a.add(vidas.getDato());
        a.add(reproduccion.getDato());
        a.add(clonado.getDato()); /*
        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < listaX.getElemento(i).getData().getNumeroElementos(); j++) {
                a.add(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getPrimero().getDato());
                a.add(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato());
                a.add(listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato());
                a.add(listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getPrimero().getDato());
                a.add(listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato());
                a.add(listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(2).getDato());
            }
        }
        a.add(v);
        for(int i = 0; i < listaCeldas.getNumeroElementos(); i++) {
            a.add(listaCeldas.getElemento(i).getDato());
        }
        o tambien hacer esta otra forma
        for(Celda celda: listaXCeldas) {
            a.add(celda);
        }

        for (int j = 0; j < maximo; j++) {
            int pos = 0;
            while ((listaX.getElemento(j).getData().getElemento(pos).getData().getListaIndividuos() != null) || (listaX.getElemento(j).getData().getElemento(pos).getData().getListaEntornos() != null)) {
                a.add(listaX.getElemento(j).getData().getElemento(pos).getData().getListaIndividuos().getElemento(0).getDato() + "," + listaX.getElemento(j).getData().getElemento(pos).getData().getListaIndividuos().getElemento(1).getDato() + "," + listaX.getElemento(j).getData().getElemento(pos).getData().getListaIndividuos().getElemento(2).getDato());
                a.add(listaX.getElemento(j).getData().getElemento(pos).getData().getListaEntornos().getPrimero().getDato() + "," + listaX.getElemento(j).getData().getElemento(pos).getData().getListaEntornos().getElemento(1).getDato() + "," + listaX.getElemento(j).getData().getElemento(pos).getData().getListaEntornos().getElemento(2).getDato());
                pos++;
            }
        }   (aquí tengo distintas cosas que he probado para el guardado de datos que no me han funcionado de momento)      */


        ParametrosModelo parameterController = new ParametrosModelo(filas.getDato(), columnas.getDato(), vidas.getDato(), reproduccion.getDato(), clonado.getDato(), v.getDato(), model.original.agua, model.original.comida, model.original.montaña, model.original.biblioteca, model.original.pozo, model.original.tesoro);

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

        //modelo.construir_tablero(k, x);
        listaX = new ListaSimple<>(k);
        maximo = k;
        for (int i = 1; i <= k; i++) {
            ListaSimple<Celda> listaY = new ListaSimple<>(x);
            max_columnas = x;
            for (int j = 1; j <= x; j++) {

                Button casilla = new Button();
                Celda celda = new Celda(i, j);
                celda.setFilas(i);
                celda.setColumnas(j);
                ListaSimple<Integer> a = new ListaSimple<>(2);
                a.add(celda.getFila());
                a.insert(celda.getColumna(), 1);
                celda.setCoordenadas(a);
                casilla.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        modelCelda.setOriginal(celda);
                        onCasillaVerDatos(celda);
                        celda.setDataGuardada(modelCelda);
                        casilla.setText(celda.getListaIndividuos().getNumeroElementos() + "\n" + celda.getListaEntornos().getNumeroElementos());
                    }
                });
                listaY.insert(celda, j-1);
                listaCeldas.add(modelCelda.original);
                casilla.setMinSize(300 * 2/ k, 400 / x);
                casilla.setMaxSize(300 * 2/ k, 400 / x);
                casilla.setStyle("-fx-border-color: black; -fx-text-alignment: center");
                casilla.setText(celda.getListaIndividuos().getNumeroElementos() + "\n" + celda.getListaEntornos().getNumeroElementos());
                tableroDeJuego.add(casilla, i, j);
            }
            listaX.insert(listaY, i-1);
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
