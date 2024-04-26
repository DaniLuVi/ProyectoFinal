package clases_a_utilizar_de_datos;

import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ElementoLDE;

public class Entorno extends ElementoLDE<Entorno> {
    private int tiempo_aparicion;

    private int v;

    public Entorno(int tiempo_aparicion, int v) {
        this.tiempo_aparicion = tiempo_aparicion;
        this.v = v;
    }

    public int getTiempo_aparicion() {
        return tiempo_aparicion;
    }

    public void setTiempo_aparicion(int tiempo_aparicion) {
        this.tiempo_aparicion = tiempo_aparicion;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void turno(Entorno entorno) {}

    public void modificarIndividuo(Individuo individuo) {}
}
