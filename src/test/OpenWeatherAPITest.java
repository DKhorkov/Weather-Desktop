package test;

import jdk.jfr.Description;
import main.openWeatherAPI.OpenWeatherAPI;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.Map;


public class OpenWeatherAPITest {
    public static OpenWeatherAPI openWeatherAPI;

    @BeforeClass
    public static void setUp() {
        openWeatherAPI = new OpenWeatherAPI();
    }

    @Test
    @Description("Testing getting weather for existent city")
    public void testExistentCityWeather() {
        Map<String, Object> weather = openWeatherAPI.getWeather(Configs.OpenWeatherAPI.existentCity);

        Assert.assertEquals(
                "Status code for existent city should be: " + Configs.OpenWeatherAPI.successStatusCode,
                this.getStatusCode(weather),
                Configs.OpenWeatherAPI.successStatusCode
        );

        Assert.assertNotEquals(
                "Message for existent city should not be: " + Configs.OpenWeatherAPI.errorMessageText,
                this.getMessage(weather),
                Configs.OpenWeatherAPI.errorMessageText
        );
    }

    @Test
    @Description("Testing getting weather for non-existent city")
    public void testGetNonExistentCityWeather() {
        Map<String, Object> weather = openWeatherAPI.getWeather(Configs.OpenWeatherAPI.nonExistentCity);

        Assert.assertNotEquals(
                "Status code for non-existent city should not be: " + Configs.OpenWeatherAPI.successStatusCode,
                this.getStatusCode(weather),
                Configs.OpenWeatherAPI.successStatusCode
        );

        Assert.assertEquals(
                "Message for non-existent city should be: " + Configs.OpenWeatherAPI.errorMessageText,
                this.getMessage(weather),
                Configs.OpenWeatherAPI.errorMessageText

        );
    }

    private int getStatusCode(Map<String, Object> weather) {
        return (int) weather.get(Configs.OpenWeatherAPI.statusKey);
    }

    private String getMessage(Map<String, Object> weather) {
        return (String) weather.get(Configs.OpenWeatherAPI.messageKey);
    }
}
