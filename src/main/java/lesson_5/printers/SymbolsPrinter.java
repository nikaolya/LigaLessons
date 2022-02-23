package lesson_5.printers;

public class SymbolsPrinter implements Printer {

    @Override
    public void print(String textForPrint) {
        String[] symbols = textForPrint.split("");
        for (String symbol : symbols) {
            System.out.println(symbol);
        }
    }
}
