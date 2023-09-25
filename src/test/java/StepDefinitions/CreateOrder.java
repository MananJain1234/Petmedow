package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class CreateOrder {
	WebDriver driver = new ChromeDriver();
JavascriptExecutor js = (JavascriptExecutor) driver;
Actions a = new Actions(driver);

	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
//      ChromeOptions option = new ChromeOptions();
		driver.get("https://pet-meadow-staging.herokuapp.com/");
		driver.manage().window().maximize();
	}
	@When("user enters username and password")
	public void user_enters_username_and_password() {
		 driver.findElement(By.id("user_username")).sendKeys("hsharma");
		 driver.findElement(By.id("user_password")).sendKeys("Harshita@99");	 
	}
	@When("clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.name("commit")).click();
	    
	}
	
	@Given("user click on new order")
	public void user_click_on_new_order() {
		driver.findElement(By.xpath("//span[text()=' New Order']")).click();    
	}
	@Given("click on services")
	public void click_on_services() {
		 driver.findElement(By.xpath("//a[text()='Service']")).click();
	    
	}

	@When("user selects the hospital {string}")
	public void user_selects_the_hospital(String hospital) throws InterruptedException {
//    	Select Hospital
		Thread.sleep(3000);
    	WebElement hospSelect = driver.findElement(By.id("order_hospital_id"));
        Select dropdown = new Select(hospSelect);
        dropdown.selectByVisibleText(hospital)

;
        js.executeScript("window.scrollBy(0, 70);");
	}

	@When("user selects the service {string}")
	public void user_selects_the_service(String service) throws InterruptedException {
//	Select the type of service by index
    	Thread.sleep(5000);
    	WebElement serviceSelect=driver.findElement(By.id("order_service_type"));
        Select dropdownService=new Select(serviceSelect);
        dropdownService.selectByVisibleText(service);
    	js.executeScript("window.scrollBy(0,70)");    	
        js.executeScript("window.scrollBy(0, 150);");
	}
	@When("user selects the pickup option {string}")
	public void user_selects_the_pickup_option(String pickup) throws InterruptedException {
		Thread.sleep(3000);
		//Pickup Options
        WebElement pickupOptions=driver.findElement(By.id("order_pickup_option"));
        Select dropdownPickup=new Select(pickupOptions);
        dropdownPickup.selectByVisibleText(pickup);
        js.executeScript("window.scrollBy(0,200)");
	}

	@When("user selects the delivery option")
	public void user_selects_the_delivery_option() throws InterruptedException {
		 //Order Delivery Options
		Thread.sleep(2000);
        WebElement deliveryOptions=driver.findElement(By.id("order_delivery_option"));
        Select dropdownDelivery=new Select(deliveryOptions);
        dropdownDelivery.selectByVisibleText("Return to Vet");
        
        Thread.sleep(4000);
	}

	@When("user selects the pickup date")
	 public void user_selects_the_pickup_date() throws InterruptedException {
			 // Get the current date in the format used in the calendar
			 SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
		     String formattedDate = dateFormat.format(Calendar.getInstance().getTime());
	        System.out.println(formattedDate);
	        // Find the calendar element (you might need to adjust the selector)
	        js.executeScript("window.scrollBy(0,850)");
	        driver.findElement(By.xpath("//*[@id='js-pickup-date']")).click();
			driver.findElement(By.xpath("//*[@class='flatpickr-calendar animate open arrowBottom arrowLeft']//*[@aria-label='"+formattedDate+"']")).click();
			js.executeScript("window.scrollBy(0,200)");
	}

	@When("user selects the delivery date")
	public void user_selects_the_delivery_date() {
		//Select Calendar and date
//        driver.findElement(By.xpath("//*[@id='order_delivery_date']")).click();
//		driver.findElement(By.xpath("//*[@class='flatpickr-calendar animate open arrowBottom arrowLeft']//*[@aria-label='September 30, 2023']")).click();
//		js.executeScript("window.scrollBy(0,200)");
	}

	@When("user enters the family information")
	public void user_enters_the_family_information() {
		//First Name
        WebElement fName=driver.findElement(By.id("order_customer_attributes_first_name"));
        fName.sendKeys(RandomStringUtils.randomAlphabetic(3));
        
        //Last Name
        WebElement lName=driver.findElement(By.id("order_customer_attributes_last_name"));
        lName.sendKeys(RandomStringUtils.randomAlphabetic(3));
	}

	@When("user selects the contact preferences")
	public void user_selects_the_contact_preferences() {
		//Family Portal Contact Preferences
        WebElement cPreferences=driver.findElement(By.id("order_customer_attributes_contact_preference"));
        Select dropdownContact=new Select(cPreferences);
        dropdownContact.selectByIndex(3);
	}

	@When("user enters the contact preferences")
	public void user_enters_the_contact_preferences() {
	    driver.findElement(By.xpath("//*[@id=\"order_customer_attributes_phone\"]")).sendKeys(RandomStringUtils.randomNumeric(10)+1);
	    driver.findElement(By.xpath("//*[@id=\"order_customer_attributes_email\"]")).sendKeys(RandomStringUtils.randomAlphabetic(7)+"@yopmail.com");
	}

	@When("family enters the pet information")
	public void family_enters_the_pet_information() throws InterruptedException {
		 //Pet Name
        WebElement pName=driver.findElement(By.id("order_pet_attributes_name"));
        pName.sendKeys(RandomStringUtils.randomAlphabetic(4));
        
        //KG Check 
//        WebElement kg=driver.findElement(By.xpath("//button[contains(text(),'kg')]"));
//        kg.click();
        
        //Weight
        WebElement weight=driver.findElement(By.id("order_pet_attributes_weight"));
        weight.sendKeys(RandomStringUtils.randomNumeric(1)+1);
        
        //Age
        WebElement age=driver.findElement(By.id("order_pet_attributes_age"));
		age.sendKeys(RandomStringUtils.randomNumeric(1)+1);
        
       
      //Species
        WebElement species=driver.findElement(By.id("order_pet_attributes_species_id"));
        Select dropdownSpecies=new Select(species);
        dropdownSpecies.selectByVisibleText("Sheep");
        Thread.sleep(4000);
        
      //Cause of Death
        WebElement deathReason=driver.findElement(By.id("order_pet_attributes_cause_of_death"));
        Select dropdownDReason=new Select(deathReason);
        dropdownDReason.selectByIndex(2);
        
      //Color
        WebElement color=driver.findElement(By.id("order_pet_attributes_distinguishing_features"));
        color.sendKeys("Color");
	}

	@When("user clicks the next step button")
	public void user_clicks_the_next_step_button() {
		//Next Step Button
        WebElement nextStep=driver.findElement(By.xpath("//a[@class='btn btn-primary duplicate_orders']"));
        nextStep.click();
	}

	@Then("the user clicks on the step three button")
	public void the_user_clicks_on_the_step_three_button() throws InterruptedException {
	   Thread.sleep(3000);	
	   driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/div/div[5]/button/span[2]")).click();
	}

	@Then("the user clicks the submit button")
	public void the_user_clicks_the_submit_button() throws InterruptedException {
		Thread.sleep(3000);
	   js.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(3000);

        // Give the page some time to load content and scroll further if needed
        try {
            Thread.sleep(2000); // You can adjust the sleep duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	   WebElement check=driver.findElement(By.id("display_submit_button"));
	   System.out.println("Executed scroll");
	   a.moveToElement(check).click().build().perform();
	   Thread.sleep(3000);
	   js.executeScript("window.scrollBy(0, 500)");
	   
	   
		Thread.sleep(3000);

        // Give the page some time to load content and scroll further if needed
        try {
            Thread.sleep(2000); // You can adjust the sleep duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	   WebElement submit=driver.findElement(By.id("submit-button"));
	   a.moveToElement(submit).click().build().perform();
	
	}
	   
	

	@Then("the user clicks view order")
	public void the_user_clicks_view_order() throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary me-4'][2]")).click();
	}

	@Then("the user will navigate to the order")
	public void the_user_will_navigate_to_the_order() {
        WebElement petEnteredElement = driver.findElement(By.id("order-station-state"));
        String extractedText = petEnteredElement.getText();
        assertEquals("Pet Entered", extractedText);
	}
	


}