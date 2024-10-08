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
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
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