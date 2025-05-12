package Design;

import javax.swing.*;
/*Imports the Swing library*/
import java.awt.*;
/*Imports the Java Abstract Window Toolkit(AWT)*/



public class Main_GUI extends JFrame
{
    public Main_GUI()
    {
        /*Frame Title and Frame Specs*/
        setTitle("Git.Fit");/*Title creation*/
        setSize(600,400);/*Size of frame*/
        setLayout(null);/*Disables layout manager of jframe allowing to use setBound*/
        setLocationRelativeTo(null);/*Centers frame*/
        setDefaultCloseOperation(EXIT_ON_CLOSE);/*Exits operation when frame is closed*/

        /*Main Title*/
        JLabel Title = new JLabel("OmniCoreFitness");/*Instance of JLabel named Title with text*/
        Font titleFont = new Font("SansSerif", Font.BOLD, 50);/*Nifty way to specify a font with bold & size*/
        Title.setFont(titleFont);/*Attaches titleFont specs to Title text*/
    }
}
