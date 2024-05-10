package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Celda;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;

public class DatosTablero {
    protected ParametrosModeloProperties model;
    private int filas;
    private int columnas;
    private ListaDoblementeEnlazada<Celda> listaCeldas = new ListaDoblementeEnlazada<>();

    public DatosTablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }
    public DatosTablero(ListaDoblementeEnlazada<Celda> listaCeldas) {
        this.listaCeldas = listaCeldas;
    }

    public ListaDoblementeEnlazada<Celda> getListaCeldas() {
        return listaCeldas;
    }

    public void setListaCeldas(ListaDoblementeEnlazada<Celda> listaCeldas) {
        this.listaCeldas = listaCeldas;
    }
    public void add(Celda celda) {
        listaCeldas.add(celda);
    }

    public void CargaDatos(ParametrosModeloProperties parametrosModeloProperties) {
        this.model = parametrosModeloProperties;
        model.commit();
    }
}
