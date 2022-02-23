package lesson_3.homework.elements;

public class Button implements Element {

    private String buttonName;

    public Button(String buttonName) {
        this.buttonName = buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    @Override
    public String getType() {
        return "Кнопка";
    }

    @Override
    public void click() {
        System.out.println("Нажимаем на кнопку: " + buttonName);
    }
}
