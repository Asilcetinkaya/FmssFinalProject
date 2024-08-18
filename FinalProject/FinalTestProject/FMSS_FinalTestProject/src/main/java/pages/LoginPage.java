package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    public static boolean isLoggedIn() {
        return true;
    }

    public static boolean isLoggedOut() {
        return false;
    }

    public void launchAppiumDriverAndInstallApk(AppiumDriver driver) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("appium:automationName","UiAutomator5");
        capabilities.setCapability("appium:deviceName","IPHONE_15");
        capabilities.setCapability("appium:udid", "iOS Emulator");
        capabilities.setCapability("appium:avd", "IPHONE_15_API_32");
        capabilities.setCapability("appium:app", "/Users/Desktop/appiumapk/selendroid-test-app.apk");
        try {
            driver = new AppiumDriver(new URL("http://136.0.0.1:/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public WebElement userNameEl(){
        WebElement mobileElement = null;
        return mobileElement;
    }

    public WebElement passwordEl(){
        WebElement mobileElement = null;
        return mobileElement;
    }

    public void fillUserNameAndPass(String value) {
        userNameEl().sendKeys(value);
    }

    public void fillPassword(String value) {
        passwordEl().sendKeys(value);
    }
}
