package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParametrosModeloTest {

    @Test
    void getFilas() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(3, para.getFilas());
    }

    @Test
    void setFilas() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setFilas(3));
        assertEquals(3, para.getFilas(), "Estas no son las filas que esperaba");
    }

    @Test
    void getColumnas() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(4, para.getColumnas());
    }

    @Test
    void setColumnas() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setColumnas(4));
        assertEquals(4, para.getColumnas(), "Estas no son las columnas que esperaba");
    }

    @Test
    void getVidas() {
    }

    @Test
    void setVidas() {
    }

    @Test
    void getReproduccion() {
    }

    @Test
    void setReproduccion() {
    }

    @Test
    void getClonado() {
    }

    @Test
    void setClonado() {
    }

    @Test
    void getV() {
    }

    @Test
    void setV() {
    }

    @Test
    void getAgua() {
    }

    @Test
    void setAgua() {
    }

    @Test
    void getComida() {
    }

    @Test
    void setComida() {
    }

    @Test
    void getMontaña() {
    }

    @Test
    void setMontaña() {
    }

    @Test
    void getBiblioteca() {
    }

    @Test
    void setBiblioteca() {
    }

    @Test
    void getPozo() {
    }

    @Test
    void setPozo() {
    }

    @Test
    void getTesoro() {
    }

    @Test
    void setTesoro() {
    }
}