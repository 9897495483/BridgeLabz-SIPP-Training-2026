class TrackNode {
    int trackId;
    TrackNode next;

    TrackNode(int trackId) {
        this.trackId = trackId;
        this.next = null;
    }
}

public class PlaylistInsertion {

    // Insert a new track after the currently playing track
    public static void insertAfterCurrentTrack(TrackNode currentTrack, int newTrackId) {

        if (currentTrack == null) {
            return;
        }

        TrackNode newTrack = new TrackNode(newTrackId);

        // Preserve the remaining playlist
        newTrack.next = currentTrack.next;

        // Insert the new track
        currentTrack.next = newTrack;
    }

    // Print the playlist
    public static void displayPlaylist(TrackNode head) {
        while (head != null) {
            System.out.print(head.trackId + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        TrackNode head = new TrackNode(101);
        head.next = new TrackNode(102);
        head.next.next = new TrackNode(104);

        System.out.println("Original Playlist:");
        displayPlaylist(head);

        // Insert track 103 after track 102
        insertAfterCurrentTrack(head.next, 103);

        System.out.println("Updated Playlist:");
        displayPlaylist(head);
    }
}