package core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.BeforeClass;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import net.sf.testng.databinding.TestInput;
import org.testng.annotations.*;
import net.sf.testng.databinding.DataBinding;

public class DBTest {
		WebDriver driver;
		@BeforeClass
		public void browserOpen() throws InterruptedException {driver = new FirefoxDriver();}
		@DataBinding
		@Test(groups = "csv")
		  public void titleValidation
  		 (@TestInput(name = "csv_id") String id, 
		  @TestInput(name = "csv_url") String url,
		  @TestInput(name = "csv_title_expected") String title_expected)
		{
		                driver.get(url);
		                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		                String title_actual = driver.getTitle();
		  assertThat(title_actual, is(title_expected));
		  }
	        @AfterClass
	        public void browserQuit() throws InterruptedException {driver.quit();}
  }

