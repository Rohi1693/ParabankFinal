package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class billPaymentPage {

    WebDriver driver;
    private WebDriverWait wait;


    public billPaymentPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Bill Pay']")
    private WebElement billPayLink;

    @FindBy(xpath = "//input[@name='payee.name']")
    private WebElement payeeName;

    @FindBy(xpath = "//input[@name='payee.address.street']")
    private WebElement payeeAddress;

    @FindBy(xpath = "//input[@name='payee.address.city']")
    private WebElement payeeCity;

    @FindBy(xpath = "//input[@name='payee.address.state']")
    private WebElement payeeState;

    @FindBy(xpath = "//input[@name='payee.address.zipCode']")
    private WebElement payeeZipCode;

    @FindBy(xpath = "//input[@name='payee.accountNumber']")
    private WebElement payeeAccountNumber;

    @FindBy(xpath = "//input[@name='verifyAccount']")
    private WebElement verifyAccountField;

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement amountField;

    @FindBy(xpath = "//input[@name='payee.phoneNumber']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@value='Send Payment']")
    private WebElement sendPaymentButton;

    @FindBy(xpath = "//h1[text()='Bill Payment Complete']")
    private WebElement billPaymentCompletedText;

    @FindBy(xpath = "//span[@id='payeeName']")
    private WebElement payeeNameLabel;

    @FindBy(xpath = "//span[@id='amount']")
    private WebElement amountLabel;

    @FindBy(xpath = "//span[@id='fromAccountId']")
    private WebElement fromAccountLabel;

    public void clickBillPayLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(billPayLink)).click();

    }

    public void clickSendPaymentButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(sendPaymentButton)).click();

    }

    public void enterBillPaymentDetails(String payeeNameValue,
                                        String address, String city, String zipCode,
                                        String accountNumber,
                                        String amount,
                                        String phone,
                                        String state) {

        payeeName.sendKeys(payeeNameValue);
        payeeAddress.sendKeys(address);
        payeeCity.sendKeys(city);
        payeeZipCode.sendKeys(zipCode);
        payeeAccountNumber.sendKeys(accountNumber);
        verifyAccountField.sendKeys(accountNumber);
        amountField.sendKeys(amount);
        phoneNumberField.sendKeys(phone);
        payeeState.sendKeys(state);
    }


    public void enterSomeBillPaymentDetails(String payeeNameValue,
                                        String address, String city, String zipCode,
                                        String accountNumber,
                                        String amount) {

        payeeName.sendKeys(payeeNameValue);
        payeeAddress.sendKeys(address);
        payeeCity.sendKeys(city);
        payeeZipCode.sendKeys(zipCode);
        payeeAccountNumber.sendKeys(accountNumber);
        verifyAccountField.sendKeys(accountNumber);
        amountField.sendKeys(amount);

    }

    public boolean isPaymentCompleted() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(40))
                    .until(ExpectedConditions.visibilityOf(billPaymentCompletedText));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getPayeeName() {
        wait.until(ExpectedConditions.visibilityOf(payeeNameLabel));
        return payeeNameLabel.getText().trim();
    }

    public String getAmount() {
        wait.until(ExpectedConditions.visibilityOf(amountLabel));
        return amountLabel.getText().trim();
    }

    public String getFromAccountNumber() {
        wait.until(ExpectedConditions.visibilityOf(fromAccountLabel));
        return fromAccountLabel.getText().trim();
    }


}
