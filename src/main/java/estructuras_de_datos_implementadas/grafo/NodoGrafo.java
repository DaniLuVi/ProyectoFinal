package estructuras_de_datos_implementadas.grafo;


import estructuras_de_datos_implementadas.listaSimplementeEnlazada.ElementoLE;
import estructuras_de_datos_implementadas.listaSimplementeEnlazada.ListaEnlazada;

public class NodoGrafo<TipoDato> extends ElementoLE<NodoGrafo<TipoDato>> {
    private TipoDato dato;
    private ListaEnlazada<ArcoGrafo<TipoDato>> frontera;


    public NodoGrafo(TipoDato dato) {
        this.dato = dato;
        this.frontera = new ListaEnlazada<>();
    }

    public TipoDato getDato() {
        return dato;
    }

    public ListaEnlazada<ArcoGrafo<TipoDato>> getFrontera() {
        return frontera;
    }


    public void addFrontera(ArcoGrafo<TipoDato> arco) {
        frontera.add(arco);

    }



}
