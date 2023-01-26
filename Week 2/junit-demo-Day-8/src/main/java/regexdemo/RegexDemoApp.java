package regexdemo;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemoApp {
    public static void main(String[] args) {
        System.out.println("Regular expression demo");

        Pattern pattern = Pattern.compile("stack");
        Matcher matcher = pattern.matcher("stack");
        System.out.println(matcher.matches());
    }
}
