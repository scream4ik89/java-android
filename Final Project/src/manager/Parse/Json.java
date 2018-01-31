package manager.Parse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.entity.Pub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Json {

    public static Pub parseJson() {
        Pub pub = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("pub.json")))) {
            GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new DataGsonConverter());
            Gson gson = builder.create();
            pub = gson.fromJson(bufferedReader, Pub.class);
        } catch (IOException e) {
            e.getMessage();
            return pub;
        }
        System.out.println(pub.toString());
        return pub;
    }

}

