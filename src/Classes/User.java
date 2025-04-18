package Classes;

import java.util.ArrayList;

public class User {

    String username;
    String password;
    ArrayList<User> followerList = new ArrayList<>();
    ArrayList<User> followingList = new ArrayList<>();
    UserBehavior behavior;
    ArrayList<playList> playLists = new ArrayList<>();
    static ArrayList<User> allUsers = new ArrayList<>();

    void follow (User user) {

    }

    void createPlaylist (String title, User owner) {
        this.behavior.createPlaylist(title, owner);
    }

    void playMusic (Misic music){

    }

    void buyPremium (User owner, int month) {

    }

}
