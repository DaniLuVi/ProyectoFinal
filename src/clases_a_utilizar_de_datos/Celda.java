package clases_a_utilizar_de_datos;

import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;

public class Celda<TipoDato> {
    private ListaDoblementeEnlazada<Individuo> listaIndividuos;
    private ListaDoblementeEnlazada<Entorno> listaEntornos;
    public Celda() {
        this.listaIndividuos = new ListaDoblementeEnlazada<Individuo>();
        this.listaEntornos = new ListaDoblementeEnlazada<Entorno>();
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
