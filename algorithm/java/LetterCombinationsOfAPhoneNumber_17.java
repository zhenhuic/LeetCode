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

    /**
     * 第二遍写
     */
    public List<String> letterCombinations1(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        String[] keypad = new String[]{"", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();

        backtrack(digits, 0, keypad, sb, result);
        return result;
    }

    private void backtrack(String digits, int idx, String[] keypad,
                           StringBuilder prefix, List<String> result) {
        if (idx == digits.length()) {
            result.add(prefix.toString());
            return;
        }
        char c = digits.charAt(idx);
        String letters = keypad[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            prefix.append(letters.charAt(i));
            backtrack(digits, idx + 1, keypad, prefix, result);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
