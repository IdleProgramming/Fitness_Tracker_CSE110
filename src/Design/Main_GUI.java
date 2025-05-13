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
        setSize(700,700);/*Size of frame*/
        setLayout(null);/*Disables layout manager of jframe allowing to use setBound*/
        setLocationRelativeTo(null);/*Centers frame*/
        setDefaultCloseOperation(EXIT_ON_CLOSE);/*Exits operation when frame is closed*/
        

        /*Design Element(s)*/
        ImageIcon icon = new ImageIcon(Login_GUI.class.getResource("/Design/images/Calling_Card.png"));
        /*Removes penguin icon and places custom image*/
        setIconImage(icon.getImage());/*Setting image*/

        JPanel TopPanel = new JPanel();
        TopPanel.setBounds(0, 0, 700, 100);
        TopPanel.setBackground(new Color(6, 7, 20));
        TopPanel.setLayout(null);

        JPanel LeftPanel = new JPanel();
        LeftPanel.setBounds(0, 100, 175, 600);
        LeftPanel.setBackground(new Color(6, 6, 33));
        LeftPanel.setLayout(null);

        JPanel RightPanel = new JPanel();
        RightPanel.setBounds(175, 100, 525, 600);
        RightPanel.setBackground(new Color(1, 0, 14));
        RightPanel.setLayout(null);


        /*Main Title*/
        JLabel Title = new JLabel("Atlas Fitness");/*Instance of JLabel named Title with text*/
        Font titleFont = new Font("SansSerif", Font.BOLD, 50);/*Nifty way to specify a font with bold & size*/
        Title.setFont(titleFont);/*Attaches titleFont specs to Title text*/ 
        Title.setBounds(175,25,500,50);/*Boundaries for text*/
        Title.setForeground(new Color(255, 215, 0));/*Attaches custom colour to Title text*/


        /*Buttons*/
        JButton ActivityCheck = new JButton("Activity Calculator");
        JButton WorkoutLog = new JButton("Workout Regiment");
        JButton NutritionLog = new JButton("Nutrition Log");
        JButton GoalLog = new JButton("Goals");

        ActivityCheck.setBounds(12,100,150,50);
        WorkoutLog.setBounds(12,200,150,50);
        NutritionLog.setBounds(12,300,150,50);
        GoalLog.setBounds(12,400,150,50);

        ActivityCheck.setBackground(new Color(0, 78, 126));
        WorkoutLog.setBackground(new Color(0, 78, 126));
        NutritionLog.setBackground(new Color(0, 78, 126));
        GoalLog.setBackground(new Color(0, 78, 126));

        ActivityCheck.setForeground(Color.BLACK);
        WorkoutLog.setForeground(Color.BLACK);
        NutritionLog.setForeground(Color.BLACK);
        GoalLog.setForeground(Color.BLACK);


        /*Gets rid of weird border around text*/
        ActivityCheck.setFocusPainted(false);
        WorkoutLog.setFocusPainted(false);
        NutritionLog.setFocusPainted(false);
        GoalLog.setFocusPainted(false);

        Font buttonFont = new Font("Segoe UI", Font.BOLD, 12);
        ActivityCheck.setFont(buttonFont);
        WorkoutLog.setFont(buttonFont);
        NutritionLog.setFont(buttonFont);
        GoalLog.setFont(buttonFont);


        /*TextArea to display results*/
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        resultArea.setBackground(Color.WHITE);
        resultArea.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(30, 250, 460, 300);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        RightPanel.setLayout(null);


        /*Additions to frame*/
        add(TopPanel);
        add(LeftPanel);
        add(RightPanel);

        /*Additions to TopPanel*/
        TopPanel.add(Title);

        /*Additions to LeftPanel*/
        LeftPanel.add(ActivityCheck);
        LeftPanel.add(WorkoutLog);
        LeftPanel.add(NutritionLog);
        LeftPanel.add(GoalLog);

        /*Addtions to RightPanel*/
        RightPanel.add(scrollPane);

        
        revalidate();
        repaint();

        setVisible(true);
    }
}
