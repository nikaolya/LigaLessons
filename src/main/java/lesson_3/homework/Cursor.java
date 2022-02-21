package lesson_3.homework;

import java.util.HashMap;
import java.util.Map;

public class Cursor {
    public Map<String, String> cursor = new HashMap<String, String>();
    private String currentElementPointing = null;
    // initial initialization of all the used pointer types
    public Cursor() {
        cursor.put("Free Screen Space", "Standard pointer");
        cursor.put("Text Insert","Text pointer");
        cursor.put("Clickable", "Hand pointer");
    }

    public void setCurrentElementPointing(String currentElementPointing) {
        this.currentElementPointing = currentElementPointing;
    }

    public String changePointerType(String elementType){
        return cursor.get(elementType);
    }

    public String getCurrentElementPointing() {
        return currentElementPointing;
    }
}
