import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Read Principal Amount
        System.out.print("Enter Principal Amount : ");
        double principal = scanner.nextDouble();

        // Read Annual Growth Rate
        System.out.print("Enter Annual Growth Rate (%) : ");
        double rate = scanner.nextDouble();

        // Read Number of Years
        System.out.print("Enter Number of Years : ");
        int years = scanner.nextInt();

        // Create ForecastCalculator object
        ForecastCalculator calculator = new ForecastCalculator();

        // Calculate Future Value
        double futureValue = calculator.forecast(principal, rate, years);

        // Display Result
        System.out.printf("\nFuture Value after %d years = %.2f\n",
                years, futureValue);

        scanner.close();
    }
}