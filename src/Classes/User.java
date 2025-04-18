package Classes;

import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    public ArrayList<User> followerList = new ArrayList<>();
    public ArrayList<User> followingList = new ArrayList<>();
    private UserBehavior behavior;
    public ArrayList<Playlist> playLists = new ArrayList<>();
    static ArrayList<User> allUsers = new ArrayList<>();

    void follow (User user) {

    }

    void createPlaylist (String title, User owner) {
        this.behavior.createPlaylist(title, owner);
    }

    void playMusic (Music music){

    }

    void buyPremium (User owner, int month) {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<User> getAllUsers() {
        return new ArrayList<>(allUsers);
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public void setBehavior (UserBehavior behavior) {
        this.behavior = behavior;
    }

    public void setPassword (String password){
        this.password = password;
    }

}
