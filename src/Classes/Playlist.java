package Classes;

import java.util.ArrayList;

public class Playlist {

    private String title;
    ArrayList<Music> playlist = new ArrayList<>();
    User owner;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
    }

    Music search (String title){
        return null;
    }

    Music search (String title, String singer){
        return null;
    }

    Music playPlaylist (Playlist playlist) {
        return null;
    }

    void editTitle (int password) {

    }

    void addMusic (int password) {

    }

    void removeMusic (int password) {

    }

}
