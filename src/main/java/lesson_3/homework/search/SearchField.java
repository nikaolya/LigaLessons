package lesson_3.homework.search;

import lesson_3.homework.elements.Button;
import lesson_3.homework.elements.InputField;

public class SearchField extends InputField {

    private ScopeButton scopeButton;
    private Button searchButton;

    public SearchField() {
        scopeButton = new ScopeButton("Везде");
        searchButton = new Button("Поиск");
    }

    public void setScope(String scope) {
        getScopeButton().setScope(scope);
    }

    public void clickOnSearchButton() {
        getSearchButton().click();
    }

    public ScopeButton getScopeButton() {
        return scopeButton;
    }

    public Button getSearchButton() {
        return searchButton;
    }
}
