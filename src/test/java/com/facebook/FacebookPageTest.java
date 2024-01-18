package com.facebook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FacebookPageTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testFacebook() throws InterruptedException, IOException {
        FacebookPage facebookPage = new FacebookPage(driver);
        facebookPage.login("rakp6505@gmail.com", "Rakesh@560068");
        facebookPage.homePage();
        facebookPage.writePost("Hello, this is my Facebook post!!!");
        facebookPage.uploadPhoto("H:\\CFP251\\AutoIt\\FacebookFile.exe");
        facebookPage.postStatus();
        facebookPage.searchForFriend("Akarsh Kumar");
        facebookPage.likeFriendPost();
        facebookPage.getLikeCount();
        facebookPage.takeScreenshot("H:\\CFP251\\FacebookSeleniumPOM\\src\\FacebookScreenshot\\facebook.png");
        facebookPage.closePopup();
        facebookPage.yourProfile();
        facebookPage.logout();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}