package takeAlotTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import frameWorkClasses.ReadExcel;
import pageObjectsTakeAlot.BasePageTakeAlot;
import pageObjectsTakeAlot.CartPage;
import pageObjectsTakeAlot.CheckoutPage;
import pageObjectsTakeAlot.LandingPage;
import pageObjectsTakeAlot.LoginPage;
import pageObjectsTakeAlot.WishListPage;

public class TestsTakeAlot {
	
	//Instantiate the Landing Page
	LandingPage lndPge = new LandingPage();
	
	//Instantiate the Login Page
	LoginPage lgnPge = new LoginPage();
	
	//Instantiate the Checkout Page
	CheckoutPage chktPge = new CheckoutPage();
	
	//Instantiate the Cart Page
	CartPage cartPge = new CartPage();
	
	//Instantiate the Cart Page
	BasePageTakeAlot basePageTA = new BasePageTakeAlot();
	
	WishListPage wishListPage = new WishListPage(); 
	
	SoftAssert softAssertion = new SoftAssert();
	
	ReadExcel readExcel = new ReadExcel();
	
	@BeforeTest
	public void clickCookiesButton() {
		lndPge.clickCookiesButton();
		//lndPge.closeChildBrowserTab();
	}
	@AfterTest
	public void closeBrowser() {
//		if(lndPge.isChildBrowser()==true) {
//		lndPge.closeChildBrowserTab();
//		
//		}
		
	}

	@Test
	public void GIVEN_shopperIsOnLandingPage_WHEN_shopperEntersBootsasSearchString_AND_shopperClicksTheSearchButton_THEN_Boots() {
		String searchInput = "boots";
		basePageTA.goHome();
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar(searchInput);
		lndPge.clickSearchButton();
		//System.out.println("Test passed " + lndPge.checkElementTextOfFirstItem());
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//lndPge.quizPopUp();
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		lndPge.clickElementTextOfFirstItem();
		lndPge.switchToNewTab();
		//String itemText = lndPge.getElementText(By.className("brand-link"));
		String itemText = lndPge.getElementText(By.cssSelector("h1"));
		Reporter.log("1 Expected value: " +searchInput + ". But got " + itemText);
		System.out.println(itemText);
		//Assert.assertEquals("forceFail", itemText);
		if(itemText.contains("Boot")) {
		Assert.assertTrue(itemText.contains("Boot"));
		Reporter.log("2 Expected value: " +searchInput + ". But got " + itemText);
		Assert.assertTrue(itemText.contains("Boot"));
		softAssertion.assertEquals(searchInput, itemText);
		Reporter.log("3 Expected value: " +searchInput + ". But got " + itemText);
		}
		Assert.assertTrue(itemText.contains("Boot"));
		Reporter.log("4 Expected value: " +searchInput + ". But got " + itemText);
		Assert.assertTrue(itemText.contains("Boot"));
		softAssertion.assertTrue(itemText.contains("fail"));
		lndPge.closeChildBrowserTab();
		//softAssertion.assertAll(); // This will make testng report on soft asserts, basicicly making it a hard assert
		//lndPge.switchToParent();
	/*2
	* GIVEN the shopper is on the landing page
	* WHEN he enters "DKNY" as the search string
	* WHEN clicks the search button
	* THEN "DKNY" is displayed as the first item in the grid
	* WHEN going to home page
	*/
		
	}
	
	@Test
	public void GIVEN_shopperIsOnLandingPage_WHEN_shopperEntersDKNUasSearchString_AND_shopperClicksTheSearchButton_THEN_DKNYBeDelicious() {
		String searchInput = "DKNY";
		basePageTA.goHome();
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar(searchInput);
		lndPge.clickSearchButton();
		lndPge.clickElementTextOfFirstItem();
		lndPge.switchToNewTab();
		String itemText = lndPge.getElementText(By.className("brand-link"));
		Reporter.log("1 Expected value: " +searchInput + ". But got " + itemText);
		System.out.println(itemText);
		Assert.assertEquals("DKNY", itemText);
		lndPge.closeChildBrowserTab();
		
		
		
	}
	
	@Test 
	 public void GIVEN_ShopperOnLandingPage_WHEN_selectDailyDeals_THEN_DailyScreenOpen_AND_PhillipsAirfryerFirstItemDislayed() {
		
		//  GIVEN
		//		Given the shopper is on the Landing page
		//	WHEN
		//		He selects daily deals
		//	THEN
		//		The Daily deals URL
		//	AND
		//		First displayed item is Phillips XXL Airfryer
		//
		//	GIVEN_ShopperOnLandingPage_WHEN_selectDailyDeals_THEN_DailyScreenOpen_AND_PhillipsAirfryerFirstItemDislayed(){
		//	landPG.checkLandingPageNavigation();
		//	landPG.selectItem(“DailyDeals”);
		//	dealsPG.checkURL(“Takealot/deals”);
		//	dealsPG.checkFirstItem(“PhillipAirFryer”);

	}
	
	@Test
	public void GIVEN_ShopperOnDKNYProduct_THEN_AddToCart() {
		String searchInput = "DKNY";
		basePageTA.goHome();
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar(searchInput);
		lndPge.clickSearchButton();
		lndPge.clickElementTextOfFirstItem();
		lndPge.switchToNewTab();
		String itemText = lndPge.getElementText(By.className("brand-link"));
		Reporter.log("1 Expected value: " +searchInput + ". But got " + itemText);
		System.out.println(itemText);
		Assert.assertEquals("DKNY", itemText);
		lndPge.addToCart();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lndPge.GoToCart();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(cartPge.getCounter(), 1);
		//System.out.println(cartPge.getUnitPrice());
		
		lndPge.closeChildBrowserTab();
	}
	
	@Test
	public void GIVEN_ShopperOnProduct_WHEN_AddToWishList_THEN_ProductAddedToWishList() {
		String searchInput = "UPS";
		basePageTA.goHome();
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar(searchInput);
		lndPge.clickSearchButton();
		lndPge.clickElementTextOfFirstItem();
		lndPge.switchToNewTab();
		lndPge.addToWishList();
		lndPge.clickWishListView();
		Reporter.log("1 Expected value: " +searchInput + ". But got " + wishListPage.productOnWishList());
		Assert.assertTrue(wishListPage.productOnWishList().contains("UPS"));
		lndPge.closeChildBrowserTab();
		
	}
	@Test(dataProvider = "Search Input List" )
	public void UseDataProvider(String searchInput,String cartNum) {
		basePageTA.goHome();
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar(searchInput);
		lndPge.clickSearchButton();
		lndPge.clickElementTextOfFirstItem();
		lndPge.switchToNewTab();
		lndPge.addToCart();
		lndPge.GoToCart();
		Assert.assertEquals(cartPge.getCounter(), Integer.parseInt(cartNum));
		lndPge.closeChildBrowserTab();
	}
	
	@DataProvider(name = "Search Input List")
	public Object[][] getDataFromExcel(){
		String excelDirectory = readExcel.getDataConfigProperties("excelDataDir");
		Object[][] errObj = readExcel.getExcelData(excelDirectory + "SearchList.xlsx","sheet1");
		return errObj;
		
	}
	
}
