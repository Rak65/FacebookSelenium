package com.facebook;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FacebookPage {
    private final WebDriver driver;
    public FacebookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.get("https://www.facebook.com");
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.name("login"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
        driver.findElement(By.xpath("//a[@aria-label='Home']"));
    }

    public void homePage() throws InterruptedException {
        WebElement homeLink = driver.findElement(By.xpath("//a[@aria-label='Home']"));
        homeLink.click();
        Thread.sleep(3000);
    }

    public void writePost(String message) throws InterruptedException {
        WebElement createPostInput = driver.findElement(By.xpath("//span[text()='Photo/video']"));
        createPostInput.click();
        Thread.sleep(3000);
        WebElement postInput = driver.findElement(By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8']"));
        postInput.sendKeys(message);
    }

    public void uploadPhoto(String filePath) throws IOException, InterruptedException {
        WebElement addPhotoButton = driver.findElement(By.xpath("//div[@class='x14yjl9h xudhj91 x18nykt9 xww2gxu x6s0dn4 x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x3nfvp2 xl56j7k x1n2onr6 x1qhmfi1 x1vqgdyp x100vrsf']"));
        addPhotoButton.click();
        Runtime.getRuntime().exec(filePath);
        Thread.sleep(3000);
    }

    public void postStatus() {
        WebElement postButton = driver.findElement(By.xpath("//span[text()='Post']"));
        postButton.click();
    }

    public void searchForFriend(String friendName) throws InterruptedException {
        Thread.sleep(5000);
        WebElement searchBox = driver.findElement(By.xpath("//input[@aria-label='Search Facebook']"));
        searchBox.sendKeys(friendName);
        searchBox.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
    }

    public void likeFriendPost() {
        WebElement like = driver.findElement(By.xpath("(//span[text()='Like'])[1]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", like);
    }

    public void getLikeCount() throws InterruptedException {
        homePage();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Rakesh Kumar']")).click();       // Go to your posts
        Thread.sleep(5000);
        WebElement like = driver.findElement(By.xpath("//div[@class='x6s0dn4 x78zum5 x1iyjqo2 x6ikm8r x10wlt62']//span[text()='You']"));
        like.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", like);
        Thread.sleep(4000);
        List<WebElement> likeCount = driver.findElements(By.xpath("//div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']/div[@data-visualcompletion='ignore-dynamic']"));
        System.out.println("No of like : " + likeCount.size());
    }

    public void takeScreenshot(String filePath) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File StFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File DsFile = new File(filePath);
        FileHandler.copy(StFile, DsFile);
    }

    public void closePopup() {
        driver.findElement(By.xpath("//div[@aria-label='Close']")).click();
    }
    public void yourProfile(){
        driver.findElement(By.xpath("//div[@class='x78zum5 x1n2onr6']")).click();
    }
    public void logout() {
        driver.findElement(By.xpath("//span[text()='Log out']")).click();
    }
}