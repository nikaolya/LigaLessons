package lesson_9.annotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class AnotherTestClass {

    @Test
    public void test() {
        System.out.println("Test in AnotherTestClass");
    }

    @AfterSuite
    public void aSuite() {
        System.out.println("After Suite");
    }


}
