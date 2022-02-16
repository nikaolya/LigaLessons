package lesson_3.cars.v1;

public class Truck extends Car {

    private boolean isTrailerConnected;

    public void connectTrailer() {
        isTrailerConnected = true;
    }

    public void removeTrailer() {
        isTrailerConnected = false;
    }
}
