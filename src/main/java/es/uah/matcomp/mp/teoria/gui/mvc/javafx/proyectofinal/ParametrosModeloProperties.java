package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;

public class ParametrosModeloProperties {
    protected ParametrosModelo original;
    private IntegerProperty filas = new SimpleIntegerProperty();
    private IntegerProperty columnas = new SimpleIntegerProperty();
    private IntegerProperty id = new SimpleIntegerProperty();
    private IntegerProperty generacion = new SimpleIntegerProperty();
    private IntegerProperty vidas = new SimpleIntegerProperty();
    private IntegerProperty reproduccion = new SimpleIntegerProperty();
    private IntegerProperty clonado = new SimpleIntegerProperty();
    private IntegerProperty turno_individuo = new SimpleIntegerProperty();
    private IntegerProperty V = new SimpleIntegerProperty();
    private IntegerProperty agua = new SimpleIntegerProperty();
    private IntegerProperty comida = new SimpleIntegerProperty();
    private IntegerProperty montaña = new SimpleIntegerProperty();
    private IntegerProperty biblioteca = new SimpleIntegerProperty();
    private IntegerProperty pozo = new SimpleIntegerProperty();
    private IntegerProperty tesoro = new SimpleIntegerProperty();

    public ParametrosModeloProperties(ParametrosModelo original) {
        setOriginal(original);
    }
    public void commit() {
        original.setFilas(filas.get());
        original.setColumnas(columnas.get());
        original.setId(id.get());
        original.setGeneracion(generacion.get());
        original.setVidas(vidas.get());
        original.setReproduccion(reproduccion.get());
        original.setClonado(clonado.get());
        original.setTurno_individuo(turno_individuo.get());
        original.setV(V.get());
        original.setAgua(agua.get());
        original.setComida(comida.get());
        original.setMontaña(montaña.get());
        original.setBiblioteca(biblioteca.get());
        original.setPozo(pozo.get());
        original.setTesoro(tesoro.get());
    }
    public void rollback() {
        filas.set(original.getFilas());
        columnas.set(original.getColumnas());
        id.set(original.getId());
        generacion.set(original.getGeneracion());
        vidas.set(original.getVidas());
        reproduccion.set(original.getReproduccion());
        clonado.set(original.getClonado());
        turno_individuo.set(original.getTurno_individuo());
        V.set(original.getV());
        agua.set(original.getAgua());
        comida.set(original.getComida());
        montaña.set(original.getMontaña());
        biblioteca.set(original.getBiblioteca());
        pozo.set(original.getPozo());
        tesoro.set(original.getTesoro());
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
    public Property<Number> idProperty() {
        return id;
    }
    public Property<Number> generacionProperty() {
        return generacion;
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
    public Property<Number> turno_individuoProperty() {
        return turno_individuo;
    }
    public Property<Number> VProperty() {
        return V;
    }
    public Property<Number> aguaProperty() { return agua;}
    public Property<Number> comidaProperty() { return comida;}
    public Property<Number> montañaProperty() { return montaña;}
    public Property<Number> bibliotecaProperty() { return biblioteca;}
    public Property<Number> pozoProperty() { return pozo;}
    public Property<Number> tesoroProperty() { return tesoro;}

    public void setFilas(IntegerProperty filas) {
        this.filas = filas;
    }

    public void setColumnas(IntegerProperty columnas) {
        this.columnas = columnas;
    }
    public void setId(IntegerProperty id) {
        this.id = id;
    }
    public void setGeneracion(IntegerProperty generacion) {
        this.generacion = generacion;
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
    public void setTurno_individuo(IntegerProperty turno_individuo) {
        this.turno_individuo = turno_individuo;
    }
    public void setV(IntegerProperty v) {
        this.V = v;
    }
    public void setAgua(IntegerProperty agua) { this.agua = agua;}
    public void setComida(IntegerProperty comida) { this.comida = comida;}
    public void setMontaña(IntegerProperty montaña) { this.montaña = montaña;}
    public void setBiblioteca(IntegerProperty biblioteca) { this.biblioteca = biblioteca;}
    public void setPozo(IntegerProperty pozo) { this.pozo = pozo;}
    public void setTesoro(IntegerProperty tesoro) { this.tesoro = tesoro;}
}
