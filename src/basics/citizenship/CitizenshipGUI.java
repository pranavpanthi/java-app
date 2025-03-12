package basics.citizenship;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class CitizenshipGUI {


    private JFrame window;

    private JLabel nameLabel;

    private JLabel yearLabel;

    private JLabel provinceLabel;

    private JButton submitBtn;

    private JButton clearBtn;

    private JTextField tfName;

    private JTextField tfYear;

    private JComboBox provinceCB;

    private String[] provinces = {"Bagmati Province","Koshi Province","Madhesh Province", "Gandaki Province", "Lumbini Province", "Kanali Province", "Sudurpashchim Province"};


    public void createGUI() {
        window = new JFrame("Citizenship Check");
        window.setSize(350,250);
        window.setResizable(false);
        window.setLocation(200,200);
        window.setLayout(null);

        nameLabel = new JLabel("Name : ");
        nameLabel.setBounds(20,20,50,20);
        tfName = new JTextField();
        tfName.setBounds(100,20, 200,20);
        yearLabel = new JLabel("Date of birth : ");
        yearLabel.setBounds(20,60,100,20);
        tfYear = new JTextField();
        tfYear.setToolTipText("yyyy-mm-dd");
        tfYear.setBounds(100,60,200,20);
        provinceLabel = new JLabel("Province :");
        provinceLabel.setBounds(20,100, 100, 20);
        provinceCB = new JComboBox(provinces);
        provinceCB.setBounds(100, 100, 200, 20);
        submitBtn = new JButton("Submit");
        submitBtn.setBounds(60,150, 100,20);
        submitBtn.addActionListener(event -> submit());
        clearBtn = new JButton("Clear");
        clearBtn.setBounds(180,150,100, 20);
        clearBtn.addActionListener(event -> clear());


        window.add(provinceCB);
        window.add(clearBtn);
        window.add(submitBtn);
        window.add(provinceLabel);
        window.add(tfYear);
        window.add(yearLabel);
        window.add(tfName);
        window.add(nameLabel);
        window.setVisible(true);
    }

    public void submit() {
        JOptionPane.showMessageDialog(window, "The following Information has been successfully submitted", "Submit", JOptionPane.INFORMATION_MESSAGE);
        processCitizenship();
    }

    public void clear() {
        tfName.setText(null);
        tfYear.setText(null);
        provinceCB.setSelectedIndex(0);
        JOptionPane.showMessageDialog(window, "The information has been cleared", "Clear", JOptionPane.INFORMATION_MESSAGE);
    }

    public void processCitizenship() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String inputDate = tfYear.getText().trim();
            LocalDate birthDate = LocalDate.parse(inputDate, formatter);
            LocalDate currentDate = LocalDate.now();
            long age = ChronoUnit.YEARS.between(birthDate,currentDate);
            String name = tfName.getText().trim();
//            String province = provinceCB.getSelectedItem().toString();
            String provinceValue = provinces[provinceCB.getSelectedIndex()];



            if (age > 16) {
                JOptionPane.showMessageDialog(window, "Congratulation! " + name + " You are " + age + " years old and are eligible for citizenship.", "Check", JOptionPane.INFORMATION_MESSAGE);
            } else if (age == 16) {
                JOptionPane.showMessageDialog(window, "Hi " + name + ", we need to manually verify your age. Please go to the office of " + provinceValue + " province", "Check", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(window, "Sorry! " + name + " are " + age + " years old and are not eligible for citizenship.", "error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DateTimeParseException dtpe) {
            JOptionPane.showMessageDialog(window,"The following is invalid", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        CitizenshipGUI citizenship = new CitizenshipGUI();
        citizenship.createGUI();
    }
}
