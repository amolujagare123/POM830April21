package regression.Clients;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;

import static utility.ConfigReader.*;

public class AddClientTest {

    WebDriver driver;
    @BeforeClass
    public void doLogin() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPass(getPassword());
        login.clickBtnLogin();
    }


    @Test
    public void addclientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);


        addClient.setcName("Visha111");
        addClient.setcSurname("Kavadikar");
        addClient.setLanguage("Spanish");
        addClient.setcAdd1("xyz");
        addClient.setcAdd2("Pqr");
        addClient.setcCity("pune");
        addClient.setcState("MH");
        addClient.setcZip("32323");
        addClient.setCountry("Hungary");
        addClient.setBirthDate("05/10/2021");
        addClient.setGender("Female");
        addClient.setClientphone("8329237");
        addClient.setClientfax("1234");
        addClient.setClientmobile("1234567890");
        addClient.setClientemail("moni@gmail.com");
        addClient.setClientweb("www.monica.com");
        addClient.setClientvatid("12345");
        addClient.setClienttaxcode("fggg");

        addClient.clickSave();
    }
}
