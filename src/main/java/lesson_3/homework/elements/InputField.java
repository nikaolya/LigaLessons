package lesson_3.homework.elements;

public class InputField implements Element {

    private String value = "";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        System.out.println("Вводим значение \"" + value + "\" в поисковую строку");
    }

    public void clear() {
        value = "";
    }

    @Override
    public String getType() {
        return "Поле ввода текста";
    }

    @Override
    public void click() {
        System.out.println("Нажимаем на поле ввода текста");
    }
}
