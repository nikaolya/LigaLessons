package lesson_3.homework.search;

import lesson_3.homework.elements.Button;

public class ScopeButton extends Button {

    public ScopeButton(String buttonName) {
        super(buttonName);
    }

    public void setScope(String newScope) {
        click();
        setButtonName(newScope);
        System.out.println("Область поиска изменена на: " + newScope);
    }
}
