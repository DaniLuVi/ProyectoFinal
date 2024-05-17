package clases_a_utilizar_de_datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    void modificarIndividuo() {
        Biblioteca b = new Biblioteca(3, 12);
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertDoesNotThrow(()-> b.modificarIndividuo(i));
        assertEquals(45, i.getClonacion(), "Este no es el % de clonación que esperaba");
    }
}