package lesson_3.homework;

public class ElementClass implements Element {
    private String elementName;
    private String elementType;
    private String elementDescription;
    public Cursor cursor;

    public ElementClass(Cursor cursor, String elementDescription) {
        this.cursor = cursor;
        this.elementDescription = elementDescription;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getElementName() {
        return elementName;
    }

    public String getElementDescription() {
        System.out.println("\nThe element you are dealing with: " + elementDescription + ".");
        return elementDescription;
    }

    @Override
    public String getType() {
        cursor.setCurrentElementPointing(elementName);
        return elementType;
    }

    @Override
    public void click() {
        System.out.println("The " + elementName + " is clicked.");
        cursor.setCurrentElementPointing(elementName);
    }

    @Override
    public boolean placeTheCursor() {
        String cursorType = cursor.changePointerType(elementType);
        cursor.setCurrentElementPointing(elementName);
        System.out.println("The cursor is placed on the " + elementName);
        System.out.println("The cursor is changed on " + cursorType + ".");
        return true;
    }

    @Override
    public boolean removeTheCursor() {
        String cursorType = cursor.changePointerType("Free Screen Space");
        cursor.setCurrentElementPointing("Free Screen Space");
        System.out.println("The cursor is removed from the " + elementName + " element.");
        System.out.println("The cursor is changed on " + cursorType + ".");
        return false;
    }

}
