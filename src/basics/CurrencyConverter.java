package basics;

import javax.swing.*;
import java.awt.*;

public class CurrencyConverter {

    private JFrame window;

    public void launch() {
        window = new JFrame();
        window.setTitle("Currency converter");
        window.setSize(500, 250);
        window.setResizable(false);
        window.setLayout(null);

        JLabel label1 = new JLabel("Label 1");
        label1.setBounds(10, 10, 50, 20);
        JLabel label2 = new JLabel("Label 2");
        label2.setBounds(10, 40, 50, 20);
        JLabel label3 = new JLabel("Label 3");
        JLabel label4 = new JLabel("Label 4");
        JLabel label5 = new JLabel("Label 5");

        window.add(label1);
        window.add(label2);
        window.add(label3);
        window.add(label4);
        window.add(label5);

        window.setVisible(true);
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        converter.launch();
    }
}
