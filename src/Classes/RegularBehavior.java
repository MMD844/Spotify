package Classes;

public class RegularBehavior implements UserBehavior{

    private int playingLimit = 5;

    @Override
    public void createPlaylist(String Title, User Owner) throws  InvalidOperationException {
        throw new InvalidOperationException("Only premium users can create playlist.");
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {
        if (playingLimit == 0){
            throw new InvalidOperationException("Your playing limit is reached for today.");
        }
        else {
            music.play();
            playingLimit --;
        }
    }

    @Override
    public void buyPremium(User owner, int month) {
        owner.setBehavior(new PremiumBehavior(month));
    }
}
