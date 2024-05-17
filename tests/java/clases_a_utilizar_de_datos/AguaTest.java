package clases_a_utilizar_de_datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AguaTest {

    @Test
    void modificarIndividuo() {
        Agua a = new Agua(3, 12);
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertDoesNotThrow(()-> a.modificarIndividuo(i));
        assertEquals(6, i.getVidas(), "Estas no es el nuevo número de vidas que esperaba");
    }
}