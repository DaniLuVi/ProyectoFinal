package estructuras_de_datos_implementadas.listaSimple;

/**
 * Programar la lista simple.
 */
public class ListaSimple<TipoDato> {

    private ElementoLS<TipoDato>[] datos;

    private int maximo;

    public ListaSimple(int maximo) {
        datos = new ElementoLS[maximo];
        this.maximo = maximo;
    }

    public ListaSimple(ElementoLS<TipoDato>[] datos, int maximo) {
        this.datos = datos;
        this.maximo = maximo;
    }

    public boolean isVacia(){
        return getNumeroElementos() == 0;
    }
    public void vaciar() {
        int contador = 0;
        while (contador < maximo) {
            this.del(0);
            contador++;
        }
    }
    public int add(TipoDato el){
        int contador = 0;
        ElementoLS<TipoDato> tmp = new ElementoLS<>(el);
        for (contador = 0; contador <= maximo; contador++)
            if (datos[contador]==null)
                break;
        if (datos[contador]==null)
            datos[contador]= tmp;
        return contador;
    }
    public void insert(TipoDato s, int posicion){
        ElementoLS<TipoDato> e = new ElementoLS<TipoDato>(s);
        if (!isVacia()) {
            if (posicion < maximo && posicion >= 0)
                datos[posicion] = e;
        } else {
            datos[0] = e;
        }

    }
    public int del(int posicion){
        if (posicion < maximo && posicion >= 0 && this.getElemento(posicion) != null) {
            datos[posicion] = null;
            if (posicion != maximo)
                for (int contador = posicion + 1; contador > posicion && contador < maximo; contador++) {
                    datos[contador - 1] = datos[contador];
                }
            return posicion;
        } else{
            return -1;
        }
    }
    public int getNumeroElementos(){
        int contador = 0;
        while (this.getElemento(contador) != null) {
            contador++;
        }
        return contador;
    }
    public int getPosicion(ElementoLS<TipoDato> el) {
        int contador = 0;
        for (contador = 0; contador <= maximo; contador++)
            if (el.getData() == this.getElemento(contador).getData())
                break;
        return contador;
    }

    public ElementoLS<TipoDato> getPrimero(){
        return datos[0];
    }
    public ElementoLS<TipoDato> getUltimo(){
        int contador = 0;
        while (datos[contador]!=null){
            contador++;
        }
        return datos[contador-1];
    }
    private ElementoLS<TipoDato> getSiguiente(ElementoLS<TipoDato> el){
        ListaSimple<TipoDato> a = new ListaSimple(maximo);
        int posicion = a.getPosicion(el);
        return datos[posicion+1];
    }
    public ElementoLS<TipoDato> getElemento(int posicion){
        if (posicion <= maximo && posicion >= 0)
            return datos[posicion];
        return null;
    }
}
