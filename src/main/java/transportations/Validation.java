package transportations;

import exception.NumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Validation {

    public static final String REGEX = "[a-z]+";
    private final Logger logger = LoggerFactory.getLogger(Validation.class);

    public void validateNumberOfTests(Integer number) {
        if (number > 10) {
            logger.info("The number of tests must be <= 10");
            throw new NumberException("The number of tests must be <= 10");
        }
    }

    public void validateNumberOfCities(Integer number) {
        if (number > 10000) {
            logger.info("The number of cities must be <= 10000");
            throw new NumberException("The number of cities must be <= 10000");
        }
    }

    public void validateNumberOfNeighbors(Integer number) {
        if (number > 100) {
            logger.info("The number of neighbors must be <= 100");
            throw new NumberException("The number of neighbors must be <= 100");
        }
    }

    public void validateNameOfCity(String str) {
        if (!str.matches(REGEX) || str.length() > 10) {
            logger.info("it must be <= 10 char and contains only letters");
            throw new NumberException("The number of neighbors must be <= 100");
        }
    }


}
