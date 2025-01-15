import java.util.Scanner;
public class PoundKilogramConversion {

    public static void main(String[] args){
        double[][] data = {
                {0, 0},
                {1, 0.453592},
                {2, 0.907185},
                {3, 1.3607},
                {4, 1.81437},
                {5, 2.26796},
                {6, 2.72155},
                {7, 3.17515},
                {8, 3.62874},
                {9, 4.08233},
                {10,  4.53592}
        };

    // Perform linear regression to find slope (m) and intercept (b)
    double[] coefficients = performLinearRegression(data);
    double m = coefficients[0];
    double b = coefficients[1];

        System.out.println("Linear Regrression Model: Kg = " + m + "x pound + " + b);

    // Interactive temperature conversion
    Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight in pounds to convert to kg(s): ");

    double pound = scanner.nextDouble();
    double kg = m * pound + b;
        System.out.println("Converted to kg: " + kg);



        System.out.println("Enter weight in kg to convert to pound: ");
    kg = scanner.nextDouble();
    pound = (kg - b) / m;
        System.out.println("Converted to kg: " + pound);

        scanner.close();


    }

public static double[] performLinearRegression(double[][] data) {

    int n = data.length;
    double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

    for(double[] point: data){
        double x = point[0];
        double y = point[1];
        sumX += x;
        sumY += y;

        sumXY += x * y;
        sumX2 += x * x;


    }

    double slope = (n * sumXY - sumX * sumY) / (n * sumX2 -sumX * sumX);
    double intercept =  (sumY - slope * sumX) / n;

    return new double[]{slope, intercept};


    /***
     *
     * Linear regression model:
     y = m * x + b
     where:
     y: Dependent variable (e.g., Fahrenheit temperature).

     x: Independent variable (e.g., Celsius temperature).

     m: Slope of the line (rate of change of y with respect to x)

     b: Intercept (value of y when x = 0).

     */

}
}