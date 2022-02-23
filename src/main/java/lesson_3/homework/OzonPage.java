package lesson_3.homework;

import lesson_3.homework.catalog.current.CurrentCategory;
import lesson_3.homework.catalog.current.CurrentCategoryBlock;
import lesson_3.homework.catalog.main.MainCategory;
import lesson_3.homework.catalog.main.MainCategoryBlock;
import lesson_3.homework.search.SearchField;

public class OzonPage {

    private SearchField searchField;
    private MainCategoryBlock mainCategoryBlock;
    private CurrentCategoryBlock currentCategoryBlock;

    private OzonPage() {
        currentCategoryBlock = new CurrentCategoryBlock();
        mainCategoryBlock = new MainCategoryBlock();
        searchField = new SearchField();
    }

    public static OzonPage getPage() {
        return new OzonPage();
    }

    public void setSearchScope(String scope) {
        searchField.setScope(scope);
    }

    public void search(String query) {
        searchField.click();
        searchField.setValue(query);
        searchField.clickOnSearchButton();
    }

    public int getProductCountOfAllCategories() {
        return 398709;
    }

    public void expandMainCategory(String categoryName) {
        mainCategoryBlock.getCategory(categoryName).expand();
    }

    public void openCurrentCategory(String categoryName) {
        currentCategoryBlock.getCategory(categoryName).open();
    }

    public CurrentCategory getCurrentCategory(String categoryName) {
        return currentCategoryBlock.getCategory(categoryName);
    }

    public MainCategory getMainCategory(String categoryName) {
        return mainCategoryBlock.getCategory(categoryName);
    }

    public SearchField getSearchField() {
        return searchField;
    }
}
