package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;

public class ParametrosModeloProperties {
    protected ParametrosModelo original;
    private IntegerProperty filas = new SimpleIntegerProperty();
    private IntegerProperty columnas = new SimpleIntegerProperty();
    private IntegerProperty vidas = new SimpleIntegerProperty();
    private IntegerProperty reproduccion = new SimpleIntegerProperty();
    private IntegerProperty clonado = new SimpleIntegerProperty();
    private IntegerProperty V = new SimpleIntegerProperty();

    public ParametrosModeloProperties(ParametrosModelo original) {
        setOriginal(original);
    }
    public void commit() {
        original.setFilas(filas.get());
        original.setColumnas(columnas.get());
        original.setVidas(vidas.get());
        original.setReproduccion(reproduccion.get());
        original.setClonacion(clonado.get());
        original.setV(V.get());
    }
    public void rollback() {
        filas.set(original.getFilas());
        columnas.set(original.getColumnas());
        vidas.set(original.getVidas());
        reproduccion.set(original.getReproduccion());
        clonado.set(original.getClonacion());
        V.set(original.getV());
    }

    public ParametrosModelo getOriginal() {
        return original;
    }

    public void setOriginal(ParametrosModelo original) {
        this.original = original;
        rollback();
    }
    public Property<Number> filasProperty() {
        return filas;
    }
    public Property<Number> columnasProperty() {
        return columnas;
    }
    public Property<Number> vidasProperty() {
        return vidas;
    }
    public Property<Number> reproduccionProperty() {
        return reproduccion;
    }
    public Property<Number> clonadoProperty() {
        return clonado;
    }
    public Property<Number> VProperty() {
        return V;
    }

    public void setFilas(IntegerProperty filas) {
        this.filas = filas;
    }

    public void setColumnas(IntegerProperty columnas) {
        this.columnas = columnas;
    }

    public void setVidas(IntegerProperty vidas) {
        this.vidas = vidas;
    }

    public void setReproduccion(IntegerProperty reproduccion) {
        this.reproduccion = reproduccion;
    }

    public void setClonado(IntegerProperty clonado) {
        this.clonado = clonado;
    }

    public void setV(IntegerProperty v) {
        this.V = v;
    }
}
