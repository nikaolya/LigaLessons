package lesson_3.homework;

public class Button extends ElementClass{

    public Button(Cursor cursor, String elementDescription) {
        super(cursor, elementDescription);
        setElementName("Button");
        setElementType("Clickable");
    }

    @Override
    public void click() {
        System.out.println("The " + getElementName() + " is clicked.");
        cursor.setCurrentElementPointing(getElementName());
        System.out.println("Corresponding action is taken, something is opened...");
    }

}
