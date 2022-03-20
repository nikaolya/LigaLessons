package lesson_9.annotations;

import org.testng.annotations.*;

public class AnnotationsExample {

    @BeforeSuite
    public void bSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void bTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void bClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void bMethod() {
        System.out.println("Before Method");
    }

    @Test
    public void test_1() {
        System.out.println("Test 1 in AnnotationsExample");
    }

    @Test
    public void test_2() {
        System.out.println("Test 2 in AnnotationsExample");
    }

    @AfterMethod
    public void aMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void aClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void aTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void aSuite3() {
        System.out.println("After Suite 2");
    }
}
