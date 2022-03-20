package lesson_9;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class RunExampleTests {

    @Test
    public void test_1() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("Thread name: " + Thread.currentThread().getName() + ", ID: " + Thread.currentThread().getId());
        }
    }

    @Test
    public void test_2() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("Thread name: " + Thread.currentThread().getName() + ", ID: " + Thread.currentThread().getId());
        }
    }
}
