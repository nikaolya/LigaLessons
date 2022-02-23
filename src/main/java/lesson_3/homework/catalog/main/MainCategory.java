package lesson_3.homework.catalog.main;

import lesson_3.homework.elements.TextElement;

public class MainCategory extends TextElement {

    private MainCategory(String name) {
        super(name);
    }

    static MainCategory getCategory(String name) {
        return new MainCategory(name);
    }

    public void expand() {
        System.out.println("Наводим курсор мыши на категорию: " + textValue);
        System.out.println("Категория " + textValue + " развернута");
    }
}
