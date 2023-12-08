package configs;


import java.awt.*;

/**
 *  Represents all configs for "Weather Desktop" application.
 */
public final class Configs {

    public static String appName = "Weather Desktop";

    // Get Display resolution
    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * Configs for main UI window.
     */
    public static final class Window {
        public static boolean windowVisibility = true;

        public static final class Bounds {
            public static int x = screenSize.width / 2;
            public static int y = screenSize.height / 2;
            public static int height = 200;
            public static int width = 300;
        }

        public static final class GridLayout {
            public static int rows = 1;
            public static int cols = 1;
            public static int hgap = 2;  // Горизонтальный отступ между элементами
            public static int vgap = 2;  // Вертикальный отступ между элементами
        }
    }

    /**
     * Configs for InputForm UI.
     */
    public static final class InputForm {

        public static final class GridLayout {
            public static int rows = 3;
            public static int cols = Window.GridLayout.cols;
            public static int hgap = Window.GridLayout.hgap;
            public static int vgap = Window.GridLayout.vgap;
        }

        public static final class Label {
            public static String text = "Please. enter a city to get weather for:";

            public static final class Bounds {
                public static int x = 25;
                public static int y = 0;
                public static int height = 50;
                public static int width = Window.Bounds.width - Label.Bounds.x * 2;
            }
        }

        public static final class TextField {
            public static int columnsCount = 1;

            public static final class Bounds {
                public static int x = Label.Bounds.x;
                public static int y = Label.Bounds.height + 200;
                public static int height = 50;
                public static int width = Window.Bounds.width - TextField.Bounds.x * 2;
            }
        }

        public static final class SelectButton {
            public static String name = "Search";
        }

        public static final class ParseWeatherKeys {
            public static String main = "main";
            public static String temperature = "temp";
            public static String feelsLike = "feels_like";
            public static String weatherInfo = "weather";
            public static String wind = "wind";
            public static String windSpeed = "speed";
        }
    }

    /**
     * Configs for Open Weather API.
     */
    public static final class OpenWeatherAPI {
        public static String URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";
        public static String tokenEnvName = "openWeatherToken";

        public static String statusKey = "cod";
        public static int successStatusCode = 200;

        public static final class Error {
            public static int code = 500;
            public static String messageKey = "message";
            public static String messageText = "city not found";
        }
    }
}
