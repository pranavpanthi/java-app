package basics.citizenship;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

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
        year.addActionListener(event -> date());
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
        date();
    }

    public void button2() {
        name.setText(null);
        year.setText(null);
        box.setSelectedIndex(0);
        JOptionPane.showMessageDialog(window, "The information has been cleared", "Clear", JOptionPane.INFORMATION_MESSAGE);
    }

    public void date() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String inputDate =year.getText().trim();
            LocalDate birthDate = LocalDate.parse(inputDate, formatter);
            LocalDate currentDate = LocalDate.now();
            long age = ChronoUnit.YEARS.between(birthDate,currentDate);

            if (age > 16) {
                JOptionPane.showMessageDialog(window, "Congratulation! You are eligible for citizenship.", "Check", JOptionPane.INFORMATION_MESSAGE);
            } else if (age == 16) {
                JOptionPane.showMessageDialog(window, "You are just eligible to have a citizenship.", "Check", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(window, "Sorry! You are not eligible to have citizenship.", "Check", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DateTimeParseException dtpe) {
            JOptionPane.showMessageDialog(window,"The following is invalid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        CitizenshipGUI citizenship = new CitizenshipGUI();
        citizenship.createGUI();
    }
}
