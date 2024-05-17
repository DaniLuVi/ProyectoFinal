package estructuras_de_datos_implementadas.listaSimplementeEnlazada;

public class ElementoLE<TipoDato> {
    private ElementoLE<TipoDato> siguiente;
    public TipoDato data;

    public ElementoLE() {
    }

    public ElementoLE(TipoDato data) {
        this.data = data;
    }

    public ElementoLE(TipoDato data, ElementoLE<TipoDato> siguiente) {
        this.data = data;
        this.siguiente = siguiente;
    }

    protected void insertarmeEN(ElementoLE<TipoDato> le) {
        this.siguiente = le.siguiente;
        le.siguiente = this;
    }

    protected ElementoLE<TipoDato> getSiguiente() {
        return siguiente;
    }

    protected void setSiguiente(ElementoLE<TipoDato> siguiente) {
        this.siguiente = siguiente;
    }

    public TipoDato getData() {
        return data;
    }

    public void setData(TipoDato data) {
        this.data = data;
    }
}
