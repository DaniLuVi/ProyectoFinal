package clases_a_utilizar_de_datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesoroTest {

    @Test
    void modificarIndividuo() {
        Tesoro t = new Tesoro(3, 12, "Tesoro");
        Individuo i = new Individuo(1, 3, 4, 50, 25, 3, "TipoAvanzado");
        assertDoesNotThrow(()-> t.modificarIndividuo(i));
        assertEquals(65, i.getReproduccion(), "Este no es el % de reproducción que esperaba");
    }
}