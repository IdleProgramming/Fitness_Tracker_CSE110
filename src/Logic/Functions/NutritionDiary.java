package Logic.Functions;

import java.util.ArrayList;

public class NutritionDiary 
{
    static ArrayList<String> meals = new ArrayList<>();
    /*Stores all meal entries as simple strings*/

    public static void logMeal(String name, int calories) 
    {
        meals.add(name + " - " + calories + " kcal");
        /*Adds meal name and calories to the log in format "Meal - X kcal"*/
    }

    public static String getNutritionSummary() 
    {
        if (meals.isEmpty())
        {
            return "No meals logged yet.";
            /*Incase no meals have been added*/
        }

        StringBuilder summary = new StringBuilder();
        /*Creates a string builder object (efficient and cool way to build strings)*/
        summary.append("Your meals:\n");
        /*Creates the header for the summary*/

        for (String meal : meals) 
        {
            summary.append(meal).append("\n");
            /*Adds each meal entry on a new line*/
        }

        return summary.toString();
        /*Combines all meal entries into one string with line breaks*/
    }
}