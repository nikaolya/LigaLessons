package lesson_3;

import lesson_3.homework.OzonPage;
import lesson_3.homework.catalog.current.CurrentCategory;
import lesson_3.homework.catalog.current.CurrentCategoryBlock;
import lesson_3.homework.catalog.main.MainCategoryBlock;
import lesson_3.homework.elements.Element;

public class Tests {
    public static void main(String[] args) {
        OzonPage page = OzonPage.getPage();
        printTypeOFElement(page.getMainCategory(MainCategoryBlock.smartphonesAndSmartWatchesCategoryName));
        CurrentCategory category = page.getCurrentCategory(CurrentCategoryBlock.photoAndVideoCamerasCategoryName);
        printTypeOFElement(category.getTextElement());
        printTypeOFElement(category.getIcon());
        printTypeOFElement(page.getSearchField());
        printTypeOFElement(page.getSearchField().getScopeButton());
    }

    public static void printTypeOFElement(Element element) {
        System.out.println(element.getType());
    }
}
