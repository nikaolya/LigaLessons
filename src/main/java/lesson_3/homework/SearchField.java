package lesson_3.homework;

public class SearchField extends ElementClass{

    public SearchField(Cursor cursor, String elementDescription) {
        super(cursor, elementDescription);
        setElementName("Search field");
        setElementType("Text Insert");
    }

    public void insertText(String textToSearch){
        System.out.println("The text is inserted into the text field: " + textToSearch + ".");
        cursor.setCurrentElementPointing(getElementName());
    }

    @Override
    public void click() {
        System.out.println("The " + getElementName() + " is clicked.");
        System.out.println("It is possible to enter text information.");
        cursor.setCurrentElementPointing(getElementName());
    }
}
