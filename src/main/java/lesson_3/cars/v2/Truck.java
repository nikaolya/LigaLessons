package lesson_3.cars.v2;

import lesson_3.cars.Trailer;

import java.util.Objects;

public class Truck extends Car {

    private Trailer trailer;

    public void connectTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public void printTrailerInfo() {
        if (Objects.nonNull(trailer)) {
            System.out.println("type: " + trailer.getType());
            System.out.println(trailer.getWheelCount() + " wheels");
        } else System.out.println("no trailer");
    }

    @Override
    public void openBackDore() {
        System.out.println("car body up");
    }
}
