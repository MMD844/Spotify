package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {

    private String title;
    static ArrayList<Music> playlist = new ArrayList<>();
    User owner;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
    }

    public ArrayList<Music> searchInPlaylist (String title) throws InvalidOperationException{
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : playlist) {
            if (music.getTitle().equals(title)) {
                result.add(music);
            }
        }
        if (result.isEmpty()){
            throw new InvalidOperationException("This song is not in playlist.");
        }
        else {
            return result;
        }
    }

    Music searchInPlaylist (String title, String singer) throws InvalidOperationException{
        for (Music music : playlist) {
            if (music.getTitle().equals(title) && music.getSinger().equals(singer)) {
                return music;
            }
        }
        throw new InvalidOperationException("This song with this singer is not in playlist.");
    }

    public void playPlaylist () {
        Scanner scanner = new Scanner(System.in);
        for (Music music : playlist) {
            music.play();
            System.out.println("Enter 'next' to continue or any other key to stop");
            if (!scanner.nextLine().equalsIgnoreCase("Next")){
                break;
            }
        }
    }

    public void editTitle (String newTitle, int password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }
        this.title = newTitle;
    }

    void addMusic (Music music, int password) throws InvalidOperationException{
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }
        if (playlist.contains(music)) {
            throw new InvalidOperationException("Music already exists in playlist");
        }
        playlist.add(music);
    }

    void removeMusic (Music music, int password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }
        if (!playlist.remove(music)) {
            throw new InvalidOperationException("Music not found in playlist");
        }
    }

}
