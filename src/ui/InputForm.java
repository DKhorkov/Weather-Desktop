package ui;

import configs.Configs;

import javax.swing.*;
import java.awt.*;

public class InputForm extends JFrame {

    private final Container inputFormContainer = super.getContentPane();

    public InputForm() {
        this.setUpInputForm();
        this.setUpLabel();
        this.setUpTextLabel();
    }

    private void setUpInputForm() {
        this.inputFormContainer.setLayout(
                new GridLayout(
                        Configs.InputForm.GridLayout.rows,
                        Configs.InputForm.GridLayout.cols,
                        Configs.InputForm.GridLayout.hgap,
                        Configs.InputForm.GridLayout.vgap
                )
        );
    }

    private void setUpLabel() {
        JLabel label = new JLabel(Configs.InputForm.Label.text);
        label.setBounds(
                Configs.InputForm.Label.Bounds.x,
                Configs.InputForm.Label.Bounds.y,
                Configs.InputForm.Label.Bounds.width,
                Configs.InputForm.Label.Bounds.height
        );

        this.inputFormContainer.add(label);
    }

    private void setUpTextLabel() {
        JTextField textField = new JTextField(Configs.InputForm.TextField.columnsCount);
        textField.setBounds(
                Configs.InputForm.TextField.Bounds.x,
                Configs.InputForm.TextField.Bounds.y,
                Configs.InputForm.TextField.Bounds.width,
                Configs.InputForm.TextField.Bounds.height
        );

        this.inputFormContainer.add(textField);
    }

    public Container getInputFormContainer() {
        return this.inputFormContainer;
    }
}
