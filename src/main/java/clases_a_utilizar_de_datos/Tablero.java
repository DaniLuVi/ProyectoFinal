package clases_a_utilizar_de_datos;

import com.google.gson.*;
import es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal.CeldaProperties;
import es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal.ParametrosModelo;
import es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal.ParametrosModeloProperties;
import es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal.TableroProperties;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;
import estructuras_de_datos_implementadas.listaSimple.ListaSimple;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class Tablero implements JsonSerializer<Tablero> {
    private Tablero tablero;
    public ParametrosModeloProperties parametrosModeloProperties;
    public TableroProperties tableroProperties;
    public CeldaProperties modelCelda = new CeldaProperties();
    public ListaSimple<Celda> listaY = new ListaSimple<>();
    public ListaSimple<ListaSimple<Celda>> listaX = new ListaSimple<ListaSimple<Celda>>();
    public ListaDoblementeEnlazada<Celda> listaCeldasEntornos = new ListaDoblementeEnlazada<>();
    public ListaDoblementeEnlazada<Celda> listaCeldasIndividuos = new ListaDoblementeEnlazada<>();
    public int filas;
    public int columnas;
    public int num_individuos;
    public int cant_entornos;
    public int num_turnos;
    public int ids;
    private ParametrosModelo model;
    private static final Logger log = LogManager.getLogger(Tablero.class);
    public Tablero() {}
    public Tablero(Tablero tablero) {
        this.tablero = tablero;
    }
    public Tablero(ParametrosModeloProperties parametrosModeloProperties, CeldaProperties modelCelda, ListaSimple<ListaSimple<Celda>> listaX) {
        this.parametrosModeloProperties = parametrosModeloProperties;
        this.modelCelda = modelCelda;
        this.listaX = listaX;
        this.listaCeldasIndividuos = listaCeldasIndividuos;
        this.listaCeldasEntornos = listaCeldasEntornos;
    }
    public void construir_tablero(int filas, int columnas) {
        listaX = new ListaSimple<>(filas);
        listaY = new ListaSimple<>(columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Celda celda = new Celda(i, j);
                modelCelda.setOriginal(celda);
                listaY.add(modelCelda.getOriginal());
            }
            listaX.add(listaY);
        }
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getIndividuos() {
        return num_individuos;
    }

    public void setNum_individuos(int num_individuos) {
        this.num_individuos = num_individuos;
    }

    public int getEntornos() {
        return cant_entornos;
    }

    public void setCant_entornos(int cant_entornos) {
        this.cant_entornos = cant_entornos;
    }

    public int getNum_turnos() {
        return num_turnos;
    }

    public void setNum_turnos(int num_turnos) {
        this.num_turnos = num_turnos;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public ListaSimple<ListaSimple<Celda>> getListaX() {
        return listaX;
    }

    public void setListaX(ListaSimple<ListaSimple<Celda>> listaX) {
        this.listaX = listaX;
    }

    public ListaDoblementeEnlazada<Celda> getListaCeldasEntornos() {
        return listaCeldasEntornos;
    }

    public void setListaCeldasEntornos(ListaDoblementeEnlazada<Celda> listaCeldasEntornos) {
        this.listaCeldasEntornos = listaCeldasEntornos;
    }

    public ListaDoblementeEnlazada<Celda> getListaCeldasIndividuos() {
        return listaCeldasIndividuos;
    }

    public void setListaCeldasIndividuos(ListaDoblementeEnlazada<Celda> listaCeldasIndividuos) {
        this.listaCeldasIndividuos = listaCeldasIndividuos;
    }

    public void ArreglarDatosACargar() {
        ParametrosModeloProperties parametrosModeloProperties = new ParametrosModeloProperties(model);
        this.parametrosModeloProperties = parametrosModeloProperties;
    }
    public void CargaDatosParametros(ParametrosModeloProperties parametrosModeloProperties) {
        this.parametrosModeloProperties = parametrosModeloProperties;
        parametrosModeloProperties.commit();
    }
    public void CargaDatosTablero(TableroProperties tableroProperties) {
        this.tableroProperties = tableroProperties;
        tableroProperties.commit();
    }
    public void establecerTipoIndividuo() {  // hacer que dependiendo del tipo que sea se establezca de esa manera o de otra

        log.info("Método para establecer el tipo de individuo que hay en las celdas de la lista");

        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                if (this.listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() != 0) {
                    if (this.listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 1) {

                    } else if (this.listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 2) {

                    } else if (this.listaX.getElemento(i).getData().getElemento(j).getData().getListaIndividuos().getNumeroElementos() == 3) {

                    }
                }
                if (this.listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() != 0) {
                    if (this.listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 1) {

                    } else if (this.listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 2) {

                    } else if (this.listaX.getElemento(i).getData().getElemento(j).getData().getListaEntornos().getNumeroElementos() == 3) {

                    }
                }
            }
        }
    }

    @Override
    public JsonElement serialize(Tablero tablero, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject tablero_guardar = new JsonObject();
        JsonArray listaXJSON = new JsonArray(listaX.getNumeroElementos());
        for (int i = 0; i < listaX.getNumeroElementos(); i++) {
            for (int j = 0; j < listaY.getNumeroElementos(); j++) {
                listaXJSON.add(String.valueOf(listaX.getElemento(i).getData().getElemento(j)));
            }
        }

        tablero_guardar.add("tablero", listaXJSON);

        return listaXJSON;
    }
}
