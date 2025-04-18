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

    public User (String username, String password) throws InvalidOperationException {
        boolean usernameExist = false;
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                usernameExist = true;
                break;
            }
        }
        if (usernameExist) {
            throw new InvalidOperationException("Username is already exists.");
        }

        if (password.length() < 8) {
            throw new InvalidOperationException("Password length must be at least 8 characters.");
        }

        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    void follow (User user) {
        if (user == this) {
            throw new InvalidOperationException("You cant follow your self.");
        }
        if (followerList.contains(user)) {
            throw new InvalidOperationException("Already following this user.");
        }
        this.followingList.add(user);
        user.followerList.add(this);
    }

    void createPlaylist (String title, User owner) {
        this.behavior.createPlaylist(title, owner);
    }

    void playMusic (Music music){
        this.behavior.playMusic(music);
    }

    void buyPremium (User owner, int month) throws InvalidOperationException {
        if (month <= 0) {
            throw new InvalidOperationException("Month must be positive.");
        }
        this.behavior.buyPremium(this, month);
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
