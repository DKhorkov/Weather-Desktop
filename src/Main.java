import configs.Configs;
import openWeatherAPI.OpenWeatherAPI;
import ui.Window;

import java.util.Map;


public class Main {
    public static void main(String[] args) {
        OpenWeatherAPI openWeatherAPI = new OpenWeatherAPI();
        Map<String, Object> weather = openWeatherAPI.getWeather("Moscow");

        Window window = new Window(Configs.appName);
        window.setVisible(Configs.Window.windowVisibility);
    }
}