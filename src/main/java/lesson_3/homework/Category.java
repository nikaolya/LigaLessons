package lesson_3.homework;

    /*Тестовое задание.
    1. Необходимо проанализировать все, что находится внутри красной рамки (смотреть скриншот) на странице https://www.ozon.ru/category/elektronika-15500/, и написать структуру классов с условным поведением, которое должно завершаться выводом соответствующего описания в консоль. Например что то нажато, что то открыто и т д.
    2. Реализация задания требует использования интерфейса Element и абстрактного класса Category.
    3. Вы можете как угодно дополнять и расширять интерфейс Element и абстрактный класс Category.
    4. Вы можете придумывать любую архитектуру классов, какую посчитаете нужной.
    5. В реализованном задании должны обязательно использоваться конструкторы, в идеале перегрузки и переопределения методов, а так же полиморфизм и инкапсуляция.
    6. При необходимости вы можете выйти за красные рамки. Красные рамки это минимум.*/

/*public abstract class Category {
    protected String iconDescription;
    protected String name;

    public abstract void open();
}*/
public abstract class Category {
    private String iconTitle;
    public Cursor cursor;
    private String elementType;


    public Category(Cursor cursor, String iconTitle) {
        this.cursor = cursor;
        this.iconTitle = iconTitle;
        this.elementType = "Clickable";
    }

    public String getType(){
        cursor.setCurrentElementPointing(iconTitle);
        return elementType;
    }

    public String getIconTitle() {
        return iconTitle;
    }

    public abstract boolean placeTheCursor();

    public abstract boolean removeTheCursor();

    public void clickCategoryIcon() {
        System.out.println("The " + getIconTitle() + " is clicked.");
        cursor.setCurrentElementPointing(getIconTitle());
        System.out.println("Corresponding website page is opened.");
    }
}
