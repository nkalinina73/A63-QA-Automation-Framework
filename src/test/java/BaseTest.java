import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;

public class BaseTest {


    public WebDriver driver = null;
    public String url =  null;
    public WebDriverWait wait = null;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchClass(){

        // added ChromeOptions argument to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;



    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
    }


    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickLoginButton() {
        WebElement buttonSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        buttonSubmit.click();
    }

    public void clickNextSongButton() {
        WebElement nextSongButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.next.fa.fa-step-forward.control")));
        nextSongButton.click();

    }

    public void clickPlayButton() {
        WebElement nextSongButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.play")));
        nextSongButton.click();
    }

    public void validateSongIsPlaying() {
        WebElement songImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainFooter img")));
        songImage.isDisplayed();

    }
    public void createNewPlaylist() {
        WebElement newPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(cssSelector("#playlists .fa.fa-plus-circle.create")));
        newPlaylistButton.click();
    }
    public void clickNewPlaylist() {
        WebElement newPlaylist = wait.until(ExpectedConditions.elementToBeClickable(cssSelector(" [data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();
    }

    public void typeNameOfPlaylist(String name) {
        WebElement namePLField = wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector(".create input[type='text']")));
        namePLField.clear();
        namePLField.sendKeys(name);
        Actions actions = new Actions(driver);
        actions.sendKeys(namePLField, Keys.RETURN).perform();
    }

    public void clickOnPlaylist() {
        WebElement playList = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("NK_PL2")));
        playList.click();
    }

    public void clickDeleteButton() {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(cssSelector(".del.btn-delete-playlist")));
        deleteButton.click();
    }

    public String deletedPlaylistNotification() {
        WebElement deleteNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector(".alertify-logs.top.right")));
        return deleteNotification.getText();
    }

  
}