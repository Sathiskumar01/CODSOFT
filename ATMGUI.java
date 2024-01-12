import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMGUI extends javax.swing.JFrame {
    private JTextField amountField;
    private JTextArea displayArea;
    private BankAccount account;

    public ATMGUI() {
        initComponents();
        account = new BankAccount(1000); // Initialize account with initial balance
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATM Machine");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 3, 10, 5));

        amountField = new JTextField(10);
        panel.add(amountField, BorderLayout.CENTER);

        String[] buttonLabels = {"Deposit", "Withdraw", "Check Balance"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonsPanel.add(button);
        }

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        panel.add(scrollPane, BorderLayout.WEST);
        panel.add(buttonsPanel, BorderLayout.EAST);

        add(panel);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String amountStr = amountField.getText();
            double amount = amountStr.isEmpty() ? 0 : Double.parseDouble(amountStr);

            String action = e.getActionCommand();

            switch (action) {
                case "Deposit":
                    performDeposit(amount);
                    break;
                case "Withdraw":
                    performWithdrawal(amount);
                    break;
                case "Check Balance":
                    displayBalance();
                    break;
                default:
                    break;
            }
        }
    }

    private void performDeposit(double amount) {
        if (account.deposit(amount)) {
            displayArea.append("Deposit of $" + amount + " successful.\n");
        }
    }

    private void performWithdrawal(double amount) {
        if (account.withdraw(amount)) {
            displayArea.append("Withdrawal of $" + amount + " successful.\n");
        } else {
            displayArea.append("Insufficient funds. Withdrawal failed.\n");
        }
    }

    private void displayBalance() {
        displayArea.append("Current balance: $" + account.getBalance() + "\n");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ATMGUI().setVisible(true));
    }
}
