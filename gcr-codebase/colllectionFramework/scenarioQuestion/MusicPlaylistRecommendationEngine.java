// File Name: MusicPlaylistRecommendationEngine.java

import java.util.LinkedList;

public class MusicPlaylistRecommendationEngine {

    // LinkedList to store recently played songs
    private LinkedList<String> playlist = new LinkedList<>();

    // Add a newly played song
    public void playSong(String songName) {

        // If song already exists, remove it first
        // so it can be moved to the top
        playlist.remove(songName);

        // Add at the beginning
        playlist.addFirst(songName);

        // Keep only the latest 10 songs
        if (playlist.size() > 10) {
            String removedSong = playlist.removeLast();
            System.out.println("Removed oldest song: " + removedSong);
        }

        System.out.println(songName + " is now playing.");
    }

    // Search for a song
    public void searchSong(String songName) {

        if (playlist.contains(songName)) {
            System.out.println(songName + " found in Recently Played.");
        } else {
            System.out.println(songName + " not found.");
        }
    }

    // Display playlist
    public void displayPlaylist() {

        System.out.println("\n===== Recently Played Songs =====");

        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        int count = 1;

        for (String song : playlist) {
            System.out.println(count + ". " + song);
            count++;
        }
    }

    public static void main(String[] args) {

        MusicPlaylistRecommendationEngine player =
                new MusicPlaylistRecommendationEngine();

        player.playSong("Shape of You");
        player.playSong("Believer");
        player.playSong("Perfect");
        player.playSong("Faded");
        player.playSong("Senorita");
        player.playSong("Closer");
        player.playSong("Thunder");
        player.playSong("Levitating");
        player.playSong("Blinding Lights");
        player.playSong("Peaches");

        // 11th song removes the oldest one
        player.playSong("Stay");

        // Playing an existing song moves it to the top
        player.playSong("Believer");

        System.out.println();

        player.searchSong("Faded");
        player.searchSong("Animals");

        player.displayPlaylist();
    }
}