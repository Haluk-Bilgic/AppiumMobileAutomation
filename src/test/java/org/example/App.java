package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class App
{
     AppiumDriver driver;
     public WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
      DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus 5 API 28");
        capabilities.setCapability("appPackage","io.selendroid.testapp");
        capabilities.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");

        URL url=new URL("HTTP://127.0.0.1:4723/wd/hub");
         driver=new AppiumDriver(url,capabilities);
         wait=new WebDriverWait(driver,30);
    }

    @Test(description = "Verify that a user can click to the EsButton and select options")
    public void EsButtonClick() throws InterruptedException {
      WebElement EnButton=driver.findElement(By.id("io.selendroid.testapp:id/buttonTest"));
        wait.until(ExpectedConditions.elementToBeClickable(EnButton));
        EnButton.click();

        Thread.sleep(5000);
        driver.findElement(By.id("android:id/button1")).click();
    }
    @Test(description = "Verify that a user can type to Box with integer and String ")
    public void Box() throws InterruptedException {
       WebElement box= driver.findElement(By.xpath("//android.widget.EditText" +
                "[@content-desc=\"my_text_fieldCD\"]"));
       wait.until(ExpectedConditions.visibilityOf(box));
       box.sendKeys("Hello World");
         Thread.sleep(5000);
       box.clear();
       box.sendKeys("1223543543254316");
    }
    @Test(description = "Verify that a user can click to ChromeButton")
    public void ChromeButton(){
        driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();

    }
    @Test(description = "Verify that a user can return to homePage after ChromePage ")
    public void goToHomeScreenButton(){
    driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
    WebElement goToHomeButton= driver.findElement(By.id("io.selendroid.testapp:id/goBack"));

    wait.until(ExpectedConditions.visibilityOf(goToHomeButton));
    goToHomeButton.click();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    }
