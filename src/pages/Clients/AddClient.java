package pages.Clients;

import org.openqa.selenium.By;
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

}
