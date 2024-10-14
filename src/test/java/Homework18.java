import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() {

        navigateToPage();
        provideEmail("natalia.kalinina@testpro.io");
        providePassword("nkKoel24$");
        clickLoginButton();
        clickNextSongButton();
        clickPlayButton();
        validateSongIsPlaying();

    }

}
