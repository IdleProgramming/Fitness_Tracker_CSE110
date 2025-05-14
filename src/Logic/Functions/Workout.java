package Logic.Functions;

import java.util.ArrayList;

public class Workout {
    static ArrayList<String> log = new ArrayList<>();

    public static void logWorkout(String exercise, int sets, int reps) 
    {
        log.add(exercise + " - Sets: " + sets + ", Reps: " + reps);
    }

    public static String getWorkoutSummary() 
    {
        if (log.isEmpty())
        {
            return "No workouts logged yet.";
        }
        return String.join("\n", log);
        /*Combines all workout entries into one string, making sure each entry is on a new line*/
    }
}
