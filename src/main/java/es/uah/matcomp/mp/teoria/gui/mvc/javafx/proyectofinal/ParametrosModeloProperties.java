package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ParametrosModeloProperties {
    protected ParametrosModelo original;
    private IntegerProperty filas = new SimpleIntegerProperty();
    private IntegerProperty columnas = new SimpleIntegerProperty();
    private IntegerProperty vidas = new SimpleIntegerProperty();
    private IntegerProperty reproduccion = new SimpleIntegerProperty();
    private IntegerProperty clonado = new SimpleIntegerProperty();

    public ParametrosModeloProperties(ParametrosModelo original) {
        setOriginal(original);
    }
    public void commit() {

    }

    public ParametrosModelo getOriginal() {
        return original;
    }

    public void setOriginal(ParametrosModelo original) {
        this.original = original;
    }
}
