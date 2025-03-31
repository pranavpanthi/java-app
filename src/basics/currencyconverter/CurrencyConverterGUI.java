package basics.currencyconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI {

    private JFrame window;
    private JTextField audField;

    private JLabel rsLabel;

    private JButton convertBtn;

    private JComboBox currencyFromJB;

    private String[] currFrom = {"Nepali Rupees", "Indian Rupees", "USD", "AUD"};

    private JComboBox currencyToJB;

    private String[] currTo = {"Nepali Rupees", "Indian Rupees", "USD", "AUD"};

    public void createGUI() {
        window = new JFrame();
        window.setTitle("Currency converter");
        window.setSize(350, 200);
        window.setResizable(false);
        window.setLayout(null);
        window.setLocation(350, 400);

        JLabel label1 = new JLabel("Currency from : ");
        label1.setBounds(30, 10, 200, 20);
        currencyFromJB = new JComboBox(currFrom);
        currencyFromJB.setBounds(140, 10, 180, 20);
        JLabel label2 = new JLabel("Currency to :");
        label2.setBounds(30,40,100,20);
        currencyToJB = new JComboBox(currTo);
        currencyToJB.setBounds(140,40,180,20);
        JLabel amount = new JLabel("Amount :");
        amount.setBounds(30,70,100,20);
        audField = new JTextField();
        audField.setBounds(140,70,100, 20);
        convertBtn = new JButton("CONVERT");
        convertBtn.setBounds(120, 100, 100,20);
        convertBtn.addActionListener(event -> convert());
        rsLabel = new JLabel();
        rsLabel.setBounds(120,130, 200,20);




        window.add(label1);
        window.add(audField);
        window.add(convertBtn);
        window.add(rsLabel);
        window.add(currencyFromJB);
        window.add(currencyToJB);
        window.add(label2);
        window.add(amount);

    }

    public void convert() {
            if (!audField.getText().trim().isEmpty()) {
                String audValueStr = audField.getText();
                Double audValue = 0.0;
                try {
                    audValue = Double.parseDouble(audValueStr);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(window, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                }
                Double nrsValue = Converter.convertAudToNrs(audValue);
                rsLabel.setText("NRS = " + nrsValue.toString());

                Double usdValue =  Converter.convertAudToUsd(audValue);
                rsLabel.setText("USD = " + usdValue.toString());

                Double irsValue = Converter.convertAudToIrs(audValue);
                rsLabel.setText("IRS = " + irsValue.toString());

            } else {
                JOptionPane.showMessageDialog(window, "Empty", "Message", JOptionPane.ERROR_MESSAGE);
            }
//        JOptionPane.showMessageDialog(window, "Button Clicked", "Message", JOptionPane.ERROR_MESSAGE);
    }
    public static void main(String[] args) {
        CurrencyConverterGUI converter = new CurrencyConverterGUI();
        converter.createGUI();
        converter.window.setVisible(true);
    }

}
