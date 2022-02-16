package lesson_3.cars.v2;

public class SportCar extends Car {

    public void boostSpeed() {
        speed = 300;
    }

    @Override
    public void openBackDore() {
        System.out.println("open third dore");
    }
}
