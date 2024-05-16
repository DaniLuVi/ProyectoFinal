package estructuras_de_datos_implementadas.grafo;


import estructuras_de_datos_implementadas.listaSimplementeEnlazada.ListaEnlazada;

public class Grafo<TipoDato> {
    private ListaEnlazada<NodoGrafo<TipoDato>> nodos;
    private ListaEnlazada<ArcoGrafo<TipoDato>> arcos;

    public Grafo() {
        this.nodos = new ListaEnlazada<>();
        this.arcos = new ListaEnlazada<>();
    }

    public ListaEnlazada<NodoGrafo<TipoDato>> getNodosGrafos() {
        return nodos;
    }

    public ListaEnlazada<ArcoGrafo<TipoDato>> getArcos() {
        return arcos;
    }



    public void addNodo(NodoGrafo<TipoDato> nodo) {
        if (nodos.isVacia()) {
            nodos.add(nodo);
        } else {
            boolean bool = false;
            for (int x = 0; x <= nodos.getNumeroElementos(); x++) {
                if (nodo.getDato() == nodos.getElemento(x).getData().getDato()) {
                    bool = true;
                }
            }
            if (!bool) {
                nodos.add(nodo);
            }
        }
    }
    public void add(ArcoGrafo<TipoDato> arco) throws ElementoRepetidoExcepcion {
        if (arcos.isVacia()) {
            arcos.add(arco);
        } else {
            int pos = 0;
            while (pos <= arcos.getNumeroElementos() - 1 && !arcos.getElemento(pos).getData().getEtiqueta().equals(arco.getEtiqueta())) {
                pos++;
            }
            if (pos >= arcos.getNumeroElementos() - 1 && !arcos.getUltimo().getData().getEtiqueta().equals(arco.getEtiqueta())) {
                arcos.add(arco);
            } else {
                throw new ElementoRepetidoExcepcion("Error, se ha intentado añadir un elemento ya existente.");
            }
        }
        if (nodos.isVacia() || (nodos.getPosicion(arco.getPrincipio()) == null)) {
            nodos.add(arco.getPrincipio());
        }
        if (nodos.isVacia() || nodos.getPosicion(arco.getDestino()) == null) {
            nodos.add(arco.getDestino());
        }
        arco.getPrincipio().addFrontera(arco);
        arco.getDestino().addFrontera(arco);
    }

    public void del(NodoGrafo<TipoDato> nodo){
            while (!nodo.getFrontera().isVacia()) {
                ArcoGrafo<TipoDato> arcoEliminar = nodo.getFrontera().getElemento(0).getData();
                arcoEliminar.getOtroVertice(nodo.getDato()).getFrontera().del(arcoEliminar.getOtroVertice(nodo.getDato()).getFrontera().getPosicion(arcoEliminar));
                arcos.del(arcos.getPosicion(arcoEliminar));
                nodo.getFrontera().del(nodo.getFrontera().getPosicion(arcoEliminar));
            }
            nodos.del(nodos.getPosicion(nodo));
        }
    public void del(ArcoGrafo<TipoDato> arco){
        arco.getPrincipio().getFrontera().del(arco.getPrincipio().getFrontera().getPosicion(arco));
        arco.getDestino().getFrontera().del(arco.getDestino().getFrontera().getPosicion(arco));
        arcos.del(arcos.getPosicion(arco));
    }
    public Mapa<NodoGrafo<TipoDato>, Camino<TipoDato>> getDijkstra(NodoGrafo<TipoDato> verticeOrigen) throws ElementoInexistenteExcepcion{
        Mapa<NodoGrafo<TipoDato>, Double> distancias = new Mapa<NodoGrafo<TipoDato>, Double>();
        ListaEnlazada<NodoGrafo<TipoDato>> colaPendientes = new ListaEnlazada<>();
        Mapa<NodoGrafo<TipoDato>, NodoGrafo<TipoDato>> verticesAnteriores = new Mapa<NodoGrafo<TipoDato>, NodoGrafo<TipoDato>>();

        this.dijkstra_Init(verticeOrigen, distancias, colaPendientes, verticesAnteriores);
        this.dijkstra_calcula(distancias, colaPendientes, verticesAnteriores);
        return this.dijkstra_ProcesaResultados(distancias, verticesAnteriores);
    }
    protected void dijkstra_Init(NodoGrafo<TipoDato> origen, Mapa<NodoGrafo<TipoDato>, Double> distancias, ListaEnlazada<NodoGrafo<TipoDato>> colaPendientes, Mapa<NodoGrafo<TipoDato>, NodoGrafo<TipoDato>> nodosAnteriores) {
        for (int i = 0; nodos.getElemento(i) != null; i ++) {
            distancias.put(nodos.getElemento(i).getData(), Double.MAX_VALUE);
        }
        distancias.put(origen, 0.0);
        colaPendientes.add(origen);
    }

