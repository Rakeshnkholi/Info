package com.sunmob.testdata;

import org.testng.annotations.DataProvider;

public class Testingdata 
{
	@DataProvider(name="checkoutData")
	public Object[][] getcheckoutData() {
	    return new Object[][] {
	        {"Rakesh", "Nayak", "560067"},  // Change 560067 to "560067"
	        {"Mouna", "Nayak", "560049"},
	        {"MoRak", "Nair", "570026"}
	    };
	

	}
}
