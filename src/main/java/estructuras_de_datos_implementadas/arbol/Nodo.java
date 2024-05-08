package estructuras_de_datos_implementadas.arbol;
public class Nodo<TipoDato> {
    TipoDato dato;
    Nodo<TipoDato> izquierda;
    Nodo<TipoDato> derecha;

    public Nodo() {
    }

    public Nodo(TipoDato dato) {
        this.dato = dato;
    }

    public Nodo(Nodo<TipoDato> izquierda, Nodo<TipoDato> derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public TipoDato getDato() {
        return dato;
    }

    public Nodo<TipoDato> getIzquierda() {
        return izquierda;
    }

    public Nodo<TipoDato> getDerecha() {
        return derecha;
    }

    public void setDato(TipoDato dato) {
        this.dato = dato;
    }

    public void setIzquierda(Nodo<TipoDato> izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(Nodo<TipoDato> derecha) {
        this.derecha = derecha;
    }


    protected void add(Nodo<TipoDato> nodo) {
        Comparable dato = (Comparable) this.getDato();
        Comparable miDato = (Comparable) nodo.getDato();
        if (miDato.compareTo(dato) == 1) {
            if (this.getDerecha() == null) {
                this.setDerecha(nodo);
            } else {
                this.getDerecha().add(nodo);
            }
        } else if (miDato.compareTo(dato) == -1) {
            if (this.getIzquierda() == null) {
                this.setIzquierda(nodo);
            } else {
                this.getIzquierda().add(nodo);
            }
        } else {
            System.out.println("No se ha podido añadir el nodo");
        }
    }
}


