package clases_a_utilizar_de_datos;

import com.google.gson.*;

import java.lang.reflect.Type;

public class IndividuoAdaptado implements JsonSerializer<IndividuoAdaptado>, JsonDeserializer {
    public IndividuoAdaptado() {}

    @Override
    public JsonElement serialize(IndividuoAdaptado individuoAdaptado, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }

    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
