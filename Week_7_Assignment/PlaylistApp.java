package STEP_SEM_3.Week_7_Assignment;

import java.util.Arrays;

// Domain Class
class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxCapacity) {
        this.songs = new String[maxCapacity];
        this.songCount = 0;
    }

    public void addSong(String title) {
        if (songCount < songs.length) {
            songs[songCount] = title;
            songCount++;
        }
    }

    // Returns a safe copy of the songs array containing only added songs
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}

// Main Driver Class
public class PlaylistApp {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Returned Copy[0]: " + copy[0]);

        // Modifying the returned array copy
        copy[0] = "Hacked";

        System.out.println("Modified Copy[0]: " + copy[0]);
        System.out.println("Actual Playlist[0]: " + p.getSongs()[0]); // Remains "Song A"
        System.out.println("Song Count: " + p.getSongCount());
    }
}
