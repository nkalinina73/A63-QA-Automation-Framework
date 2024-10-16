package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");
    By nextSongBtn = By.cssSelector("i.next.fa.fa-step-forward.control");
    By playBth = By.cssSelector("span.play");
    By songImage = By.cssSelector("#mainFooter img");


    public void clickNextSongButton() {findElement(nextSongBtn).click();}
    public void clickPlayButton(){findElement(playBth).click();}
    public void validateSongIsPlaying(){findElement(songImage).isDisplayed();}

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }
}

