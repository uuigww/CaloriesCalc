package org.example;

import javax.swing.JComboBox;

public class User extends Person {
    private JComboBox<String> activityComboBox;
    private JComboBox<String> genderComboBox;

    public User(double weight, double height, int age, JComboBox<String> activityComboBox, JComboBox<String> genderComboBox) {
        super(weight, height, age);
        this.activityComboBox = activityComboBox;
        this.genderComboBox = genderComboBox;
    }

    @Override
    public double calculateBMR() {
        double activityFactor, genderFactor;

        // Определяем коэффициент активности
        switch (activityComboBox.getSelectedItem().toString()) {
            case "Низкая":
                activityFactor = 1.2;
                break;
            case "Умеренная":
                activityFactor = 1.375;
                break;
            case "Высокая":
                activityFactor = 1.55;
                break;
            default:
                activityFactor = 1.2;
                break;
        }

        // Определяем коэффициент пола
        switch (genderComboBox.getSelectedItem().toString()) {
            case "Мужской":
                genderFactor = 5;
                break;
            case "Женский":
                genderFactor = -161;
                break;
            default:
                genderFactor = 5;
                break;
        }

        // Рассчитываем БЖУ
        return (10 * getWeight() + 6.25 * getHeight() - 5 * getAge() + genderFactor) * activityFactor;
    }
}