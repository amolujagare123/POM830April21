package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    @FindBy(xpath="//a[normalize-space()='Dashboard']")
    WebElement dashboard;

    @FindBy(xpath="//span[normalize-space()='Clients']")
    WebElement clients;

    @FindBy(xpath="//a[contains(text(),'Add Client')]")
    WebElement addClients;

    @FindBy(xpath="//a[normalize-space()='View Clients']")
    WebElement viewClients;

    @FindBy(xpath="//span[normalize-space()='Quotes']")
    WebElement quotes;

    @FindBy(xpath="//a[contains(text(),'Create Quote')]")
    WebElement creatQuote;

    @FindBy(xpath="//a[normalize-space()='View Quotes']")
    WebElement viewQuotes;

    public Menu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickDashboard()
    {
        dashboard.click();
    }

    public void clickAddClient()
    {
        clients.click();
        addClients.click();
    }

    public void clickViewClients()
    {
        clients.click();
        viewClients.click();
    }

    public void clickCreateQuote()
    {
        quotes.click();
        creatQuote.click();
    }

    public void clickViewQuotes()
    {
        quotes.click();
        viewQuotes.click();
    }

}
