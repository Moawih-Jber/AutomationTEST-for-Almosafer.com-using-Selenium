import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.io.FileSystemUtils;
import org.bouncycastle.asn1.cmp.Challenge.Rand;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class myTestCases {
	String[] myWebsite = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
	Random rand = new Random();
	int randomnumber = rand.nextInt(myWebsite.length);
//	String url = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();

	@BeforeTest
	public void Beforetest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();
//		driver.get(url);
		driver.get(myWebsite[randomnumber]);

		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div/button[1]")).click();
	}

	@Test(enabled = false)
	public void Checkthelanguge() {
		String lang = driver.findElement(By.tagName("html")).getAttribute("lang");
		System.out.println(lang);
		Assert.assertEquals(lang, "en");

	}

	@Test(enabled = false)
	public void ChecktheCurrency() {

		WebElement currency = driver.findElement(By.xpath("//button[normalize-space()='SAR']"));
		String currencyst = currency.getText();
		System.out.println(currency);
//		 بتعمل عمل ال if هون بتاكد اذا القيمة الموجودة مطابقة للي انا متوقعها
		Assert.assertEquals(currencyst, "SAR");

	}

	@Test(enabled = false)
	public void ChecktheNumber() {
		String Actualnumber = driver.findElement(By.xpath("//strong[normalize-space()='+966554400000']")).getText();
		String ExpectedNumber = "+966554400000";
		System.out.println(Actualnumber);
		Assert.assertEquals(Actualnumber, ExpectedNumber);

	}

	@Test(enabled = false)
	public void QitafLogo() {
		WebElement Footer = driver.findElement(By.tagName("footer"));
		boolean isdisplayed = Footer.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']")).isDisplayed();
		Assert.assertEquals(isdisplayed, true);
	}

	@Test(enabled = false)
	public void checkHotleIsNotSelected() {
		WebElement hotel = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String actualvalue = hotel.getAttribute("aria-selected");
		Assert.assertEquals(actualvalue, "false");
	}

	@Test(invocationCount = 5, enabled = false)
	public void CheckRandomLanguage() throws InterruptedException {
		String[] myWebsite = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
		Random rand = new Random();
		int randomnumber = rand.nextInt(myWebsite.length);
		driver.get(myWebsite[randomnumber]);
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		// if (URL.equals(https://www.almosafer.com/ar)) طريقة اخرى
		if (URL.contains("ar")) {
			String lang = driver.findElement(By.tagName("html")).getAttribute("lang");
			System.out.println(lang);
			Assert.assertEquals(lang, "ar");
		} else if (URL.contains("en")) {
			String lang = driver.findElement(By.tagName("html")).getAttribute("lang");
			System.out.println(lang);

			Assert.assertEquals(lang, "en");
		}
	}

	@Test(enabled = false)
	public void dateonthewebsite_AR() {
//		String[] myWebsite = { "https://www.almosafer.com/en", "https://www.almosafer.com/en" };
//		Random rand = new Random();
//		int randomnumber = rand.nextInt(myWebsite.length);
//		driver.get(myWebsite[randomnumber]);

		// هون بجيب التاريخ كامل وبزيد عليه 1 او 2
//		LocalDate expecteddepaturedate = LocalDate.now().plusDays(1);
//		LocalDate expectedreturndate = LocalDate.now().plusDays(2);
		// هون بجيب اليوم فقط
//		int Expecteddepaturedate = expecteddepaturedate.getDayOfMonth();
//		int Expectedreturndate = expectedreturndate.getDayOfMonth();
		// هاي نفس الي فوق بس بطريقة مختلف
		LocalDate today = LocalDate.now();
		int expecteddepaturedate = today.plusDays(1).getDayOfMonth();
		int expectedreturndate = today.plusDays(2).getDayOfMonth();
		// هون بجيب التاريخ من الويب سايت
		WebElement ActualDepature = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE gmaGJq'] span[class='sc-cPuPxo dVqOVe']"));
		WebElement ActualReturn = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP bkqiMc'] span[class='sc-cPuPxo dVqOVe']"));

		softassert.assertEquals(Integer.parseInt(ActualDepature.getText()), expecteddepaturedate);
		softassert.assertEquals(Integer.parseInt(ActualReturn.getText()), expectedreturndate);
		softassert.assertAll();
	}

	@Test(enabled = false)
	public void dateonthewebsite_EN() {
		LocalDate today = LocalDate.now();
		int expecteddepaturedate = today.plusDays(1).getDayOfMonth();
		int expectedreturndate = today.plusDays(2).getDayOfMonth();

		WebElement ActualDepature = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"));
		WebElement ActualReturn = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"));

		softassert.assertEquals(Integer.parseInt(ActualDepature.getText()), expecteddepaturedate);
		softassert.assertEquals(Integer.parseInt(ActualReturn.getText()), expectedreturndate);
		softassert.assertAll();
	}

	@Test(enabled = false)

	public void CheckTheDateOfTheWebSite() {

//		
//		System.out.println(today);
//		System.out.println(today.plusDays(2));
//		System.out.println(today.plusDays(28));

		LocalDate today = LocalDate.now();
//
//		System.out.println(today);
//
//		System.out.println(today.getDayOfWeek().plus(1).getDisplayName(TextStyle.FULL, Locale.ENGLISH));

		// Actual Values on the Website
		String ActualNameMonth = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-hvvHee cuAEQj']"))
				.getText();
		int ActualDayAsNumber = Integer.parseInt(driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"))
				.getText());
		String ActualNameOftheDay = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-eSePXt ljMnJa']"))
				.getText();

// expected Values that i am as qa expected 
		String ExpectedNameMonth = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int ExpectedDayAsNumber = today.plusDays(1).getDayOfMonth();

		String ExpectedNameOftheDay = today.plusDays(1).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

		Assert.assertEquals(ActualNameMonth, ExpectedNameMonth);
		Assert.assertEquals(ActualDayAsNumber, ExpectedDayAsNumber);
		Assert.assertEquals(ActualNameOftheDay, ExpectedNameOftheDay);

	}

	@Test()
	public void chickToTheSearchHotel() throws InterruptedException {

		Random rand = new Random();

		String[] hotalnameAR = { "جدة", "دبي" };
		String[] hotalnameEN = { "dubai", "jaddah", "riyadh" };

		int randomAR = rand.nextInt(hotalnameAR.length);
		int randomEN = rand.nextInt(hotalnameEN.length);

		WebElement Hotel = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		Hotel.click();
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.className("phbroq-2"));
		if (driver.getCurrentUrl().contains("ar")) {

			search.sendKeys(hotalnameAR[randomAR]);
			WebElement results = driver.findElement(By.className("phbroq-4"));
			Thread.sleep(1000);

			List<WebElement> Listitem = results.findElements(By.tagName("li"));
			Thread.sleep(1000);

			for (int i = 0; i < Listitem.size(); i++) {
				Listitem.get(1).click();
				WebElement searchclick = driver.findElement(
						By.cssSelector(".sc-dxgOiQ.hTjMfW.sc-1vkdpp9-2.kxpSys.HotelSearchBox__SearchButton.col-md-2"));
				searchclick.click();
				Thread.sleep(11000);
				WebElement select = driver.findElement(By.xpath("//select[@class='sc-dDojKJ kgmORR']"));
				Select selector = new Select(select);
				selector.selectByIndex(rand.nextInt(2));

				String foundd = driver
						.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount'")).getText();
				Assert.assertEquals(foundd.contains("وجدنا"), true);

			}
		} else {
			search.sendKeys(hotalnameEN[randomEN]);
			WebElement results = driver.findElement(By.className("phbroq-4"));
			Thread.sleep(1000);

			List<WebElement> Listitem = results.findElements(By.tagName("li"));
			Thread.sleep(1000);

			for (int i = 0; i < Listitem.size(); i++) {
				Listitem.get(1).click();
				WebElement searchclick = driver.findElement(By.cssSelector(
						".sc-jTzLTM.hQpNle.sc-1vkdpp9-6.iKBWgG.js-HotelSearchBox__SearchButton.btn.btn-primary.btn-block"));
				searchclick.click();
				Thread.sleep(11000);
				WebElement select = driver.findElement(By.xpath("//select[@class='sc-dDojKJ kgmORR']"));
				Select selector = new Select(select);
				selector.selectByIndex(rand.nextInt(2));
				String foundd = driver
						.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount'")).getText();
				Assert.assertEquals(foundd.contains("found"), true);

			}

		}
		WebElement rightSection = driver.findElement(By.xpath("//div[@class='sc-htpNat KtFsv col-9']"));
		List<WebElement> Prices = rightSection.findElements(By.className("Price__Value"));

		int LowestPrice = 0;
		int HighestPrice = 0;

		for (int i = 0; i < Prices.size(); i++) {

			LowestPrice = Integer.parseInt(Prices.get(0).getText());
			HighestPrice = Integer.parseInt(Prices.get(Prices.size() - 1).getText());

			Assert.assertEquals(LowestPrice < HighestPrice, true);

		}
		System.out.println(LowestPrice + " this is the lowest price ");
		System.out.println(HighestPrice + " this is the highest price ");

	}

	@AfterTest
	public void Aftertest() {

	}
}
