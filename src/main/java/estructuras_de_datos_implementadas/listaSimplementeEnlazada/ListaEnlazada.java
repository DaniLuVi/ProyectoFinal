package estructuras_de_datos_implementadas.listaSimplementeEnlazada;

public class ListaEnlazada<TipoDato> {
    private ElementoLE<TipoDato> primero;
    public ListaEnlazada() {
    }
    public boolean isVacia() {
        return primero == null;
    }
    public void Vaciar() {
        this.primero = null;
    }
    public int add(TipoDato el) {
        int posicion = 0;
        ElementoLE<TipoDato> puntero = new ElementoLE<>(el);
        if (this.isVacia()) {
            primero = puntero;
            posicion++;
        } else if (this.getNumeroElementos() == 1) {
            primero.setSiguiente(puntero);
            posicion++;
        } else {
            ElementoLE<TipoDato> tmp = primero;
            while (tmp.getSiguiente() != null) {
                posicion += 1;
                tmp = tmp.getSiguiente();
            }
            tmp.setSiguiente(puntero);
            primero = tmp;
        }
        return posicion;
    }
    public void insert(TipoDato s, int posicion) {
        ElementoLE<TipoDato> tmp = new ElementoLE();
        tmp.setData(s);
        if (posicion == 0) {
            tmp.setSiguiente(primero);
            primero = tmp;
        } else {
            tmp.insertarmeEN(getElemento(posicion-1));
        }
    }
    public int del(int pos) {
        if (pos == 0) {
            primero = primero.getSiguiente();
            return this.getNumeroElementos();
        }else{
            ElementoLE<TipoDato> tmp = this.primero;
            for (int i=0; i != pos - 1; i++) {
                tmp = tmp.getSiguiente();
                if (tmp.getSiguiente().getSiguiente() == null) {
                    tmp.setSiguiente(null);
                    return this.getNumeroElementos();
                }
            }
            tmp.setSiguiente(tmp.getSiguiente().getSiguiente());
            return this.getNumeroElementos();
        }
    }

    public int getNumeroElementos() {
        if (isVacia())
            return 0;
        int contador=0;
        if (primero.getData()!=null)
            contador = 1;
        ElementoLE<TipoDato> tmp = primero;
        while (tmp.getSiguiente()!=null) {
            contador++;
            tmp = tmp.getSiguiente();
        }
        return contador;
    }
    public int getPosicion(ElementoLE<TipoDato> el) {
        ElementoLE<TipoDato> tmp = primero;
        int contador = 0;
        if (tmp != el.getData())
            while (tmp != el.getData()) {
                tmp = tmp.getSiguiente();
                contador++;
                if (tmp == el.getData())
                    return contador;
            }
        return 0;
    }
    public ElementoLE<TipoDato> getPrimero() {
        return primero;
    }
    public ElementoLE<TipoDato> getUltimo() {
        ElementoLE<TipoDato> tmp = primero;
        while (tmp.getData() != null)
            tmp = tmp.getSiguiente();
        return tmp;
    }
    public ElementoLE<TipoDato> getSiguiente(ElementoLE<TipoDato> el) {
        return el.getSiguiente();
    }
    public ElementoLE<TipoDato> getElemento(int posicion) {
        int contador = 0;
        if (getNumeroElementos() == 1)
            return primero;
        ElementoLE<TipoDato> tmp = primero;
        while (contador != posicion) {
            tmp = tmp.getSiguiente();
            contador++;
        }
        return tmp;
    }
}