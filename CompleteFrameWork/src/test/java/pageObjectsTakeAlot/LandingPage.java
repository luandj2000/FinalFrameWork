package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage {
	private static String firstProduct = "div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV";

//	landPG.checkLandingPageNavigation();
	// landPG.selectItem(“DailyDeals”);
	// dealsPG.checkURL(“Takealot/deals”);
	// dealsPG.checkFirstItem(“PhillipAirFryer”);

	public boolean checkLandingPageNavigation() {
		return false;

	}

	public void clickSearchBar() {
		clickElement(By.cssSelector("input[name='search']"));
	}

	public void clickSearchButton() {
		clickElement(By.cssSelector("button[type='submit']"));
	}

	public void enterTextInSearchBar(String searchText) {
		enterText(By.name("search"), searchText);

	}

	public String checkElementTextOfFirstItem() {
		String text1 = getElementText(By.cssSelector(firstProduct));
		return text1;
	}

	public void clickElementTextOfFirstItem() {
		clickElement(By.cssSelector(firstProduct));
	}

	public boolean checkFirstItem(String checkFirstItem) {
		return false;
	}

	public void selectItem(String selectItem) {

	}

	// landPG.searchFor(“DKNY”);
	// landPG.clickOnSearch();
	// landPG.checkFirstItem(“DKNY”);

	public void searchFor(String searcFor) {

	}

	public void clickCookiesButton() {
		String cookiesButton = "button.cookies-banner-module_dismiss-button_24Z98";

		//if(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cookiesButton))!=null)
			
		//	{
		try {
				clickElement(By.cssSelector(cookiesButton));
		}catch(Exception e)
		{
			System.out.println("cookie not there");
		}
			//}
	}
	public void quizPopUp() {
		String nextButton = "_hj-3HqTJ__styles__surveyActionButton";
		//if(ExpectedConditions.visibilityOfElementLocated(By.className("_hj-2fsWS__styles__closeEndedOptionText"))!=null) {
		try {
			clickElement(By.className("_hj-2fsWS__styles__closeEndedOptionText"));
			clickElement(By.className(nextButton));
			clickElement(By.className(nextButton));
			clickElement(By.className("_hj-3Y4y-__styles__closeButton"));
		}catch(Exception e) {
			System.out.println("Survey not there");
		}
		//}
	}
	
	public void addToCart() {
		clickElement(By.cssSelector(".buybox-actions-module_add-to-cart-cell_3fXyS [data-ref]"));
		//driver.findElement(By.cssSelector(".button.buybox-actions-module_checkout-now_2iHOZ.checkout-now.dark.expanded")).click();
		
	}
	public void GoToCart() {
		clickElement(By.cssSelector(".content-wrapper .checkout-now"));
		//driver.findElement(By.cssSelector("")).click();
	}
	public void addToWishList() {
		clickElement(By.cssSelector(".button.shade-gray.wishlist-button.wishlist-split-button-module_wishlist-button_36rqk > .wishlist-split-button-module_text_E0HQC"));
	}
	public void clickWishListView() {
		clickElement(By.cssSelector(".icon-link.top-nav-module_wishlist-button_mIJ0_.wish > svg[role='presentation'] > path"));
	}
	
	
}
