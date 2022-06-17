import brackets.Parenthesis;
import exception.NumberException;
import factorial.SumDigitsFactorial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import transportations.Transportation;

import java.util.Scanner;

public class Logic {

    private final Logger logger = LoggerFactory.getLogger(Logic.class);

    public void start() {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Please, enter your number to find parentheses:");

            System.out.println(new Parenthesis().getNumber(new Parenthesis().getParenthesis(scanner.nextInt()))
                    + System.lineSeparator());

            new Transportation().testExecute(scanner);

            System.out.println(System.lineSeparator() + "Please, enter your number to find factorial:");

            System.out.print("SumDigitsFactorial is " + new SumDigitsFactorial().findSum(
                    new SumDigitsFactorial().findFactorial(scanner.nextInt())));

        } catch (NumberException exception) {
            logger.error("Program failed : ", exception);
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            logger.error("Program failed : ", exception);
            System.out.println("Something went wrong");
        }
    }
}
