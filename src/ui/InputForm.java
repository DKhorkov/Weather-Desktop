package ui;

import configs.Configs;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputForm extends JFrame {

    @Getter
    private final Container inputFormContainer = super.getContentPane();  // https://projectlombok.org/features/GetterSetter
    private JTextField textField;

    public InputForm() {
        this.setUpInputForm();
        this.setUpLabel();
        this.setUpTextLabel();
        this.setUpSearchButton();
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
        this.textField = new JTextField(Configs.InputForm.TextField.columnsCount);
        this.textField.setBounds(
                Configs.InputForm.TextField.Bounds.x,
                Configs.InputForm.TextField.Bounds.y,
                Configs.InputForm.TextField.Bounds.width,
                Configs.InputForm.TextField.Bounds.height
        );

        this.inputFormContainer.add(this.textField);
    }

    private void setUpSearchButton() {
        JButton selectButton = new JButton(Configs.InputForm.SelectButton.name);
        selectButton.addActionListener(new SelectButtonEventManager(this.textField));
        this.inputFormContainer.add(selectButton);
    }

    // https://metanit.com/java/tutorial/3.18.php
    private record SelectButtonEventManager(JTextField inputField) implements ActionListener {

        @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String selectedCity = this.inputField.getText();

                // TODO Here need to check info from weather API. If no DATA - show error message

                JOptionPane.showMessageDialog(
                        null,
                        selectedCity,
                        Configs.appName,
                        JOptionPane.PLAIN_MESSAGE
                );
            }
        }
}
