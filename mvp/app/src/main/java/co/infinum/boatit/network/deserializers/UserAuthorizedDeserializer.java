package co.infinum.boatit.network.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import co.infinum.boatit.enums.UserAuthorized;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class UserAuthorizedDeserializer implements JsonDeserializer<UserAuthorized>, JsonSerializer<UserAuthorized> {

    @Override
    public UserAuthorized deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        UserAuthorized authorized = UserAuthorized.fromKey(json.getAsInt());
        return authorized;
    }

    @Override
    public JsonElement serialize(UserAuthorized src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src.getKey());
    }
}
