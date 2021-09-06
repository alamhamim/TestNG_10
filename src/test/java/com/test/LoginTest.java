package com.test;

import org.testng.annotations.Test;

import com.excelDataProvider.ExcelDataProvider;
import com.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	public void loginTest(String username, String password) {
		loginPage = new LoginPage(driver);

		loginPage.inputLoginInfo(username, password);

	}

}
