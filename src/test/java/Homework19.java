import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class Homework19 extends BaseTest  {

    @Test
    public void removePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        navigateToPage();
        provideEmail("natalia.kalinina@testpro.io");
        providePassword("nkKoel24$");
        clickLoginButton();
        homePage.createNewPlaylist();
        homePage.clickNewPlaylist();
        homePage.typePlaylistName("NK_PL2");
        homePage.clickOnPlaylist();
        homePage.clickDeleteButton();
        homePage.deletedPlaylistNotification();
    }

}

