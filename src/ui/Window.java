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
     * Добавляет слой. Созданные объекты нельзя просто забросить в программу, необходимо создать слой,
     * на котором они будут расположены.
     */
    private final Container windowContainer = super.getContentPane();

    public Window(String title) {
        super(title);  // setting title of our Window
        this.setUpWindow();
        this.run();
    }

    private void setUpWindow() {
        // Setting size and position of window
        super.setBounds(
                Configs.Window.Bounds.x,
                Configs.Window.Bounds.y,
                Configs.Window.Bounds.width,
                Configs.Window.Bounds.height
        );

        // Указываем систему расположения объектов. Выберем систему сетки (ряды + столбцы)
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

    public void run() {
        InputForm inputForm = new InputForm();
        Container inputFormContainer = inputForm.getInputFormContainer();
        this.windowContainer.add(inputFormContainer);
    }
}
