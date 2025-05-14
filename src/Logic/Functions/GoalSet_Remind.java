package Logic.Functions;

public class GoalSet_Remind 
{
    public static int calculateGoalDays(int dailySteps, double weightLossKg) 
    {
        double totalCalories = weightLossKg * 7700;/*1kg of fat is around 7,700 calories*/
        double dailyCaloriesBurned = dailySteps * 0.04;/*Each step burns around 0.04 calories*/

        if (dailyCaloriesBurned == 0) return 0;
        /*Makes sure dailySteps is not 0*/

        double rawDays = totalCalories / dailyCaloriesBurned;
        int days;

        /*If its equal to the int version of itself its integer if not plus 1 is added to round up*/
       if (rawDays == (int) rawDays) 
        {
            days = (int) rawDays; 
        } 
        else 
        {
            days = (int) rawDays + 1; 
        }

        return days;
    }
}
