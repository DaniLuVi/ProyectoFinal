package clases_a_utilizar_de_datos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {

    @Test
    void getId() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertEquals(01, i.getId(), 01);
    }

    @Test
    void setId() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertDoesNotThrow(()-> i.setId(01));
        assertEquals(01, i.getId(), "Esta no es la identificación que esperaba");
    }

    @Test
    void getGeneracion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertEquals(3, i.getGeneracion(), 3);
    }

    @Test
    void setGeneracion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertDoesNotThrow(()-> i.setGeneracion(3));
        assertEquals(3, i.getGeneracion(), "Esta no es la generación que se esperaba");
    }

    @Test
    void getVidas() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertEquals(4, i.getVidas(), 4);
    }

    @Test
    void setVidas() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertDoesNotThrow(()-> i.setVidas(4));
        assertEquals(4, i.getVidas(), "Estas no son las vidas que se esperaban");
    }

    @Test
    void getReproduccion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertEquals(40, i.getReproduccion(), 40);
    }

    @Test
    void setReproduccion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertDoesNotThrow(()-> i.setReproduccion(40));
        assertEquals(40, i.getReproduccion(), "Este no es el % de reproducción que se esperaba");
    }

    @Test
    void getClonacion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertEquals(35, i.getClonacion(), 35);
    }

    @Test
    void setClonacion() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertDoesNotThrow(()-> i.setClonacion(35));
        assertEquals(35, i.getClonacion(), "Este no es el % de clonación que se esperaba");
    }

    @Test
    void getMuerte() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertEquals(60, i.getMuerte());
    }

    @Test
    void getTurno_individuo() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertEquals(0, i.getTurno_individuo());
    }

    @Test
    void setTurno_individuo() {
        Individuo i = new Individuo(01, 3, 4, 40, 35, 0);
        assertDoesNotThrow(()-> i.setTurno_individuo(0));
        assertEquals(0, i.getTurno_individuo(), "Este no es el turno que esperaba");
    }

    @Test
    void testToString() {
        TipoBasico t1 = new TipoBasico(1, 3, 4, 45, 43, 0);
        TipoNormal t2 = new TipoNormal(2, 3, 4, 65, 78, 0);
        TipoAvanzado t3 = new TipoAvanzado(3, 4, 5, 32,89, 0);
        Individuo i = new Individuo();
        assertEquals("Individuo[TipoBásico{id=1, generacion=3, vidas=4, reproduccion=45, clonacion=43, turno_individuo=0}]", t1.toString(t1));
        assertEquals("Individuo[TipoNormal{id=2, generacion=3, vidas=4, reproduccion=65, clonacion=78, turno_individuo=0}]", t2.toString(t2));
        assertEquals("Individuo[TipoBásico{id=3, generacion=4, vidas=5, reproduccion=32, clonacion=89, turno_individuo=0}]", t3.toString(t3));
        assertEquals(null, i.toString(i));
    }
}