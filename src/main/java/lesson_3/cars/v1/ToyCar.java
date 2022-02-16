package lesson_3.cars.v1;

public class ToyCar extends Car {

    public void setSpeed(int speed) {
        if (speed <= 5) super.setSpeed(speed);
    }
}
