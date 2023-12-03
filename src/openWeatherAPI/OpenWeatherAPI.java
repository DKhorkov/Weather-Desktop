package openWeatherAPI;

import configs.Configs;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;


/**
 * Class, representing operations with Open Weather API
 * @see <a href="https://openweathermap.org/api">Open Weather</a>
 */
public class OpenWeatherAPI {

    private final String token = this.getToken();

    public OpenWeatherAPI() {}

    /**
     *  This method looks into .env file for Open Weather API token to make HTTP requests.
     * @return Token for Open Weather API
     */
    private String getToken() {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get(Configs.OpenWeatherAPI.tokenEnvName);
    }

    public Map<String, Object> getWeather(String city) {
        String URL = String.format(Configs.OpenWeatherAPI.URL, city, this.token);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();

        // TODO add logging
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String rawWeather = response.body();
            return this.processRawWeather(rawWeather);
        } catch (IOException | InterruptedException exception){
            return this.createFailureWeather(Configs.OpenWeatherAPI.Error.messageText);
        }
    }

    private Map<String, Object> processRawWeather(String rawWeather) {
        Map<String, Object> weather = new JSONObject(rawWeather).toMap();
        int statusCode = this.getStatusCode(weather);
        if (statusCode == Configs.OpenWeatherAPI.successStatusCode) {
            return weather;
        } else {
            String message = this.getMessage(weather);
            return this.createFailureWeather(message);
        }
    }

    private int getStatusCode(Map<String, Object> weather) {
        // TODO add logging
        try {
            // Using this syntax to get int type instead of Object
            return (int) weather.get(Configs.OpenWeatherAPI.Error.key);
        } catch (ClassCastException e) {
            return Configs.OpenWeatherAPI.Error.code;
        }
    }

    private String getMessage(Map<String, Object> weather) {
        // TODO add logging
        try {
            return (String) weather.get(Configs.OpenWeatherAPI.Error.messageKey);
        } catch (ClassCastException e) {
            return Configs.OpenWeatherAPI.Error.messageText;
        }
    }

    private Map<String, Object> createFailureWeather(String message) {
        return new HashMap<>() {{
            put(Configs.OpenWeatherAPI.Error.key, Configs.OpenWeatherAPI.Error.code);
            put(Configs.OpenWeatherAPI.Error.messageKey, message);
        }};
    }
}
