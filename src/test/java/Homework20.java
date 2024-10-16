import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    @Test
    public void removePlaylist() {

        navigateToPage();
        provideEmail("natalia.kalinina@testpro.io");
        providePassword("nkKoel24$");
        clickLoginButton();
      /*  createNewPlaylist();
        clickNewPlaylist();
        typeNameOfPlaylist("NK_PL2");
        clickOnPlaylist();
        clickDeleteButton();
        deletedPlaylistNotification();*/
    }
}
