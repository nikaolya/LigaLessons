package lesson_3.cars;

public class PlatformTrailer implements Trailer {
    @Override
    public String getType() {
        return "platform";
    }

    @Override
    public int getWheelCount() {
        return 4;
    }
}
