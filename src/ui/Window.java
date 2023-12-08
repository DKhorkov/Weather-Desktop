package ui;

import configs.Configs;

import javax.swing.*;
import java.awt.*;


/**
 * This class represents UI window for user.
 * Extends from JFrame for using swing methods purposes.
 * @see JFrame
 */
public class Window extends JFrame {

    /**
     * Adds a layer. The created objects cannot simply be thrown into the program.
     * It is necessary to create a layer on which they will be located.
     */
    private final Container windowContainer = super.getContentPane();

    public Window(String title) {
        super(title);  // setting title of our Window
        this.setupWindow();
        this.run();
    }

    /**
     * Configures main UI window with objects.
     */
    private void setupWindow() {
        // Setting size and position of window
        super.setBounds(
                Configs.Window.Bounds.x,
                Configs.Window.Bounds.y,
                Configs.Window.Bounds.width,
                Configs.Window.Bounds.height
        );

        this.windowContainer.setLayout(
                new GridLayout(
                        Configs.Window.GridLayout.rows,
                        Configs.Window.GridLayout.cols,
                        Configs.Window.GridLayout.hgap,
                        Configs.Window.GridLayout.vgap
                )
        );

        super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);  // exiting on close window
    }

    /**
     * Method with logics of app.
     * Creates input form, adds it to main UI window.
     */
    public void run() {
        InputForm inputForm = new InputForm();
        Container inputFormContainer = inputForm.getInputFormContainer();
        this.windowContainer.add(inputFormContainer);
    }
}
