package clases_a_utilizar_de_datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComidaTest {

    @Test
    void modificarIndividuo() {
        Comida c = new Comida(3, 12);
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertDoesNotThrow(()-> c.modificarIndividuo(i));
        assertEquals(14, i.getVidas(), "Estas no es el nuevo número de vidas que esperaba");
    }
}