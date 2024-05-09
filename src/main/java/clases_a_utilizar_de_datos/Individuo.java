package clases_a_utilizar_de_datos;

import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ElementoLDE;

public class Individuo extends ElementoLDE<Individuo> {
    private int id;
    private int generacion;
    private int vidas;
    private int reproduccion;
    private int clonacion;
    public Individuo() {}
    public Individuo(int id, int generacion, int vidas, int reproduccion, int clonacion) {
        this.id = id;
        this.generacion = generacion;
        this.vidas = vidas;
        this.reproduccion = reproduccion;
        this.clonacion = clonacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getReproduccion() {
        return reproduccion;
    }

    public void setReproduccion(int reproduccion) {
        this.reproduccion = reproduccion;
    }

    public int getClonacion() {
        return clonacion;
    }

    public void setClonacion(int clonacion) {
        this.clonacion = clonacion;
    }

    public int getMuerte() {
        int muerte = 100 - this.getReproduccion();
        return muerte;
    }
    public void movimiento(Individuo individuo) {}

    public void turno(Individuo individuo) {}
}
