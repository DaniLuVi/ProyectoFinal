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
    private ListaDoblementeEnlazada<Celda> listaCeldas = new ListaDoblementeEnlazada<>();
    private ListaSimple<Celda> listaY = new ListaSimple<>();
    public ListaSimple<ListaSimple<Celda>> listaX = new ListaSimple<ListaSimple<Celda>>();
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
                listaCeldas.add(modelCelda.getOriginal());
                listaY.add(modelCelda.getOriginal());
            }
            listaX.add(listaY);
        }
    }
    public void commit() {

    }
    public void rollback() {

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
