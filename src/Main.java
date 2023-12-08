import configs.Configs;
import ui.Window;

/**
 * Main class, which activates and run Weather Desktop application.
 */
public class Main {
    public static void main(String[] args) {
        Window window = new Window(Configs.appName);
        window.setVisible(Configs.Window.windowVisibility);
    }
}