package lesson_11.homework.pages.listing.filters;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SwitherFilter {

    private SelenideElement switcherFilter;

    public SwitherFilter(String name) {
        switcherFilter = Selenide.$x(String.format("//mvid-switcher[.//a[text() = ' %s ']]//input", name));
    }

    public void click() {
        switcherFilter.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        switcherFilter.click();
    }
}
