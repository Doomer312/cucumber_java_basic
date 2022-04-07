package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TaskSteps {
    private WebDriver driver;

    public TaskSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on People with Jobs page$")
    public void iAmOnJobsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @When("^I click Add person$")
    public void iClickAddPerson() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I enter name on People with Jobs page: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter job on People with Jobs page: \"([^\"]*)\"$")
    public void iEnterJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click Add$")
    public void iClickAdd() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^I see name \"([^\"]*)\" on People with Jobs page$")
    public void iCanSeeNameOnJobsPage(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.xpath("//span[text()='" + name + "']")).getText());
    }

    @Then("^I see job \"([^\"]*)\" on People with Jobs page$")
    public void iCanSeeJobOnJobsPage(String job) throws Throwable {
        assertEquals(job, driver.findElement(By.xpath("//span[text()='" + job + "']")).getText());
    }

    //Edit and delete tests are designed considering that list is static. Not ideal, but this is due to time constraints.

    @When("^I click Edit person$")
    public void iClickEditPerson() throws Throwable {
        driver.findElement(By.className("fa-pencil")).click();

    }

    @And("^I enter Edited name on People with Jobs page: \"([^\"]*)\"$")
    public void iEnterEditedName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter Edited job on People with Jobs page: \"([^\"]*)\"$")
    public void iEnterEditedJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click Edit$")
    public void iClickEdit() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
    }

    @And("^I click Remove person$")
    public void iClickRemovePerson() throws Throwable {
        driver.findElement(By.xpath("//span[@onclick='deletePerson(0)']")).click();
        Thread.sleep(5000);
    }

    // Approach below can be used if list is static and Mike (Web Designer) is always first on the list. Otherwise, we would need to compare lists.

    @Then("^I cant see removed name on People with Jobs page$")
    public void iCantSeeNameOnJobsPage() throws Throwable {
        assertFalse(driver.getPageSource().contains("Mike"));
        }

    @Then("^I cant see removed job on People with Jobs page$")
    public void iCantSeeJobOnJobsPage() throws Throwable {
        assertFalse(driver.getPageSource().contains("Web Designer"));
    }

    @And("^I click Reset List$")
    public void iClickResetList() throws Throwable {
        driver.findElement(By.xpath("*//div[@class='w3-container'][2]/button[@id='addPersonBtn'][2]")).click();
    }

    @Then("^I cant see name \"([^\"]*)\" after reset$")
    public void iCantSeeNameAfterReset(String name) throws Throwable {
        assertFalse(driver.getPageSource().contains("Albus Dumbledore"));
    }

    @Then("^I cant see job \"([^\"]*)\" after reset$")
    public void iCantSeeJobAfterReset(String name) throws Throwable {
        assertFalse(driver.getPageSource().contains("Headmaster"));
    }
    //tried with className, but it did not work
    @And("^I click Clear all fields$")
    public void iClickClearAll() throws Throwable {
        driver.findElement(By.xpath("*//div[@class='w3-container w3-margin']/div[@class='clear-btn']/button[@id='addPersonBtn']")).click();
        Thread.sleep(5000);
    }

    @Then("^Age field is empty after Clear all fields$")
    public void ageFieldIsEmptyAfterClear() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getText());
    }
    @Then("^Job field is empty after Clear all fields$")
    public void jobFieldIsEmptyAfterClear() throws Throwable {
        assertEquals("", driver.findElement(By.id("job")).getText());
    }

    }

