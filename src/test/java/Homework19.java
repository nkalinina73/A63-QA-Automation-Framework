import org.testng.annotations.Test;

public class Homework19 extends BaseTest  {

    @Test
    public void removePlaylist() throws InterruptedException {

        navigateToPage();
        provideEmail("natalia.kalinina@testpro.io");
        providePassword("nkKoel24$");
        clickLoginButton();
        createNewPlaylist();
        clickNewPlaylist();
        typeNameOfPlaylist("NK_PL2");
        clickOnPlaylist();
        clickDeleteButton();
        deletedPlaylistNotification();
    }

}

