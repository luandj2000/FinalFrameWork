package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class CartPage extends BasePage {
	
	//Ensure shopping cart is empty
	public boolean checkEmptyCart() {
		String itemElement = "img[alt='Empty shopping cart']";
		if (driver.findElements(By.cssSelector(itemElement)).size() !=0) {
			System.out.println("Element exist");
			Reporter.log("Element exist " + itemElement);
			Reporter.log("Text is "+ getElementText(By.cssSelector(itemElement)));
			return true;
			
		}else
		{
			System.out.println("Element doesn't exist");
			Reporter.log("Element does not exist " + itemElement);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return false;
		}
	
	}
	
	public boolean checkEmptyCartWithIsDisplayed() {
		String itemElement = "img[alt='Empty shopping cart]";
		Boolean display = elementExists(By.cssSelector(itemElement));
		return display;
	}
	//Checkout 
	
	//Delete item
	public int getCounter() {
		String cartNum = 	getElementText(By.cssSelector("div.badge-button-module_badge-count_28PIS"));
		return Integer.parseInt(cartNum);
		}
		
		public int getUnitPrice() {
			String unitPriceString = getElementText(By.className("currency plus currency-module_currency_29IIm"));
			// Regex
			//String unitPrice = unitPriceString.substring(2);
			//String unitPrice = unitPriceString.replaceAll("[^0-9]",""); // ^ means negate (Don't remove those)
			String unitPrice = unitPriceString.replaceAll("[\\d]", "");
			int unitPriceInt = Integer.parseInt(unitPriceString);
			return unitPriceInt;
		}
		
		public void selectQuantity(String qunt) {
			selectDropDown(By.id("cart-item_undefined"),qunt);
		}
		
}
