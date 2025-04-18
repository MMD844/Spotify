package Classes;

import java.util.ArrayList;

public class Music {

    private String title;
    private User singer;
    private int numberOfStream = 0;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public Music (String title, User singer) {
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    public void play (){
        System.out.println("Now playing: " + title + " by " + singer.getUsername());
        numberOfStream ++;
    }



    public static ArrayList<Music> search(String title) throws InvalidOperationException{
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidOperationException("Search for bigin need title");
        }
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.getTitle().equals(title)) {
                result.add(music);
            }
        }
        if (result.isEmpty()){
            throw new InvalidOperationException("No songs with that name.");
        }
        else {
            return result;
        }
    }

    public static Music search(String title, User singer) throws InvalidOperationException{
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidOperationException("Title of song cant be empty.");
        }
        for (Music music : allMusics) {
            if (music.getTitle().equals(title) && music.getSinger().equals(singer)) {
                return music;
            }
        }
        throw new InvalidOperationException(" no Songs with these specification was found ! ");
    }

    public String getTitle () {
        return title;
    }

    public static ArrayList<Music> getAllMusics () {
        return allMusics;
    }

    public User getSinger () {
        return singer;
    }

    public int getNumberOfStream () {
        return numberOfStream;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public void setNumberOfStream (int numberOfStream) {
        this.numberOfStream = numberOfStream;
    }

}
