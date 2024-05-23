package clases_a_utilizar_de_datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MontañaTest {
    @Test
    void modificarIndividuo() {
        Montaña m = new Montaña(3, 30, "Montaña");
        Individuo i = new Individuo(01, 3, 4, 40, 35, 3, "TipoAvanzado");
        assertDoesNotThrow(()-> m.modificarIndividuo(i));
        assertEquals(2, i.getVidas(), "Estas no es el nuevo número de vidas que esperaba");
    }
}