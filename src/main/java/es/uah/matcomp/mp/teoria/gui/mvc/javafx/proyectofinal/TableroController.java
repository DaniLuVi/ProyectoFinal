package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import estructuras_de_datos_implementadas.grafo.ArcoGrafo;
import estructuras_de_datos_implementadas.grafo.Grafo;
import estructuras_de_datos_implementadas.grafo.NodoGrafo;
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
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.abs;

public class TableroController {
    public ListaSimple<ListaSimple<Celda>> listaX;
    private ListaDoblementeEnlazada<Celda> listaCeldasEntornos = new ListaDoblementeEnlazada<>();
    private ListaDoblementeEnlazada<Celda> listaCeldasIndividuos = new ListaDoblementeEnlazada<>();
    private Grafo<Celda> grafoTablero = new Grafo<>();
    private int num_individuos = 0;
    private int cant_entornos = 0;
    public int num_turnos = 0;
    public int ids = 0;
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
    public CeldaProperties modelCelda = new CeldaProperties();
    public ParametrosModeloProperties model;
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

        log.info("Se inicia el bucle de control");

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

            log.info("El bucle de control se ha completado con éxito");

            if (hacer_pausa() == true) {

                log.info("Se hace una pausa");

                pause();
            }
        } else {

            log.info("La simulación termina porque no hay más de 1 individuo vivo, y se abre una nueva ventana");

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("simulacion-terminada.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 550, 300);
                stage.setTitle("Simulación terminada");
                stage.setScene(scene);
                PantallaFinalizar p = fxmlLoader.getController();

                p.setStage(stage);
                stage.show();

                log.info("Enviando traza de ejecución");
                log.debug("Enviado un debug");
                log.info("Enviando un info");
                log.warn("Enviando un aviso");
                log.error("Enviando un error");
                log.fatal("Enviando una explosión fatal");
                log.info("La nueva ventana ha sido creada con éxito");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scene.close();
            }
        }
    }
    private void vida_individuo() {

        log.info("Se actualizan las vidas de todos los individuos vivos de la simulación");

        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 2) {
                    int vidas_actuales_1 = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas();
                    int vidas_actuales_2 = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().setVidas(vidas_actuales_2 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().setVidas(vidas_actuales_1 - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(1);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(0);
                    }
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 3) {
                    int vidas_actuales_1 = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas();
                    int vidas_actuales_2 = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas();
                    int vidas_actuales_3 = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato().getVidas();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().setVidas(vidas_actuales_2 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().setVidas(vidas_actuales_1 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato().setVidas(vidas_actuales_3 - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(2).getDato().getVidas() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(2);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getVidas() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(1);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(0);
                    }
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 1) {
                    int vidas_actuales = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().setVidas(vidas_actuales - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getVidas() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().del(0);
                    }
                }
            }
        }

        log.info("Las vidas de los individuos han sido actualizadas");

    }
    private void tiempo_recurso() {

        log.info("Se actualizan los tiempos de aparición de todos los entornos/recursos que hay presentes en la simulación ");

        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 2) {
                    int tiempo_actual_1 = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion();
                    int tiempo_actual_2 = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().getTiempo_aparicion();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().setTiempo_aparicion(tiempo_actual_1 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().setTiempo_aparicion(tiempo_actual_2 - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().getTiempo_aparicion() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(1);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(0);
                    }
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 3) {
                    int tiempo_actual_1 = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion();
                    int tiempo_actual_2 = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().getTiempo_aparicion();
                    int tiempo_actual_3 = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(2).getDato().getTiempo_aparicion();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().setTiempo_aparicion(tiempo_actual_1 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().setTiempo_aparicion(tiempo_actual_2 - 1);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(2).getDato().setTiempo_aparicion(tiempo_actual_3 - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(2).getDato().getTiempo_aparicion() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(2);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(1).getDato().getTiempo_aparicion() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(1);
                    }
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(0);
                    }
                } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 1) {
                    int tiempo_actual = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion();
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().setTiempo_aparicion(tiempo_actual - 1);
                    if (listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getElemento(0).getDato().getTiempo_aparicion() <= 0) {
                        listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().del(0);
                    }
                }
            }
        }

        log.info("Los tiempos de aparición de los entornos/recursos han sido actualizados");

    }
    private void movimiento_individuo() throws ArrayIndexOutOfBoundsException, IllegalArgumentException{       // tengo que referenciar a los que ya se han movido, para que ya no se vuelvan a mover en ese turno

        log.info("Se realizan los movimientos de todos los individuos que hay en la simualción");

        try{
            for (int i = 0; i < maximo; i++) {
                for (int j = 0; j < max_columnas; j++) {
                    int num_indi_en_casilla = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos();
                    for (int k = 0; k < num_indi_en_casilla; k++) {
                        Individuo individuo_cambiar = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato();
                        if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoBasico == true) && (individuo_cambiar.getTurno_individuo() == model.original.turno_individuo)) {
                            Random randomBasico = new Random();
                            int opcion = randomBasico.nextInt(1, 4);
                            if (opcion == 1) {
                                listaX.getElemento(i-1).getData().getElemento(j).getData().getListaIndividuos().add(individuo_cambiar);
                            } else if (opcion == 2) {
                                listaX.getElemento(i+1).getData().getElemento(j).getData().getListaIndividuos().add(individuo_cambiar);
                            } else if (opcion == 3) {
                                listaX.getElemento(i).getData().getElemento(j-1).getData().getListaIndividuos().add(individuo_cambiar);
                            } else if (opcion == 4) {
                                listaX.getElemento(i).getData().getElemento(j+1).getData().getListaIndividuos().add(individuo_cambiar);
                            }
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).setDato(null);
                            int turno = model.original.turno_individuo + 1;
                            individuo_cambiar.setTurno_individuo(turno++);
                            individuo_cambiar.setGeneracion(num_turnos + 1);
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoNormal == true) && (individuo_cambiar.getTurno_individuo() == model.original.turno_individuo)) {
                            int numero_celdas_con_entornos = getCeldasConRecursos().getNumeroElementos();
                            Random randomNormal = new Random();
                            int opcion = randomNormal.nextInt(0, numero_celdas_con_entornos);
                            ListaSimple<Integer> coordenadas = listaCeldasEntornos.getElemento(opcion).getDato().getCoordenadas();
                            if (abs(i - coordenadas.getElemento(0).getData()) >= abs(j - coordenadas.getElemento(1).getData())) {
                                if (coordenadas.getElemento(1).getData() > j) {
                                    listaX.getElemento(i).getData().getElemento(j + 1).getData().getListaIndividuos().add(individuo_cambiar);
                                } else if (coordenadas.getElemento(1).getData() < j) {
                                    listaX.getElemento(i).getData().getElemento(j - 1).getData().getListaIndividuos().add(individuo_cambiar);
                                }
                            } else if (abs(i - coordenadas.getElemento(0).getData()) < abs(j - coordenadas.getElemento(1).getData())) {
                                if (coordenadas.getElemento(0).getData() > i) {
                                    listaX.getElemento(i + 1).getData().getElemento(j).getData().getListaIndividuos().add(individuo_cambiar);
                                } else if (coordenadas.getElemento(0).getData() < i) {
                                    listaX.getElemento(i - 1).getData().getElemento(j).getData().getListaIndividuos().add(individuo_cambiar);
                                }
                            }
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).setDato(null);
                            int turno = model.original.turno_individuo + 1;
                            individuo_cambiar.setTurno_individuo(turno++);
                            individuo_cambiar.setGeneracion(num_turnos + 1);
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoAvanzado == true) && (individuo_cambiar.getTurno_individuo() == model.original.turno_individuo)) {

                            //este tipo de movimiento lo tengo que implementar a partir de un grafo
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).setDato(null);
                            int turno = model.original.turno_individuo + 1;
                            individuo_cambiar.setTurno_individuo(turno++);
                            individuo_cambiar.setGeneracion(num_turnos + 1);
                        }
                    }
                }
            }

            log.info("Los movimientos de los individuos se han hecho correctamente");

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException a) {
            a.printStackTrace();
        }
    }
    private void mejoras() {     // ver que funciona correctamente

        log.info("Se realizan las mejoras que se puedan a los individuos de la simulación");

        for (int i = 0; i < maximo; i++) {
            int k = 0;
            for (int j = 0; j < max_columnas; j++) {
                if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() != 0) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() != 0)) {
                    int num_elementos = listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos();
                    for (int l = 0; l < num_elementos; l++) {
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

        log.info("Las maejoras correspondientes se han realizado correctamente");
    }
    private void hay_reproduccion() {         // creo que este funciona correctamente, pero asegurarme

        log.info("Se hace (si se puede dar) las reproducciones que tenga que haber entre los individuos de la simulación");

        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 2) {
                    int reproduccion_primero = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().getReproduccion();
                    int reproduccion_segundo = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().getReproduccion();
                    int turno = model.original.turno_individuo + 1;
                    if (reproduccion_primero + reproduccion_segundo >= 100) {
                        if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoBasico == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoBasico == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoBasico(0, num_turnos + 1, model.original.vidas, model.original.reproduccion, model.original.clonado, turno));
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoNormal == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoNormal == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoNormal(0, num_turnos + 1, model.original.vidas, model.original.reproduccion, model.original.clonado, turno));
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoAvanzado == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoAvanzado == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado(0, num_turnos + 1, model.original.vidas, model.original.reproduccion, model.original.clonado, turno));
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoBasico == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoNormal == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoNormal(0, num_turnos + 1, model.original.vidas, model.original.reproduccion, model.original.clonado, turno));
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoBasico == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoAvanzado == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado(0, num_turnos + 1, model.original.vidas, model.original.reproduccion, model.original.clonado, turno));
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoNormal == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoBasico == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoNormal(0, num_turnos + 1, model.original.vidas, model.original.reproduccion, model.original.clonado, turno));
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoNormal == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoAvanzado == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado(0, num_turnos + 1, model.original.vidas, model.original.reproduccion, model.original.clonado, turno));
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoAvanzado == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoBasico == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado(0, num_turnos + 1, model.original.vidas, model.original.reproduccion, model.original.clonado, turno));
                        } else if ((listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato() instanceof TipoAvanzado == true) && (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato() instanceof TipoNormal == true)) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(new TipoAvanzado(0, num_turnos + 1, model.original.vidas, model.original.reproduccion, model.original.clonado, turno));
                        }
                    }
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(1).getDato().setReproduccion(reproduccion_segundo - 10);
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(0).getDato().setReproduccion(reproduccion_primero - 10);
                }
            }
        }

        log.info("La reproducción entre los individuos correspondientes se ha realizado");

    }
    private void hay_clonacion() {     // asegurarme que funcione bien

        log.info("Se comprueba si se puede hacer (y se hace en caso afirmativo) la clonación de individuos de la simulación");

        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                int num_indi_en_casilla = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos();
                for (int k = 0; k < num_indi_en_casilla; k++) {
                    Random num_random = new Random();
                    int valor = num_random.nextInt(0, 100);
                    int pro_clonado = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato().getClonacion();
                    if (valor <= pro_clonado) {
                        Individuo individuo_clonar = listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato();
                        individuo_clonar.setGeneracion(num_turnos + 1);
                        if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoBasico == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(individuo_clonar);
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoNormal == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(individuo_clonar);
                        } else if (listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato() instanceof TipoAvanzado == true) {
                            listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().add(individuo_clonar);
                        }
                    }
                    listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getElemento(k).getDato().setClonacion(pro_clonado - 10);
                }
            }
        }

        log.info("Las clonaciones correspondientes han sido realizadas");

    }
    private void hay_individuos_a_desaparecer() {    // ver que funcione bien

        log.info("Se comprueba si hay individuos que tengan que desaparecer de la simulación");

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

        log.info("Han sido eliminados los individuos correspondientes de la simulación");

    }
    private void habra_nuevos_recursos() {     // ver que funcione bien

        log.info("Se comprueba si en cada casilla deberán aparecer nuevos recursos");

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

        log.info("Se han añadido los nuevos recursos que se requerían");

    }
    private int getNum_individuos() {

        log.info("Devuelve el número de individuos que hay en total en el tablero de juego");

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

        log.info("Devuelve el número de entornos/recursos que hay en total en el tablero de juego");

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
    private ListaDoblementeEnlazada<Celda> getCeldaConIndividuos() {

        log.info("Devuelve la lista de celdas que contienen individuos en su interior");

        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                if (!listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().isVacia()) {
                    listaCeldasIndividuos.add(listaX.getElemento(i).getData().getElemento(j).getData());
                }
            }
        }
        return listaCeldasIndividuos;
    }
    private ListaDoblementeEnlazada<Celda> getCeldasConRecursos() {

        log.info("Devuelve la lisa de celdas que contienen entornos/recursos en su interior");

        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < max_columnas; j++) {
                if (!listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().isVacia()) {
                    listaCeldasEntornos.add(listaX.getElemento(i).getData().getElemento(j).getData());
                }
            }
        }
        return listaCeldasEntornos;
    }
    public int getSiguienteID() {
        int contador = 0;
        if (this.getCeldaConIndividuos().getNumeroElementos() != 0) {
            while (listaCeldasIndividuos.getElemento(contador).getDato() != null) {
                int mayor = 0;
                if (listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getNumeroElementos() == 3) {
                    if ((listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(0).getDato().getId() >= listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(1).getDato().getId()) && (listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(0).getDato().getId() >= listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(2).getDato().getId())) {
                        mayor = listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(0).getDato().getId();
                    } else if ((listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(1).getDato().getId() >= listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(0).getDato().getId()) && (listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(1).getDato().getId() >= listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(2).getDato().getId())) {
                        mayor = listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(1).getDato().getId();
                    } else if ((listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(2).getDato().getId() >= listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(0).getDato().getId()) && (listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(2).getDato().getId() >= listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(1).getDato().getId())) {
                        mayor = listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(2).getDato().getId();
                    }
                    if (mayor > ids) {
                        ids = mayor;
                    }
                } else if (listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getNumeroElementos() == 2) {
                    if (listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(0).getDato().getId() >= listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(1).getDato().getId()) {
                        mayor = listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(0).getDato().getId();
                    } else if (listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(0).getDato().getId() < listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(1).getDato().getId()) {
                        mayor = listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(1).getDato().getId();
                    }
                    if (mayor > ids) {
                        ids = mayor;
                    }
                } else if (listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getNumeroElementos() == 1) {
                    if (listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(0).getDato().getId() > ids) {
                        ids = listaCeldasIndividuos.getElemento(contador).getDato().getListaIndividuos().getElemento(0).getDato().getId();
                    }
                }
                contador++;
            }
        }
        return ids + 1;
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

        log.info("Se abre la ventana de parámetros");

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

            log.info("Enviando traza de ejecución");
            log.debug("Enviado un debug");
            log.info("Enviando un info");
            log.warn("Enviando un aviso");
            log.error("Enviando un error");
            log.fatal("Enviando una explosión fatal");
            log.info("La ventana de ventanas ha sido abierta correctamente");

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
        } (aquí tengo distintas cosas que he probado para el guardado de datos que no me han funcionado de momento)*/

        for (int j = 0; j < maximo; j++) {
            for (int pos = 0; pos < max_columnas; pos++) {
                if ((listaX.getElemento(j).getData().getElemento(pos).getData().getListaIndividuos().getNumeroElementos() != 0) || (listaX.getElemento(j).getData().getElemento(pos).getData().getListaEntornos().getNumeroElementos() != 0)) {
                    ListaDoblementeEnlazada<Individuo> listaindi = listaX.getElemento(j).getData().getElemento(pos).getData().getListaIndividuos();
                    ListaDoblementeEnlazada<Entorno> listaento = listaX.getElemento(j).getData().getElemento(pos).getData().getListaEntornos();
                    if (listaindi.getNumeroElementos() == 3 && listaento.getNumeroElementos() == 3) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaindi.getElemento(1).getDato() + "," + listaindi.getElemento(2).getDato() + "," + listaento.getPrimero().getDato() + "," + listaento.getElemento(1).getDato() + "," + listaento.getElemento(2).getDato());
                    } else if (listaindi.getNumeroElementos() == 3 && listaento.getNumeroElementos() == 2) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaindi.getElemento(1).getDato() + "," + listaindi.getElemento(2).getDato() + "," + listaento.getPrimero().getDato() + "," + listaento.getElemento(1).getDato());
                    } else if (listaindi.getNumeroElementos() == 2 && listaento.getNumeroElementos() == 3) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaindi.getElemento(1).getDato() + "," + listaento.getPrimero().getDato() + "," + listaento.getElemento(1).getDato() + "," + listaento.getElemento(2).getDato());
                    } else if (listaindi.getNumeroElementos() == 2 && listaento.getNumeroElementos() == 2) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaindi.getElemento(1).getDato() + "," + listaento.getPrimero().getDato() + "," + listaento.getElemento(1).getDato());
                    } else if (listaindi.getNumeroElementos() == 3 && listaento.getNumeroElementos() == 1) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaindi.getElemento(1).getDato() + "," + listaindi.getElemento(2).getDato() + "," + listaento.getPrimero().getDato());
                    } else if (listaindi.getNumeroElementos() == 1 && listaento.getNumeroElementos() == 3) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaento.getPrimero().getDato() + "," + listaento.getElemento(1).getDato() + "," + listaento.getElemento(2).getDato());
                    } else if (listaindi.getNumeroElementos() == 2 && listaento.getNumeroElementos() == 1) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaindi.getElemento(1).getDato() + "," + listaento.getPrimero().getDato());
                    } else if (listaindi.getNumeroElementos() == 1 && listaento.getNumeroElementos() == 2) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaento.getPrimero().getDato() + "," + listaento.getElemento(1).getDato());
                    } else if (listaindi.getNumeroElementos() == 1 && listaento.getNumeroElementos() == 1) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaento.getPrimero().getDato());
                    } else if (listaindi.getNumeroElementos() == 3 && listaento.getNumeroElementos() == 0) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaindi.getElemento(1).getDato() + "," + listaindi.getElemento(2).getDato());
                    } else if (listaindi.getNumeroElementos() == 0 && listaento.getNumeroElementos() == 3) {
                        a.add(listaento.getPrimero().getDato() + "," + listaento.getElemento(1).getDato() + "," + listaento.getElemento(2).getDato());
                    } else if (listaindi.getNumeroElementos() == 2 && listaento.getNumeroElementos() == 0) {
                        a.add(listaindi.getPrimero().getDato() + "," + listaindi.getElemento(1).getDato());
                    } else if (listaindi.getNumeroElementos() == 0 && listaento.getNumeroElementos() == 2) {
                        a.add(listaento.getPrimero().getDato() + "," + listaento.getElemento(1).getDato());
                    } else if (listaindi.getNumeroElementos() == 1 && listaento.getNumeroElementos() == 0) {
                        a.add(listaindi.getPrimero().getDato());
                    } else if (listaindi.getNumeroElementos() == 0 && listaento.getNumeroElementos() == 1) {
                        a.add(listaento.getPrimero().getDato());
                    }
                }
            }
        }


        ParametrosModelo parameterController = new ParametrosModelo(filas.getDato(), columnas.getDato(), model.original.id, model.original.generacion, vidas.getDato(), reproduccion.getDato(), clonado.getDato(),model.original.turno_individuo, v.getDato(), model.original.agua, model.original.comida, model.original.montaña, model.original.biblioteca, model.original.pozo, model.original.tesoro);

        ParametrosModelo datos = parameterController;
        Tablero tablero = new Tablero(model, modelCelda, listaX);
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
        model.original.setTurno_individuo(0);
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
            /*    grafoTablero.addNodo(celda);
                if (celda.getFila() > 0 && celda.getColumna() > 0) {
                    Celda celda1 = new Celda(i - 1, j - 1);
                    Celda celda2 = new Celda(i - 1, j);
                    Celda celda3 = new Celda(i - 1, j + 1);
                    Celda celda4 = new Celda(i, j + 1);
                    Celda celda5 = new Celda(i + 1, j + 1);
                    Celda celda6 = new Celda(i + 1, j);
                    Celda celda7 = new Celda(i + 1, j - 1);
                    Celda celda8 = new Celda(i, j - 1);
                    int valor1 = celda.getListaIndividuos().getNumeroElementos() + celda.getListaEntornos().getNumeroElementos() + celda1.getListaIndividuos().getNumeroElementos() + celda1.getListaEntornos().getNumeroElementos();
                    int valor2 = celda.getListaIndividuos().getNumeroElementos() + celda.getListaEntornos().getNumeroElementos() + celda2.getListaIndividuos().getNumeroElementos() + celda2.getListaEntornos().getNumeroElementos();
                    int valor3 = celda.getListaIndividuos().getNumeroElementos() + celda.getListaEntornos().getNumeroElementos() + celda3.getListaIndividuos().getNumeroElementos() + celda3.getListaEntornos().getNumeroElementos();
                    int valor4 = celda.getListaIndividuos().getNumeroElementos() + celda.getListaEntornos().getNumeroElementos() + celda4.getListaIndividuos().getNumeroElementos() + celda4.getListaEntornos().getNumeroElementos();
                    int valor5 = celda.getListaIndividuos().getNumeroElementos() + celda.getListaEntornos().getNumeroElementos() + celda5.getListaIndividuos().getNumeroElementos() + celda5.getListaEntornos().getNumeroElementos();
                    int valor6 = celda.getListaIndividuos().getNumeroElementos() + celda.getListaEntornos().getNumeroElementos() + celda6.getListaIndividuos().getNumeroElementos() + celda6.getListaEntornos().getNumeroElementos();
                    int valor7 = celda.getListaIndividuos().getNumeroElementos() + celda.getListaEntornos().getNumeroElementos() + celda7.getListaIndividuos().getNumeroElementos() + celda7.getListaEntornos().getNumeroElementos();
                    int valor8 = celda.getListaIndividuos().getNumeroElementos() + celda.getListaEntornos().getNumeroElementos() + celda8.getListaIndividuos().getNumeroElementos() + celda8.getListaEntornos().getNumeroElementos();
                    grafoTablero.add(new ArcoGrafo<>((NodoGrafo<>)celda, celda1, valor1, "Arista de (" + celda.getFila() + "," + celda.getColumna() + ") a (" + celda1.getFila() + "," + celda1.getColumna() + ")"));
                    grafoTablero.add(new ArcoGrafo<>((NodoGrafo<>)celda, celda2, valor2, "Arista de (" + celda.getFila() + "," + celda.getColumna() + ") a (" + celda2.getFila() + "," + celda2.getColumna() + ")"));
                    grafoTablero.add(new ArcoGrafo<>((NodoGrafo<>)celda, celda3, valor3, "Arista de (" + celda.getFila() + "," + celda.getColumna() + ") a (" + celda3.getFila() + "," + celda3.getColumna() + ")"));
                    grafoTablero.add(new ArcoGrafo<>((NodoGrafo<>)celda, celda4, valor4, "Arista de (" + celda.getFila() + "," + celda.getColumna() + ") a (" + celda4.getFila() + "," + celda4.getColumna() + ")"));
                    grafoTablero.add(new ArcoGrafo<>((NodoGrafo<>)celda, celda5, valor5, "Arista de (" + celda.getFila() + "," + celda.getColumna() + ") a (" + celda5.getFila() + "," + celda5.getColumna() + ")"));
                    grafoTablero.add(new ArcoGrafo<>((NodoGrafo<>)celda, celda6, valor6, "Arista de (" + celda.getFila() + "," + celda.getColumna() + ") a (" + celda6.getFila() + "," + celda6.getColumna() + ")"));
                    grafoTablero.add(new ArcoGrafo<>((NodoGrafo<>)celda, celda7, valor7, "Arista de (" + celda.getFila() + "," + celda.getColumna() + ") a (" + celda7.getFila() + "," + celda7.getColumna() + ")"));
                    grafoTablero.add(new ArcoGrafo<>((NodoGrafo<>)celda, celda8, valor8, "Arista de (" + celda.getFila() + "," + celda.getColumna() + ") a (" + celda8.getFila() + "," + celda8.getColumna() + ")"));
                } else if (celda.getFila() == 0 && celda.getColumna() > 0) {

                } else if (celda.getFila() > 0 && celda.getColumna() == 0) {

                } else if (celda.getFila() == 0 && celda.getColumna() == 0) {

                } */
                listaY.insert(celda, j-1);
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
