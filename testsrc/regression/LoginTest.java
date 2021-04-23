package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

import static utility.ConfigReader.getUrl;

public class LoginTest {


    @Test
    public void loginTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUser("amolujagare@gmail.com");
        login.setTxtPass("admin123");
        login.clickBtnLogin();
    }
}
