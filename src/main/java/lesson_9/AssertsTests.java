package lesson_9;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertsTests {

    @Test
    public void hardAssert() {
        System.out.println("compare 1 and 1");
        Assert.assertEquals(1, 1);

        System.out.println("compare asd and qwe");
        Assert.assertEquals("asd", "qwe", "ERROR MESSAGE");

        System.out.println("check that is true");
        Assert.assertTrue(true);
    }

    @Test
    public void softAssert() {
        System.out.println("compare 1 and 1");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 1);

        System.out.println("compare asd and qwe");
        softAssert.assertEquals("asd", "qwe");

        System.out.println("check that is true");
        softAssert.assertTrue(false);

        softAssert.assertAll("Something is wrong");
    }
}
