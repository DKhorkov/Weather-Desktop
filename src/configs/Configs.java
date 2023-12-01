package configs;


/**
 *  Represents all configs for "Weather Desktop" application.
 */
public final class Configs {

    public static boolean windowVisibility = true;

    public static final class Bounds {
        public static int x = 200;
        public static int y = 250;
        public static int height = 500;
        public static int width = 400;
    }

    public static final class GridLayout {
        public static int rows = 3;
        public static int cols = 2;
        public static int hgap = 2;  // Горизонтальный отступ
        public static int vgap = 2;  // Вертикальный отступ
    }
}
