package lesson_5.printers;

public class TextLengthPrinter implements Printer {

    @Override
    public void print(String textForPrint) {
        System.out.println("text length is: " + textForPrint.length());
    }
}
