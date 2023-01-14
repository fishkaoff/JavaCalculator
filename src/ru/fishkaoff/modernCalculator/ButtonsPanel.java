package ru.fishkaoff.modernCalculator;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel {
    private JButton[] numbers;
    private JPanel panel;
    public ButtonsPanel(JButton[] numbers) {
        this.numbers = numbers;
    }

    public JPanel initButtonsPanel(JButton addButton,
                                 JButton subButton,
                                 JButton mulButton,
                                 JButton decButton,
                                 JButton equButton,
                                 JButton divButton) {
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);// задача размера и положения
        panel.setLayout(new GridLayout(4,4,10,10)); // задаем сеточный шаблон

        // первый ряд
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addButton);
        //второй ряд
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subButton);
        // третий ряд
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mulButton);
        panel.add(decButton);
        // четвертый ряд
        panel.add(numbers[0]);
        panel.add(divButton);
        panel.add(equButton);

        return panel;
    }
}
