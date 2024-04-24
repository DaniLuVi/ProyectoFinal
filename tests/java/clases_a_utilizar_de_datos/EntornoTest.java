package clases_a_utilizar_de_datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntornoTest {

    @Test
    void getTiempo_aparicion() {
        Entorno e = new Entorno(3, 12);
        assertEquals(3, e.getTiempo_aparicion(), 3);
    }

    @Test
    void setTiempo_aparicion() {
        Entorno e = new Entorno(3, 12);
        assertDoesNotThrow(()-> e.setTiempo_aparicion(3));
        assertEquals(3, e.getTiempo_aparicion(), "Este no es el tiempo de aparición que esperaba que saliera");
    }

    @Test
    void getV() {
        Entorno e = new Entorno(3, 12);
        assertEquals(12, e.getV(), 12);
    }

    @Test
    void setV() {
        Entorno e = new Entorno(3, 12);
        assertDoesNotThrow(()-> e.setV(12));
        assertEquals(12, e.getV(), "Esta no es la probabilidad V que esperaba");
    }

    @Test
    void turno() {
    }

    @Test
    void modificarIndividuo() {
    }
}