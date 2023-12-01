import configs.Configs;
import ui.Window;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Weather Desktop");
        window.setVisible(Configs.windowVisibility);
    }
}