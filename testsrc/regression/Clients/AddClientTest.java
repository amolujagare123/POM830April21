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


        addClient.setLanguage("Spanish");

       /* addClient.setcName("Visha");
        addClient.setcSurname("Kavadikar");
        addClient.setcAdd1("xyz");
        addClient.setcAdd2("Pqr");
        addClient.setcCity("pune");
        addClient.setcState("MH");
        addClient.setcZip("32323");
        addClient.clickSave();*/
    }
}
