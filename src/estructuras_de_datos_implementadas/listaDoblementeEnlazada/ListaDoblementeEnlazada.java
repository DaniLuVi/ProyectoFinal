package estructuras_de_datos_implementadas.listaDoblementeEnlazada;

public class ListaDoblementeEnlazada {
    private ElementoLDE primero;
    private ElementoLDE ultimo;

    public boolean isVacia() {
        return primero == null;
    }
    public void Vaciar() {
        while (primero != null) {
            primero = primero.getSiguiente();
        }
    }
    protected int add(ElementoLDE el) {
        int posicion = 0;
        if (el == null) {
            return -1;
        }
        if (isVacia()) {
            primero = el;
            ultimo = el;
            posicion++;
            return posicion;
        } else if (getNumeroElementos() == 1) {
            primero.setSiguiente(el);
            ultimo = el;
            posicion++;
            return posicion;
        } else {
            ElementoLDE tmp = primero;
            while (tmp.getSiguiente() != null) {
                posicion++;
                tmp = tmp.getSiguiente();
            }
            tmp.setSiguiente(el);
            el.setAnterior(ultimo);
            ultimo = el;
            return posicion;
        }
    }
    public void add(String s) {
        add(new ElementoLDE(s));
    }
    public void add(Object o) {
        add(new ElementoLDE(o));
    }
    public void insert(String s, int posicion) {
        ElementoLDE a = new ElementoLDE(s);
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

    public void insert(Object o, int posicion) {
        ElementoLDE b = new ElementoLDE(o);
        if (isVacia()) {
            this.primero = b;
            this.ultimo = this.primero;
        } else if (posicion == 0) {
            this.primero.setAnterior(b);
            b.setSiguiente(this.primero);
            primero = b;
        } else {
            b.InsertarmeEn(getElemento(posicion - 1));
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
                ElementoLDE a = this.primero;
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
            ElementoLDE tmp = primero;
            while (tmp.getSiguiente() != null) {
                contador++;
                tmp = tmp.getSiguiente();
            }
            return contador;
        }
    }

    public int getPosicion(ElementoLDE el) {
        ElementoLDE tmp = primero;
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

    public ElementoLDE getPrimero() {
        return primero;
    }

    public ElementoLDE getUltimo() {
        return ultimo;
    }
    public ElementoLDE getSiguiente(ElementoLDE el) {
        return el.getSiguiente();
    }
    public ElementoLDE getAnterior(ElementoLDE el) {
        return el.getAnterior();
    }
    public ElementoLDE getElemento(int posicion) {
        ElementoLDE a = primero;
        int contador = 0;
        if (getNumeroElementos() == 1)
            return primero;
        while (contador != posicion && a != null) {
            a = a.getSiguiente();
            contador++;
        }
        return a;
    }
}