package lesson_3.homework;

import java.util.Arrays;

public class DropDown extends ElementClass{
    private String[] dropDownList;

    public DropDown(Cursor cursor, String elementDescription, String[] dropDownList) {
        super(cursor, elementDescription);
        setElementName("Drop down");
        setElementType("Clickable");
        this.dropDownList = Arrays.copyOf(dropDownList, dropDownList.length);
    }

    @Override
    public void click() {
        System.out.println("The " + getElementName() + " is clicked.");
        cursor.setCurrentElementPointing(getElementName());
        System.out.println("The drop down menu options are shown:");
        for(String listElement: dropDownList){
            System.out.println(listElement);
        }
        cursor.setCurrentElementPointing(getElementName());
    }

}
