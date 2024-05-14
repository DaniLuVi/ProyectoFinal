package clases_a_utilizar_de_datos;

import es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal.CeldaProperties;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;
import estructuras_de_datos_implementadas.listaSimple.ElementoLS;
import estructuras_de_datos_implementadas.listaSimple.ListaSimple;

public class Celda extends ElementoLS<Celda> {
    private ListaSimple<Integer> coordenadas = new ListaSimple<Integer>(2);
    private ListaDoblementeEnlazada<Individuo> listaIndividuos = new ListaDoblementeEnlazada<>();
    private ListaDoblementeEnlazada<Entorno> listaEntornos = new ListaDoblementeEnlazada<>();
    private Individuo individuo;
    private int filas;
    private int columnas;
    public Celda(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }
    public Celda() {
    }
    public int getFila() {
        return filas;
    }
    public int getColumna() {
        return columnas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public Individuo getIndividuo() {
        return individuo;
    }

    public ListaDoblementeEnlazada<Individuo> getListaIndividuos() {
        return listaIndividuos;
    }

    public ListaDoblementeEnlazada<Entorno> getListaEntornos() {
        return listaEntornos;
    }
    public void addIndividuo(Individuo individuo) {
        this.listaIndividuos.add(individuo);
    }
    public void addEntorno(Entorno entorno) {
        this.listaEntornos.add(entorno);
    }

    public ListaSimple<Integer> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ListaSimple<Integer> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void setListaIndividuos(ListaDoblementeEnlazada<Individuo> listaIndividuos) {
        this.listaIndividuos = listaIndividuos;
    }

    public void setListaEntornos(ListaDoblementeEnlazada<Entorno> listaEntornos) {
        this.listaEntornos = listaEntornos;
    }
    public void setDataGuardada(CeldaProperties modelCelda) {
        this.coordenadas = modelCelda.getOriginal().getCoordenadas();
        this.listaIndividuos = modelCelda.getOriginal().getListaIndividuos();
        this.listaEntornos = modelCelda.getOriginal().getListaEntornos();
    }
    @Override
    public String toString() {
        return "Celda{" +
                "coordenadas=" + coordenadas +
                ", listaIndividuos=" + listaIndividuos +
                ", listaEntornos=" + listaEntornos +
                '}';
    }
}

