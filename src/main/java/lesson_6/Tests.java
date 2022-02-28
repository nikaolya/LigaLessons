package lesson_6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tests {
    public static void main(String[] args) {
        Tests tests = new Tests();
        tests.test_7();

    }

    /**
     * Получить List чисел в виде текстовых элементов
     */
    public void test_1() {
        List<Integer> integerList = getIntList();
        Stream<Integer> myStream = integerList.stream();
        List<String> result = myStream.map(String::valueOf).collect(Collectors.toList());
        System.out.println();
    }

    /**
     * Отсортировать список по убыванию
     */
    public void test_2() {
        List<Integer> integerList = getIntList();
        Stream<Integer> myStream = integerList.stream();
        List<Integer> result = myStream.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println();
    }

    /**
     * Получить одну строку текста. Каждый элемент должен начинаться с текста "Number - ".
     * Элементы должны разделяться запятой и пробелом.
     * В начале итоговой строки должен быть текст "Number list: "
     * В конце итоговой строки должен быть текст "end of list.".
     */
    public void test_3() {
        List<String> stringList = getStringList();
        Stream<String> myStream = stringList.stream();
        String result = myStream.map(item -> "Number - " + item)
                .collect(Collectors.joining(", ", "Number list: ", "end of list."));
        System.out.println(result);
    }

    /**
     * Получить мапу со значениями, ключи которых больше трех и меньше девяти
     */
    public void test_4() {
        Map<Integer, String> map = getMap();
        Stream<Map.Entry<Integer, String>> myStream = getMap().entrySet().stream();
        Map<Integer, String> result = myStream.filter(item -> item.getKey() > 3 && item.getKey() < 9)
                        .collect(Collectors.toMap(item -> item.getKey(), item -> item.getValue()));
        System.out.println();
    }

    /**
     * Перемешать все элементы в мапе.
     * Пример результата:
     * Элемент 1: ключ - 5, значение "five"
     * Элемент 2: ключ - 7, значение "seven"
     * Элемент 3: ключ - 2, значение "two"
     * и так далее.
     */
    public void test_5() {
        Map<Integer, String> map = getMap();
        // No idea...
    }



    /**
     * Установить во всех элементах isDisplayed = true, и оставить в списке только элементы с value NULL.
     */
    public void test_6() {
        List<WebElement> elements = getElements();
        Stream <WebElement> myStream = elements.stream();
        List<WebElement> result = myStream.peek(item -> item.setDisplayed(true)).filter(item -> item.getValue() == null).collect(Collectors.toList());
        System.out.println();
    }

    /**
     * Инвертировать isDisplayed параметр каждого элемента и отсортировать список по типу элемента
     * со следующим приоритетом:
     * 1. TEXT
     * 2. INPUT_FIELD
     * 3. CHECKBOX
     * 4. BUTTON
     * 5. RADIO_BUTTON
     * 6. IMAGE
     */
    public void test_7() {
        List<WebElement> elements = getElements();
        Stream<WebElement> myStream = elements.stream();
        System.out.println();
        List<WebElement> result = myStream.map(item -> {

            if (item.isDisplayed())
                item.setDisplayed(false);
            else {
                item.setDisplayed(true);
            }
            return item;
        }).sorted((item1, item2) -> {
            Map<String, Integer> mapPriority= new HashMap<>();
            mapPriority.put("TEXT", 1);
            mapPriority.put("INPUT_FIELD", 2);
            mapPriority.put("CHECKBOX", 3);
            mapPriority.put("BUTTON", 4);
            mapPriority.put("RADIO_BUTTON", 5);
            mapPriority.put("IMAGE", 6);
            int res = 0;
            if (mapPriority.get(item1.getType().name()) < mapPriority.get(item2.getType().name())){
                res = -1;
            }
            else if (mapPriority.get(item1.getType().name()) > mapPriority.get(item2.getType().name())){
                res = 1;
            }
            return res;
        }).collect(Collectors.toList());
        System.out.println();
    }

    /**
     * Создать мапу:
     * ключ - текст
     * значение - тип элемента
     */
    public void test_8() {
        List<WebElement> elements = getElements();
    }

    /**
     * Получить список элементов, у которых текст или значение оканчивается на число от 500 и более.
     * И отсортировать по увеличению сначала элементы с текстом, а затем по убыванию элементы со значением.
     */
    public void test_9() {
        List<WebElement> elements = getElements();
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        return map;
    }

    public static List<String> getStringList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("one");
        list.add("nine");
        list.add("ten");
        return list;
    }

    public static List<Integer> getIntList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        return list;
    }

    public static List<WebElement> getElements() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            result.add(new WebElement());
        }
        return result;
    }
}
