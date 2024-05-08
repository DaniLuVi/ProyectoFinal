package estructuras_de_datos_implementadas.arbol;


import estructuras_de_datos_implementadas.listaSimplementeEnlazada.ListaEnlazada;

public class ArbolBinarioDeBusqueda<TipoDato>{
    Nodo<TipoDato> raiz;
    private int altura;
    private int contador = 2;
    public ArbolBinarioDeBusqueda() {
    }
    public ArbolBinarioDeBusqueda(Nodo<TipoDato> raiz) {
        this.raiz = raiz;
    }
    public Nodo<TipoDato> getRaiz() {
        return raiz;
    }
    public void setRaiz(Nodo<TipoDato> raiz) {
        this.raiz = raiz;
    }


    public void add(Nodo<TipoDato> nodo) {
        if (raiz == null){
            raiz = nodo;
        } else if (nodo == null) {
            System.out.println("El nodo es nulo");
        } else {
            raiz.add(nodo);
        }
    }
    public ArbolBinarioDeBusqueda<TipoDato> getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda<TipoDato> subarbol = new ArbolBinarioDeBusqueda<>();
        if (raiz != null && raiz.getIzquierda() != null)
            subarbol.setRaiz(raiz.getIzquierda());
        return subarbol;
    }
    public ArbolBinarioDeBusqueda<TipoDato> getSubArbolDerecha() {
        ArbolBinarioDeBusqueda<TipoDato> subarbol = new ArbolBinarioDeBusqueda<>();
        if (raiz != null && raiz.getDerecha() != null)
            subarbol.setRaiz(raiz.getDerecha());
        return subarbol;
    }

    public ListaEnlazada<TipoDato> getListaPreOrden() {
        ListaEnlazada<TipoDato> lista1 = new ListaEnlazada<TipoDato>();

        return getListaPreOrden(this.raiz, lista1);
    }
    private ListaEnlazada<TipoDato> getListaPreOrden(Nodo<TipoDato> n, ListaEnlazada<TipoDato> le){
        if (n != null) {
            le.add(n.dato);
            getListaPreOrden(n.izquierda, le);
            getListaPreOrden(n.derecha, le);
        }
        return le;
    }
    public ListaEnlazada<TipoDato> getListaPostOrden() {
        ListaEnlazada<TipoDato> lista1 = new ListaEnlazada<TipoDato>();
        return getListaPostOrden(this.raiz, lista1);
    }
    private ListaEnlazada<TipoDato> getListaPostOrden(Nodo<TipoDato> n, ListaEnlazada<TipoDato> le) {
        if (n != null) {
            getListaPostOrden(n.izquierda,le);
            getListaPostOrden(n.derecha,le);
            le.add(n.dato);
        }
        return le;
    }
    public ListaEnlazada<TipoDato> getListaOrdenCentral() {
        ListaEnlazada<TipoDato> lista1 = new ListaEnlazada<TipoDato>();
        return getListaOrdenCentral(this.raiz, lista1);
    }
    private ListaEnlazada<TipoDato> getListaOrdenCentral(Nodo<TipoDato> n, ListaEnlazada<TipoDato> listaEl) {
        if (n != null) {
            getListaOrdenCentral(n.izquierda,listaEl);
            listaEl.add(n.dato);
            getListaOrdenCentral(n.derecha,listaEl);
        }
        return listaEl;
    }
    public int getGrado() {
        if (raiz == null) {
            return 0;
        } else if (raiz.getIzquierda() != null) {
            if (raiz.getDerecha() != null) {
                return 2;
            } else if (raiz.getIzquierda() != null && raiz.getDerecha() == null) {
                return 1;
            }
        } else if (raiz.getDerecha() != null) {
            if (raiz.getIzquierda() != null) {
                return 2;
            } else if (raiz.getIzquierda() == null && raiz.getDerecha() != null){
                return 1;
            }
        }
        return 0;
    }

    public int getAltura() {
        return getAltura(raiz);
    }
    private int getAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int AI = getAltura(nodo.izquierda);
            int AD = getAltura(nodo.derecha);
            return Math.max(AI, AD) + 1;
        }
    }
    public ListaEnlazada<TipoDato> getListaDatosNivel(int t){
        ListaEnlazada <TipoDato> nivel = new ListaEnlazada<>();
        nivel(raiz, t, nivel,1);
        return nivel;
    }
    public void nivel(Nodo<TipoDato> nodo, int x, ListaEnlazada<TipoDato> datos, int y){
        if(nodo==null){
            return ;
        } else if (x==y) {
            datos.add(nodo.getDato());
        }
        else{
            nivel(nodo.getIzquierda(),x,datos,y+1);
            nivel(nodo.getDerecha(),x,datos,y+1);
        }
    }


    public boolean isArbolHomogeneo() {
        if (this.isArbolCompleto()) {
            return true;
        } else if (this.Grado1(this.raiz)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean Grado1 (Nodo<TipoDato> nodo) {
        if (nodo.getDerecha() == null && nodo.getIzquierda() != null) {
            return (true && Grado1(nodo.getIzquierda()));
        } else if (nodo.getDerecha() != null && nodo.getIzquierda() == null) {
            return (true && Grado1(nodo.getDerecha()));
        } else if (nodo.getDerecha() != null && nodo.getIzquierda() != null) {
            return false;
        } else {
            return true;
        }
    }
    public boolean isArbolCompleto(){
        boolean b = false;
        boolean bool = isArbolCompleto(raiz, b);
        return bool;
    }
    protected boolean isArbolCompleto(Nodo<TipoDato> a, boolean b) {
        if (a.izquierda != null && a.derecha != null){
            if (b == false) {
                isArbolCompleto(a.derecha, false);
                isArbolCompleto(a.izquierda, false);
            }
            else {
                isArbolCompleto(a.derecha, true);
                isArbolCompleto(a.izquierda, true);
            }
        }
        if (a.izquierda == null || a.derecha == null) {
            if (a.derecha != null) isArbolCompleto(a.derecha, false);
            if (a.izquierda != null) isArbolCompleto(a.izquierda, false);
        }
        return b;
    }
    boolean x1 = true;
    boolean x2 = true;

    public boolean isArbolCasiCompleto(Nodo<TipoDato> n, int numero) {
        ListaEnlazada<TipoDato> l1 = new ListaEnlazada<TipoDato>();
        if (n.getIzquierda() == null && n.getDerecha() == null) {
            l1 = getCamino(n, l1, this.raiz);
            int num = l1.getNumeroElementos();
            if (num == numero - 1) {
                x1 = false;
            } else if (num <= numero - 1) {
                x2 = false;
            }
            if (!x1) {
                if (num != numero - 1) {
                    x2 = false;
                }
            }
        }
        if (n.getIzquierda() != null) {
            isArbolCasiCompleto(n.getIzquierda(), numero);
        }
        if (n.getDerecha() != null) {
            isArbolCasiCompleto(n.getDerecha(), numero);
        }
        return x2;
    }
    public ListaEnlazada<TipoDato> getCamino(Nodo<TipoDato> nodo, ListaEnlazada<TipoDato> l1, Nodo<TipoDato> raiz) {
        ListaEnlazada<TipoDato> camino = new ListaEnlazada<TipoDato>();
        if (nodo != null)
            return getCaminos(camino, nodo, this.raiz);
        return null;
    }
    private ListaEnlazada<TipoDato> getCaminos(ListaEnlazada<TipoDato> datosLista, Nodo<TipoDato> nodoAbuscar, Nodo<TipoDato> nodoAcomparar) {
        if (nodoAcomparar != null) {
            Comparable MiNodo = (Comparable) nodoAbuscar.getDato();
            Comparable NodoActual = (Comparable) nodoAcomparar.getDato();
            if (MiNodo.compareTo(NodoActual) == 0){
                datosLista.add(nodoAcomparar.getDato());
                return datosLista;
            } else {
                datosLista.add(nodoAcomparar.getDato());
                if ((nodoAcomparar.getDerecha() != null) && (MiNodo.compareTo(NodoActual) > 0)) {
                    return getCaminos(datosLista, nodoAbuscar, nodoAcomparar.getDerecha());
                } else if ((nodoAcomparar.getIzquierda() != null) && (MiNodo.compareTo(NodoActual) < 0)) {
                    return getCaminos(datosLista, nodoAbuscar, nodoAcomparar.getIzquierda());
                }
            }
        }
        return datosLista;
    }

}
