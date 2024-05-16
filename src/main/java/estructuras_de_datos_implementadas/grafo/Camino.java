package estructuras_de_datos_implementadas.grafo;

import estructuras_de_datos_implementadas.listaSimplementeEnlazada.ListaEnlazada;

public class Camino<TipoDato> {
        ListaEnlazada<NodoGrafo<TipoDato>> camino;
        double coste;
        public Camino(ListaEnlazada<NodoGrafo<TipoDato>>camino, double coste){
            this.camino=camino;
            this.coste=coste;
        }
        public ListaEnlazada<NodoGrafo<TipoDato>> getCamino(){
            return camino;
        }

        public double getCoste() {
            return coste;
        }

        @Override
        public String toString() {
            ListaEnlazada<String> texto = new ListaEnlazada<>();
            texto.add("Camino desde: (" + getCamino().getPrimero() + ") hasta (" + getCamino().getUltimo() + ")\n");
            texto.add("Lista de los vertices recorridos: " + this.getCamino());
        /*    for (NodoGrafo<T> nodo : this.getCamino()) {   // tengo que hacer un método para recorrer las listas
                texto.add(nodo.dato + ",");
            }
 */           texto.add(" - Coste: " + this.getCoste() + "\n");
            return texto.toString();
        }
    }
