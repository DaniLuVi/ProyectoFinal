package clases_a_utilizar_de_datos;

import com.google.gson.*;
import es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal.CeldaProperties;
import es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal.ParametrosModeloProperties;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;
import estructuras_de_datos_implementadas.listaSimple.ListaSimple;

import java.lang.reflect.Type;

public class Tablero implements JsonSerializer<Tablero> {
    public ParametrosModeloProperties model;
    public CeldaProperties modelCelda = new CeldaProperties();
    private ListaSimple<Celda> listaY = new ListaSimple<>();
    public ListaSimple<ListaSimple<Celda>> listaX = new ListaSimple<ListaSimple<Celda>>();
    public int filas;
    public int columnas;
    public int num_individuos;
    public int cant_entornos;
    public int num_turnos;
    public int ids;
    public Tablero() {}
    public Tablero(ParametrosModeloProperties parametrosModeloProperties, CeldaProperties modelCelda, ListaSimple<ListaSimple<Celda>> listaX) {
        this.model = parametrosModeloProperties;
        this.modelCelda = modelCelda;
        this.listaX = listaX;
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

    public int getNum_individuos() {
        return num_individuos;
    }

    public void setNum_individuos(int num_individuos) {
        this.num_individuos = num_individuos;
    }

    public int getCant_entornos() {
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

    public void CargaDatosParametros(ParametrosModeloProperties parametrosModeloProperties) {
        this.model = parametrosModeloProperties;
        model.commit();
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
