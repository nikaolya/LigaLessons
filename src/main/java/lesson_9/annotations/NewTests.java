package lesson_9.annotations;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTests {
    @BeforeMethod
    public void pre() {
        System.out.println("Логика перед тест кейсом");
    }

    @Test
    public void test1() {
        System.out.println("test 1 in NewTests");
    }

    @Test
    public void test2() {
        System.out.println("test 2 in NewTests");
    }
}
