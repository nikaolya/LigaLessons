package lesson_11;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class MvideoPage {

    private static MvideoPage mvideoPage;

    private final String XPATH_TITLE_BRAND_CONTAINER = "//div[contains(@class, 'title-brand')]";

    @FindBy(className = "zoomable-image__button")
    private SelenideElement productImage;

    @FindBy(xpath = XPATH_TITLE_BRAND_CONTAINER + "/h1")
    private SelenideElement productTitle;

    @FindBy(xpath = XPATH_TITLE_BRAND_CONTAINER + "/mvid-brand-logo")
    private SelenideElement productBrandLogo;

    private MvideoPage() {
    }

    public static MvideoPage getMvideoPage() {
        if (Objects.isNull(mvideoPage)) mvideoPage = Selenide.page(new MvideoPage());
        return mvideoPage;
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    private SelenideElement getProductBrandLogo() {
        return Selenide.$x(XPATH_TITLE_BRAND_CONTAINER + "/mvid-brand-logo");
    }

}
