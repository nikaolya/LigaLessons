package lesson_6;

import java.util.*;
import java.util.stream.Collectors;

public class Tests {
    public static void main(String[] args) {
        new Tests().test_7();
    }

    /**
     * Получить List чисел в виде текстовых элементов
     */
    public void test_1() {
        List<Integer> integerList = getIntList();
        List<String> stringList = integerList.stream().map(String::valueOf).toList();
    }

    /**
     * Отсортировать список по убыванию
     */
    public void test_2() {
        List<Integer> integerList = getIntList().stream().sorted((item1, item2) -> {
            int result = 0;
            if (item1 < item2) result = 1;
            else if (item1 > item2) result = -1;
            return result;
        }).toList();
    }

    /**
     * Получить одну строку текста. Каждый элемент должен начинаться с текста "Number - ".
     * Элементы должны разделяться запятой и пробелом.
     * В начале итоговой строки должен быть текст "Number list: "
     * В конце итоговой строки должен быть текст "end of list.".
     */
    public void test_3() {
        List<String> stringList = getStringList();
        getStringList().stream()
                .map(item -> "Number - " + item)
                .collect(Collectors.joining(", ", "Number list: ", " end of list."));
    }

    /**
     * Получить мапу со значениями, ключи которых больше трех и меньше девяти
     */
    public void test_4() {
        Map<Integer, String> map = getMap().entrySet()
                .stream()
                .filter(item -> item.getKey() > 3 && item.getKey() < 9)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
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
        getMap().entrySet()
                .stream()
                .sorted((item1, item2) -> {
                    int result = new Random().nextInt(3);
                    if (result == 2) result = -1;
                    return result;
                }).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (item1, item2) -> item1,
                        LinkedHashMap::new)
                );
    }

    /**
     * Установить во всех элементах isDisplayed = true, и оставить в списке только элементы с value NULL.
     */
    public void test_6() {
        List<WebElement> elements = getElements().stream().filter(element -> {
            boolean result = Objects.isNull(element.getValue());
            if (result) element.setDisplayed(true);
            return result;
        }).toList();
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
        List<WebElement> elements = getElements().stream()
                .sorted((item1, item2) -> {
                    int result = 0;
                    if (item1.getType().equals(Type.TEXT) && !item2.getType().equals(Type.TEXT)) result = -1;
                    else if (item2.getType().equals(Type.TEXT) && !item1.getType().equals(Type.TEXT)) result = 1;
                    else if (item1.getType().equals(Type.IMAGE) && !item2.getType().equals(Type.IMAGE)) result = 1;
                    else if (item2.getType().equals(Type.IMAGE) && !item1.getType().equals(Type.IMAGE)) result = -1;
                    else if (item1.getType().equals(Type.RADIO_BUTTON) && !item2.getType().equals(Type.RADIO_BUTTON))
                        result = 1;
                    else if (item2.getType().equals(Type.RADIO_BUTTON) && !item1.getType().equals(Type.RADIO_BUTTON))
                        result = -1;
                    else if (item1.getType().equals(Type.BUTTON) && !item2.getType().equals(Type.BUTTON)) result = 1;
                    else if (item2.getType().equals(Type.BUTTON) && !item1.getType().equals(Type.BUTTON)) result = -1;
                    else if (item1.getType().equals(Type.CHECKBOX) && !item2.getType().equals(Type.CHECKBOX))
                        result = 1;
                    else if (item2.getType().equals(Type.CHECKBOX) && !item1.getType().equals(Type.CHECKBOX))
                        result = -1;
                    else if (item1.getType().equals(Type.INPUT_FIELD) && !item2.getType().equals(Type.INPUT_FIELD))
                        result = 1;
                    else if (item2.getType().equals(Type.INPUT_FIELD) && !item1.getType().equals(Type.INPUT_FIELD))
                        result = -1;
                    return result;
                }).toList();
    }

    /**
     * Создать мапу:
     * ключ - текст
     * значение - тип элемента
     */
    public void test_8() {
        List<WebElement> elements = getElements();
        Map<String, Type> map = elements.stream()
                .filter(item -> Objects.nonNull(item.getText()))
                .collect(Collectors.toMap(WebElement::getText, WebElement::getType));
    }

    /**
     * Получить список элементов, у которых текст или значение оканчивается на число от 500 и более.
     * И отсортировать по увеличению сначала элементы с текстом, а затем по убыванию элементы со значением.
     */
    public void test_9() {
        List<WebElement> elements = getElements().stream().filter(item -> {
            String text = item.getText();
            String value = item.getValue();
            return (Objects.nonNull(text) && Integer.parseInt(text.replaceAll("\\D", "")) > 499)
                    || (Objects.nonNull(value) && Integer.parseInt(value.replaceAll("\\D", "")) > 499);
        }).sorted((item1, item2) -> {
            String text1 = item1.getText();
            String value1 = item1.getValue();
            String text2 = item2.getText();
            String value2 = item2.getValue();
            int result = 0;
            if (Objects.nonNull(text1) && Objects.nonNull(value2)) result = -1;
            else if (Objects.nonNull(value1) && Objects.nonNull(text2)) result = 1;
            return result;
        }).sorted((item1, item2) -> {
            String text1 = item1.getText();
            String value1 = item1.getValue();

            String text2 = item2.getText();
            String value2 = item2.getValue();
            int result = 0;
            if (Objects.nonNull(text1) && Objects.nonNull(text2)) {
                int num1 = Integer.parseInt(text1.replaceAll("\\D", ""));
                int num2 = Integer.parseInt(text2.replaceAll("\\D", ""));
                if (num1 > num2) result = 1;
                else if (num1 < num2) result = -1;
            } else if (Objects.nonNull(value1) && Objects.nonNull(value2)) {
                int num1 = Integer.parseInt(value1.replaceAll("\\D", ""));
                int num2 = Integer.parseInt(value2.replaceAll("\\D", ""));
                if (num1 > num2) result = -1;
                else if (num1 < num2) result = 1;
            }
            return result;
        }).toList();
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
