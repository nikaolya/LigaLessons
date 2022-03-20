package lesson_11;

import org.testng.Assert;

public class Steps {

    private MvideoPage mvideoPage;

    public Steps() {
        mvideoPage = MvideoPage.getMvideoPage();
    }

    public void checkThatProductTitleIsEqualsTo(String expectedTitle) {
        String actualTitle = mvideoPage.getProductTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
