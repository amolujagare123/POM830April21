package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;

import java.io.IOException;

import static utility.ConfigReader.getUrl;

public class ForgotPasswordTest {


    @Test
    public void forgotPassTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(getUrl());

        // 2.click on forgot password button

        Login login = new Login(driver);
        login.clickForgotPass();

        // 3. enter email
        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.setTxtEmail("amol@gmail.com");

        //4.click on reset
        forgotPassword.clickResetBtn();

        // in tests  (POM) we will very rarely use
        //1. find elements / sendkeys / click like method
    }

}
