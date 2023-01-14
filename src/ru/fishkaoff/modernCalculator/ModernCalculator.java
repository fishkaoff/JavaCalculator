package ru.fishkaoff.modernCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ModernCalculator extends JFrame implements ActionListener {

    // переменные для задачи параметров приложения
    private static final int WIDTH = 420; // ширина окна
    private static final int HEIGHT = 550; // высота окна


    // создание окна
    JTextField textField; // создаем поле для отображения значений
    JButton[] numbers = new JButton[10]; // массив отвечающий за кнопки с цифрами
    JButton[] functions = new JButton[8]; // массив отвечающий за функциональные кнопки


    // объявление функциональных кнопок
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel; // панель для функ. кнопок


    // шрифт, чтобы приложение было красивым
    Font appFont = new Font("Ink Free", Font.BOLD, 30);


    // исходные данные
    double num1=0,num2=0,result=0;
    char opt; // данная переменная будет отвечать за действие которое хочет сделать пользователь


    // создаем конструктор
    ModernCalculator(String title) {

        // Конфигурация главного окна
        super(title); // создаем окно с заданным именем
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // делаем чтобы приложение закрывалось, а не сворачивалось
        this.setSize(WIDTH, HEIGHT); // задаем размеры окна
        this.setLocationRelativeTo(null); // ставим окно по центру
        this.setLayout(null);


        //  Конфигурация текстового поля
        textField = new JTextField(); // Инициализируем текстовое поле
        textField.setBounds(50,25,300, 50); // задаем координаты
        textField.setFont(appFont); // задаем шрифт
        textField.setEditable(false);


        // Создание
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("delete");
        clrButton = new JButton("clear");


        // Добавление в массив кнопок
        functions[0] = addButton;
        functions[1] = subButton;
        functions[2] = mulButton;
        functions[3] = divButton;
        functions[4] = decButton;
        functions[5] = equButton;
        functions[6] = delButton;
        functions[7] = clrButton;

        // настройка каждой кнопки
        for (int i = 0; i < 8; i++) {
            functions[i].addActionListener(this); // добавляем прослушиватель событий к кнопке
            functions[i].setFont(appFont); // задаем шрифт кнопке
            functions[i].setFocusable(false); //не дает навестить на кнопку
        }


        // настройка кнопок цифр
        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(appFont);
            numbers[i].setFocusable(false);
        }


        // проработка особенных кнопок
        delButton.setBounds(50, 430, 145, 50);// задаем положение и размер кнопки
        clrButton.setBounds(205, 430, 145, 50);// задаем положение и размер кнопки


        // создание сетки с кнопками
        panel = new ButtonsPanel(numbers).initButtonsPanel(
                addButton,
                subButton,
                mulButton,
                decButton,
                equButton,
                divButton
        );


        // добавляем элементы во фрейм
        this.add(textField);// текстовое поле
        this.add(panel);// панель с кнопками
        this.add(delButton);// кнопка удалить
        this.add(clrButton);// кнопк очистить


        this.setVisible(true); // делаем фрейм видмым
    }


    // функция, чтобы сохранить первое число и обнулить текстовое поле
    public void setOption(char tmpOpt) {
        num1 = Double.parseDouble(textField.getText());
        opt = tmpOpt;
        textField.setText("");
    }


    // переопределяем метод из класса ActionListener для работы с пользователем
    @Override
    public void actionPerformed(ActionEvent e) {

        // проверяем нажата ли кнопка с цифрой
        for (int i = 0; i<10; i++) {
            if (e.getSource() == numbers[i]) {
                textField.setText(textField.getText() + String.valueOf(i));// выводим значение в текстовое поле
            }
        }


        // действие если нажата кнопка с точкой
        if (e.getSource() == decButton) {
            textField.setText(textField.getText() + ".");// выводим значение в текстовое поле
        }


        // проверяем была ли нажата кнопка очистки
        if (e.getSource() == clrButton) {
            textField.setText(""); // очищаем поле
        }


        // если нажата кнопка delete
        if (e.getSource() == delButton) {
            String str = textField.getText();
            str = str.substring(0, str.length() - 1);
            textField.setText(str);
        }


        // если нажата кнопка плюс
        if (e.getSource() == addButton) {
            setOption('+');
        }


        // если вычитание
        if (e.getSource() == subButton) {
            setOption('-');
        }


        // умножение
        if (e.getSource() == mulButton) {
            setOption('*');
        }


        // деление
        if (e.getSource() == divButton) {
            setOption('/');
        }


        // равно
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (opt) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 + num2;
                case '*': result = num1*num2; break;
                case '/': result = num1 / num2;
            }

            textField.setText(String.valueOf(result));
        }
    }
}
