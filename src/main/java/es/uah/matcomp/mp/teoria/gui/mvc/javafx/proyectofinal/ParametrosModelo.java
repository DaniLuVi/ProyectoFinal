package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Entorno;
import clases_a_utilizar_de_datos.Individuo;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParametrosModelo {
    private int filas;
    private int columnas;
    private int vidas;
    private int reproduccion;
    private int clonado;
    private int V;
    private Individuo individuo;
    private Entorno entorno;

    public ParametrosModelo(int filas, int columnas, int vidas, int reproduccion, int clonado, int V) {
        this.filas = filas;
        this.columnas = columnas;
        this.vidas = vidas;
        this.reproduccion = reproduccion;
        this.clonado = clonado;
        this.V = V;
    }  // como hago esto para que me funcione bien

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

    public Individuo getIndividuo() {
        individuo.setVidas(vidas);
        individuo.setReproduccion(reproduccion);
        individuo.setClonacion(clonado);
        return individuo;
    }
    public Entorno getEntorno() {
        entorno.setV(V);
        return entorno;
    }
}
