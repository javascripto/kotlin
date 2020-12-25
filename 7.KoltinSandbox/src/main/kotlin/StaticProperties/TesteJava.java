package StaticProperties;

import static java.lang.System.out;

public class TesteJava {
    public static int counter = 0;

    TesteJava() {
        TesteJava.counter++;
    }

    public static void main(String[] args) {
        new TesteKotlin();
        new TesteKotlin();
        new TesteKotlin();
        out.println(TesteKotlin.counter.getCount());
    }
}
