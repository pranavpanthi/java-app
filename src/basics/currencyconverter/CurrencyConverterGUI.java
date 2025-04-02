package basics.currencyconverter;

import javax.swing.*;

public class CurrencyConverterGUI {

    private JFrame window;
    private JTextField amountField;

    private JLabel rsLabel;

    private JButton convertBtn;

    private JComboBox currencyFromJB;

    private String[] currencies = {"Nepali Rupees", "Indian Rupees", "USD", "AUD"};

    private JComboBox currencyToJB;

    private String[] currencyCodes = {"NPR", "INR", "USD", "AUD"};

    public void createGUI() {
        window = new JFrame();
        window.setTitle("Currency converter");
        window.setSize(350, 200);
        window.setResizable(false);
        window.setLayout(null);
        window.setLocation(350, 400);

        JLabel label1 = new JLabel("Currency from : ");
        label1.setBounds(30, 10, 200, 20);
        currencyFromJB = new JComboBox(currencies);
        currencyFromJB.setBounds(140, 10, 180, 20);

        JLabel label2 = new JLabel("Currency to :");
        label2.setBounds(30,40,100,20);
        currencyToJB = new JComboBox(currencies);
        currencyToJB.setBounds(140,40,180,20);

        JLabel amount = new JLabel("Amount :");
        amount.setBounds(30,70,100,20);
        amountField = new JTextField();
        amountField.setBounds(140,70,100, 20);

        convertBtn = new JButton("CONVERT");
        convertBtn.setBounds(120, 100, 100,20);
        convertBtn.addActionListener(event -> convert());

        rsLabel = new JLabel();
        rsLabel.setBounds(120,130, 200,20);


        window.add(label1);
        window.add(amountField);
        window.add(convertBtn);
        window.add(rsLabel);
        window.add(currencyFromJB);
        window.add(currencyToJB);
        window.add(label2);
        window.add(amount);

    }

    public void convert() {
        String fromCurrency = (String) currencyFromJB.getSelectedItem();
        String toCurrency = (String) currencyToJB.getSelectedItem();
        double amount;

            if (!amountField.getText().trim().isEmpty()) {
                try {
                    amount = Double.parseDouble(amountField.getText());
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(window, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int fromIndex = currencyFromJB.getSelectedIndex();
                int toIndex = currencyToJB.getSelectedIndex();
                String fromCode = currencyCodes[fromIndex];
                String toCode = currencyCodes[toIndex];

                double convertedValue = Converter.convert(fromCode, toCode, amount);

                if (convertedValue != -1) {
                    rsLabel.setText(String.format("%.2f %s", convertedValue, toCode));
                } else {
                    JOptionPane.showMessageDialog(window, "Enter an amount!", "Message", JOptionPane.ERROR_MESSAGE);
                }
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
