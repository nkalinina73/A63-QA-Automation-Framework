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

public class BaseTest {


    public WebDriver driver = null;
    public String url = null;
    public WebDriverWait wait = null;

  

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
        WebElement passwordField = driver.findElement(cssSelector("input[type='password']"));

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(cssSelector("input[type='email']"));

        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickOnPlaylist() throws InterruptedException {
        // a[href='#!/playlist/99663']
        WebElement playList = driver.findElement(By.linkText("NK_PL2"));
        playList.click();
        Thread.sleep(2000);
    }

    public void clickDeleteButton() throws InterruptedException {
        // .del.btn-delete-playlist
        WebElement deleteBtton = driver.findElement(cssSelector(".del.btn-delete-playlist"));
        deleteBtton.click();

        Thread.sleep(3000);

    }

    public void createNewPlaylist() throws InterruptedException {
        // #playlists .fa.fa-plus-circle.create
        WebElement newPlaylistButton = driver.findElement(cssSelector("#playlists .fa.fa-plus-circle.create"));
        newPlaylistButton.click();
        Thread.sleep(2000);
    }

    public void clickNewPlaylist() throws InterruptedException {
        // [data-testid='playlist-context-menu-create-simple']
        WebElement newPlaylist = driver.findElement(cssSelector(" [data-testid='playlist-context-menu-create-simple']"));
        newPlaylist.click();
        Thread.sleep(2000);
    }

    public void typeNameOfPlaylist(String name) throws InterruptedException {
        // .create input[type='text']
        WebElement namePLField = driver.findElement(cssSelector(".create input[type='text']"));
        namePLField.clear();
        namePLField.sendKeys(name);
        Actions actions = new Actions(driver);
        actions.sendKeys(namePLField, Keys.RETURN).perform();
        Thread.sleep(4000);
    }

    public String deletedPlaylistNotification() {
        // .alertify-logs.top.right
        WebElement deleteNotification = driver.findElement(cssSelector(".alertify-logs.top.right"));
        return deleteNotification.getText();
    }

}