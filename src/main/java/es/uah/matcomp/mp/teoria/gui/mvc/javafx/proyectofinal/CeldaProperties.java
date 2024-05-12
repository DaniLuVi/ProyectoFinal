package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Celda;
import clases_a_utilizar_de_datos.Entorno;
import clases_a_utilizar_de_datos.Individuo;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;
import estructuras_de_datos_implementadas.listaSimple.ListaSimple;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

public class CeldaProperties {
    protected Celda original = new Celda();
    private ListProperty coordenadas = new SimpleListProperty<>();
    private ListProperty<Individuo> listaIndividuos = new SimpleListProperty<>();
    private ListProperty<Entorno> listaEntornos = new SimpleListProperty<>();

    public CeldaProperties(Celda original) {
        setOriginal(original);
    }
    public CeldaProperties() {}
    public void commit() {
        original.getCoordenadas();
        original.getListaIndividuos();
        original.getListaEntornos();
    }
    public void rollback() {
        coordenadas.set(original.getCoordenadas());
        listaIndividuos.set((ObservableList<Individuo>) original.getListaIndividuos());
        listaEntornos.set((ObservableList<Entorno>) original.getListaEntornos());
    }

    public Celda getOriginal() {
        return original;
    }

    public void setOriginal(Celda original) {
        this.original = original;
    }

    public ObservableList<Integer> getCoordenadas() {
        return (ObservableList<Integer>) coordenadas.get();
    }

    public ListProperty<Integer> coordenadasProperty() {
        return coordenadas;
    }

    public void setCoordenadas(ObservableList<Integer> coordenadas) {
        this.coordenadas.set(coordenadas);
    }

    public ObservableList<Individuo> getListaIndividuos() {
        return listaIndividuos.get();
    }

    public ListProperty<Individuo> listaIndividuosProperty() {
        return listaIndividuos;
    }

    public void setListaIndividuos(ObservableList<Individuo> listaIndividuos) {
        this.listaIndividuos.set(listaIndividuos);
    }

    public ObservableList<Entorno> getListaEntornos() {
        return listaEntornos.get();
    }

    public ListProperty<Entorno> listaEntornosProperty() {
        return listaEntornos;
    }

    public void setListaEntornos(ObservableList<Entorno> listaEntornos) {
        this.listaEntornos.set(listaEntornos);
    }
}
