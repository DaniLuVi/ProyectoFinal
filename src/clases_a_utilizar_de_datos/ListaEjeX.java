package clases_a_utilizar_de_datos;

import estructuras_de_datos_implementadas.listaSimple.ElementoLS;
import estructuras_de_datos_implementadas.listaSimple.ListaSimple;

public class ListaEjeX {
    private ListaSimple<Celda> listaEjeX;
    private int filas;
    public ListaEjeX() {
        this.listaEjeX = new ListaSimple<Celda>(filas);
    }

}
