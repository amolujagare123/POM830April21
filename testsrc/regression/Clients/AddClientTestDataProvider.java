package regression.Clients;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Login;
import pages.Menu;

import java.io.FileInputStream;
import java.io.IOException;

import static utility.ConfigReader.*;

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
                              String web,String vat ,String tax)
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

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
    }


    @DataProvider
    public  Object[][]  getData() throws IOException {
        //1.  Read the file :
        FileInputStream fis = new FileInputStream("Data/Invoiceplane.xlsx");

        //2.  Convert file object into workbook object
        XSSFWorkbook workbook = new  XSSFWorkbook(fis);

        // 3. Identify the sheet name & create sheet object
        XSSFSheet sheet = workbook.getSheet("addclient");

        // 4. count the number of active rows in the sheet
        int rowCount = sheet.getPhysicalNumberOfRows(); // 5
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];

        // 5. traverse the array
        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1); // excel

            for(int j=0;j<colCount;j++)
               data[i][j] = row.getCell(j).toString().trim();

        }


        return  data;
    }
}
