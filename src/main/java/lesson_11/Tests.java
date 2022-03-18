package lesson_11;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class Tests {

    public static void main(String[] args) {

    }

    /**
     * это класс со степами
     */
    private Steps steps = new Steps();

    @Test
    public void test() {
        Selenide.open("https://www.mvideo.ru/products/televizor-haier-le65u6900ug-10022393");
        steps.checkThatProductTitleIsEqualsTo("Тостер Haier LE65U6900UG");
        Selenide.sleep(1000);
    }

}
