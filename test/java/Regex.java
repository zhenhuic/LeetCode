import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\s");
        String text = "Hello 23 dk";
        Matcher matcher = p.matcher(text);
        System.out.println(Arrays.toString(text.split("\\w")));
        while (matcher.find()) {
            System.out.println(matcher.group().replace('l', '5'));
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }
        System.out.println(matcher);
        System.out.println(matcher.replaceAll("1"));

        System.out.println(text.replaceAll("\\W", "5"));
    }
}
