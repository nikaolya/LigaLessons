package lesson_11.homework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lesson_11.homework.steps.Steps;
import org.testng.annotations.Test;

public class Tests {

    @Test
    public void test() {
        Configuration.pageLoadTimeout = 30000;
        Selenide.open("https://www.mvideo.ru/smartfony-i-svyaz-10/smartfony-205?from=no-search-results");
        new Steps().searchProductInGridView("Смартфон realme C25S 4+64GB Water Blue (RMX3195)");
        System.out.println();
    }

}
