package clases_a_utilizar_de_datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {

    @Test
    void getId() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertEquals(01, i.getId(), 01);
    }

    @Test
    void setId() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertDoesNotThrow(()-> i.setId(01));
        assertEquals(01, i.getId(), "Esta no es la identificación que esperaba");
    }

    @Test
    void getGeneracion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertEquals(3, i.getGeneracion(), 3);
    }

    @Test
    void setGeneracion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertDoesNotThrow(()-> i.setGeneracion(3));
        assertEquals(3, i.getGeneracion(), "Esta no es la generación que se esperaba");
    }

    @Test
    void getVidas() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertEquals(4, i.getVidas(), 4);
    }

    @Test
    void setVidas() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertDoesNotThrow(()-> i.setVidas(4));
        assertEquals(4, i.getVidas(), "Estas no son las vidas que se esperaban");
    }

    @Test
    void getReproduccion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertEquals(40, i.getReproduccion(), 40);
    }

    @Test
    void setReproduccion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertDoesNotThrow(()-> i.setReproduccion(40));
        assertEquals(40, i.getReproduccion(), "Este no es el % de reproducción que se esperaba");
    }

    @Test
    void getClonacion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertEquals(35, i.getClonacion(), 35);
    }

    @Test
    void setClonacion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);
        assertDoesNotThrow(()-> i.setClonacion(35));
        assertEquals(35, i.getClonacion(), "Este no es el % de clonación que se esperaba");
    }

    @Test
    void getMuerte() {
        Individuo i = new Individuo(01, 3, 4, 40, 35);

    }

    @Test
    void movimiento() {
    }

    @Test
    void turno() {
    }
}