package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.LogoutPage;

import static org.junit.Assert.assertTrue;
import static steps.loginSteps.driver;

public class logoutSteps {
    private LogoutPage logoutPage;

    @Given("Kullanıcı başarılı bir şekilde login olup Ana Ekrandadır")
    public void kullanıcıBasarılıBirSekildeLoginOlupAnaEkrandadır() {
        boolean isLoggedIn = LoginPage.isLoggedIn(); // Login kontrol metodu
        assertTrue("Kullanıcı giriş yapmış veya ana ekranda", isLoggedIn );
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullanıcıButonunaTıklar(String buttonName) {
        if (buttonName.equals("Çıkış")) {
            logoutPage.clickLogoutButton();
        }
    }

    @Then("Uygulamada oturum kapatılır ve kullanıcı giriş ekranına yönlendirilir")
    public void uygulamadaOturumKapatılırVeKullanıcıGirisEkranınaYonlendirilir() {
        boolean isLoggedOut = LoginPage.isLoggedOut();
        assert logoutPage.isLoginScreenDisplayed();
        assertTrue("Oturum kapatıldı", isLoggedOut);
    }

    @Given("Kullanıcı başarılı bir şekilde login olup Ana Ekrandadır ve internet bağlantısı yoktur")
    public void kullanıcıBasarılıBirSekildeLoginOlupAnaEkrandadırVeInternetBaglantısıYoktur() {

    }

    @Then("{string} hata mesajı gösterilir")
    public void hataMesajıGosterilir(String errorMessage) {
        assert logoutPage.isInternetConnectionErrorDisplayed();
    }

    @And("Uygulamada oturum açık kalır")
    public void uygulamadaOturumAcıkKalır() {

    }

    @When("Kullanıcı {string} butonuna tıklar ve çıkış işlemini onaylamadan {string} butonuna basar")
    public void kullanıcıButonunaTıklarVeCıkısIsleminiOnaylamadanButonunaBasar(String buttonName, String cancelButton) {
        if (buttonName.equals("Çıkış")) {
            logoutPage.clickLogoutButton();
            if (cancelButton.equals("İptal")) {
                logoutPage.clickCancelButton();
            }
        }
    }

    @And("Kullanıcı Ana Ekranda kalır")
    public void kullanıcıAnaEkrandaKalır() {

    }

    @Given("Kullanıcı oturumunu kapatmıştır ve Ana Ekranda değildir")
    public void kullanıcıOturumunuKapatmıstırVeAnaEkrandaDegildir() {

    }

    @When("Kullanıcı uygulamayı yeniden açıp {string} butonuna tıklar")
    public void kullanıcıUygulamayıYenidenAcıpButonunaTıklar(String buttonName) {
        if (buttonName.equals("Çıkış")) {
            logoutPage.clickLogoutButton();
        }
    }

    @And("Kullanıcı giriş ekranında kalır")
    public void kullanıcıGirisEkranındaKalır() {
        assert logoutPage.isLoginScreenDisplayed();
    }

    @When("Kullanıcı uygulamayı kapatmadan önce {string} butonuna tıklar")
    public void kullanıcıUygulamayıKapatmadanOnceButonunaTıklar(String buttonName) {
        if (buttonName.equals("Çıkış")) {
            logoutPage.clickLogoutButton();
        }
    }

    @Then("Uygulamada oturum kapatılır")
    public void uygulamadaOturumKapatılır() {

    }

    @And("Uygulama kapatılır")
    public void uygulamaKapatılır() {
        logoutPage.clickLogoutButton();
        driver.quit();
    }

    @And("Kullanıcı uygulamayı tekrar açtığında giriş ekranında olur")
    public void kullanıcıUygulamayıTekrarActıgındaGirisEkranındaOlur() {
        assert logoutPage.isLoginScreenDisplayed();
    }
}