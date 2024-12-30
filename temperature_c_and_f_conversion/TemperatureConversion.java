import java.util.Scanner;

public class TemperatureConversion {

    public static void main(String[] args) {
        // sample data for linear regression
        double[][] data = {
            {0, 32},
            {10, 50},
            {20, 68},
            {30, 86},
            {40, 104},
            {50, 122},
            {60, 140},
            {70, 158},
            {80, 176},
            {90, 194},
            {100, 212}
            
            
        };


        // Perform linear regression to find slope (m) and intercept (b)
        double[] coefficients = performLinearRegression(data);
        double m = coefficients[0];
        double b = coefficients[1]; 

        System.out.println("Linear Regrression Model: F = " + m + "C + " + b);

        // Interactive temperature conversion 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature in Celsius to convert to Fahrenheit: ");

        double celsius = scanner.nextDouble();
        double fahrenheit = m * celsius + b;
        System.out.println("Converted to Fahrenheit: " + fahrenheit);


        System.out.println("Enter temperature in Fahrenheit to convert to Celsius: ");
        fahrenheit = scanner.nextDouble();
        celsius = (fahrenheit - b) / m;
        System.out.println("Converted to Celsius: " + celsius);

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