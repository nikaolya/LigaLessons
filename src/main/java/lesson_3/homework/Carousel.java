package lesson_3.homework;

public class Carousel extends ElementClass {

    public Carousel(Cursor cursor, String elementDescription) {
        super(cursor, elementDescription);
        setElementName("Carousel");
        setElementType("Clickable");
    }

    @Override
    public void click() {
        System.out.println("The " + getElementName() + " is clicked.");
        cursor.setCurrentElementPointing(getElementName());
        System.out.println("Corresponding website page is opened.");
    }
}
