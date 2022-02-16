package lesson_3;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {

    public static String testStaticValue;

    private int volume;
    private List<String> trackList;
    private String currentTrack;

    public MusicPlayer() {
        trackList = getTrackList();
    }

    public MusicPlayer(String track) {
        this();
        currentTrack = track;
    }

    public MusicPlayer(int volume, String track) {
        this(track);
        this.volume = volume;
    }

    public static MusicPlayer getPlayed() {
        return new MusicPlayer();
    }

    public void volumeUp() {
        volume++;
    }

    public void setVolume(int newVolume) {
        if (newVolume >= 0 && newVolume <= 100)
            volume = newVolume;
    }

    public int getVolume() {
        return volume;
    }

    public List<String> getTrackList() {
        List<String> trackList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            trackList.add("Track " + i);
        }
        return trackList;
    }

    public String getTrack() {
        return currentTrack;
    }

    public void playTrack(String track) {
        currentTrack = track;
    }
}
