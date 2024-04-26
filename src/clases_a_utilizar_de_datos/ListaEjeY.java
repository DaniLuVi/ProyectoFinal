package clases_a_utilizar_de_datos;
import estructuras_de_datos_implementadas.listaSimple.*;

public class ListaEjeY<Celda> {
    private ListaSimple<Celda> listaEjeY;
    private int columnas;
    public ListaEjeY() {
        this.listaEjeY = new ListaSimple<Celda>(columnas);
    }

}
