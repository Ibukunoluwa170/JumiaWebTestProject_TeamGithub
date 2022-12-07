import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//TEST
//Test1: Confirm the webUrl
//Test2: Confirm the page title
//Test3: Confirm that user was redirected to the correct signIn page
//Test4: Verify that when user was redirected to the homePage after signIn
//Test5: Verify that when user logout, he/she is directed back to the homepage
//Test6: Verify that user can not sigIn with invalid Email Address
//Test7: Verify that user can not sigIn with invalid Password


public class JumiaWebTest {
    //import Jumia webdriver
    private WebDriver driver;
@BeforeTest
public void start() throws InterruptedException {
    //Step1: locate where the chrome driver is
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    //Step2: open Chrome browser
    driver = new ChromeDriver();

}
@Test(priority = 0)
public void webUrl() throws InterruptedException {
    //Step3: Open your selected app URL (https://www.jumia.com.ng)
    driver.get("https://www.jumia.com.ng/");
    //Test1: Confirm the webUrl
    if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
        //pass
        System.out.println("Correct webPage");
    else
        //fail
        System.out.println("Wrong webPage");
    //Add delay command before loading the next page
    Thread.sleep(5000);

}
@Test(priority = 1)
public void getPageTitle() throws InterruptedException {
    //Step4: Get page title
    //Test2: Confirm the page title
    String expectedTittle = "Jumia Nigeria|Online Shopping";
    String actualTitle = driver.getTitle();
    if (actualTitle.contains(expectedTittle))
        //pass
        System.out.println("correct pageTitle");
    else
        //fail
        System.out.println("wrong pageTitle");

    // Maximize the window
    driver.manage().window().maximize();
    //Added delay command before loading the next page
    Thread.sleep(5000);

}
@Test(priority = 2)
public void signIN()throws InterruptedException {
    //Step5: Click on Account to locate the sign-in button
    driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();

    //Step6: Click on the sign-in
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

    //Test3: Confirm that user was redirected to the correct signIn page
    String expectedSignInUrl = "https://my.jumia.com.ng/interaction/0_NwRHRb6rpJYrDmx836O/en-ng/sign-in/email";
    String actualSignupUrl = driver.getCurrentUrl();
    if (actualSignupUrl.contains(expectedSignInUrl))
        //pass
        System.out.println("Correct signInPage");
    else
        //fail
        System.out.println("wrong signIn Page");
    //Added delay command before loading the next page
    Thread.sleep(2000);

}
@Test(priority = 3)
public void positiveSignIn()throws InterruptedException {
    //Step7: Input your Email
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("davidadebanke@gmail.com");

    //Step8: Click on continue button
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();

    //Step9: Input your Password
    driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("banksdavid");

    //Step10: Click on login button
    driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();

    //Test4: Verify that when user was redirected to the homePage after signIn
    String expectedPageUrl = "https://www.jumia.com.ng";
    String actualPageUrl = driver.getCurrentUrl();
    if (actualPageUrl.contains(expectedPageUrl))
        //pass
        System.out.println("Correct User Account Page");
    else
        // fail
        System.out.println("Wrong User Account");
//Added delay command before loading the next page
    Thread.sleep(2000);

}
    @Test(priority = 4)
 public void LogoutSuccessfully()throws InterruptedException{
    //Step11: click on the name header label
    driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();

    //Step12: Click on logout
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();

        //Test5: Verify that when user logout, he/she is directed back to the homepage
        String expectedTittle = "Jumia Nigeria|Online Shopping";
        String actualTittle = driver.getTitle();
        if (actualTittle.contains(expectedTittle))
            //pass
            System.out.println("correct pageTitle");
        else
            //fail
            System.out.println("wrong pageTitle");
        //Added delay command before loading the next page
        Thread.sleep(2000);

}
@Test(priority = 5)
public void negativeSignInEmail() throws InterruptedException {
    driver.get("https://www.jumia.com.ng/");

    //Step1: Click on Account to locate the sign-in button
    driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();

    //Step2: Click on the sign-in
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

    //Added delay command before loading the next page
    Thread.sleep(3000);

    //Step3: Input your Email
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("1234@gmail.com");

    //Step4: Click on continue button
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();

    //Step5: Input your password
    driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("banksdavid");

    //Step6: Click on login button
    driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();

//Test6: Verify that user can not sigIn with invalid Email Address
    String expectedPageUrl = "https://my.jumia.com.ng/interaction/2TxRnEGggyznUyM6NeGYN/en-ng/sign-in";
    String actualPageUrl = driver.getCurrentUrl();
    if (driver.getCurrentUrl().contains(expectedPageUrl))
        //pass
        System.out.println("Correct webPage");
    else
        //fail
        System.out.println("Wrong webPage");
    //Added delay command before loading the next page
    Thread.sleep(3000);

}
@Test(priority = 5)
public void negativeSignInPassword() throws InterruptedException {
    driver.get("https://www.jumia.com.ng/");

    //Step1: Click on Account to locate the sign-in button
    driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();

    //Step2: Click on the sign-in
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

    Thread.sleep(3000);
    //Step3: Input your Email
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("davidadebanke@gmail.com");

    //Step4: click on continue button
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();

    //Step5: Input your password
    driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("banks");

    //Step6: Click on login button
    driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();

    //Test7: Verify that user can not sigIn with invalid Password
    String expectedPageUrl = "https://my.jumia.com.ng/interaction/SNWuOLLh_VCuQKkAO9MOJ/en-ng/sign-in";
    String actualPageUrl = driver.getCurrentUrl();
    if (driver.getCurrentUrl().contains(expectedPageUrl))
        //pass
        System.out.println("Correct webPage");
    else
        //fail
        System.out.println("Wrong webPage");
}

@AfterTest
    public void closeBrowser(){
    //quite the browser
    driver.quit();
}

}






