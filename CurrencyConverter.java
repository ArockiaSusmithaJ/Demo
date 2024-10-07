import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CurrencyConverter extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve input values from the request
        double amount = Double.parseDouble(request.getParameter("amount"));
        String sourceCurrency = request.getParameter("sourceCurrency");
        String targetCurrency = request.getParameter("targetCurrency");

        // Perform currency conversion calculation
        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

        // Set the response content type
        response.setContentType("text/plain");

        // Return the converted amount as the response
        response.getWriter().write(Double.toString(convertedAmount));
    }

    private double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        // Implement currency conversion logic here using exchange rates
        // Replace with your own implementation or API call

        double exchangeRateUSDToINR = 75.0;  // Example exchange rate for USD to INR

        if (sourceCurrency.equals("USD") && targetCurrency.equals("INR")) {
            return amount * exchangeRateUSDToINR;
        } else if (sourceCurrency.equals("INR") && targetCurrency.equals("USD")) {
            return amount / exchangeRateUSDToINR;
        } else {
            // Handle unsupported currency conversion or error condition
            return 0.0;
        }
    }
}
