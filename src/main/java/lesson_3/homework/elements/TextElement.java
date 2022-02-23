package lesson_3.homework.elements;

public class TextElement implements Element {

    protected String textValue;

    public TextElement(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue() {
        return textValue;
    }

    @Override
    public String getType() {
        return "Text element";
    }

    @Override
    public void click() {
        System.out.println("Нажимаем на текстовый элемент: " + textValue);
    }
}
