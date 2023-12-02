package configs;


/**
 *  Represents all configs for "Weather Desktop" application.
 */
public final class Configs {

    public static final class Window {
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
            public static int hgap = 2;  // Горизонтальный отступ между элементами
            public static int vgap = 2;  // Вертикальный отступ между элементами
        }
    }

    public static final class InputForm {

        public static final class GridLayout {
            public static int rows = Window.GridLayout.rows;
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
    }
}
