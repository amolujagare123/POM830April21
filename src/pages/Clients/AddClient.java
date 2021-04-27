package pages.Clients;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    @FindBy(xpath="//input[@id='client_name']")
    WebElement cName;

    @FindBy(xpath="//input[@id='client_surname']")
    WebElement cSurname;

    @FindBy(xpath="//input[@id='client_address_1']")
    WebElement cAdd1;

    @FindBy(xpath="//input[@id='client_address_2']")
    WebElement cAdd2;

    @FindBy(xpath="//input[@id='client_city']")
    WebElement cCity;

    @FindBy(xpath="//input[@id='client_state']")
    WebElement cState;

    @FindBy(id="client_zip")
    WebElement cZip;

    @FindBy(xpath="//button[normalize-space()='Save']")
    WebElement save;


    @FindBy (id="select2-client_language-container")
    WebElement languageContainer;

    @FindBy(xpath="//input[@role='searchbox']")
    WebElement searchBox;

    WebDriver driver;

    public void setLanguage(String language)
    {
        languageContainer.click();
        searchBox.sendKeys(language);
        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();
    }

    @FindBy(id = "client_phone")
    WebElement clientphone;

    @FindBy(id = "client_fax")
    WebElement clientfax;
    @FindBy(id = "client_mobile")
    WebElement clientmobile;

    @FindBy(id = "client_email")
    WebElement clientemail;

    @FindBy(id = "client_web")
    WebElement clientweb;

    @FindBy(id = "client_vat_id")
    WebElement clientvatid;

    @FindBy(id = "client_tax_code")
    WebElement clienttaxcode;

    @FindBy(xpath="//input[@id='client_birthdate']")
    WebElement birthDate;

    public void setBirthDate(String bdate)
    {
      //  birthDate.sendKeys(bdate);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value','"+bdate+"')",birthDate);


    }

    @FindBy(id = "select2-client_gender-container")
    WebElement gendercontainer;

    public void setGender(String gender)
    {
        gendercontainer.click();
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();
    }


    @FindBy (id="select2-client_country-container")
    WebElement contryContainer;

    public void setCountry(String country)
    {
        contryContainer.click();
        searchBox.sendKeys(country);
        driver.findElement(By.xpath("//li[normalize-space()='"+country+"']")).click();
    }


    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void setcName(String name)
    {
        cName.sendKeys(name);
    }

    public void setcSurname(String surname)
    {
        cSurname.sendKeys(surname);
    }

    public void setcAdd1(String add1)
    {
        cAdd1.sendKeys(add1);
    }

    public void setcAdd2(String add2)
    {
        cAdd2.sendKeys(add2);
    }

    public void setcCity(String city)
    {
        cCity.sendKeys(city);
    }

    public void setcState(String state)
    {
        cState.sendKeys(state);
    }

    public void setcZip(String zip)
    {
        cZip.sendKeys(zip);
    }


    public void clickSave()
    {
        save.click();
    }

    public void setClientphone(String phone) {
        clientphone.sendKeys(phone);
    }

    public void setClientfax(String fax) {
        clientfax.sendKeys(fax);
    }

    public void setClientmobile(String mobile) {
        clientmobile.sendKeys(mobile);
    }

    public void setClientemail(String email) {
        clientemail.sendKeys(email);
    }

    public void setClientweb(String web) {
        clientweb.sendKeys(web);
    }

    public void setClientvatid(String vatid) {
        clientvatid.sendKeys(vatid);
    }

    public void setClienttaxcode(String taxcode) {
        clienttaxcode.sendKeys(taxcode);
    }

}
