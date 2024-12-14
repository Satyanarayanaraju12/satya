package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import setUp.setup;

public class HighLightElement extends setup {
	
	// Method for Highlighting the Webelements
		public static void highlightElement(WebElement element) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);

		}

}
