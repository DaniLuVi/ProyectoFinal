package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

public class ParametrosModelo {
    private int filas;
    private int columnas;
    private int vidas;
    private int reproduccion;
    private int clonado;
    private int V;

    public ParametrosModelo(int filas, int columnas, int vidas, int reproduccion, int clonado, int V) {
        this.filas = filas;
        this.columnas = columnas;
        this.vidas = vidas;
        this.reproduccion = reproduccion;
        this.clonado = clonado;
        this.V = V;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
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

    public int getClonado() {
        return clonado;
    }

    public void setClonado(int clonado) {
        this.clonado = clonado;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }
}
