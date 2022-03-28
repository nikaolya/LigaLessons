package lesson_11.homework.pages.listing;

public class XpathFormatter {

    public static String formatXpath(String rawPath, Object... args) {
        return String.format(rawPath, args);
    }

}
