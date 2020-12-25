import java.util.regex.Pattern;

import static java.lang.System.out;

public class RegExp {
    private Pattern pattern;

    public static void main(String[] args) {
        println(new RegExp("^y.*i$", "i").test("Yuri"));
    }

    RegExp(String regex) {
        pattern = Pattern.compile(regex);
    }

    RegExp(String regexp, String flags) {
        if (flags.indexOf("i") != -1) {
            pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        }
    }
    public boolean test(String input) {
        return pattern.matcher(input).find();
    }


    private static void println(Object arg) { out.println(arg); }
}
