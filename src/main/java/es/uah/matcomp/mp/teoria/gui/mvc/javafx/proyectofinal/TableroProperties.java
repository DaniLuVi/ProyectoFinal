package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Celda;
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

    public TableroProperties(Tablero original) {
        setOriginal(original);
    }
    public TableroProperties() {
    }
    public void commit() {
        original.setFilas(filas.get());
        original.setColumnas(columnas.get());
        original.setNum_individuos(num_individuos.get());
        original.setCant_entornos(cant_entornos.get());
        original.setNum_turnos(num_turnos.get());
        original.setIds(ids.get());
        original.getListaX();
    }
    public void rollback() {
        filas.set(original.getFilas());
        columnas.set(original.getColumnas());
        num_individuos.set(original.getNum_individuos());
        cant_entornos.set(original.getCant_entornos());
        num_turnos.set(original.getNum_turnos());
        ids.set(original.getIds());
        listaX.set((ObservableList<ListProperty<Celda>>) original.getListaX());
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
}
