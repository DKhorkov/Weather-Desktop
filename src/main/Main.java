package main;

import main.configs.Configs;
import main.ui.Window;

/**
 * main.Main class, which activates and run Weather Desktop application.
 */
public class Main {
    public static void main(String[] args) {
        Window window = new Window(Configs.appName);
        window.setVisible(Configs.Window.windowVisibility);
    }
}