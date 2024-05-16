package estructuras_de_datos_implementadas.grafo;


import estructuras_de_datos_implementadas.listaSimplementeEnlazada.ListaEnlazada;

public class Mapa<T, E> {
    private ElementoHashMap<T, E> primero;

    public boolean isVacia() {
        return primero == null;
    }

    public Mapa() {
    }

    public void put(T indice, E dato) {
        if (!this.isVacia()) {
            ElementoHashMap<T, E> actual = this.primero;
            while (actual.getSiguiente() != null) {
                if (actual.getIndice() == indice) {
                    actual.setDato(dato);
                    return;
                }
                actual = actual.getSiguiente();
            }
            if (actual.getIndice() == indice) {
                actual.setDato(dato);
            } else {
                ElementoHashMap<T, E> nuevoElemento = new ElementoHashMap<>(indice, dato, null);
                actual.setSiguiente(nuevoElemento);
            }
        } else {
            ElementoHashMap<T, E> nuevoElemento = new ElementoHashMap<>(indice, dato, null);
            this.primero = nuevoElemento;
        }
    }
    public E get(T indice) {
        ElementoHashMap<T, E> actual = this.primero;
        while (actual.getSiguiente() != null && actual.getIndice() != indice) {
            actual = actual.getSiguiente();
        }
        if (actual.getIndice() == indice) {
            return actual.getDato();
        } else {
            return null;
        }
    }
    public ListaEnlazada<T> KeySet() {
        ListaEnlazada<T> listaClaves = new ListaEnlazada<>();
        ElementoHashMap<T, E> actual = this.primero;
        while (actual != null) {
            listaClaves.add(actual.getIndice());
            actual = actual.getSiguiente();
        }
        return listaClaves;
    }
}
