package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import clases_a_utilizar_de_datos.Entorno;
import clases_a_utilizar_de_datos.Individuo;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParametrosModelo extends Individuo {
    private int filas;
    private int columnas;
    private int vidas;
    private int reproduccion;
    private int clonado;
    private int V;
    private Individuo individuo;
    private Entorno entorno;

    public ParametrosModelo(int filas, int columnas, Individuo individuo) {
        super(individuo.getId(), individuo.getGeneracion(), individuo.getVidas(), individuo.getReproduccion(), individuo.getClonacion());
        this.filas = filas;
        this.columnas = columnas;
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

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para cargar un objeto desde un archivo JSON
    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
