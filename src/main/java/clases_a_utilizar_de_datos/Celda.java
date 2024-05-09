package clases_a_utilizar_de_datos;

import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;
import estructuras_de_datos_implementadas.listaSimple.ElementoLS;

public class Celda extends ElementoLS<Celda> {
    private ListaDoblementeEnlazada<Individuo> listaIndividuos;
    private ListaDoblementeEnlazada<Entorno> listaEntornos;
    private Individuo individuo;
    private int filas;
    private int columnas;
    public Celda(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }
    public Celda(Individuo individuo) {
        this.individuo = individuo;
        this.listaIndividuos = new ListaDoblementeEnlazada<Individuo>();
        this.listaEntornos = new ListaDoblementeEnlazada<Entorno>();
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
}

