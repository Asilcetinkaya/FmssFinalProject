package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.SignupPage;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class signupSteps {
    private AppiumDriver<MobileElement> driver;
    private SignupPage signupPage;

    public signupSteps() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-7656");
        capabilities.setCapability(MobileCapabilityType.APP, "path/to/your/app.apk"); //
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator5");

        try {

            driver = new AndroidDriver(new URL("http://136.0.0.1:/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        signupPage = new SignupPage(driver);
    }

    @Given("Kullanıcı kayıt ekranındadır")
    public void kullanıcıKayıtEkranındadır() {driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("example.com.tr");

    }

    @When("Kullanıcı gerekli tüm alanları doldurur ve {string} butonuna tıklar")
    public void kullanıcıGerekliTumAlanlarıDoldururVeButonunaTıklar(String buttonText) {

        signupPage.enterUsername("testuserName");
        signupPage.enterEmail("testUser@example.com");
        signupPage.enterPassword("HatalıPassword");
        signupPage.enterPasswordConfirm("HatalıParola1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @Then("Kullanıcının hesabı oluşturulur ve kullanıcı Ana Ekrana yönlendirilir")
    public void kullanıcınınHesabıOlusturulurVeKullanıcıAnaEkranaYonlendirilir() {
        signupPage.enterUsername("testuserName");
        signupPage.enterEmail("testUser@example.com");
    }

    @When("Kullanıcı bazı alanları doldurmaz ve {string} butonuna tıklar")
    public void kullanıcıBazıAlanlarıDoldurmazVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("demoUser");
        signupPage.enterEmail("demouser@example.com");
        // Do not enter password and confirm password
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @Then("{string} hata mesajı gösterilir ve kayıt işlemi gerçekleşmez")
    public void hataMesajıGosterilirVeKayıtIslemiGerceklesmez(String errorMessage) {
    }

    @When("Kullanıcı geçersiz bir e-posta adresi girer ve {string} butonuna tıklar")
    public void kullanıcıGecersizBirEPostaAdresiGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("demouser");
        signupPage.enterEmail("invalid-email");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı şifre alanına ve şifre onayı alanına farklı şifreler girer ve {string} butonuna tıklar")
    public void kullanıcıSifreAlanınaVeSifreOnayıAlanınaFarklıSifrelerGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("demouser");
        signupPage.enterEmail("demouser@example.com");
        signupPage.enterPassword("Şifre1");
        signupPage.enterPasswordConfirm("Farklısifre1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı daha önce kayıt olmuş bir e-posta adresi girer ve {string} butonuna tıklar")
    public void kullanıcıDahaOnceKayıtOlmusBirEPostaAdresiGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("demouser");
        signupPage.enterEmail("differentuser@example.com");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı gerekli tüm alanları doldurur ancak {string}ni kabul etmez ve {string} butonuna tıklar")
    public void kullanıcıGerekliTumAlanlarıDoldururAncakNiKabulEtmezVeButonunaTıklar(String termsCheckbox, String buttonText) {
        signupPage.enterUsername("demouser");
        signupPage.enterEmail("differentuser@example.com");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        // Do not check terms checkbox
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı zayıf bir şifre girer ve {string} butonuna tıklar")
    public void kullanıcıZayıfBirSifreGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("demouser");
        signupPage.enterEmail("differentuser@example.com");
        signupPage.enterPassword("weak");
        signupPage.enterPasswordConfirm("weak");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı e-posta adresi alanını boş bırakır ve {string} butonuna tıklar")
    public void kullanıcıEPostaAdresiAlanınıBosBırakırVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("demouser");
        // Empty email field
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı adı olarak sadece iki karakter girer ve {string} butonuna tıklar")
    public void kullanıcıAdıOlarakSadeceIkiKarakterGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("ab"); // Only two characters
        signupPage.enterEmail("differentuser@example.com");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı daha önce kullanılmış bir kullanıcı adı girer ve {string} butonuna tıklar")
    public void kullanıcıDahaOnceKullanılmışBirKullanıcıAdıGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("existinguser");
        signupPage.enterEmail("differentuser@example.com");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}