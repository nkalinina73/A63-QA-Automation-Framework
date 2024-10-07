import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest{


    @Test(priority = 1)
    public void loginToKoel() throws InterruptedException {

        provideEmail("natalia.kalinina@testpro.io");
        providePassword("nkKoel24$");
        clickLoginButton();
        Thread.sleep(2000);
        clickAvatarIcon();
        Thread.sleep(2000);
        // providing current pswd
        provideCurrentPassword("nkKoel24$");
        Thread.sleep(2000);
        // Variable for random name
        String randomName = generateRandomName();
        System.out.println("The random name is: " + randomName);
        Thread.sleep(2000);
        // providing Profile (random) name
        provideProfileName(randomName);
        Thread.sleep(2000);
        clickSaveButton();
        Thread.sleep(2000);

//        WebElement actualProfileName = driver.findElement(By.cssSelector("#inputProfileName"));
//        Thread.sleep(2000);
//        Assert.assertEquals(actualProfileName.getText(), randomName);



    }

    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String profileName) {
        WebElement myPName = driver.findElement(By.cssSelector("#inputProfileName"));
        myPName.clear();
        myPName.sendKeys(profileName);
    }

    public void provideCurrentPassword(String currentPassword) {
        WebElement myPassword = driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
        myPassword.sendKeys(currentPassword);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
