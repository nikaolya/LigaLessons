package lesson_3.homework;

public class CategoryFigure extends Category {

    public CategoryFigure(Cursor cursor, String iconDescription) {
        super(cursor, iconDescription);
    }


    @Override
    public boolean placeTheCursor() {
        String cursorType = cursor.changePointerType(getType());
        cursor.setCurrentElementPointing(getIconTitle());
        System.out.println("The cursor is placed on the \'" + getIconTitle() + "\'.");
        System.out.println("The cursor is changed on " + cursorType + ".");
        System.out.println("Picture changes the background color.");
        return true;
    }

    @Override
    public boolean removeTheCursor() {
        String cursorType = cursor.changePointerType("Free Screen Space");
        cursor.setCurrentElementPointing("Free Screen Space");
        System.out.println("The cursor is removed from the \'" + getIconTitle() + "\' element.");
        System.out.println("The cursor is changed on " + cursorType + ".");
        System.out.println("Picture changes the background color back to the original.");
        return false;
    }
}
