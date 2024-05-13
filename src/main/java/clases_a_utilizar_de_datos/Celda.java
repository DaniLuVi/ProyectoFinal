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
    public Celda(int filas, int columnas) {
        this.coordenadas.add(filas);
        this.coordenadas.add(columnas);
    }
    public Celda() {
    }
    public int getFila() {
        return coordenadas.getElemento(0).getData();
    }
    public int getColumna() {
        return coordenadas.getElemento(1).getData();
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

