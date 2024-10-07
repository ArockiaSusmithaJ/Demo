import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

Class MyJTextFieldLimit extends PlainDocument {
    private int limit;

    MyJTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}

public Class Lgmvip extends JFrame {
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField amountTextField;
    private JLabel resultLabel;

    // Conversion rates (dummy values for demonstration)
    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_GBP = 0.75;
    private static final double EUR_TO_USD = 1.18;
    private static final double GBP_TO_USD = 1.34;

    public Lgmvip() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Currency options
        String[] currencies = {"USD", "EUR", "GBP"};

        // Components
        JLabel fromLabel = new JLabel("From:");
        fromCurrencyComboBox = new JComboBox<>(currencies);
        JLabel toLabel = new JLabel("To:");
        toCurrencyComboBox = new JComboBox<>(currencies);
        JLabel amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField();
        amountTextField.setDocument(new MyJTextFieldLimit(10)); // Limit the input length to 10 characters
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel();

        // Convert button ActionListener
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        // Add components to the frame
        add(fromLabel);
        add(fromCurrencyComboBox);
        add(toLabel);
        add(toCurrencyComboBox);
        add(amountLabel);
        add(amountTextField);
        add(convertButton);
        add(resultLabel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void convertCurrency() {
        String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
        String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
        double amount;
        try {
            amount = Double.parseDouble(amountTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double convertedAmount;
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            convertedAmount = amount * USD_TO_EUR;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            convertedAmount = amount * USD_TO_GBP;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            convertedAmount = amount * EUR_TO_USD;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
            convertedAmount = amount * GBP_TO_USD;
        } else {
            JOptionPane.showMessageDialog(this, "Unsupported conversion", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Lgmvip();
            }
        });
    }
}
