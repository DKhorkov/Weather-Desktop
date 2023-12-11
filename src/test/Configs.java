package test;


public class Configs {
    public static final class OpenWeatherAPI {
        public static String existentCity = "Moscow";
        public static String nonExistentCity = "SomeCityToFind";
        public static String statusKey = "cod";
        public static int successStatusCode = 200;
        public static String messageKey = "message";
        public static String errorMessageText = "city not found";
    }
}
