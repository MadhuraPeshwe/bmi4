import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bmi4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel heightLabel = new JLabel("Enter your height (m):");
        JTextField heightField = new JTextField(10);
        JLabel weightLabel = new JLabel("Enter your weight (kg):");
        JTextField weightField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(heightLabel, constraints);

        constraints.gridx = 1;
        panel.add(heightField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(weightLabel, constraints);

        constraints.gridx = 1;
        panel.add(weightField, constraints);

        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(calculateButton, constraints);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double height = Double.parseDouble(heightField.getText());
                    double weight = Double.parseDouble(weightField.getText());

                    double bmi = calculateBMI(weight, height);
                    String bmiCategory = interpretBMI(bmi);

                    resultLabel.setText("Your BMI is: " + String.format("%.2f", bmi) + " (" + bmiCategory + ")");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter valid values.");
                }
            }
        });

        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(resultLabel, constraints);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static String interpretBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}
