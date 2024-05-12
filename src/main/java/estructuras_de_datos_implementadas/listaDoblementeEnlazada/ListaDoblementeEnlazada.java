package estructuras_de_datos_implementadas.listaDoblementeEnlazada;

public class ListaDoblementeEnlazada<TipoDato> {
    private ElementoLDE<TipoDato> primero;
    private ElementoLDE<TipoDato> ultimo;
    public ListaDoblementeEnlazada() {

    }
    public boolean isVacia() {
        return primero == null;
    }
    public void Vaciar() {
        while (primero != null) {
            primero = primero.getSiguiente();
        }
    }
    public int add(TipoDato el) {
        int posicion = 0;
        ElementoLDE<TipoDato> puntero = new ElementoLDE<>(el);
        if (el == null) {
            return -1;
        }
        if (isVacia()) {
            primero = puntero;
            ultimo = puntero;
            posicion++;
        } else if (getNumeroElementos() == 1) {
            primero.setSiguiente(puntero);
            ultimo = puntero;
            posicion++;
        } else {
            ElementoLDE<TipoDato> tmp = primero;
            while (tmp.getSiguiente() != null) {
                posicion++;
                tmp = tmp.getSiguiente();
            }
            tmp.setSiguiente(puntero);
            tmp.setAnterior(ultimo);
            ultimo = puntero;
        }
        return posicion;
    }
    public void insert(TipoDato s, int posicion) {
        ElementoLDE<TipoDato> a = new ElementoLDE(s);
        if (isVacia()) {
            this.primero = a;
            this.ultimo = this.primero;
        } else if (posicion == 0) {
            this.primero.setAnterior(a);
            a.setSiguiente(this.primero);
            primero = a;
        } else {
            a.InsertarmeEn(getElemento(posicion - 1));
        }
    }

    public int del(int pos) {
        if (isVacia()) {
            return 0;
        } else {
            if (pos == 0) {
                primero = primero.getSiguiente();
                return getNumeroElementos();
            } else {
                ElementoLDE<TipoDato> a = this.primero;
                for (int contador = 0; contador!= pos - 1; contador++ ) {
                    a = a.getSiguiente();
                    if (a.getSiguiente().getSiguiente() == null) {
                        a.setSiguiente(null);
                        return getNumeroElementos();
                    }
                }
                a.setSiguiente(a.getSiguiente().getSiguiente());
                return getNumeroElementos();
            }

        }
    }
    public int getNumeroElementos() {
        if (isVacia()) {
            return 0;
        } else {
            int contador = 0;
            if (primero.getDato() != null)
                contador = 1;
            ElementoLDE<TipoDato> tmp = primero;
            while (tmp.getSiguiente() != null) {
                contador++;
                tmp = tmp.getSiguiente();
            }
            return contador;
        }
    }

    public int getPosicion(ElementoLDE<TipoDato> el) {
        ElementoLDE<TipoDato> tmp = primero;
        int contador = 0;
        if (tmp != el.getDato())
            while (tmp != el.getDato()) {
                tmp = tmp.getSiguiente();
                contador++;
                if (tmp == el.getDato())
                    return contador;
            }
        return 0;
    }

    public ElementoLDE<TipoDato> getPrimero() {
        return primero;
    }

    public ElementoLDE<TipoDato> getUltimo() {
        return ultimo;
    }
    public ElementoLDE<TipoDato> getSiguiente(ElementoLDE<TipoDato> el) {
        return el.getSiguiente();
    }
    public ElementoLDE<TipoDato> getAnterior(ElementoLDE<TipoDato> el) {
        return el.getAnterior();
    }
    public ElementoLDE<TipoDato> getElemento(int posicion) {
        ElementoLDE<TipoDato> a = primero;
        int contador = 0;
        if (getNumeroElementos() == 1 && posicion == 0)
            return a;
        while (contador != posicion && a != null) {
            a = a.getSiguiente();
            contador++;
        }
        return a;
    }
}