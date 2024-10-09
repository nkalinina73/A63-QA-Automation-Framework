import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest {

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

/*

11. Commit your changes to the new branch homework-19.

12. Push your code to the remote repository.

13. Create a pull request.

 */
