package brackets;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    public static final String OPENED_PARENTHESIS = "(";
    public static final String CLOSED_PARENTHESIS = ")";
    public static final String EMPTY_STRING = "";


    public List<String> getParenthesis(Integer number) {

        // Building all bracket sequences made from opening parentheses and closing parentheses
        List<String> parenthesis = new ArrayList<>();
        if (number == 0) {
            parenthesis.add(EMPTY_STRING);
        } else {
            buildParenthesis(number, parenthesis);
        }
        return parenthesis;
    }

    private void buildParenthesis(Integer number, List<String> parenthesis) {
        for (int i = 0; i < number; ++i) {
            for (String left : getParenthesis(i)) {
                for (String right : getParenthesis(number - 1 - i)) {
                    parenthesis.add(OPENED_PARENTHESIS + left + CLOSED_PARENTHESIS + right);
                }
            }
        }
    }

    public Integer getNumber(List<String> parenthesis) {
        //Showing all variants
        System.out.println("All variants of parenthesis :" + parenthesis);
        //Counting all variants
        return parenthesis.size();
    }

}
