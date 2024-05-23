package clases_a_utilizar_de_datos;

import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ElementoLDE;

public class Entorno extends ElementoLDE<Entorno> {
    private int tiempo_aparicion;

    private int probabilidad;
    private String tipo;

    public Entorno(int tiempo_aparicion, int probabilidad, String tipo) {
        this.tiempo_aparicion = tiempo_aparicion;
        this.probabilidad = probabilidad;
        this.tipo = tipo;
    }
    public Entorno() {}

    public int getTiempo_aparicion() {
        return tiempo_aparicion;
    }

    public void setTiempo_aparicion(int tiempo_aparicion) {
        this.tiempo_aparicion = tiempo_aparicion;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void TipoEntorno() {
        if (tipo == "Agua") {
            Agua agua = (Agua) this;
        } else if (tipo == "Comida") {
            Comida comida = (Comida) this;
        } else if (tipo == "Montaña") {
            Montaña montaña = (Montaña) this;
        } else if (tipo == "Biblioteca") {
            Biblioteca biblioteca = (Biblioteca) this;
        } else if (tipo == "Tesoro") {
            Tesoro tesoro = (Tesoro) this;
        } else if (tipo == "Pozo") {
            Pozo pozo = (Pozo) this;
        }
    }

    public String toString(Entorno entorno) {
        if (entorno instanceof Agua) {
            return "Entorno[Agua{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Agua=" + probabilidad +
                    "}]";
        } else if (entorno instanceof Comida) {
            return "Entorno[Comida{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Comida=" + probabilidad +
                    "}]";
        } else if (entorno instanceof Montaña) {
            return "Entorno[Montaña{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Montaña=" + probabilidad +
                    "}]";
        } else if (entorno instanceof Biblioteca) {
            return "Entorno[Biblioteca{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Biblioteca=" + probabilidad +
                    "}]";
        } else if (entorno instanceof Pozo) {
            return "Entorno[Pozo{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Pozo=" + probabilidad +
                    "}]";
        } else if (entorno instanceof Tesoro) {
            return "Entorno[Tesoro{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Tesoro=" + probabilidad +
                    "}]";
        }
        return null;
    }

    public void modificarIndividuo(Individuo individuo) {}
}
