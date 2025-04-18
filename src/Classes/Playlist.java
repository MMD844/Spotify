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
        owner.getPlayLists().add(this);
    }

    public ArrayList<Music> searchInPlaylist (String title) throws InvalidOperationException{
        if (title == null || title.trim().isEmpty()){
            throw new InvalidOperationException("Title cant be null.");
        }
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

    public Music searchInPlaylist (String title, User singer) throws InvalidOperationException{
        if (title == null|| title.trim().isEmpty() || singer == null) {
            throw new InvalidOperationException("Title or Singeruser cant be null. ");
        }
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

    public void editTitle (String newTitle, String password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }
        this.title = newTitle;
    }

    public void addMusic (Music music, String password) throws InvalidOperationException{
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }
        if (playlist.contains(music)) {
            throw new InvalidOperationException("Music already exists in playlist");
        }
        playlist.add(music);
    }

    public void removeMusic (Music music, String password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }
        if (!playlist.remove(music)) {
            throw new InvalidOperationException("Music not found in playlist");
        }
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public User getOwner () {
        return owner;
    }

    public void setOwner (User owner) {
        this.owner = owner;
    }

    public ArrayList<Music> getPlaylist () {
        return playlist;
    }
}
