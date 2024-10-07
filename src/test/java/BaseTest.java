import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {


    public WebDriver driver = null;
    public String url =  "https://qa.koel.app/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchClass(){

        // added ChromeOptions argument to fix websocket error

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
    }


    public void selectPlaylist() throws InterruptedException {
        WebElement playList = driver.findElement(By.cssSelector("#songResultsWrapper .playlist"));
        playList.click();
        Thread.sleep(2000);

    }

    public void clickAddToButton() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector("#songResultsWrapper .btn-add-to"));
        addToButton.click();
        Thread.sleep(2000);

    }

    public void clickFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.cssSelector(".search-results [draggable='true']:nth-of-type(1) .title"));
        firstSong.click();
        Thread.sleep(2000);

    }

    public void clickViewAllButton() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);


    }

    public void searchForSong(String song) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(song);
        Thread.sleep(2000);

    }

    public void clickLoginButton() throws InterruptedException {
        WebElement buttonSubmit = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonSubmit.click();
        Thread.sleep(2000);

    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void getAddToPlaylistSuccessMsg() {
        WebElement notificationPopUp = driver.findElement(By.cssSelector(".alertify-logs"));
        System.out.println("Notification: " + notificationPopUp.getText());
        Assert.assertEquals(notificationPopUp.getText(), "Added 1 song into \"NK_PL.\"");
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void clickLoginButton() {
        WebElement buttonSubmit = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonSubmit.click();
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();

    }


}