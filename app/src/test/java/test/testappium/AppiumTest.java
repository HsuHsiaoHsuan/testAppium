package test.testappium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest {

    WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Samsung SM-G930F"); // 手機在 Android Monitor 顯示的名字
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION, "6.0.1"); // 手機版本
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "test.testappium");
        capabilities.setCapability("appActivity", "test.testappium.MainActivity");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); // 固定不變的寫法
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testClickButton() {
        driver.findElements(By.xpath("//android.widget.Button")).get(0).click(); // 在眾多的 Button 中取第 0 個出來按下去
        driver.findElement(By.id("btn_test")).click();
        driver.findElement(By.name("CANCEL")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void End() {
        driver.quit();
    }
}
