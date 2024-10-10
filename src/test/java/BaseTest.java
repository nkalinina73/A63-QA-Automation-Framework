import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;


import org.openqa.selenium.Keys;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static org.openqa.selenium.By.*;

import java.time.Duration;

import java.time.Duration;

public class BaseTest {


    public WebDriver driver = null;

    public String url = null;
    public WebDriverWait wait;




    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod


    @Parameters({"BaseURL"})
    public void launchClass(String BaseURL) {

        // added ChromeOptions argument to fix websocket error

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;


    }

    @AfterMethod
    public void closeBrowser() {


        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void clickLoginButton() throws InterruptedException {

        WebElement buttonSubmit = wait.until(ExpectedConditions.elementToBeClickable(cssSelector("button[type='submit']")));
        buttonSubmit.click();

    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(cssSelector("input[type='password']")));

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(cssSelector("input[type='email']")));

        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickOnPlaylist() throws InterruptedException {
        WebElement playList = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("NK_PL2")));
        playList.click();
    }

    public void clickDeleteButton() throws InterruptedException {
        // .del.btn-delete-playlist
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(cssSelector(".del.btn-delete-playlist")));
        deleteButton.click();
    }

    public void createNewPlaylist() throws InterruptedException {
        // #playlists .fa.fa-plus-circle.create
        WebElement newPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(cssSelector("#playlists .fa.fa-plus-circle.create")));
        newPlaylistButton.click();
    }

    public void clickNewPlaylist() throws InterruptedException {
        // [data-testid='playlist-context-menu-create-simple']
        WebElement newPlaylist = wait.until(ExpectedConditions.elementToBeClickable(cssSelector(" [data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();
    }

    public void typeNameOfPlaylist(String name) throws InterruptedException {
        // .create input[type='text']
        WebElement namePLField = wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector(".create input[type='text']")));
        namePLField.clear();
        namePLField.sendKeys(name);
        Actions actions = new Actions(driver);
        actions.sendKeys(namePLField, Keys.RETURN).perform();
        //Thread.sleep(4000);
    }

    public String deletedPlaylistNotification() {
        // .alertify-logs.top.right
        WebElement deleteNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector(".alertify-logs.top.right")));
        return deleteNotification.getText();
    }

    public void clickLoginButton() throws InterruptedException {
        WebElement buttonSubmit = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonSubmit.click();
        Thread.sleep(2000);
    }


    public void clickNextSongButton() throws InterruptedException {
        WebElement nextSongButton = driver.findElement(By.cssSelector("i.next.fa.fa-step-forward.control"));
        nextSongButton.click();
        Thread.sleep(3000);

    }

    public void clickPlayButton() throws InterruptedException {
        WebElement nextSongButton = driver.findElement(By.cssSelector("span.play"));
        nextSongButton.click();
        Thread.sleep(3000);
    }

    public void validateSongIsPlaying() {
        // #mainFooter img
        WebElement songImage = driver.findElement(By.cssSelector("#mainFooter img"));
        songImage.isDisplayed();

    }

 
}