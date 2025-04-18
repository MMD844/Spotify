package Classes;

import java.util.ArrayList;

public class Music {

    private String title;
    private User singer;
    private int numberOfStream = 0;
    static ArrayList<Music> allMusics = new ArrayList<>();

    public Music (String title, User singer) {
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    public void play (){
        System.out.println("Now playing: " + title + " by " + singer.getUsername());
        numberOfStream ++;
    }

    public ArrayList<Music> search (String title) throws InvalidOperationException{
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

    public Music search (String title, User singer) throws InvalidOperationException{
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
