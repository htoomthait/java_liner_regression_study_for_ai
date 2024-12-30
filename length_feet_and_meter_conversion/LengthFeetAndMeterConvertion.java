import java.util.Scanner;

public class LengthFeetAndMeterConvertion {
    public static void main(String[] args) {

        // sample dta for linear regression
        double[][] data = {
            {0, 0},
            {1, 0.3048},
            {2, 0.6096},
            {3, 0.9144},
            {4, 1.2192},
            {5, 1.524},
            {6, 1.8288},
            {7, 2.1336},
            {8, 2.4384},
            {9, 2.7432},
            {10, 3.048},


        };

        // Perform linear regression to find slope (m) and intercept (b)
        double[] coefficients = performLinearRegression(data);
        double m = coefficients[0];
        double b = coefficients[1]; 

        System.out.println("Linear Regrression Model: Meter = " + m + "x Feet + " + b); 

         // Interactive temperature conversion 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature in feet(foot) to convert to Meter(s): ");

        double feet = scanner.nextDouble();
        double meter = m * feet + b;
        System.out.println("Converted to Fahrenheit: " + meter);



        System.out.println("Enter temperature in meter to convert to feet: ");
        meter = scanner.nextDouble();
        feet = (meter - b) / m;
        System.out.println("Converted to feet: " + feet);

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