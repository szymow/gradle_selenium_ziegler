package theinternet;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestSteps {
    private WebDriver driver;
    static String TestString;

    @Before
    public void setUp() {

        // ChromeDriver path on development machine, which is Windows
        String OS = System.getProperty("os.name");
        if (OS.startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver",
                    Paths.get("src/test/resources/chromedriver_win32/chromedriver.exe").toString());

        }

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            // If you do not want to show the browser during test execution just uncomment line bellow
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }

    @Given("Navigate to Page ZieglerGroup")
    public void navigateToPageForgotPassword() {
        driver.navigate().to("https://zieglergroup.com");
    }

    @When("User clicks on Accept all button")
    public void userClicksOnAcceptAllButton() throws InterruptedException {
        driver.findElement(By.id("cookie_button_ok")).click();
        Thread.sleep(1000);
    }

    @Then("User clicks on Request a quote button")
    public void userClicksOnRequestAQuoteButton() throws InterruptedException {
        driver.findElement(By.cssSelector(".btn-z-xxl-3xl:nth-child(1)")).click();
        Thread.sleep(1000);
    }

    @When("User enters invalid firstname")
    public void userEntersInvalidFirstname() {
        driver.findElement(By.id("quote_firstname")).sendKeys("invalid@");
    }

    @And("User enters invalid lastname")
    public void userEntersInvalidLastname() {
        driver.findElement(By.id("quote_lastname")).sendKeys("invalid@");
    }

    @And("User enters invalid company")
    public void userEntersInvalidCompany() {
        driver.findElement(By.id("quote_company")).sendKeys("invalid@");
    }

    @And("User enters valid email")
    public void userEntersValidEmail() {
        driver.findElement(By.id("quote_email")).sendKeys("valid@valid.com");
    }

    @And("User enters invalid tel")
    public void userEntersInvalidTel() {
        driver.findElement(By.id("quote_tel")).sendKeys("invalid@");
    }

    @And("User selects country")
    public void userSelectsCountry() {
        new Select(driver.findElement(By.id("quote_country"))).selectByIndex(1);
    }

    @And("User clicks on Legal Mentions button")
    public void userClicksOnLegalMentionsButton() {
        driver.findElement(By.cssSelector(".custom-control-label > .ml-1")).click();
    }


    @Then("User clicks on Submit quote contact information button")
    public void userClicksOnSubmitQuoteContactInformationButton() throws InterruptedException {
        driver.findElement(By.id("submit_quote_contact_information")).click();
        Thread.sleep(1000);
    }

    @Then("User enters invalid origin")
    public void userEntersInvalidQuoteGoodsOrigin() {
        driver.findElement(By.id("quote_goods_origin")).sendKeys("invalid@");
    }

    @And("User enters invalid destination")
    public void userEntersInvalidQuoteGoodsDestination() {
        driver.findElement(By.id("quote_goods_destination")).sendKeys("invalid@");
    }

    @And("User enters invalid description")
    public void userEntersInvalidQuoteGoodsDescription() {
        driver.findElement(By.id("quote_goods_description")).sendKeys("invalid@");
    }

    @And("User checks all checkboxes")
    public void userChecksAllCheckboxes() {
        /*Click all Checkboxes
        element not interactable
        List<WebElement> AllCheckboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement allCheckbox : AllCheckboxes) {
            allCheckbox.click();
        }
         */
        driver.findElement(By.id("checkbox_services_1")).click();
        driver.findElement(By.id("checkbox_services_2")).click();
        driver.findElement(By.id("checkbox_services_3")).click();
        driver.findElement(By.id("checkbox_services_4")).click();
        driver.findElement(By.id("checkbox_services_5")).click();
        driver.findElement(By.id("checkbox_services_6")).click();
        driver.findElement(By.id("checkbox_services_7")).click();
        driver.findElement(By.id("checkbox_services_8")).click();
        driver.findElement(By.id("checkbox_services_9")).click();
        driver.findElement(By.id("checkbox_services_10")).click();
    }


    /*
    @Then("User clicks on Submit quote goods information")
    public void userClicksOnSubmitQuoteContactGoodsInformationButton() throws InterruptedException {
        driver.findElement(By.id("submit_quote_goods_information")).click();
        Thread.sleep(3000);
    }
     */


    @Then("Application shows that quote has been confirmed.")
    public void applicationShowsThatQuoteHasBeenConfirmed() {
        String actualMessage = driver.findElement(By.id("quote_confirm")).getText();
        assertThat(actualMessage, containsString("Well done"));
    }

    @Then("User clicks on Contact us button")
    public void userClicksOnContactUsButton() throws InterruptedException {
        driver.findElement(By.linkText("Contact us")).click();
        Thread.sleep(1000);
    }

    @And("User enters contact email")
    public void userContactEmail() {
        driver.findElement(By.id("contact_email")).sendKeys("valid@valid.com");
    }

    @And("User enters contact name")
    public void userContactName() {
        driver.findElement(By.id("contact_name")).sendKeys("invalid@");
    }

    @And("User enters contact subject")
    public void userContactSubject() {
        driver.findElement(By.id("contact_subject")).sendKeys("invalid@");
    }

    @And("User selects contact country")
    public void userSelectsContactCountry() {
        new Select(driver.findElement(By.id("contact_country"))).selectByIndex(1);
    }

    @And("User selects contact comment")
    public void userEntersContactComment() {
        driver.findElement(By.id("contact_comment")).sendKeys("invalid@");
    }

    @And("User clicks on Privacy Policy button")
    public void userClicksOnPrivacyPolicyButton() {
        driver.findElement(By.cssSelector(".custom-control-label > span")).click();
    }

    /*
    @And("User clicks on Submit contact button")
    public void userClicksOnSubmitContactButton() throws InterruptedException {
        driver.findElement(By.id("submit_contact")).click();
        Thread.sleep(3000);
    }
     */

    @Then("Application shows that contact has been confirmed.")
    public void applicationShowsThatContactHasBeenConfirmed() {
        String actualMessage = driver.findElement(By.id("modalInfoTitle")).getText();
        assertThat(actualMessage, containsString("WRITE TO US"));
    }




    @Given("A User Navigates to StatusCodes Page")
    public void aUserNavigatesToStatusCodesPage() {
        driver.navigate().to("https://the-internet.herokuapp.com/status_codes");
    }

    @When("A User Clicks on status Code {int}")
    public void aUserClicksOnStatusCodeInput(Integer inputCode) {
        driver.findElement(By.partialLinkText(inputCode.toString())).click();
    }

    @Then("Application displays the message {int}")
    public void applicationDisplaysTheMessageOutputCode(Integer outputCode) {
        String expectedMessage = "This page returned a "+outputCode.toString()+" status code.";
        String actualMessage = driver.findElement(By.cssSelector("h3 + p")).getText();

        assertThat(actualMessage, containsString(expectedMessage));
    }
}
