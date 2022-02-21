package lesson_3.homework;

/*public interface Element {
    String getType();

    void click();
}*/

public interface Element {
    String getType();

    void click();
    boolean placeTheCursor();
    boolean removeTheCursor();
}
