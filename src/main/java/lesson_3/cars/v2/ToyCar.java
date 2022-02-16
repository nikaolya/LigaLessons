package lesson_3.cars.v2;

public class ToyCar extends Car {

    @Override
    public void openBackDore() {
        System.out.println("do nothing");
    }

    public void setSpeed(int speed) {
        if (speed <= 5) super.setSpeed(speed);
    }

}
