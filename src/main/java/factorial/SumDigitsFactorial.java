package factorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class SumDigitsFactorial {

    public static final String ONE = "1";

    private final Logger logger = LoggerFactory.getLogger(SumDigitsFactorial.class);

    private BigInteger findFactorial(int number) {
        logger.info("Number to find factorial " + number);
        // Calculating the factorial
        while (number <= 2) {
            logger.info("number must be positive and > 2" + number);
            System.out.println("Number must be positive and > 2" + number);
        }

        // Initialize result
        BigInteger factorial = new BigInteger(ONE);

        // Multiply factorial
        for (int i = 2; i <= number; i++)
            factorial = factorial.multiply(BigInteger.valueOf(i));

        return factorial;
    }

    public int findSum(int number) {

        String factorial = findFactorial(number).toString();
        int sum = 0;

        // Calculating sum of all digits
        for (int i = 0; i < factorial.length(); i++) {
            int digit = (factorial.charAt(i) - '0');
            sum = sum + digit;
        }
        return sum;
    }

}
