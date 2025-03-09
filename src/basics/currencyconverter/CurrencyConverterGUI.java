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

    public void createGUI() {
        window = new JFrame();
        window.setTitle("Currency converter");
        window.setSize(350, 150);
        window.setResizable(false);
        window.setLayout(null);
        window.setLocation(200, 200);

        JLabel label1 = new JLabel("Enter Amount in AUD : ");
        label1.setBounds(30, 10, 200, 20);
        audField = new JTextField();
        audField.setBounds(200,10,100, 25);
        convertBtn = new JButton("CONVERT");
        convertBtn.setBounds(100, 40, 100,20);
        convertBtn.addActionListener(event -> convert());
        rsLabel = new JLabel();
        rsLabel.setBounds(30,70, 200,20);



        window.add(label1);
        window.add(audField);
        window.add(convertBtn);
        window.add(rsLabel);

    }

    public void convert() {
        if (!audField.getText().trim().isEmpty()) {
            String audValueStr = audField.getText();
            Double audValue = 0.0;
            try {
                audValue = Double.parseDouble(audValueStr);
            } catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(window,"Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            Double nrsValue = Converter.convertAudToNrs(audValue);
            rsLabel.setText("NRS = " + nrsValue.toString());
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
