public class ForecastCalculator {

    public double forecast(double principal, double rate, int years) {

        // Base Case
        if (years == 0) {
            return principal;
        }

        // Recursive Case
        return forecast(principal, rate, years - 1) * (1 + rate / 100);

    }
}