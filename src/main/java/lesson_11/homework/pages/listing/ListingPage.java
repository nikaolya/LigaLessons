package lesson_11.homework.pages.listing;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lesson_11.homework.pages.listing.filters.Filter;
import lesson_11.homework.pages.listing.filters.SwitherFilter;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

import static lesson_11.homework.pages.listing.XpathFormatter.formatXpath;

public class ListingPage {

    private static ListingPage listingPage;

    @FindBy(xpath = "//div[contains(@class, 'plp__current-category')]/span[contains(@class, 'count')]")
    private SelenideElement productListCounter;

    @FindBy(tagName = "mvid-product-cards-row")
    private SelenideElement productList;

    @FindBy(className = "listing-view-switcher__pointer")
    private SelenideElement listingViewPointer;

    @FindBy(xpath = "//mvid-button[contains(@class, 'listing-view-switcher__button--list')]/button")
    private SelenideElement listViewButton;

    @FindBy(xpath = "//mvid-button[contains(@class, 'listing-view-switcher__button--grid')]/button")
    private SelenideElement gridViewButton;

    @FindBy(xpath = XPATH_PAGINATION_CONTAINER + "/li[contains(@class, 'page-item') and not(contains(@class, 'ng-star-inserted'))][2]")
    private SelenideElement nextPaginationButton;

    private final String XPATH_PAGINATION_CONTAINER = "//ul[contains(@class, 'pagination')]";
    private final String XPATH_PRODUCTS_ROW = "//div[contains(@class, 'product-cards-row')]";
    private final String XPATH_PRODUCTS_ROW_WITH_NUM = XPATH_PRODUCTS_ROW + "[%s]";

    private ListingPage() {
    }

    public static ListingPage getListingPage() {
        if (Objects.isNull(listingPage)) listingPage = Selenide.page(new ListingPage());
        return listingPage;
    }

    public ProductCard getProductCard(String productName) {
        return ProductCard.getProductCard(productName);
    }

    public SwitherFilter getSwitcherFilter(String switcherName) {
        return new SwitherFilter(switcherName);
    }

    public int getProductCount() {
        return Integer.parseInt(productListCounter.getText());
    }

    public Filter getFilter(String filterName) {
        return new Filter(filterName);
    }

    public void productsCountShouldNotBe(int productCount) {
        productListCounter.shouldNotBe(Condition.text(String.valueOf(productCount)));
    }

    public void productListShouldBeVisible() {
        shouldBeVisible(productList);
    }

    public void clickOnGridViewButton() {
        gridViewButton.click();
    }

    public void gridViewShouldBeVisible() {
        shouldBeVisible(Selenide.$x(formatXpath(XPATH_PRODUCTS_ROW_WITH_NUM, 1)));
    }

    public ListingType getListingType() {
        String pointerClass = getClassAttribute(listingViewPointer);
        return Objects.nonNull(pointerClass) && pointerClass.contains("--grid") ? ListingType.GRID : ListingType.LIST;
    }

    public int getProductRowsCount() {
        return Selenide.$$x(XPATH_PRODUCTS_ROW).size();
    }

    public void scrollToProductsRow(int rowNum) {
        scrollIntoView(Selenide.$x(formatXpath(XPATH_PRODUCTS_ROW_WITH_NUM, rowNum)));
    }

    public void productRowShouldBeVisible(int rowNum) {
        String xPath = formatXpath(XPATH_PRODUCTS_ROW_WITH_NUM + "//mvid-plp-product-title", rowNum);
        shouldBeVisible(Selenide.$x(xPath));
    }

    private void shouldBeVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    private void scrollIntoView(SelenideElement element) {
        element.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
    }

    public boolean isTheLastPaginationPage() {
        String buttonClass = getClassAttribute(nextPaginationButton);
        return Objects.nonNull(buttonClass) && buttonClass.contains("disabled");
    }

    public int getPagitationCount() {
        ElementsCollection numbers = Selenide.$$x(XPATH_PAGINATION_CONTAINER +
                "/li[contains(@class, 'page-item') and contains(@class, 'ng-star-inserted')]");
//        int result = 0;
//        int lastIndex = numbers.size() - 1;
//        if (lastIndex > -1) result = Integer.parseInt(numbers.get(lastIndex).getText());
//        return result;
        return Integer.parseInt(numbers.last().getText());
    }

    public void clickOnNextPaginationButton() {
        nextPaginationButton.click();
    }

    private String getClassAttribute(SelenideElement element) {
        return element.getAttribute("class");
    }
}
