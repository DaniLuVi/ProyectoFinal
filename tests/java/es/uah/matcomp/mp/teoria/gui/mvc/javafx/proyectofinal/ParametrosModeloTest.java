package es.uah.matcomp.mp.teoria.gui.mvc.javafx.proyectofinal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParametrosModeloTest {

    @Test
    void getFilas() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 0, 78, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(3, para.getFilas());
    }

    @Test
    void setFilas() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setFilas(3));
        assertEquals(3, para.getFilas(), "Estas no son las filas que esperaba");
    }

    @Test
    void getColumnas() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(4, para.getColumnas());
    }

    @Test
    void setColumnas() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setColumnas(4));
        assertEquals(4, para.getColumnas(), "Estas no son las columnas que esperaba");
    }

    @Test
    void getVidas() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(5, para.getVidas());
    }

    @Test
    void setVidas() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setVidas(5));
        assertEquals(5, para.getVidas(), "Estas no son las vidas que esperaba");
    }

    @Test
    void getReproduccion() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(7, para.getReproduccion());
    }

    @Test
    void setReproduccion() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setReproduccion(7));
        assertEquals(7, para.getReproduccion(), "Este no es el % de reproducción que esperaba");
    }

    @Test
    void getClonado() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(78, para.getClonado());
    }

    @Test
    void setClonado() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setClonado(78));
        assertEquals(78, para.getClonado(), "Este no es el % de clonado que esperaba");
    }
    @Test
    void getTurno_individuo() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(0, para.getTurno_individuo());
    }

    @Test
    void setTurno_individuo() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setTurno_individuo(0));
        assertEquals(0, para.getTurno_individuo(), "Este no es el turno que esperaba");
    }

    @Test
    void getV() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(34, para.getV());
    }

    @Test
    void setV() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setV(34));
        assertEquals(34, para.getV(), "Este no es el % V que esperaba");
    }

    @Test
    void getAgua() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(56, para.getAgua());
    }

    @Test
    void setAgua() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setAgua(56));
        assertEquals(56, para.getAgua(), "Este no es el % de agua que esperaba");
    }

    @Test
    void getComida() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(65, para.getComida());
    }

    @Test
    void setComida() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setComida(65));
        assertEquals(65, para.getComida(), "Este no es el % de comida que esperaba");
    }

    @Test
    void getMontaña() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(98, para.getMontaña());
    }

    @Test
    void setMontaña() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setMontaña(98));
        assertEquals(98, para.getMontaña(), "Este no es el % de montaña que esperaba");
    }

    @Test
    void getBiblioteca() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(12, para.getBiblioteca());
    }

    @Test
    void setBiblioteca() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setBiblioteca(12));
        assertEquals(12, para.getBiblioteca(), "Este no es el % de biblioteca que esperaba");
    }

    @Test
    void getPozo() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(34, para.getPozo());
    }

    @Test
    void setPozo() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setPozo(34));
        assertEquals(34, para.getPozo(), "Este no es el % de pozo que esperaba");
    }

    @Test
    void getTesoro() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertEquals(54, para.getTesoro());
    }

    @Test
    void setTesoro() {
        ParametrosModelo para = new ParametrosModelo(3, 4, 5, 7, 78, 0, 34, 56, 65, 98, 12, 34, 54);
        assertDoesNotThrow(()-> para.setTesoro(54));
        assertEquals(54, para.getTesoro(), "Este no es el % de tesoro que esperaba");
    }
}