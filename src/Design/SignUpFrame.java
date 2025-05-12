package Design;

import javax.swing.*;
/*Imports the Swing library*/
import Logic.Login.Account_Create;
/*Imports Account_Create from another package*/

public class SignUpFrame extends JFrame 
{
    public SignUpFrame() 
    {
        setTitle("Create Account");/*Title creation*/
        setSize(300, 200);/*Size of frame*/
        setLayout(null);/*Disables layout manager of jframe allowing to use setBound*/
        setLocationRelativeTo(null);/*Centers the frame basicaly*/
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ImageIcon icon = new ImageIcon(Login_GUI.class.getResource("/Design/images/Calling_Card.png"));
        /*Removes penguin icon and places custom image*/
        setIconImage(icon.getImage());/*Setting image*/

        JTextField usernameField = new JTextField();/*Textfield creation*/
        JPasswordField passwordField = new JPasswordField();/*Textfield creation*/
        JButton createBtn = new JButton("Create");/*Button creation*/

        usernameField.setBounds(100, 30, 150, 25);/*Boundaries for usernameField*/
        passwordField.setBounds(100, 60, 150, 25);/*Boundaries for usernameField*/
        createBtn.setBounds(100, 100, 90, 25);/*Boundaries for createBtn*/

        add(new JLabel("Username:")).setBounds(20, 30, 80, 25);
        /*Boundaries for username label*/
        add(new JLabel("Password:")).setBounds(20, 60, 80, 25);
        /*Boundaries for password label*/

        add(usernameField);/*Adds usernameField to frame directly since class extends JFrame*/
        add(passwordField);/*Adds passwordField to frame directly since class extends JFrame*/
        add(createBtn);/*Adds createBtn to frame directly since class extends JFrame*/

        createBtn.addActionListener(e -> 
        {
            String user = usernameField.getText();/*Takes data from textField, usernameField*/
            String pass = new String(passwordField.getPassword());/*Takes data from textField, passwordField*/

            boolean success = Account_Create.createAccount(user, pass);
            /*Used to check if program succeeds or fails*/
            new ResultFrame(success ? "Account created!" : "Account already exists or error.");
            /*Success ? acts as if(true) i think and the colon acts like an else*/
        });

        setVisible(true);
    }
}
