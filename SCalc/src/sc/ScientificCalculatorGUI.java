package sc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculatorGUI extends JFrame implements ActionListener {
    private JTextField display;
    private Calculator calculator;

    public ScientificCalculatorGUI() {
        // Initialize the calculator
        calculator = new Calculator();

        // Create and set up the window
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Create the panel with buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));
        add(buttonPanel, BorderLayout.CENTER);

        // Button labels in the correct order
        String[] buttonLabels = {
                "1", "2", "3", "/",
                "*", "4", "5", "6",
                "+", "-", "7", "8",
                "9", ".", "=", "0",
                "sqrt", "log", "sin", "cos",
                "tan", "cbrt", "square", "cube",
                "Clear", "Ans", "Exit"
        };

        // Create and add buttons to the panel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Set the window to be visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Clear")) {
            display.setText("");
            calculator.reset();
        } else if (command.equals("Exit")) {
            System.exit(0);
        } else if (command.equals("Ans")) {
            display.setText(String.valueOf(calculator.getCurrentResult()));
        } else if ("0123456789.".contains(command)) {
            display.setText(display.getText() + command);
        } else {
            try {
                if (calculator.isFirstCalculation()) {
                    calculator.setCurrentResult(Double.parseDouble(display.getText()));
                    calculator.setFirstCalculation(false);
                } else {
                    calculator.calculate(Double.parseDouble(display.getText()));
                }
                calculator.setLastOperation(command);
                display.setText("");
                if (command.equals("=")) {
                    display.setText(String.valueOf(calculator.getCurrentResult()));
                    calculator.setFirstCalculation(true);
                }
            } catch (NumberFormatException | ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                display.setText("");
                calculator.reset();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScientificCalculatorGUI::new);
    }
}
