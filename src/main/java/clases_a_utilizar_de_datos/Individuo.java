package clases_a_utilizar_de_datos;

import com.google.gson.*;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ElementoLDE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class Individuo extends ElementoLDE<Individuo> implements JsonSerializer<Individuo> {
    private static final Logger log = LogManager.getLogger(Individuo.class);
    private int id;
    private int generacion;
    private int vidas;
    private int reproduccion;
    private int clonacion;
    private int turno_individuo;
    private String tipo;
    public Individuo() {}
    public Individuo(int id, int generacion, int vidas, int reproduccion, int clonacion, int turno_individuo, String tipo) {
        this.id = id;
        this.generacion = generacion;
        this.vidas = vidas;
        this.reproduccion = reproduccion;
        this.clonacion = clonacion;
        this.turno_individuo = turno_individuo;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getReproduccion() {
        return reproduccion;
    }

    public void setReproduccion(int reproduccion) {
        this.reproduccion = reproduccion;
    }

    public int getClonacion() {
        return clonacion;
    }

    public void setClonacion(int clonacion) {
        this.clonacion = clonacion;
    }

    public int getTurno_individuo() {
        return turno_individuo;
    }

    public void setTurno_individuo(int turno_individuo) {
        this.turno_individuo = turno_individuo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void TipoIndividuo() {
        if (tipo == "TipoBasico") {
            TipoBasico tipoBasico = (TipoBasico) this;
        } else if (tipo == "TipoNormal") {
            TipoNormal tipoNormal = (TipoNormal) this;
        } else if (tipo == "TipoAvanzado") {
            TipoAvanzado tipoAvanzado = (TipoAvanzado) this;
        }
    }

    public int getMuerte() {
        int muerte = 100 - this.getReproduccion();
        return muerte;
    }

    public String toString(Individuo individuo) {
        if (individuo instanceof TipoBasico) {
            return "Individuo[TipoBásico{" +
                    "id=" + id +
                    ", generacion=" + generacion +
                    ", vidas=" + vidas +
                    ", reproduccion=" + reproduccion +
                    ", clonacion=" + clonacion + ", turno_individuo=" + turno_individuo +
                    "}]";
        }
        if (individuo instanceof TipoNormal) {
            return "Individuo[TipoNormal{" +
                    "id=" + id +
                    ", generacion=" + generacion +
                    ", vidas=" + vidas +
                    ", reproduccion=" + reproduccion +
                    ", clonacion=" + clonacion + ", turno_individuo=" + turno_individuo +
                    "}]";
        }
        if (individuo instanceof TipoAvanzado) {
            return "Individuo[TipoAvanzado{" +
                    "id=" + id +
                    ", generacion=" + generacion +
                    ", vidas=" + vidas +
                    ", reproduccion=" + reproduccion +
                    ", clonacion=" + clonacion + ", turno_individuo=" + turno_individuo +
                    "}]";
        }
        return null;
    }
    @Override
    public JsonElement serialize(Individuo individuo, Type type, JsonSerializationContext jsonSerializationContext) {

        log.info("Se serializa un individuo a JSON");

        JsonObject individuoAserializar = new JsonObject();
        individuoAserializar.add("id", new JsonPrimitive(individuo.id));
        individuoAserializar.add("generacion", new JsonPrimitive(individuo.generacion));
        individuoAserializar.add("vidas", new JsonPrimitive(individuo.vidas));
        individuoAserializar.add("reproduccion", new JsonPrimitive(individuo.reproduccion));
        individuoAserializar.add("clonacion", new JsonPrimitive(individuo.clonacion));
        individuoAserializar.add("turno_individuo", new JsonPrimitive(individuo.turno_individuo));

        return individuoAserializar;
    }

}
