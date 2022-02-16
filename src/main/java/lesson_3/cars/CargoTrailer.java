package lesson_3.cars;

public class CargoTrailer implements Trailer {
    @Override
    public String getType() {
        return "cargo trailer";
    }

    @Override
    public int getWheelCount() {
        return 8;
    }
}
