import Classes.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        User regularUser = new User("user1", "longlong1");
        User premiumUser = new User("premiumUser1", "iampremium");
        premiumUser.buyPremium(premiumUser, 24);
        User singer = new User("Singer1", "singasong");
        singer.buyPremium(singer,90);
        User artist = new User("Singer2", "sangasong");

        // Test kardane add kardan user va exception an ha.
    try {
        User wrongUser = new User("abdollah", "short" );
    } catch (InvalidOperationException e) {
        System.out.println(e.getMessage());
    }
    try {
        User wrongPremium = new User("WrongWrong", "premiumpass");
        wrongPremium.buyPremium(wrongPremium, 0);
    } catch (InvalidOperationException e) {
        System.out.println(e.getMessage());
    }
    try {
        User replyUser = new User("user1","tekrartekra");
    } catch (InvalidOperationException e) {
        System.out.println(e.getMessage());
    }

    // Test packsh music baraye user regular va premuim.
    for (int i = 1; i <= 6; i ++) {
        try {
            Music song = new Music("SongTest", singer);
            regularUser.playMusic(song);
            System.out.println("pakhsh :" + i + "om user.");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }
        System.out.println("_________________________________________");
        for (int i = 1; i <= 10; i ++) {
            try {
                Music song = new Music("SongTestPremium", singer);
                premiumUser.playMusic(song);
                System.out.println("pakhsh :" + i + "om premium user.");
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("_________________________________________");
        // Test sakht music va play kardan music va playlist.

        Music music1 = new Music("Song1", singer);
        Music music2 = new Music("Song2", singer);
        Music music3 = new Music("Song1", artist);
        Music music4 = new Music("Songdelete", artist);

        music1.play();
        music1.play();
        music2.play();

        System.out.println("________________________________________");

        try {
            regularUser.createPlaylist("I cant create playlist");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        premiumUser.createPlaylist("My playlist");
        Playlist playlist = premiumUser.getPlayLists().get(0);
        playlist.addMusic(music1, premiumUser.getPassword());
        playlist.addMusic(music2, premiumUser.getPassword());
        playlist.addMusic(music3, premiumUser.getPassword());
        playlist.addMusic(music4, premiumUser.getPassword());
        playlist.editTitle("Bro,S playlist", premiumUser.getPassword());
        System.out.println(playlist.getTitle());
        System.out.println("__________________________________________");
        playlist.playPlaylist();
        System.out.println("__________________________________");
        playlist.removeMusic(music4, premiumUser.getPassword());
        try {
            playlist.removeMusic(music4, premiumUser.getPassword());
        }catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("_____________________________________________");
        try {
            playlist.addMusic(music1, "98097547027");
        } catch (InvalidOperationException e){
            System.out.println(e.getMessage());
            System.out.println("____________________________________");
        }

        // Test search dar playlist
        for (Music m : playlist.searchInPlaylist("Song1")) {
            System.out.println("- " + m.getTitle());
        }

        // Test advanced search dar playlist va chap
        Music found = playlist.searchInPlaylist("Song1", singer);
        System.out.println(found.getTitle()+ "      " + found.getSinger().toString());
        try {
            Music test = playlist.searchInPlaylist("", singer);
            System.out.println(found.getTitle()+ "      " + test.getSinger().toString());
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        //Test follow kardan va follw shodan.
        regularUser.follow(singer);
        System.out.println(singer.toString());
        System.out.println(regularUser.toString());
        System.out.println("________________________________________________");

        try {
            premiumUser.follow(premiumUser);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
        try {
            regularUser.follow(singer);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("________________________________________________");

        //Test search va advanced search music.
        for (Music find : Music.search("Song2")){
            System.out.println(find.getTitle() + "     " + find.getSinger().toString());
        }
        System.out.println("____________________________________________");
        Music f = Music.search("Song1", singer);
        System.out.println(f.getTitle()+ "      " + f.getSinger().toString());
        System.out.println("____________________________________________");
        try {
            Music wrong = Music.search("wrongSong", singer);
            System.out.println(f.getTitle()+ "      " + f.getSinger().toString());
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}