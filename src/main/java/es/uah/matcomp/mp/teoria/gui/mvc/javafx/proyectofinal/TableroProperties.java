package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Celda;
import clases_a_utilizar_de_datos.Entorno;
import clases_a_utilizar_de_datos.Individuo;
import clases_a_utilizar_de_datos.Tablero;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;
import estructuras_de_datos_implementadas.listaSimple.ListaSimple;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

public class TableroProperties {
    protected Tablero original = new Tablero();
    private IntegerProperty filas = new SimpleIntegerProperty();
    private IntegerProperty columnas = new SimpleIntegerProperty();
    private IntegerProperty num_individuos = new SimpleIntegerProperty();
    private IntegerProperty cant_entornos = new SimpleIntegerProperty();
    private IntegerProperty num_turnos = new SimpleIntegerProperty();
    private IntegerProperty ids = new SimpleIntegerProperty();
    private ListProperty<ListProperty<Celda>> listaX = new SimpleListProperty<>();
    private ListProperty<Individuo> listaCeldaIndividuos = new SimpleListProperty<>();
    private ListProperty<Entorno> listaCeldaEntornos = new SimpleListProperty<>();

    public TableroProperties(Tablero original) {
        setOriginal(original);
    }
    public TableroProperties() {
    }
    public void commit() {
        original.setFilas(original.filas);
        original.setColumnas(original.columnas);
        original.setNum_individuos(original.num_individuos);
        original.setCant_entornos(original.cant_entornos);
        original.setNum_turnos(original.num_turnos);
        original.setIds(original.ids);
        original.getListaX();
        original.getListaCeldasIndividuos();
        original.getListaCeldasEntornos();
    }
    public void rollback() {
        filas.set(original.getFilas());
        columnas.set(original.getColumnas());
        num_individuos.set(original.getIndividuos());
        cant_entornos.set(original.getEntornos());
        num_turnos.set(original.getNum_turnos());
        ids.set(original.getIds());
        listaX.set((ObservableList<ListProperty<Celda>>) original.getListaX());
        listaCeldaIndividuos.set((ObservableList<Individuo>) original.getListaCeldasIndividuos());
        listaCeldaEntornos.set((ObservableList<Entorno>) original.getListaCeldasEntornos());
    }
    public Tablero getOriginal() {
        return original;
    }

    public void setOriginal(Tablero original) {
        this.original = original;
    }

    public int getFilas() {
        return filas.get();
    }

    public IntegerProperty filasProperty() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas.set(filas);
    }

    public int getColumnas() {
        return columnas.get();
    }

    public IntegerProperty columnasProperty() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas.set(columnas);
    }

    public int getNum_individuos() {
        return num_individuos.get();
    }

    public IntegerProperty num_individuosProperty() {
        return num_individuos;
    }

    public void setNum_individuos(int num_individuos) {
        this.num_individuos.set(num_individuos);
    }

    public int getCant_entornos() {
        return cant_entornos.get();
    }

    public IntegerProperty cant_entornosProperty() {
        return cant_entornos;
    }

    public void setCant_entornos(int cant_entornos) {
        this.cant_entornos.set(cant_entornos);
    }

    public int getNum_turnos() {
        return num_turnos.get();
    }

    public IntegerProperty num_turnosProperty() {
        return num_turnos;
    }

    public void setNum_turnos(int num_turnos) {
        this.num_turnos.set(num_turnos);
    }

    public int getIds() {
        return ids.get();
    }

    public IntegerProperty idsProperty() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids.set(ids);
    }

    public ObservableList<ListProperty<Celda>> getListaX() {
        return listaX.get();
    }

    public ListProperty<ListProperty<Celda>> listaXProperty() {
        return listaX;
    }

    public void setListaX(ObservableList<ListProperty<Celda>> listaX) {
        this.listaX.set(listaX);
    }

    public ObservableList<Individuo> getListaCeldaIndividuos() {
        return listaCeldaIndividuos.get();
    }

    public ListProperty<Individuo> listaCeldaIndividuosProperty() {
        return listaCeldaIndividuos;
    }

    public void setListaCeldaIndividuos(ObservableList<Individuo> listaCeldaIndividuos) {
        this.listaCeldaIndividuos.set(listaCeldaIndividuos);
    }

    public ObservableList<Entorno> getListaCeldaEntornos() {
        return listaCeldaEntornos.get();
    }

    public ListProperty<Entorno> listaCeldaEntornosProperty() {
        return listaCeldaEntornos;
    }

    public void setListaCeldaEntornos(ObservableList<Entorno> listaCeldaEntornos) {
        this.listaCeldaEntornos.set(listaCeldaEntornos);
    }
}
