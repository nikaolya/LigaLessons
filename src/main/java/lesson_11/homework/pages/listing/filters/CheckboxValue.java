package lesson_11.homework.pages.listing.filters;

import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

public class CheckboxValue {


    protected SelenideElement filterValue;

    public CheckboxValue(SelenideElement filterValue) {
        this.filterValue = filterValue;
    }

    public void click() {
        filterValue.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        filterValue.click();
    }

    public boolean isChecked() {
        String attributeValue = filterValue.getAttribute("class");
        return Objects.nonNull(attributeValue) && attributeValue.contains("checkbox__icon_checked");
    }
}
