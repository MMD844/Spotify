package Classes;

public class PremiumBehavior implements UserBehavior{

    private int month;

    public PremiumBehavior (int month) throws InvalidOperationException {
        if (month <= 0) {
            throw new InvalidOperationException("Month must be positive.");
        }
        else {
            this.month = month;
        }
    }

    @Override
    public void createPlaylist(String title, User owner) throws InvalidOperationException {
        if (!owner.isPremium()) {
            throw new InvalidOperationException("Only premium users can create playlists");
        }
        if (title == null) {
            throw new InvalidOperationException("Titles cant be null");
        }
        Playlist playlist = new Playlist(title, owner);
    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month += month;
    }

}
