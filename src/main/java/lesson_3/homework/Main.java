package lesson_3.homework;

public class Main {
    public static void main(String[] args) {
        Cursor cursor = new Cursor();
        String[] dropDownList = {"first", "second", "third", "bla-bla"}; // Just for example
        DropDown dropDown = new DropDown(cursor, "Drop down menu prior the search field on the main page", dropDownList);
        Carousel carousel = new Carousel(cursor, "Ads Banner on the main page");
        SearchField searchField = new SearchField(cursor, "Search field on the main page");
        Button button = new Button(cursor, "Search button on the main page");
        CategoryButton categoryButton = new CategoryButton(cursor, "Category: Бытовая техника", dropDownList);
        CategoryFigure categoryFigure = new CategoryFigure(cursor, "Category: Смартфоны");

        button.getElementDescription();
        button.placeTheCursor();
        button.click();
        System.out.println("Current element pointing: "+ cursor.getCurrentElementPointing());
        // Apparently we cannot just remove the pointer as technically we are on another page
        // This illustrates just the action
        button.removeTheCursor();

        carousel.getElementDescription();
        carousel.placeTheCursor();
        carousel.click();
        System.out.println("Current element pointing: "+ cursor.getCurrentElementPointing());
        carousel.removeTheCursor();

        dropDown.getElementDescription();
        dropDown.placeTheCursor();
        dropDown.click();
        System.out.println("Current element pointing: "+ cursor.getCurrentElementPointing());
        dropDown.removeTheCursor();

        searchField.getElementDescription();
        searchField.placeTheCursor();
        searchField.click();
        searchField.insertText("Hey there!");
        System.out.println("Current element pointing: "+ cursor.getCurrentElementPointing());
        searchField.removeTheCursor();
        System.out.println("Current element pointing: "+ cursor.getCurrentElementPointing());


        System.out.println("\nYou are dealing with: " + categoryButton.getIconTitle());
        categoryButton.placeTheCursor();
        categoryButton.removeTheCursor();
        categoryButton.clickCategoryIcon();
        System.out.println("Current element pointing: "+ cursor.getCurrentElementPointing());


        System.out.println("\nYou are dealing with: " + categoryFigure.getIconTitle());
        categoryFigure.placeTheCursor();
        categoryFigure.clickCategoryIcon();
        categoryFigure.removeTheCursor();
        System.out.println("Current element pointing: "+ cursor.getCurrentElementPointing());


    }
}
