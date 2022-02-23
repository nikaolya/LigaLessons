package lesson_3.homework.elements;

public class Icon implements Element {

    private String description;

    public Icon(String description) {
        this.description = description;
    }

    @Override
    public String getType() {
        return description;
    }

    @Override
    public void click() {
        System.out.println("Нажимаем на иконку: " + description);
    }
}
