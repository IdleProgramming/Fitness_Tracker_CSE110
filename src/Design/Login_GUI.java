package Design;

import javax.swing.*;
/*Imports the Swing library*/
import java.awt.*;
/*Imports the Java Abstract Window Toolkit(AWT)*/



public class Login_GUI
{
    public static void main(String[] args)
    {
        JFrame login_interface = new JFrame();
        /*Instance of JFrame called login_interface*/
        ImageIcon icon = new ImageIcon(Login_GUI.class.getResource("/Design/images/Calling_Card.png"));
        /*Removes penguin icon and places custom image*/
        login_interface.setIconImage(icon.getImage());/*Setting image*/

        /*Frame_Title*/
        login_interface.setTitle("Git.Fit");/*Title creation*/
        login_interface.setSize(300, 200);/*Size of Title*/

        /*Frame_Work*/
        login_interface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*Exits operation when frame is closed*/
        login_interface.setSize(600, 400);/*Frame width and height respectively*/
        login_interface.setLocationRelativeTo(null);/*Launches frame in center of screen*/

        login_interface.getContentPane().setBackground(Color.BLACK);/*Changes colour of content pane*/
        login_interface.setLayout(null);/*Disables layout manager of jframe allowing to use setBound*/
        login_interface.setVisible(true);/*Frame is visible*/


        /*Title_Label*/
        JLabel Title = new JLabel("OmniCoreFitness");/*Instance of JLabel named Title with text*/
        Font titleFont = new Font("SansSerif", Font.BOLD, 50);/*Nifty way to specify a font with bold & size*/
        Title.setFont(titleFont);/*Attaches titleFont specs to Title text*/

        Title.setBounds(85,50,500,75);/*Boundaries for text*/
        Title.setForeground(new Color(255, 215, 0));/*Attaches custom colour to Title text*/
        login_interface.add(Title);/*Adds label to frame*/


        /*Buttons_Login_CreateAccount*/
        JButton Create_ = new JButton("Sign Up");/*Sign Up button*/
        JButton Log_ = new JButton("Log in");/*Log in button*/

        Create_.setBounds(225,200,120,35);/*Button boundaries*/
        Log_.setBounds(225,250,120,35);/*Button boundaries*/

        login_interface.add(Create_);/*Adds button to frame*/
        login_interface.add(Log_);/*Adds button to frame*/

        /*Login button sometimes doesnt appear this should fix that*/
        login_interface.revalidate();
        login_interface.repaint();

        Create_.addActionListener(e -> new SignUpFrame());
        Log_.addActionListener(e -> new LogInFrame());
    }
}