package clases_a_utilizar_de_datos;

import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ListaDoblementeEnlazada;

public class Celda<TipoDato> {
    private ListaDoblementeEnlazada<TipoDato> listaIndividuos;
    private ListaDoblementeEnlazada<TipoDato> listaEntornos;
    public Celda() {
        this.listaIndividuos = new ListaDoblementeEnlazada<TipoDato>();
        this.listaEntornos = new ListaDoblementeEnlazada<TipoDato>();
    }

}
