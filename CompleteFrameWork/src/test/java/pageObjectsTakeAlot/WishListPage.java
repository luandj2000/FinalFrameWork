package pageObjectsTakeAlot;


import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class WishListPage extends BasePage {

public String productOnWishList() {
	String productText =  getElementText(By.className("detail-item-module_item-title_1DTJI"));
	return productText;
}
	
}
