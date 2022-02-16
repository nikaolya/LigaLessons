package lesson_3.cars.v2;

import java.awt.*;

public abstract class Car {

    private Color color;
    protected int speed;

    public abstract void openBackDore();

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
