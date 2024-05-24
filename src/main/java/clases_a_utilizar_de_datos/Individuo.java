package clases_a_utilizar_de_datos;

import com.google.gson.*;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ElementoLDE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class Individuo extends ElementoLDE<Individuo> implements JsonSerializer<Individuo>, JsonDeserializer<Individuo> {
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
        try {
            if (getTipo() == "TipoBasico") {
                TipoBasico tipoBasico = TipoBasico.class.cast(this);
            } else if (getTipo() == "TipoNormal") {
                TipoNormal tipoNormal = TipoNormal.class.cast(this);
            } else if (getTipo() == "TipoAvanzado") {
                TipoAvanzado tipoAvanzado = TipoAvanzado.class.cast(this);
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
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
        individuoAserializar.addProperty("tipo", individuo.getClass().descriptorString());
        individuoAserializar.add("data", jsonSerializationContext.serialize(individuo));

        log.info("Individuo serializado");

        return individuoAserializar;
    }

    @Override
    public Individuo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        log.info("Se deserializa de JSON a un individuo");

        JsonObject individuoADeserializar = jsonElement.getAsJsonObject();
        if (individuoADeserializar.get("tipo").getAsString().contains("TipoBasico")) {
            return jsonDeserializationContext.deserialize(individuoADeserializar.get("data"), TipoBasico.class);
        } else if (individuoADeserializar.get("tipo").getAsString().contains("TipoNormal")) {
            return jsonDeserializationContext.deserialize(individuoADeserializar.get("data"), TipoNormal.class);
        } else if (individuoADeserializar.get("tipo").getAsString().contains("TipoAvanzado")) {
            return jsonDeserializationContext.deserialize(individuoADeserializar.get("data"), TipoAvanzado.class);
        } else {

            log.info("Se ha dado un error al encontrar el tipo de individiduo");
            log.error("Se ha producido un error");
            log.fatal("Se ha producido un error fatal");

            throw new JsonParseException("No se ha encontrado el tipo de individuo");
        }
    }
}
