package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class createNewAccount {
     WebDriver driver;
    private WebDriverWait wait;


    public createNewAccount(WebDriver driver){
     this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Open New Account']")
    private WebElement openNewAccountLink;

    @FindBy(id = "type")
    private WebElement accountTypeDropdown;

    // Existing Account Dropdown
    @FindBy(id = "fromAccountId")
    private WebElement existingAccountDropdown;

    // Open New Account Button
    @FindBy(xpath = "//input[@value='Open New Account']")
    private WebElement openNewAccountButton;

    // New Account Number
    @FindBy(id = "newAccountId")
    private WebElement newAccountNumber;;

    @FindBy(xpath = "//h1[text()='Account Opened!']")
    private WebElement accountOpenedMessage;

    @FindBy(xpath = "//a[text()='Accounts Overview']")
    private WebElement accountOverViewLink;

    public void selectAccountType(String accountType) {
        new Select(accountTypeDropdown).selectByVisibleText(accountType);
    }

    public void selectExistingAccount(String accountNumber) {
        new Select(existingAccountDropdown).selectByVisibleText(accountNumber);
    }

    public void clickOpenNewAccount() {
        openNewAccountButton.click();
    }

    public String getNewAccountNumber() {
        return newAccountNumber.getText();
    }

    public String openNewAccount(String accountType, String accountNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.elementToBeClickable(openNewAccountLink)).click();
        wait.until(ExpectedConditions.visibilityOf(accountTypeDropdown));
        new Select(accountTypeDropdown).selectByVisibleText(accountType);
        wait.until(ExpectedConditions.visibilityOf(existingAccountDropdown));
       // new Select(existingAccountDropdown).selectByVisibleText(accountNumber);
        Select select = new Select(existingAccountDropdown);
        for (WebElement option : select.getOptions()) {
            if (option.getText().trim().equals(accountNumber.trim())) {
                option.click();
                break;
            }
        }wait.until(ExpectedConditions.elementToBeClickable(openNewAccountButton)).click();
        wait.until(ExpectedConditions.visibilityOf(newAccountNumber));
        return newAccountNumber.getText();
    }

    public boolean isAccountCreated() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(40))
                    .until(ExpectedConditions.visibilityOf(accountOpenedMessage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickAccountOverView(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(accountOverViewLink)).click();

    }

    public void clickAccountIfPresent(String accountNumber) {
        List<WebElement> accounts = driver.findElements(
                By.xpath("//a[text()='" + accountNumber + "']")
        );

        if (!accounts.isEmpty()) {
            accounts.get(0).click();
        } else {
            throw new NoSuchElementException(
                    "Account number not found: " + accountNumber);
        }
    }

    public boolean isAccountPresent(String accountNumber) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[text()='" + accountNumber + "']")
            ));

            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
