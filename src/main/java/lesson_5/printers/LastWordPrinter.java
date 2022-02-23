package lesson_5.printers;

public class LastWordPrinter implements Printer {
    @Override
    public void print(String textForPrint) {
        String[] words = textForPrint.split(" ");
        System.out.println(words[words.length - 1]);
    }
}
