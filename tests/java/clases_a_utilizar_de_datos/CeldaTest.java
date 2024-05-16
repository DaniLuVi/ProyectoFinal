package clases_a_utilizar_de_datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldaTest {

    @Test
    void getFila() {
        Celda c = new Celda(3, 5);
        assertEquals(3, c.getFila(), 3);
    }

    @Test
    void getColumna() {
        Celda c = new Celda(3, 5);
        assertEquals(5, c.getColumna(), 5);
    }

    @Test
    void setFilas() {
        Celda c = new Celda(3, 5);
        assertDoesNotThrow(()-> c.setFilas(3));
        assertEquals(3, c.getFila(), "Este no era el nª de filas que esperaba");
    }

    @Test
    void setColumnas() {
        Celda c = new Celda(3, 5);
        assertDoesNotThrow(()-> c.setColumnas(5));
        assertEquals(5, c.getColumna(), "Este no era el nª de columnas que esperaba");
    }

    @Test
    void getV() {
        Celda c = new Celda(3, 5);
        assertDoesNotThrow(()-> c.setV(50));
        assertEquals(50, c.getV(), 50);
    }

    @Test
    void setV() {
        Celda c = new Celda(3, 5);
        assertDoesNotThrow(()-> c.setV(50));
        assertEquals(50, c.getV(), "Esta no era la probabilidad V que esperaba");
    }

    @Test
    void getListaIndividuos() {
    }

    @Test
    void getListaEntornos() {
    }

    @Test
    void addIndividuo() {
    }

    @Test
    void addEntorno() {
    }

    @Test
    void getCoordenadas() {
    }

    @Test
    void setCoordenadas() {
    }

    @Test
    void setListaIndividuos() {
    }

    @Test
    void setListaEntornos() {
    }

    @Test
    void setDataGuardada() {
    }

    @Test
    void testToString() {

    }
}