package manager.Parse;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataGsonConverter implements JsonDeserializer<Date> {

    private static final String DATE_FORMAT = "yyyy-MM-dd X";

    //устанавливает необходимое поведение для парсинга даты
    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String fullDate = jsonElement.getAsString();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            return sdf.parse(fullDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
