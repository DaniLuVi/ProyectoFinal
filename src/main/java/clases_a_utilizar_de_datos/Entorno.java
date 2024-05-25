package clases_a_utilizar_de_datos;

import com.google.gson.*;
import estructuras_de_datos_implementadas.listaDoblementeEnlazada.ElementoLDE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class Entorno extends ElementoLDE<Entorno> implements JsonSerializer<Entorno>, JsonDeserializer<Entorno> {
    private int tiempo_aparicion;

    private int probabilidad;
    private String tipo;
    private static final Logger log = LogManager.getLogger(Entorno.class);

    public Entorno(int tiempo_aparicion, int probabilidad, String tipo) {
        this.tiempo_aparicion = tiempo_aparicion;
        this.probabilidad = probabilidad;
        this.tipo = tipo;
    }
    public Entorno() {}

    public int getTiempo_aparicion() {
        return tiempo_aparicion;
    }

    public void setTiempo_aparicion(int tiempo_aparicion) {
        this.tiempo_aparicion = tiempo_aparicion;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void TipoEntorno() {
        try {
            if (getTipo() == "Agua") {
                Agua agua = (Agua) this;
            } else if (getTipo() == "Comida") {
                Comida comida = (Comida) this;
            } else if (getTipo() == "Montaña") {
                Montaña montaña = (Montaña) this;
            } else if (getTipo() == "Biblioteca") {
                Biblioteca biblioteca = (Biblioteca) this;
            } else if (getTipo() == "Tesoro") {
                Tesoro tesoro = (Tesoro) this;
            } else if (getTipo() == "Pozo") {
                Pozo pozo = (Pozo) this;
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public String toString(Entorno entorno) {
        if (entorno instanceof Agua) {
            return "Entorno[Agua{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Agua=" + probabilidad +
                    "}]";
        } else if (entorno instanceof Comida) {
            return "Entorno[Comida{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Comida=" + probabilidad +
                    "}]";
        } else if (entorno instanceof Montaña) {
            return "Entorno[Montaña{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Montaña=" + probabilidad +
                    "}]";
        } else if (entorno instanceof Biblioteca) {
            return "Entorno[Biblioteca{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Biblioteca=" + probabilidad +
                    "}]";
        } else if (entorno instanceof Pozo) {
            return "Entorno[Pozo{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Pozo=" + probabilidad +
                    "}]";
        } else if (entorno instanceof Tesoro) {
            return "Entorno[Tesoro{" +
                    "tiempo_aparicion=" + tiempo_aparicion +
                    ", %Tesoro=" + probabilidad +
                    "}]";
        }
        return null;
    }

    public void modificarIndividuo(Individuo individuo) {}

    @Override
    public Entorno deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        log.info("Se deserializa de JSON a un entorno");

        JsonObject entornoADeserializar = jsonElement.getAsJsonObject();
        if (entornoADeserializar.get("tipo").getAsString().contains("Agua")) {
            return jsonDeserializationContext.deserialize(entornoADeserializar.get("data"), Agua.class);
        } else if (entornoADeserializar.get("tipo").getAsString().contains("Comida")) {
            return jsonDeserializationContext.deserialize(entornoADeserializar.get("data"), Comida.class);
        } else if (entornoADeserializar.get("tipo").getAsString().contains("Montaña")) {
            return jsonDeserializationContext.deserialize(entornoADeserializar.get("data"), Montaña.class);
        } else if (entornoADeserializar.get("tipo").getAsString().contains("Biblioteca")) {
            return jsonDeserializationContext.deserialize(entornoADeserializar.get("data"), Biblioteca.class);
        } else if (entornoADeserializar.get("tipo").getAsString().contains("Pozo")) {
            return jsonDeserializationContext.deserialize(entornoADeserializar.get("data"), Pozo.class);
        } else if (entornoADeserializar.get("tipo").getAsString().contains("Tesoro")) {
            return jsonDeserializationContext.deserialize(entornoADeserializar.get("data"), Tesoro.class);
        } else {

            log.info("Se ha dado un error al encontrar el tipo de entorno");
            log.error("Se ha producido un error");
            log.fatal("Se ha producido un error fatal");

            throw new JsonParseException("No se ha encontrado el tipo de entorno");
        }
    }

    @Override
    public JsonElement serialize(Entorno entorno, Type type, JsonSerializationContext jsonSerializationContext) {

        log.info("Se serializa un entorno a JSON");

        JsonObject entornoAserializar = new JsonObject();
        entornoAserializar.addProperty("tipo", entorno.getClass().descriptorString());
        entornoAserializar.add("data", jsonSerializationContext.serialize(entorno));

        log.info("Entorno serializado");

        return entornoAserializar;
    }
}
