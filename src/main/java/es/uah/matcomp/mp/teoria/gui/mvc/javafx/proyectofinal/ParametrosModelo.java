package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Entorno;
import clases_a_utilizar_de_datos.Individuo;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParametrosModelo {
    public int filas;
    public int columnas;
    public int id;
    public int generacion;
    public int vidas;
    public int reproduccion;
    public int clonado;
    public int turno_individuo;
    public int V;
    public int agua;
    public int comida;
    public int montaña;
    public int biblioteca;
    public int pozo;
    public int tesoro;


    public ParametrosModelo(int filas, int columnas, int id, int generacion, int vidas, int reproduccion, int clonado, int turno_individuo, int V, int agua, int comida, int montaña, int biblioteca, int pozo, int tesoro) {
        this.filas = filas;
        this.columnas = columnas;
        this.id = id;
        this.generacion = generacion;
        this.vidas = vidas;
        this.reproduccion = reproduccion;
        this.clonado = clonado;
        this.turno_individuo = turno_individuo;
        this.V = V;
        this.agua = agua;
        this.comida = comida;
        this.montaña = montaña;
        this.biblioteca = biblioteca;
        this.pozo = pozo;
        this.tesoro = tesoro;
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

    public int getClonado() {
        return clonado;
    }

    public void setClonado(int clonado) {
        this.clonado = clonado;
    }

    public int getTurno_individuo() {
        return turno_individuo;
    }

    public void setTurno_individuo(int turno_individuo) {
        this.turno_individuo = turno_individuo;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    public int getMontaña() {
        return montaña;
    }

    public void setMontaña(int montaña) {
        this.montaña = montaña;
    }

    public int getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(int biblioteca) {
        this.biblioteca = biblioteca;
    }

    public int getPozo() {
        return pozo;
    }

    public void setPozo(int pozo) {
        this.pozo = pozo;
    }

    public int getTesoro() {
        return tesoro;
    }

    public void setTesoro(int tesoro) {
        this.tesoro = tesoro;
    }

}
