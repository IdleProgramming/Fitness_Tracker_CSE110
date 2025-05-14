package Design;

import javax.swing.*;
/*Imports the Swing library*/
import java.awt.*;
/*Imports the Java Abstract Window Toolkit(AWT)*/
import Logic.Functions.Daily_Activity;
import Logic.Functions.Workout;
import Logic.Functions.GoalSet_Remind;
import Logic.Functions.NutritionDiary;



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

        /*Action Listener for ActivityCheck Button*/
        ActivityCheck.addActionListener(e -> 
        {
            /*Clears previous textArea and labels from previous buttons hopefully*/
            RightPanel.removeAll();


            /*Options for selection using a comboBox which should allow 3 options to be displayed*/
            JLabel ActivityChoice = new JLabel("Choose Activity: ");
            ActivityChoice.setBounds(30,20,150,25);

            String[] Options = {"Walking","Running","Cycling"};
            JComboBox<String> Boxin = new JComboBox<>(Options);
            /*Creates a drop down menu like when you pick what region to play games on and uses Options as.. options.*/
            Boxin.setBounds(180, 20, 150, 25);


            /*Time Walked,Ran etc in MINUTES(IMPORTANT)*/
            JLabel timeSelect = new JLabel("Duration (Min): ");
            timeSelect.setBounds(30, 60, 150, 25);

            JTextField timeField = new JTextField();
            timeField.setBounds(180, 60, 100, 25);


            /*Distance Input in KILOMETRES(IMPORTANT)*/
            JLabel distanceSelect = new JLabel("Distance (km):");
            distanceSelect.setBounds(30, 100, 150, 25);

            JTextField distanceField = new JTextField();
            distanceField.setBounds(180, 100, 100, 25);


            /*JTextArea for Results (can't be edited)*/
            JTextArea resultArea = new JTextArea();
            resultArea.setEditable(false);
            resultArea.setLineWrap(true);/*Moves to next line if no space left*/
            resultArea.setWrapStyleWord(true);/*Prevents full words from being separated*/
            resultArea.setBackground(Color.WHITE);
            resultArea.setForeground(Color.BLACK);

            JScrollPane scroller = new JScrollPane(resultArea);
            scroller.setBounds(30, 200, 460, 200);
            scroller.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            /*Slight border around entire box. pointless but cool*/


            /*Calculate calories button*/
            JButton calButton = new JButton("Calculate Calories");
            calButton.setBounds(30, 150, 180, 30);

            calButton.addActionListener(ev ->
            {
                try
                {
                    String activity = (String) Boxin.getSelectedItem();
                    double duration = Double.parseDouble(timeField.getText());
                    /*getText() returns a string but Double.parseDouble turns it into a double variable*/
                    double distance = Double.parseDouble(distanceField.getText());
                    /*getText() returns a string but Double.parseDouble turns it into a double variable*/

                    double calories = Daily_Activity.calculateCalories(activity, duration, distance);
                    /*Calls method in Daily_Activity. Basic.*/
                    resultArea.setText("Estimated Calories Burned: " + calories);
                } 
                catch (NumberFormatException ex) 
                {
                    resultArea.setText("Please enter valid numbers.");
                    /*Incase letters are inputted in duration/distance or an error occurs*/
                }
            });

            /*Add to RightPanel.*/
            RightPanel.add(ActivityChoice);
            RightPanel.add(Boxin);
            RightPanel.add(timeSelect);
            RightPanel.add(timeField);
            RightPanel.add(distanceSelect);
            RightPanel.add(distanceField);
            RightPanel.add(calButton);
            RightPanel.add(scroller);

            RightPanel.revalidate();
            /*Basically stores the current format if you add/remove components like switching buttons to be reused later*/
            RightPanel.repaint();
            /*Redraws panel somehow? need to study later.*/
        });

        
        /*Action Listener for WorkoutLog Button*/
        WorkoutLog.addActionListener(e -> 
        {
            /*Clears previous textArea and labels from previous buttons hopefully*/
            RightPanel.removeAll();


            /*Options for selection using a comboBox which should allow 3 options to be displayed*/
            JLabel ExcerciseChoice = new JLabel("Choose Activity: ");
            ExcerciseChoice.setBounds(30,20,150,25);

            String[] Options = {"Benchpress","Squatting","Deadlift"};
            JComboBox<String> Boxin = new JComboBox<>(Options);
            /*Creates a drop down menu like when you pick what region to play games on and uses Options as.. options.*/
            Boxin.setBounds(180, 20, 150, 25);


            /*Number of Sets selection*/
            JLabel setsSelect = new JLabel("Sets: ");
            setsSelect.setBounds(30, 60, 150, 25);

            JTextField setsField = new JTextField();
            setsField.setBounds(180, 60, 100, 25);


            /*Number of Reps*/
            JLabel repsSelect = new JLabel("Reps per Set: ");
            repsSelect.setBounds(30, 100, 150, 25);

            JTextField repsField = new JTextField();
            repsField.setBounds(180, 100, 100, 25);


            /*JTextArea for Results (can't be edited)*/
            JTextArea resultArea = new JTextArea();
            resultArea.setEditable(false);
            resultArea.setLineWrap(true);/*Moves to next line if no space left*/
            resultArea.setWrapStyleWord(true);/*Prevents full words from being separated*/
            resultArea.setBackground(Color.WHITE);
            resultArea.setForeground(Color.BLACK);

            JScrollPane scroller = new JScrollPane(resultArea);
            scroller.setBounds(30, 200, 460, 200);
            scroller.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            /*Slight border around entire box. pointless but cool*/


            /*LWorkoutButton*/
            JButton LWorkoutButton = new JButton("Log Workout");
            LWorkoutButton.setBounds(30, 150, 180, 30);

            LWorkoutButton.addActionListener(ev ->
            {
                try
                {
                    String activity = (String) Boxin.getSelectedItem();
                    int sets = Integer.parseInt(setsField.getText());
                    /*getText() returns a string but Integer.parseInt turns it into a integer variable*/
                    int reps = Integer.parseInt(repsField.getText());
                    /*getText() returns a string but Integer.parseInt turns it into a integer variable*/

                    Workout.logWorkout(activity, sets, reps);
                    /*Calls method in Workout. Basic.*/

                    resultArea.setText("Workout logged successfully.\n\n" + Workout.getWorkoutSummary());
                } 
                catch (NumberFormatException ex) 
                {
                    resultArea.setText("Please enter valid numbers.");
                    /*Incase letters are inputted in sets/reps or an error occurs*/
                }
            });

            /*Add to RightPanel.*/
            RightPanel.add(ExcerciseChoice);
            RightPanel.add(Boxin);
            RightPanel.add(setsSelect);
            RightPanel.add(setsField);
            RightPanel.add(repsSelect);
            RightPanel.add(repsField);
            RightPanel.add(LWorkoutButton);
            RightPanel.add(scroller);

            RightPanel.revalidate();
            /*Basically stores the current format if you add/remove components like switching buttons to be reused later*/
            RightPanel.repaint();
            /*Redraws panel somehow? need to study later.*/
        });



        NutritionLog.addActionListener(e -> 
        {
            RightPanel.removeAll(); 
            /*Clears previous textArea and labels from previous buttons*/

            /*Meal Name Input*/
            JLabel mealLabel = new JLabel("Meal Name:");
            mealLabel.setBounds(30, 20, 150, 25);

            JTextField mealField = new JTextField();
            mealField.setBounds(180, 20, 200, 25);

            /*Calories Input*/
            JLabel calorieLabel = new JLabel("Calories (kcal):");
            calorieLabel.setBounds(30, 60, 150, 25);

            JTextField calorieField = new JTextField();
            calorieField.setBounds(180, 60, 100, 25);

            /*Result Display Area*/
            JTextArea resultArea = new JTextArea();
            resultArea.setEditable(false);
            resultArea.setLineWrap(true); /*Moves to next line if no space left*/
            resultArea.setWrapStyleWord(true); /*Prevents full words from being separated*/
            resultArea.setBackground(Color.WHITE);
            resultArea.setForeground(Color.BLACK);

            JScrollPane scroll = new JScrollPane(resultArea);
            scroll.setBounds(30, 150, 460, 200);
            scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            /*Slight border around entire box*/

            /*Log Meal Button*/
            JButton logButton = new JButton("Log Meal");
            logButton.setBounds(30, 100, 150, 30);

            logButton.addActionListener(ev -> 
            {
                try 
                {
                    String mealName = mealField.getText();
                    int calories = Integer.parseInt(calorieField.getText());
                    /*getText() returns a string but Integer.parseInt turns it into an integer*/

                    NutritionDiary.logMeal(mealName, calories);
                    /*Calls method in NutritionDiary to log the meal*/
            
                    resultArea.setText(NutritionDiary.getNutritionSummary());
                    /*Updates textArea with meal summary*/
            
                    /*Clear input fields*/
                    mealField.setText("");
                    calorieField.setText("");
                } 
                catch (NumberFormatException ex) 
                {
                    resultArea.setText("Please enter valid numbers for calories.");
                    /*Incase letters are inputted where numbers should be*/
                }
            });

            /*Add all components to RightPanel*/
            RightPanel.add(mealLabel);
            RightPanel.add(mealField);
            RightPanel.add(calorieLabel);
            RightPanel.add(calorieField);
            RightPanel.add(logButton);
            RightPanel.add(scroll);

            RightPanel.revalidate();
            /*Stores current format when switching buttons*/
            RightPanel.repaint();
            /*Redraws panel*/
        });



        GoalLog.addActionListener(e -> 
        {
            RightPanel.removeAll(); // Clear previous content

            /*Steps per day*/
            JLabel stepLabel = new JLabel("Steps per day:");
            stepLabel.setBounds(30, 20, 150, 25);

            JTextField stepField = new JTextField();
            stepField.setBounds(180, 20, 100, 25);


            /*Ideal weight loss in terms of kgs*/
            JLabel weightLabel = new JLabel("Weight to lose (kg):");
            weightLabel.setBounds(30, 60, 150, 25);

            JTextField weightField = new JTextField();
            weightField.setBounds(180, 60, 100, 25);


            /*JTextArea for Results (can't be edited)*/
            JTextArea resultArea = new JTextArea();
            resultArea.setEditable(false);
            resultArea.setLineWrap(true);
            resultArea.setWrapStyleWord(true);
            resultArea.setBackground(Color.WHITE);
            resultArea.setForeground(Color.BLACK);

            JScrollPane scroll = new JScrollPane(resultArea);
            scroll.setBounds(30, 150, 460, 200);
            scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));


            /*calcButton to check how many days needed*/
            JButton calcButton = new JButton("Calculate Days Needed");
            calcButton.setBounds(30, 100, 200, 30);
            calcButton.addActionListener(ev -> 
            {
                try 
                {
                    int steps = Integer.parseInt(stepField.getText());
                    /*getText() returns a string but Integer.parseInt turns it into a integer variable*/
                    double weight = Double.parseDouble(weightField.getText());
                    /*getText() returns a string but Double.parseDouble turns it into a double variable*/

                    int days = GoalSet_Remind.calculateGoalDays(steps, weight);
                    resultArea.setText("To lose " + weight + " kg,\nyou need to walk " + steps + " steps per day for about " + days + " days.");
                }       
                catch (NumberFormatException ex) 
                {
                    resultArea.setText("Please enter valid numbers.");
                }
            });

            /*Add to RightPanel.*/
            RightPanel.add(stepLabel);
            RightPanel.add(stepField);
            RightPanel.add(weightLabel);
            RightPanel.add(weightField);
            RightPanel.add(calcButton);
            RightPanel.add(scroll);

            RightPanel.revalidate();
            /*Basically stores the current format if you add/remove components like switching buttons to be reused later*/
            RightPanel.repaint();
            /*Redraws panel somehow? need to study later.*/
        });
        

        

        setVisible(true);
    }
}
