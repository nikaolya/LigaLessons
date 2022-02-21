package lesson_3.homework;

import java.util.Arrays;

public class CategoryButton extends Category {
    private String[] dropDownCategoryList;

    public CategoryButton(Cursor cursor, String iconDescription, String[] dropDownCategoryList) {
        super(cursor, iconDescription);
        this.dropDownCategoryList = Arrays.copyOf(dropDownCategoryList, dropDownCategoryList.length);
    }
    @Override
    public boolean placeTheCursor() {
        String cursorType = cursor.changePointerType(getType());
        cursor.setCurrentElementPointing(getIconTitle());
        System.out.println("The cursor is placed on the \'" + getIconTitle() + "\'.");
        System.out.println("The cursor is changed on " + cursorType + ".");
        System.out.println("The drop down menu options are shown:");
        for(String listElement: dropDownCategoryList){
            System.out.println(listElement);
        }
        return true;
    }

    @Override
    public boolean removeTheCursor() {
        String cursorType = cursor.changePointerType("Free Screen Space");
        cursor.setCurrentElementPointing("Free Screen Space");
        System.out.println("The cursor is removed from the \'" + getIconTitle() + "\' element.");
        System.out.println("The cursor is changed on " + cursorType + ".");
        System.out.println("The drop down menu options disappear.");
        return false;
    }

}
