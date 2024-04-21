package estructuras_de_datos_implementadas.listaDoblementeEnlazada;

public class ElementoLDE {
    private Object dato;
    private ElementoLDE siguiente;
    private ElementoLDE anterior;
    public ElementoLDE(){

    }

    public ElementoLDE(ElementoLDE ant, ElementoLDE sig, Object data){
        this.anterior=ant;
        this.siguiente=sig;
        this.dato=data;
    }

    public ElementoLDE(Object dato) {
        this.dato = dato;
    }

    public ElementoLDE(Object dato, ElementoLDE siguiente, ElementoLDE anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public void InsertarmeEn(ElementoLDE el) {
        el.anterior = this.anterior;
        el.siguiente = this;
        if (this.anterior != null) {
            this.anterior.siguiente = el;
        }
        this.anterior = el;
    }
    protected ElementoLDE getSiguiente(){
        return siguiente;
    }
    protected void setSiguiente(ElementoLDE newSiguiente) {
        siguiente = newSiguiente;
    }
    protected ElementoLDE getAnterior(){
        return anterior;
    }
    protected void setAnterior(ElementoLDE newAnterior) {
        anterior = newAnterior;
    }

    public Object getDato(){
        return dato;
    }
    public void setDato(Object dato){
        this.dato = dato;
    }

}
