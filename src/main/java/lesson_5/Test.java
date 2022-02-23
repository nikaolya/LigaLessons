package lesson_5;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        //Ссылка на метод своего класса
        Comparator comparator = new Comparator("text");
        Function<Comparator, Boolean> function = Comparator::equals;

        new StringPrinter_V_2("test").print(getConsumer());


    }

    public static Consumer<String> getConsumer() {
        return System.out::println; //тоже ссылка на метод
    }


    public void predicateTest() {
        Predicate<Integer> predicate_1 = num -> num > 0;
        Predicate<Integer> predicate_2 = num -> num == 2;
        Predicate<Integer> predicate_3 = num -> num < 3;
        predicate_1.and(predicate_2)
                .negate()
                .or(predicate_3)
                .test(1);
    }

    public void functionTest() {
        Function<String, String> function_1 = text -> text.toUpperCase() + " function 1 ";
        Function<String, String> function_2 = text -> text + " function 2 ";
        Function<String, String> function_3 = text -> text + text.length();
        function_1.compose(function_2)
                .andThen(function_3)
                .apply("test text");
    }


}
