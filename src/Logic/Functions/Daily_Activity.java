package Logic.Functions;

public class Daily_Activity 
{
    public static double calculateCalories(String activity, double duration, double distance) 
    {
        switch (activity) 
        {
            case "Walking":
            return duration * 3.5 + distance * 1.2;

            case "Running":
            return duration * 6.0 + distance * 2.3;

            case "Cycling":
            return duration * 5.5 + distance * 1.8;
            
            default:
            return 0.0;
        }
    }
}
