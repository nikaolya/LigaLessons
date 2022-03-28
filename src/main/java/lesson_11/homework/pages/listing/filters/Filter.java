package lesson_11.homework.pages.listing.filters;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static lesson_11.homework.pages.listing.XpathFormatter.formatXpath;

public class Filter {

    protected final String XPATH_FILTER_BLOCK = "//div[contains(@class, 'accordion__option')][label[span[text() = ' %s ']]]";
    private final String XPATH_CHECKBOX_FILTER = ".//div[@class = 'checkbox'][.//a[text() = ' %s ']]/mvid-icon";

    private SelenideElement filterContainer;
    private SelenideElement expandArrow;
    private SelenideElement showAllLink;
    private SelenideElement hideLink;
    private SelenideElement checkboxListContainer;

    public Filter(String filterName) {
        filterContainer = Selenide.$x(formatXpath(XPATH_FILTER_BLOCK, filterName));
        expandArrow = filterContainer.find(By.xpath(".//mvid-icon[@type = 'chevron_up']"));
        showAllLink = filterContainer.find(By.xpath(".//p[contains(@class, 'show-all') and text() = ' Показать ещё ']"));
        hideLink = filterContainer.find(By.xpath(".//p[contains(@class, 'show-all') and text() = ' Скрыть ']"));
        checkboxListContainer = filterContainer.find(By.tagName("mvid-filter-checkbox-list"));
    }

    public CheckboxValue getCheckboxValue(String filterValue) {
        return new CheckboxValue(checkboxListContainer.find(By.xpath(formatXpath(XPATH_CHECKBOX_FILTER, filterValue))));
    }

    public void expand() {
        if (!checkboxListContainer.isDisplayed()) {
            expandArrow.click();
            checkboxListContainer.shouldBe(Condition.visible);
        }
    }

    public boolean isHideLinkDisplayed() {
        return hideLink.isDisplayed();
    }

    public void showAllValues() {
        if (!isHideLinkDisplayed()) showAllLink.shouldBe(Condition.visible).click();
    }
}
