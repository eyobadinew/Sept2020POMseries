package com.qa.tutorialsninja.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
 // naming convention for constants is All CAPITAL LETTER with underscore
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String ACCOUNTS_PAGE_HEADER = "Your Store";
	public static final int ACCOUNT_SECTIONS = 4;
	public static List<String> getAccountSectionsList() {
		List<String> accountList = new ArrayList<>();
		accountList.add("My Account");
		accountList.add("My Orders");
		accountList.add("My Affiliate Account");
		accountList.add("Newsletter");
		return accountList;
	}
}
