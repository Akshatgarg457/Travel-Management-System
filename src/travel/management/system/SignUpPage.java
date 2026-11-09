package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays; // For comparing char arrays from password fields

public class SignUpPage extends JFrame implements ActionListener {

    // GUI Components
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField emailField;
    private JButton signUpButton;
    private JButton backToLoginButton;
    private JLabel messageLabel; // To display feedback to the user

    public SignUpPage() {
        // --- Frame Setup ---
        setTitle("Travel Management System - Sign Up");
        setSize(400, 350); // Width, Height
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close application when frame is closed
        setLocationRelativeTo(null); // Center the window on the screen
        setResizable(false); // Prevent resizing

        // --- Panel Setup (Using GridBagLayout for better control) ---
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding
        add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make components fill their grid cell horizontally

        // --- Username Label and Field ---
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1; // Column 1
        gbc.gridy = 0; // Row 0
        usernameField = new JTextField(20); // 20 columns wide hint
        panel.add(usernameField, gbc);

        // --- Password Label and Field ---
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        passwordField = new JPasswordField(20);
        panel.add(passwordField, gbc);

        // --- Confirm Password Label and Field ---
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Confirm Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        confirmPasswordField = new JPasswordField(20);
        panel.add(confirmPasswordField, gbc);

        // --- Email Label and Field ---
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        emailField = new JTextField(20);
        panel.add(emailField, gbc);

        // --- Sign Up Button ---
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Span across two columns
        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(this); // Register for action events
        panel.add(signUpButton, gbc);

        // --- Back to Login Button ---
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        backToLoginButton = new JButton("Back to Login");
        backToLoginButton.addActionListener(this); // Register for action events
        panel.add(backToLoginButton, gbc);

        // --- Message Label (for feedback) ---
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        messageLabel = new JLabel("");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center text
        panel.add(messageLabel, gbc);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            handleSignUp();
        } else if (e.getSource() == backToLoginButton) {
            handleBackToLogin();
        }
    }

    private void handleSignUp() {
        String username = usernameField.getText().trim();
        char[] password = passwordField.getPassword(); // Returns char array for security
        char[] confirmPassword = confirmPasswordField.getPassword();
        String email = emailField.getText().trim();

        // --- Basic Validation ---
        if (username.isEmpty() || password.length == 0 || confirmPassword.length == 0 || email.isEmpty()) {
            messageLabel.setText("Please fill in all fields.");
            messageLabel.setForeground(Color.RED);
            return;
        }

        if (!Arrays.equals(password, confirmPassword)) {
            messageLabel.setText("Passwords do not match.");
            messageLabel.setForeground(Color.RED);
            // Clear password fields for security
            passwordField.setText("");
            confirmPasswordField.setText("");
            return;
        }

        if (!isValidEmail(email)) {
            messageLabel.setText("Please enter a valid email address.");
            messageLabel.setForeground(Color.RED);
            return;
        }

        // --- Simulation of Registration Logic ---
        // In a real application, you would:
        // 1. Hash the password (DO NOT store plain text passwords!)
        // 2. Send the data to your backend (e.g., Spring Boot REST API)
        // 3. Handle server response (success/failure, duplicate username, etc.)
        // 4. Store user data in a database

        // For this example, we'll just simulate success
        System.out.println("Attempting to sign up:");
        System.out.println("Username: " + username);
        // DO NOT print password like this in real apps!
        System.out.println("Password (hashed in real app): " + new String(password));
        System.out.println("Email: " + email);

        messageLabel.setText("Registration Successful! Redirecting to Login...");
        messageLabel.setForeground(new Color(0, 128, 0)); // Green color

        // Simulate a delay and then go back to login
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear fields for next use
                usernameField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                emailField.setText("");
                messageLabel.setText("");

                handleBackToLogin(); // Go to login page
            }
        });
        timer.setRepeats(false); // Only run once
        timer.start();

        // Important: Clear password char arrays after use for security
        Arrays.fill(password, ' ');
        Arrays.fill(confirmPassword, ' ');
    }

    private boolean isValidEmail(String email) {
        // A very basic email validation regex.
        // For production, use a more robust library or a more comprehensive regex.
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private void handleBackToLogin() {
        // In a full application, you would dispose this frame
        // and open the LoginPage frame.
        JOptionPane.showMessageDialog(this, "Simulating navigation to Login Page.", "Info", JOptionPane.INFORMATION_MESSAGE);
        this.dispose(); // Close current sign-up page
        // new LoginPage().setVisible(true); // Uncomment if you have a LoginPage class
    }

    public static void main(String[] args) {
        // Schedule a job for the event dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignUpPage();
            }
        });
    }
}