package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class loginSteps {
    static AppiumDriver driver;
    LoginPage loginPage = new LoginPage();

    private URL getUrl() {
        try {
            return new URL("http://136.0.0.1:/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Given("Kullanıcı oturum açma sayfasında")
    public void kullanıcıOturumAcmaSayfasında() {
        BaseOptions options = new BaseOptions()
                .amend("platformName", "iOS")
                .amend("appium:deviceName", "I Phone 15")
                .amend("appium:automationName", "UiAutomator5")
                .amend("appium:udid", "iOS Emulator")
                .amend("appium:avd", "Iphone_15_pro_API_32")
                .amend("appium:fastReset", true)
                .amend("appium:fastReset", true)
                .amend("appium:newCommandTimeout", 5)
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:connectHardwareKeyboard", true)
                .amend("appium:app", "/Users/asil/Downlands/appiumapk/selendroid-test-app.apk");

        driver = new AndroidDriver(this.getUrl(), options);
        loginPage.launchAppiumDriverAndInstallApk(driver);
    }

    @When("Kullanıcı geçerli bir e-posta ve şifre ile oturum aç butonuna tıklar.")
    public void kullanıcıGecerliBirEPostaVeSifreIleOturumAcButonunaTıklar() {
        loginPage.fillUserNameAndPass("gecerliEposta");
        loginPage.fillPassword("gecerliSifre");
        driver.findElement(By.id("login_button_id")).click();
    }

    @Then("Kullanıcı Ana Sayfaya yönlendirilir.")
    public void kullanıcıAnaSayfayaYonlendirilir() {
        String expectedUrl = "http://example.com/home";
        String actualUrl = driver.getCurrentUrl();
        assert expectedUrl.equals(actualUrl);
    }

    @When("Kullanıcı geçersiz bir e-posta veya yanlış şifre ile oturum aç butonuna tıklar.")
    public void kullanıcıGecersizBirEPostaVeyaYanlısSifreIleOturumAcButonunaTıklar() {
        loginPage.fillUserNameAndPass("gecersizEposta");
        loginPage.fillPassword("yanlisSifre");
        driver.findElement(By.id("login_button_id")).click();
    }

    @Then("Kullanıcıya {string} uyarısı ekranda gösterilir.")
    public void kullanıcıyaUyarısıEkrandaGosterilir(String uyarıMesajı) {
        String actualMessage = driver.findElement(By.id("uyari_mesaji_id")).getText();
        assert actualMessage.equals(uyarıMesajı);
    }
}