import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 */
public class LetterCombinationsOfAPhoneNumber_17 {
    Map<String, String> phone = new HashMap<>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<>();

    /**
     * 回溯法
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    private void backtrack(String combination, String nextDigits) {
        // if there is no more digits to check
        if (nextDigits.length() == 0) {
            // the combination is done
            output.add(combination);
        } else {  // if there are still digits to check
            // iterate over all letters which map
            // the next available digit
            String digit = nextDigits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }
}
