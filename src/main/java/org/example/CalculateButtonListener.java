package org.example;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalculateButtonListener implements ActionListener {
    private JTextField weightField;
    private JTextField heightField;
    private JTextField ageField;
    private JComboBox<String> activityComboBox;
    private JComboBox<String> genderComboBox;
    private JTextArea resultTextArea;


    // Переименовываем конструктор в более понятное имя
    public CalculateButtonListener(JTextField weightField, JTextField heightField, JTextField ageField, JComboBox<String> activityComboBox, JComboBox<String> genderComboBox, JTextArea resultTextArea) {
        this.weightField = weightField;
        this.heightField = heightField;
        this.ageField = ageField;
        this.activityComboBox = activityComboBox;
        this.genderComboBox = genderComboBox;
        this.resultTextArea = resultTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
            int age = Integer.parseInt(ageField.getText());

            User user = new User(Double.parseDouble(weightField.getText()), Double.parseDouble(heightField.getText()), Integer.parseInt(ageField.getText()), activityComboBox, genderComboBox);
            double bju = user.calculateBMR();

            resultTextArea.setText("БЖУ: " + bju + " г");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректные числовые значения.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
