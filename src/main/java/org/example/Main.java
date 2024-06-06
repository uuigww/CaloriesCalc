package org.example;
import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class Main extends JFrame {

    private JLabel weightLabel, heightLabel, ageLabel, activityLabel, genderLabel;
    private JTextField weightField, heightField, ageField;
    private JComboBox<String> activityComboBox, genderComboBox;
    private JButton calculateButton;
    private JTextArea resultTextArea;
    private CalculateButtonListener calculateButtonListener;

    public Main() {
        setTitle("Калькулятор БЖУ");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Создаем панель для ввода данных
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        // Добавляем стиль для меток
        Font labelFont = new Font("Calibri Light", Font.BOLD, 14);

        // Добавляем метку для веса
        weightLabel = new JLabel("Вес (кг):");
        weightLabel.setFont(labelFont);
        c.gridy = 0;
        inputPanel.add(weightLabel, c);

        // Добавляем поле ввода для веса
        weightField = new JTextField(5);
        weightField.setBorder(new RoundBorder(8, Color.GRAY));
        weightField.setOpaque(false);
        weightField.setBackground(new Color(220, 220, 220));
        weightField.setPreferredSize(new Dimension(100, 30));
        c.gridy = 1;
        inputPanel.add(weightField, c);

        // Добавляем метку для роста
        heightLabel = new JLabel("Рост (см):");
        heightLabel.setFont(labelFont);
        c.gridy = 2;
        inputPanel.add(heightLabel, c);


        // Добавляем поле ввода для роста
        heightField = new JTextField(5);
        heightField.setBorder(new RoundBorder(8, Color.GRAY));
        heightField.setOpaque(false);
        heightField.setBackground(new Color(220, 220, 220));
        heightField.setPreferredSize(new Dimension(100, 30));
        c.gridy = 3;
        inputPanel.add(heightField, c);


        // Добавляем метку для возраста
        ageLabel = new JLabel("Возраст (лет):");
        ageLabel.setFont(labelFont);
        c.gridy = 4;
        inputPanel.add(ageLabel, c);

        // Добавляем поле ввода для возраста
        ageField = new JTextField(5);
        ageField.setBorder(new RoundBorder(8, Color.GRAY));
        ageField.setOpaque(false);
        ageField.setBackground(new Color(220, 220, 220));
        ageField.setPreferredSize(new Dimension(100, 30));
        c.gridy = 5;
        inputPanel.add(ageField, c);

        // Добавляем метку для активности
        activityLabel = new JLabel("Активность:");
        activityLabel.setFont(labelFont);
        c.gridy = 6;
        inputPanel.add(activityLabel, c);

        // Добавляем выпадающий список для выбора активности
        activityComboBox = new JComboBox<>(new String[] { "Низкая", "Умеренная", "Высокая" });
        c.gridy = 7;
        inputPanel.add(activityComboBox, c);

        // Добавляем метку для гендера
        genderLabel = new JLabel("Пол:");
        genderLabel.setFont(labelFont);
        c.gridy = 8;
        inputPanel.add(genderLabel, c);

        // Добавляем выпадающий список для выбора гендера
        genderComboBox = new JComboBox<>(new String[] { "Мужской", "Женский" });
        c.gridy = 9;
        inputPanel.add(genderComboBox, c);


        // Создаем панель для кнопки расчета
        JPanel buttonPanel = new JPanel();

        // Добавляем стиль для кнопки
        Font buttonFont = new Font("Calibri Light", Font.BOLD, 20);

        // Создаем текстовую область для вывода результата
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        // Добавляем кнопку расчета
        calculateButton = new JButton("Рассчитать БЖУ");
        calculateButton.setFont(buttonFont);
        calculateButton.setBackground(Color.GREEN);
        calculateButton.setForeground(Color.WHITE);
        buttonPanel.add(calculateButton);
        CalculateButtonListener buttonListener = new CalculateButtonListener(weightField, heightField, ageField, activityComboBox, genderComboBox, resultTextArea);
        calculateButton.addActionListener(buttonListener);


        // Добавляем стиль для текстовой области
        resultTextArea.setFont(new Font("Calibri Light", Font.PLAIN, 14));

        // Добавляем панели ввода данных, кнопку расчета и текстовую область для вывода результата в главное окно
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultTextArea, BorderLayout.SOUTH);

        // Выравниваем поля ввода по центру
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Отображаем окно
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