    protected void dijkstra_calcula(Mapa<NodoGrafo<TipoDato>, Double>distancias, ListaEnlazada<NodoGrafo<TipoDato>> colaPendientes, Mapa<NodoGrafo<TipoDato>, NodoGrafo<TipoDato>> nodosAnteriores) throws ElementoInexistenteExcepcion {
        while (!colaPendientes.isVacia()) {
            NodoGrafo<TipoDato> nodoActual = colaPendientes.getUltimo().getData();
            colaPendientes.del(colaPendientes.getNumeroElementos()-1);
            for (int i = 0; nodoActual.getFrontera().getElemento(i) != null; i ++) {
                ArcoGrafo<TipoDato> arco = nodoActual.getFrontera().getElemento(i).getData();
                NodoGrafo<TipoDato> verticeVecino = arco.getOtroVertice(nodoActual.getDato());
                double nuevoCalculoDistancia1 = distancias.get(nodoActual) + arco.getDatos();

                if (nuevoCalculoDistancia1 < distancias.get(verticeVecino)) {
                    distancias.put(verticeVecino, nuevoCalculoDistancia1);
                    nodosAnteriores.put(verticeVecino, nodoActual);
                    colaPendientes.insert(verticeVecino, 0);
                }
            }
        }
    }
    protected Mapa<NodoGrafo<TipoDato>, Camino<TipoDato>> dijkstra_ProcesaResultados(Mapa<NodoGrafo<TipoDato>, Double> distancias, Mapa<NodoGrafo<TipoDato>, NodoGrafo<TipoDato>> nodosAnteriores) {
        Mapa<NodoGrafo<TipoDato>, Camino<TipoDato>> caminos = new Mapa<NodoGrafo<TipoDato>, Camino<TipoDato>>();
        ListaEnlazada<NodoGrafo<TipoDato>> listanodos = nodosAnteriores.KeySet();

        for (int i = 0; listanodos.getElemento(i) != null; i ++) {
            NodoGrafo<TipoDato> nodoDestino = listanodos.getElemento(i).getData();
            ListaEnlazada<NodoGrafo<TipoDato>> caminoCalculado = new ListaEnlazada<>();
            NodoGrafo<TipoDato> v = nodoDestino;
            while (v != null) {
                caminoCalculado.add(v);
                v = nodosAnteriores.get(v);
            }
            ListaEnlazada<NodoGrafo<TipoDato>> listaOrdenada = caminoCalculado.reverse(caminoCalculado);
            caminos.put(nodoDestino, new Camino<TipoDato>(listaOrdenada, distancias.get(nodoDestino)));
        }
        return caminos;
    }
    public ListaEnlazada<NodoGrafo<TipoDato>> getCaminoVertices(NodoGrafo<TipoDato> salida, NodoGrafo<TipoDato> llegada) throws ElementoInexistenteExcepcion {
        if (nodos.getPosicion(salida) != null && nodos.getPosicion(llegada) != null) {
            ListaEnlazada<NodoGrafo<TipoDato>> caminoHastaLlegada = this.getDijkstra(salida).get(llegada).getCamino();
            return caminoHastaLlegada;
        } else {
            throw new ElementoInexistenteExcepcion("Error, alguno de los datos no están en el grafo");
        }
    }


    public ListaEnlazada<TipoDato> getCamino(NodoGrafo<TipoDato> salida, NodoGrafo<TipoDato> llegada) throws ElementoInexistenteExcepcion {
        ListaEnlazada<TipoDato> camino = new ListaEnlazada<>();
        ListaEnlazada<NodoGrafo<TipoDato>> caminoVertices = getCaminoVertices(salida, llegada);
        for (int i = 0; i < caminoVertices.getNumeroElementos(); i ++) {
            camino.add(caminoVertices.getElemento(i).getData().getDato());
        }
        return camino;
    }
}