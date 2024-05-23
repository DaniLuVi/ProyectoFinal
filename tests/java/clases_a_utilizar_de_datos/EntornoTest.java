package clases_a_utilizar_de_datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntornoTest {

    @Test
    void getTiempo_aparicion() {
        Entorno e = new Entorno(3, 12, "Agua");
        assertEquals(3, e.getTiempo_aparicion(), 3);
    }

    @Test
    void setTiempo_aparicion() {
        Entorno e = new Entorno(3, 12, "Agua");
        assertDoesNotThrow(()-> e.setTiempo_aparicion(3));
        assertEquals(3, e.getTiempo_aparicion(), "Este no es el tiempo de aparición que esperaba que saliera");
    }

    @Test
    void modificarIndividuo() {
    }

    @Test
    void getProbabilidad() {
        Entorno e = new Entorno(3, 12, "Agua");
        assertEquals(12, e.getProbabilidad());
    }

    @Test
    void setProbabilidad() {
        Entorno e = new Entorno(3, 12, "Agua");
        assertDoesNotThrow(()-> e.setProbabilidad(12));
        assertEquals(12, e.getProbabilidad(), "Esta no es la probabilidad que esperaba");
    }

    @Test
    void testToString() {
        Agua a = new Agua(3, 12, "Agua");
        Comida c = new Comida(3, 12, "Comida");
        Montaña  m = new Montaña(3, 12, "Montaña");
        Biblioteca b = new Biblioteca(3, 12, "Biblioteca");
        Pozo p = new Pozo(3, 12, "Pozo");
        Tesoro t = new Tesoro(3, 12, "Tesoro");
        Entorno e = new Entorno(3, 12, "Agua");
        assertEquals("Entorno[Agua{tiempo_aparicion=3, %Agua=12}]", a.toString(a));
        assertEquals("Entorno[Comida{tiempo_aparicion=3, %Comida=12}]", c.toString(c));
        assertEquals("Entorno[Montaña{tiempo_aparicion=3, %Montaña=12}]", m.toString(m));
        assertEquals("Entorno[Biblioteca{tiempo_aparicion=3, %Biblioteca=12}]", b.toString(b));
        assertEquals("Entorno[Pozo{tiempo_aparicion=3, %Pozo=12}]", p.toString(p));
        assertEquals("Entorno[Tesoro{tiempo_aparicion=3, %Tesoro=12}]", t.toString(t));
        assertEquals(null, e.toString(e));

    }
}