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

    /*
     * Добавляет слой. Созданные объекты нельзя просто забросить в программу, необходимо создать слой,
     * на котором они будут расположены.
     */
    private Container container = super.getContentPane();;

    public Window(String title) {
        super(title);  // setting title of our Window

        // Setting size and position of window
        super.setBounds(
                Configs.Bounds.x,
                Configs.Bounds.y,
                Configs.Bounds.width,
                Configs.Bounds.height
        );
        super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);  // exiting on close window

        // Указываем систему расположения объектов. Выберем систему сетки (ряды + столбцы)
        this.container.setLayout(
                new GridLayout(
                        Configs.GridLayout.rows,
                        Configs.GridLayout.cols,
                        Configs.GridLayout.hgap,
                        Configs.GridLayout.vgap
                )
        );
    }
}
