package lesson_5;

import lesson_5.printers.Printer;

public class StringPrinter_V_1 {
    private String text;

    public StringPrinter_V_1(String text) {
        this.text = text;
    }

    public void print(Printer printer) {
        printer.print(text);
    }
}
