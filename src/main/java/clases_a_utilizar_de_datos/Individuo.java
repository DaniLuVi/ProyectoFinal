package clases_a_utilizar_de_datos;

import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ElementoLDE;

public class Individuo extends ElementoLDE<Individuo> {
    private int id;
    private int generacion;
    private int vidas;
    private int reproduccion;
    private int clonacion;
    private int turno_individuo;
    public Individuo() {}
    public Individuo(int id, int generacion, int vidas, int reproduccion, int clonacion, int turno_individuo) {
        this.id = id;
        this.generacion = generacion;
        this.vidas = vidas;
        this.reproduccion = reproduccion;
        this.clonacion = clonacion;
        this.turno_individuo = turno_individuo;
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

    public int getTurno_individuo() {
        return turno_individuo;
    }

    public void setTurno_individuo(int turno_individuo) {
        this.turno_individuo = turno_individuo;
    }

    public int getMuerte() {
        int muerte = 100 - this.getReproduccion();
        return muerte;
    }

    public String toString(Individuo individuo) {
        if (individuo instanceof TipoBasico) {
            return "Individuo[TipoBásico{" +
                    "id=" + id +
                    ", generacion=" + generacion +
                    ", vidas=" + vidas +
                    ", reproduccion=" + reproduccion +
                    ", clonacion=" + clonacion + ", turno_individuo=" + turno_individuo +
                    "}]";
        }
        if (individuo instanceof TipoNormal) {
            return "Individuo[TipoNormal{" +
                    "id=" + id +
                    ", generacion=" + generacion +
                    ", vidas=" + vidas +
                    ", reproduccion=" + reproduccion +
                    ", clonacion=" + clonacion + ", turno_individuo=" + turno_individuo +
                    "}]";
        }
        if (individuo instanceof TipoAvanzado) {
            return "Individuo[TipoAvanzado{" +
                    "id=" + id +
                    ", generacion=" + generacion +
                    ", vidas=" + vidas +
                    ", reproduccion=" + reproduccion +
                    ", clonacion=" + clonacion + ", turno_individuo=" + turno_individuo +
                    "}]";
        }
        return null;
    }
}
