package estructuras_de_datos_implementadas.grafo;


import estructuras_de_datos_implementadas.listaSimplementeEnlazada.ElementoLE;

public class ArcoGrafo<TipoDato> extends ElementoLE<ArcoGrafo<TipoDato>> {
    private NodoGrafo<TipoDato> principio;
    private NodoGrafo<TipoDato> destino;
    private Double dato;
    private String etiqueta;
    public ArcoGrafo(NodoGrafo<TipoDato> principio, NodoGrafo<TipoDato> destino, Double dato, String etiqueta) {
        this.principio = principio;
        this.principio = principio;
        this.dato = dato;
        this.etiqueta = etiqueta;
    }

    public Double getDatos() {
        return dato;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public NodoGrafo<TipoDato> getPrincipio() {
        return principio;
    }

    public NodoGrafo<TipoDato> getDestino() {
        return destino;
    }

    public void setDato(Double dato) {
        this.dato = dato;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public NodoGrafo<TipoDato> getVerticeAdyacente(TipoDato dato){
        if (dato!= this.getPrincipio()){
            return getPrincipio();
        }
        else {
            return  getDestino();
        }
    }
    public NodoGrafo<TipoDato> getOtroVertice(TipoDato dato){
            if (dato != this.getPrincipio().getDato()) {
                return this.getPrincipio();
            } else {
                return this.getDestino();
            }
        }
    }

