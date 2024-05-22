package clases_a_utilizar_de_datos;

import es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal.ParametrosModelo;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;
import estructuras_de_datos_implementadas.listaSimple.ListaSimple;

public class TableroASerializar {
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
    public TableroASerializar() {}

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

    public ParametrosModelo getParametrosModelo() {
        return model;
    }

    public void setParametrosModelo(ParametrosModelo parametrosModelo) {
        this.model = parametrosModelo;
    }

    // posiblemente tenga que hacer el guardado a partir de esta clase, con una clase limpia sin properties
}
