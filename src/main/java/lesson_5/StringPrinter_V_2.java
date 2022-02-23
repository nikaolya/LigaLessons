package lesson_5;

import java.util.function.Consumer;

public class StringPrinter_V_2 {
    private String text;

    public StringPrinter_V_2(String text) {
        this.text = text;
    }

    public void print(Consumer<String> printer) {
        printer.accept(text);
    }
}
