package basics.currencyconverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI {

    private JFrame window;

    private JTextField audField;

    private JLabel rsLabel;


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
        JButton convertBtn = new JButton("CONVERT");
        convertBtn.setBounds(100, 40, 100,20);
        convertBtn.addActionListener(event -> convert());
        rsLabel = new JLabel();
        rsLabel.setBounds(30,70, 100,20);



        window.add(label1);
        window.add(audField);
        window.add(convertBtn);
        window.add(rsLabel);

    }

    public void convert() {
        String audValueStr = audField.getText();
        Double audValue = Double.parseDouble(audValueStr);
        Double nrsValue = Converter.convertAudToNrs(audValue);
        rsLabel.setText("NRS = " + nrsValue.toString());
//         JOptionPane.showMessageDialog(window, "Button Clicked", "Message", JOptionPane.ERROR_MESSAGE);
    }
    public static void main(String[] args) {
        CurrencyConverterGUI converter = new CurrencyConverterGUI();
        converter.createGUI();
        converter.window.setVisible(true);
    }

}
