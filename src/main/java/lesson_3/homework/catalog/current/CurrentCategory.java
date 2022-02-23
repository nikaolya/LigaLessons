package lesson_3.homework.catalog.current;

import lesson_3.homework.elements.Icon;
import lesson_3.homework.elements.TextElement;

public class CurrentCategory extends Category {
    private Icon icon;
    private TextElement textElement;

    private CurrentCategory(Icon icon, TextElement textElement) {
        this.icon = icon;
        this.textElement = textElement;
        iconDescription = icon.getType();
        name = textElement.getTextValue();
    }

    public static CurrentCategory getCategory(String iconDescription, String categoryName) {
        return new CurrentCategory(new Icon(iconDescription), new TextElement(categoryName));
    }

    @Override
    public void open() {
        getIcon().click();
        System.out.println("Категория \"" + name + "\" открыта.");
    }

    public Icon getIcon() {
        return icon;
    }

    public TextElement getTextElement() {
        return textElement;
    }
}
