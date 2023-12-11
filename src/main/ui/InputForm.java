package main.ui;

import main.configs.Configs;
import main.openWeatherAPI.OpenWeatherAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;


/**
 * Class represents Input form UI, where user chose city to find weather for.
 * THis class also creates message reply with weather for chosen city in new UI window.
 */
public class InputForm extends JFrame {
    private final Container inputFormContainer = super.getContentPane();
    private JTextField textField;

    public InputForm() {
        this.inputFormContainer.setBackground(Color.BLACK);
        this.setUpInputForm();
        this.setUpLabel();
        this.setUpTextField();
        this.setUpSearchButton();
    }

    /**
     * Base getter.
     * @return Input Form container with objects for adding to main UI window.
     */
    public Container getInputFormContainer() {
        return this.inputFormContainer;
    }

    /**
     * Configures Input Form UI.
     */
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

    /**
     * Configures text label on input form with information for user.
     */
    private void setUpLabel() {
        JLabel label = new JLabel(Configs.InputForm.Label.text);
        label.setForeground(Color.WHITE);
        label.setBounds(
                Configs.InputForm.Label.Bounds.x,
                Configs.InputForm.Label.Bounds.y,
                Configs.InputForm.Label.Bounds.width,
                Configs.InputForm.Label.Bounds.height
        );

        this.inputFormContainer.add(label);
    }

    /**
     * Configures text field, in which city name will be set.
     */
    private void setUpTextField() {
        this.textField = new JTextField(Configs.InputForm.TextField.columnsCount);
        this.textField.setBounds(
                Configs.InputForm.TextField.Bounds.x,
                Configs.InputForm.TextField.Bounds.y,
                Configs.InputForm.TextField.Bounds.width,
                Configs.InputForm.TextField.Bounds.height
        );

        this.inputFormContainer.add(this.textField);
    }

    /**
     * Configures "submit"-button, which starts logic for getting weather of chosen city.
     */
    private void setUpSearchButton() {
        JButton selectButton = new JButton(Configs.InputForm.SelectButton.name);
        selectButton.setBackground(Color.YELLOW);
        selectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        selectButton.addActionListener(new SelectButtonEventManager(this.textField));
        this.inputFormContainer.add(selectButton);
    }

    /**
     * Event listener for "submit"-button.
     * <p></p>
     * @param inputField - field with city to get weather for.
     * @see <a href="https://metanit.com/java/tutorial/3.18.php">Records in Java</a>
     */
    private record SelectButtonEventManager(JTextField inputField) implements ActionListener {

        /**
         * Gets weather and shows it in new UI window.
         */
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String selectedCity = this.inputField.getText();
            OpenWeatherAPI openWeatherAPI = new OpenWeatherAPI();
            Map<String, Object> weather = openWeatherAPI.getWeather(selectedCity);
            String message = this.checkWeatherStatusAndGetMessage(weather);
            JOptionPane jOptionPane = new JOptionPane();
            jOptionPane.setBackground(Color.BLACK);
            jOptionPane.setForeground(Color.WHITE);
            jOptionPane.showMessageDialog(
                    null,
                    message,
                    Configs.appName,
                    JOptionPane.PLAIN_MESSAGE
            );
        }

        /**
         * Checks is status cod of weather info is equal to "successStatusCode".
         * If true, returns message with processed weather info, else returns message with error info.
         * <p></p>
         * @param weather info about weather in selected city.
         * @return processed message with parsed weather info.
         */
        private String checkWeatherStatusAndGetMessage(Map<String, Object> weather) {
            if ((int) weather.get(Configs.OpenWeatherAPI.statusKey) == Configs.OpenWeatherAPI.successStatusCode) {
                return this.prepareSuccessMessage(weather);
            } else {
                return (String) weather.get(Configs.OpenWeatherAPI.Error.messageKey);
            }
        }

        /**
         * Prepares message for user from not-empty weather-info Map.
         * <p></p>
         * @param weather Map with weather info from Open Weather API.
         * @return processed message with parsed weather info.
         */
        private String prepareSuccessMessage(Map<String, Object> weather) {
            Map<String, Object> main = (Map<String, Object>) weather.get(Configs.InputForm.ParseWeatherKeys.main);
            Object temperature = main.get(Configs.InputForm.ParseWeatherKeys.temperature);
            Object feelsLike = main.get(Configs.InputForm.ParseWeatherKeys.feelsLike);

            ArrayList<Map<String, Object>> weatherInfo = (ArrayList<Map<String, Object>>) weather.get(
                    Configs.InputForm.ParseWeatherKeys.weatherInfo
            );
            String weatherStatus = (String) weatherInfo.get(0).get(Configs.InputForm.ParseWeatherKeys.main);

            Map<String, Object> wind = (Map<String, Object>) weather.get(Configs.InputForm.ParseWeatherKeys.wind);
            Object windSpeed = wind.get(Configs.InputForm.ParseWeatherKeys.windSpeed);

            return String.format(
                    """
                        Weather: %s
                        Temperature: %s
                        Feels like: %s
                        Wind speed: %s
                    """,
                    weatherStatus,
                    temperature,
                    feelsLike,
                    windSpeed
            );
        }
    }
}
