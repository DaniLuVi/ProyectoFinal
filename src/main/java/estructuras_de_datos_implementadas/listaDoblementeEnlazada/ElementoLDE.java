package estructuras_de_datos_implementadas.listaDoblementeEnlazada;

public class ElementoLDE<TipoDato> {
    private TipoDato dato;
    private ElementoLDE<TipoDato> siguiente;
    private ElementoLDE<TipoDato> anterior;
    public ElementoLDE(){

    }

    public ElementoLDE(ElementoLDE<TipoDato> ant, ElementoLDE<TipoDato> sig, TipoDato data){
        this.anterior=ant;
        this.siguiente=sig;
        this.dato=data;
    }

    public ElementoLDE(TipoDato dato) {
        this.dato = dato;
    }

    public ElementoLDE(TipoDato dato, ElementoLDE<TipoDato> siguiente, ElementoLDE<TipoDato> anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public void InsertarmeEn(ElementoLDE<TipoDato> el) {
        el.anterior = this.anterior;
        el.siguiente = this;
        if (this.anterior != null) {
            this.anterior.siguiente = el;
        }
        this.anterior = el;
    }
    protected ElementoLDE<TipoDato> getSiguiente(){
        return siguiente;
    }
    protected void setSiguiente(ElementoLDE<TipoDato> newSiguiente) {
        siguiente = newSiguiente;
    }
    protected ElementoLDE<TipoDato> getAnterior(){
        return anterior;
    }
    protected void setAnterior(ElementoLDE<TipoDato> newAnterior) {
        anterior = newAnterior;
    }

    public TipoDato getDato(){
        return dato;
    }
    public void setDato(TipoDato dato){
        this.dato = dato;
    }

}
