package DatabseTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static utility.ConfigReader.*;
import static utility.DataProviderUtil.testDataProvider;

public class AddClientTestDataProvider {

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


    @Test (dataProvider = "getData")
    public void addclientTest(String name,String surname,String language,
                              String add1,String add2,String city,String state,
                              String zip,String country,String gender,String birthdate,
                              String phone,String fax,String mobile,String email,
                              String web,String vat ,String tax) throws ClassNotFoundException, SQLException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        ArrayList<String> expected = new ArrayList<>();

        expected.add(name);
        expected.add(surname);
        expected.add(language);
        expected.add(add1);
        expected.add(add2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat );
        expected.add(tax);



        AddClient addClient = new AddClient(driver);


        addClient.setcName(name);
        addClient.setcSurname(surname);
        addClient.setLanguage(language);
        addClient.setcAdd1(add1);
        addClient.setcAdd2(add2);
        addClient.setcCity(city);
        addClient.setcState(state);
        addClient.setcZip(zip);
        addClient.setCountry(country);
        addClient.setBirthDate(birthdate);
        addClient.setGender(gender);
        addClient.setClientphone(phone);
        addClient.setClientfax(fax);
        addClient.setClientmobile(mobile);
        addClient.setClientemail(email);
        addClient.setClientweb(web);
        addClient.setClientvatid(vat);
        addClient.setClienttaxcode(tax);
        addClient.clickSave();

        //1 . loading a driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.Creating a connection

        String user = "root";
        String password ="root";
        String connectionUrl= "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(connectionUrl,user,password);

        //3.Creating a statement
        Statement st = con.createStatement();

        // 4. execute query
        String sql = "select * from ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while(rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));
            actual.add(rs.getString("client_country"));
            actual.add(rs.getString("client_gender"));
            actual.add(rs.getString("client_birthdate"));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("Expected="+expected);

        System.out.println("Actual="+actual);

    }

    @DataProvider
    public  Object[][]  getData() throws IOException {

        return  testDataProvider("Data/Invoiceplane.xlsx","dbTest");
    }
}
