package basics.citizenship;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;

public class CitizenshipGUI {


    private JFrame window;

    private JButton submit;

    private JButton clear;

    private JTextField name;

    private JTextField year;

    private JComboBox box;

    public void createGUI() {
        window = new JFrame("Citizenship Check");
        window.setSize(300,250);
        window.setResizable(false);
        window.setLocation(200,200);
        window.setLayout(null);

        JLabel label = new JLabel("Name : ");
        label.setBounds(20,20,50,20);
        name = new JTextField();
        name.setBounds(100,20, 150,20);
        JLabel label1 = new JLabel("Year of birth : ");
        label1.setBounds(20,60,100,20);
        year = new JTextField();
        year.setBounds(100,60,150,20);
        JLabel label2 = new JLabel("Province :");
        label2.setBounds(20,100, 100, 20);
        String[] provinces = {"Bagmati Province","Koshi Province","Madhesh Province", "Gandaki Province", "Lumbini Province", "Kanali Province", "Sudurpashchim Province"};
        box = new JComboBox(provinces);
        box.setBounds(100, 100, 150, 20);
        submit = new JButton("Submit");
        submit.setBounds(10,150, 100,20);
        submit.addActionListener(event -> button1());
        clear = new JButton("Clear");
        clear.setBounds(120,150,100, 20);
        clear.addActionListener(event -> button2());


        window.add(box);
        window.add(clear);
        window.add(submit);
        window.add(label2);
        window.add(year);
        window.add(label1);
        window.add(name);
        window.add(label);
        window.setVisible(true);
    }

    public void button1() {
            JOptionPane.showMessageDialog(window, "The following Information has been successfully submitted", "Submit", JOptionPane.INFORMATION_MESSAGE);
    }

    public void button2() {
        name.setText(null);
        year.setText(null);
        box.setSelectedIndex(0);
        JOptionPane.showMessageDialog(window, "The information has been cleared", "Clear", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        CitizenshipGUI citizenship = new CitizenshipGUI();
        citizenship.createGUI();
    }
}
