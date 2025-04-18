package Classes;

import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    private UserBehavior behavior;
    private ArrayList<Playlist> playLists = new ArrayList<>();
    static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) throws InvalidOperationException {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidOperationException("Your user name cant be empty.");
        }
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                throw new InvalidOperationException("Username is already exists");
            }
        }

        if (password.length() < 8) {
            throw new InvalidOperationException("Password length must be at least 8 characters.");
        }

        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    public void follow(User user) throws InvalidOperationException {
        if (!(allUsers.contains(user))) {
            throw new InvalidOperationException("this users dont have account in app.");
        }
        if (user == this) {
            throw new InvalidOperationException("You cant follow your self.");
        }
        if (followingList.contains(user)) {
            throw new InvalidOperationException("Already follow this user.");
        }
        this.followingList.add(user);
        user.followerList.add(this);
    }

    public void createPlaylist(String title) {
        this.behavior.createPlaylist(title, this);
    }

    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium(User owner, int month) throws InvalidOperationException {
        if (month <= 0) {
            throw new InvalidOperationException("Month must be positive.");
        }
        this.behavior.buyPremium(this, month);
    }

    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", followers=" + followerList.size() +
                ", following=" + followingList.size() +
                ", playlists=" + playLists.size() +
                ", isPremium=" + isPremium() +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public UserBehavior getBehavior () {
        return behavior;
    }

    public String getPassword() {
        return password;
    }

    public boolean isPremium() {
        return behavior instanceof PremiumBehavior;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public ArrayList<Playlist> getPlayLists() {
        return playLists;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFollowerList(ArrayList<User> followerList) {
        this.followerList = followerList;
    }

    public void setFollowingList(ArrayList<User> followingList) {
        this.followingList = followingList;
    }

    public void setPlayLists (ArrayList<Playlist> playLists) {
        this.playLists = playLists;
    }

}

