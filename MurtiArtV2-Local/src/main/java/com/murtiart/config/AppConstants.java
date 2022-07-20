package com.murtiart.config;

public class AppConstants {
	
	public static final String PAGE_NUMBER = "0";
	public static final String PAGE_SIZE = "10";
	public static final String SORT_BY = "productid";
	public static final String SORT_DIR = "asc";
	public static final String CAT_ID = "-1";
	public static final String USER_ID = "-1";
	public static final String SEARCH = "false";
	
	public static final String SHOPKEEPER_SORT_BY = "userid";
	public static final String SHOPKEEPER_DEFAULT_USER = "2";
	
	public static final String FAVOURITE_SORT_BY = "favouriteid";
	public static final String FAVOURITE_DEFAULT_USER = "2";
	
	// Role IDS
	public static final Integer ADMIN_ROLE = 1;
	public static final String ADMIN = "ADMIN";
	
	public static final Integer SHOPKEEPER_ROLE = 2;
	public static final String SHOPKEEPER = "SHOPKEEPER";
	
	public static final Integer CUSTOMER_ROLE = 3;
	public static final String CUSTOMER = "CUSTOMER";
	
	public static final String DEFAULT = "0";
	
	// Appka remote controler
	public static final Integer APPKAREMOTE_ID = 1;
	public static final String APPKAREMOTE_MESSAGE= "Sample Message";
	public static final Boolean APPKAREMOTE_FORCEUPDATE = false;
	public static final Boolean APPKAREMOTE_FREEZ = false;
	public static final String APPKAREMOTE_URLMAKER = "image url base path";
	public static final String APPKAREMOTE_NODATAPLACEHOLDER = "place holder image";
	public static final String APPKAREMOTE_CURRENCY = "INR";
	public static final Long APPKAREMOTE_SUPPORT = 8097885917L;
	
	//About Us
	public static final Integer ABOUTUS_ID1 = 1;
	public static final  String ABOUTUS_TYPE1 = "HEADER";
	public static final  String ABOUTUS_NAME1 = "";
	public static final  String ABOUTUS_EMAIL1 ="";
	public static final  String ABOUTUS_DESCRIPTION1 = "<!DOCTYPE html> <html> <head> </head> <body>  <h1>Welcome to Murti Art!</h1> <p>We're dedicated to giving you the best showcase of Murti Arts from your local murti shops and other sources, with a focus on virtually visualize \"Murti\" at any where before visting your local Shop!.</p>  <p>Founded in 2020 by \"KK\", Murti Art has come a long way from its beginnings in a Home Office. When All store found at your local area.</p>    <p>We hope you enjoy our application as much as we enjoy offering them to you. If you have any questions or comments, please don't hesitate to contact us.</p>  <p>Sincerely, <br> Kirtikumar Dilip Giripunje <br> Founder</p>  </body> </html>";
	public static final  Long ABOUTUS_PHONE1 = 0L;
	public static final  String ABOUTUS_GENDER1 = "";
	public static final  Boolean ABOUTUS_REMOVE1 = false;
	public static final  String ABOUTUS_IMAGE1 =  "";
	
	
	public static final Integer ABOUTUS_ID2 = 2;
	public static final  String ABOUTUS_TYPE2 = "PERSON";
	public static final  String ABOUTUS_NAME2 = "Kirtikumar Dilip Giripunje";
	public static final  String ABOUTUS_EMAIL2 ="nworldcapture2015@gmail.com";
	public static final  String ABOUTUS_DESCRIPTION2 = "";
	public static final  Long ABOUTUS_PHONE2 = 8097885917L;
	public static final  String ABOUTUS_GENDER2 = "M";
	public static final  Boolean ABOUTUS_REMOVE2 = false;
	public static final  String ABOUTUS_IMAGE2 =  "";
	
	
	/**
	 * How To Use
	 */
	
	private static final  String HOW_TO_USE_TYPE1 = "Manage Registration"; // login, registration, click on role to go inside
	private static final  String HOW_TO_USE_TYPE2 = "Manage Application"; // home screen information, product list, detail screen
	private static final  String HOW_TO_USE_TYPE3= "Manage Favorite"; // Home screen to Product Detail Screen, Show fav product present in list
	private static final  String HOW_TO_USE_TYPE4 = "Manage QR"; // Scan normal product and navigate to that product, Scan Fav product and shopkeeper get that product where it is. Show QR code of normal product
	private static final  String HOW_TO_USE_TYPE5 = "Manage Setting"; // setting screen, manage address, manage profile, manage update, manage support, 
	private static final  String HOW_TO_USE_TYPE6 = "Manage Product";
	
	
	// Login
	public static final Integer ID1_1 = 1;
	public static final String TYPE1_1 = HOW_TO_USE_TYPE1;
	public static final String LINK1_1 = "-";
	public static final String TITLE1_1 = "Application Login";
	public static final String DESCRIPTION1_1 = "This is help to login in the system.";
	public static final String THUMBNAIL1_1 ="";
	public static final Boolean REMOVE1_1 = false;
	public static final Boolean SHOW1_1 = true;
	
	// Registration
	public static final Integer ID2_1 = 2;
	public static final String TYPE2_1 = HOW_TO_USE_TYPE1;
	public static final String LINK2_1 = "-";
	public static final String TITLE2_1 = "Application Registration";
	public static final String DESCRIPTION2_1 = "This is help to register in the system.";
	public static final String THUMBNAIL2_1 ="";
	public static final Boolean REMOVE2_1 = false;
	public static final Boolean SHOW2_1 = true;
	
	// Role Selection at login
	public static final Integer ID3_1 = 3;
	public static final String TYPE3_1 = HOW_TO_USE_TYPE1;
	public static final String LINK3_1 = "-";
	public static final String TITLE3_1 = "Role Selection";
	public static final String DESCRIPTION3_1 = "This is help to choose role and navigate into the system.";
	public static final String THUMBNAIL3_1 ="";
	public static final Boolean REMOVE3_1 = false;
	public static final Boolean SHOW3_1 = true;
	
	
	/////////////////////////
	
	// home screen information
	public static final Integer ID1_2 = 4;
	public static final String TYPE1_2 = HOW_TO_USE_TYPE2;
	public static final String LINK1_2 = "-";
	public static final String TITLE1_2 = "Home Information";
	public static final String DESCRIPTION1_2 = "This is help to give more infromation about home screen.";
	public static final String THUMBNAIL1_2 ="";
	public static final Boolean REMOVE1_2 = false;
	public static final Boolean SHOW1_2 = false;
	
	// product list 
	public static final Integer ID2_2 = 5;
	public static final String TYPE2_2 = HOW_TO_USE_TYPE2;
	public static final String LINK2_2 = "-";
	public static final String TITLE2_2 = "List Infromation";
	public static final String DESCRIPTION2_2 = "This is help to give more infromation about listing screen.";
	public static final String THUMBNAIL2_2 ="";
	public static final Boolean REMOVE2_2 = false;
	public static final Boolean SHOW2_2 = false;
	
	// Detail screen
	public static final Integer ID3_2 = 6;
	public static final String TYPE3_2 = HOW_TO_USE_TYPE2;
	public static final String LINK3_2 = "-";
	public static final String TITLE3_2 = "Detail Information";
	public static final String DESCRIPTION3_2 = "This is help to give more infromation about detail screen.";
	public static final String THUMBNAIL3_2 ="";
	public static final Boolean REMOVE3_2 = false;
	public static final Boolean SHOW3_2 = false;
	
	////////////////////
	

	// How to add to fav show from Home screen to Product Detail Screen 
	public static final Integer ID1_3 = 7;
	public static final String TYPE1_3 = HOW_TO_USE_TYPE3;
	public static final String LINK1_3 = "-";
	public static final String TITLE1_3 = "To Know More About Application";
	public static final String DESCRIPTION1_3 = "This is help to give more infromation about application navigation.";
	public static final String THUMBNAIL1_3 ="";
	public static final Boolean REMOVE1_3 = false;
	public static final Boolean SHOW1_3 = false;
	

	// Show fav product present in list
	public static final Integer ID2_3 = 8;
	public static final String TYPE2_3 = HOW_TO_USE_TYPE3;
	public static final String LINK2_3 = "-";
	public static final String TITLE2_3 = "Manage Favourites";
	public static final String DESCRIPTION2_3 = "This is help to give more infromation about favourite screen.";
	public static final String THUMBNAIL2_3 ="";
	public static final Boolean REMOVE2_3 = false;
	public static final Boolean SHOW2_3 = false;
	
	///////////////////
	

	// Scan normal product and navigate to that product
	public static final Integer ID1_4 = 9;
	public static final String TYPE1_4 = HOW_TO_USE_TYPE4;
	public static final String LINK1_4 = "-";
	public static final String TITLE1_4 = "Search using QR code";
	public static final String DESCRIPTION1_4 = "This is help to search using qr code.";
	public static final String THUMBNAIL1_4 ="";
	public static final Boolean REMOVE1_4 = false;
	public static final Boolean SHOW1_4 = false;
	

	//  Scan favourite product and shopkeeper get that product where it is.
	public static final Integer ID2_4 = 10;
	public static final String TYPE2_4 = HOW_TO_USE_TYPE4;
	public static final String LINK2_4 = "-";
	public static final String TITLE2_4 = "To Know More About Application";
	public static final String DESCRIPTION2_4 = "This is help to shopkeeper that using qr code scan get the customer favourite";
	public static final String THUMBNAIL2_4 ="";
	public static final Boolean REMOVE2_4 = false;
	public static final Boolean SHOW2_4 = false;
	
	// Show QR code of normal product
	public static final Integer ID3_4 = 11;
	public static final String TYPE3_4 = HOW_TO_USE_TYPE4;
	public static final String LINK3_4 = "-";
	public static final String TITLE3_4 = "How to use QR Code scanner?";
	public static final String DESCRIPTION3_4 = "This is help to how to use qr scanner in the application.";
	public static final String THUMBNAIL3_4 ="";
	public static final Boolean REMOVE3_4 = false;
	public static final Boolean SHOW3_4 = false;
	
	///////////////

	// setting screen
	public static final Integer ID1_5 = 12;
	public static final String TYPE1_5 = HOW_TO_USE_TYPE5;
	public static final String LINK1_5 = "-";
	public static final String TITLE1_5 = "Application Setting";
	public static final String DESCRIPTION1_5 = "This is help to know application setting.";
	public static final String THUMBNAIL1_5 ="";
	public static final Boolean REMOVE1_5 = false;
	public static final Boolean SHOW1_5 = false;
	
	//  manage address
	public static final Integer ID2_5 = 13;
	public static final String TYPE2_5 = HOW_TO_USE_TYPE5;
	public static final String LINK2_5 = "-";
	public static final String TITLE2_5 = "Manage Address";
	public static final String DESCRIPTION2_5 = "This is help to manage address in the application.";
	public static final String THUMBNAIL2_5 ="";
	public static final Boolean REMOVE2_5 = false;
	public static final Boolean SHOW2_5 = false;
	
	// manage profile
	public static final Integer ID3_5 = 14;
	public static final String TYPE3_5 = HOW_TO_USE_TYPE5;
	public static final String LINK3_5 = "-";
	public static final String TITLE3_5 = "Manage Profile";
	public static final String DESCRIPTION3_5 = "This is help to manage profile in the application.";
	public static final String THUMBNAIL3_5 ="";
	public static final Boolean REMOVE3_5 = false;
	public static final Boolean SHOW3_5 = false;
	
	// manage update,
	public static final Integer ID4_5 = 15;
	public static final String TYPE4_5 = HOW_TO_USE_TYPE5;
	public static final String LINK4_5 = "-";
	public static final String TITLE4_5 = "Manage Updates";
	public static final String DESCRIPTION4_5 = "This is help to mnage your application upto date.";
	public static final String THUMBNAIL4_5 ="";
	public static final Boolean REMOVE4_5 = false;
	public static final Boolean SHOW4_5 = false;
	
	// manage support,
	public static final Integer ID5_5 = 16;
	public static final String TYPE5_5 = HOW_TO_USE_TYPE5;
	public static final String LINK5_5 = "-";
	public static final String TITLE5_5 = "Contact Support";
	public static final String DESCRIPTION5_5 = "This is help to give infromation about support team";
	public static final String THUMBNAIL5_5 ="";
	public static final Boolean REMOVE5_5 = false;
	public static final Boolean SHOW5_5 = false;
	
	
	// Product Add
	public static final Integer ID1_6 = 17;
	public static final String TYPE1_6 = HOW_TO_USE_TYPE6;
	public static final String LINK1_6 = "-";
	public static final String TITLE1_6 = "Create Entery";
	public static final String DESCRIPTION1_6 = "This is help to create the entery of the any cateogry in system.";
	public static final String THUMBNAIL1_6 ="";
	public static final Boolean REMOVE1_6 = false;
	public static final Boolean SHOW1_6 = false;
 
	// Variant Add
	public static final Integer ID2_6 = 18;
	public static final String TYPE2_6 = HOW_TO_USE_TYPE6;
	public static final String LINK2_6 = "-";
	public static final String TITLE2_6 = "Create Variation";
	public static final String DESCRIPTION2_6 = "This is help to create the variation of any entery in system.";
	public static final String THUMBNAIL2_6 ="";
	public static final Boolean REMOVE2_6 = false;
	public static final Boolean SHOW2_6 = false;
	
	// Attribute Add
	public static final Integer ID3_6 = 19;
	public static final String TYPE3_6 = HOW_TO_USE_TYPE6;
	public static final String LINK3_6 = "-";
	public static final String TITLE3_6 = "Create Attribute or Features";
	public static final String DESCRIPTION3_6 = "This is help to create the attribute of variation in system.";
	public static final String THUMBNAIL3_6 ="";
	public static final Boolean REMOVE3_6 = false;
	public static final Boolean SHOW3_6 = false;
	
	// Images Add
	public static final Integer ID4_6 = 20;
	public static final String TYPE4_6 = HOW_TO_USE_TYPE6;
	public static final String LINK4_6 = "-";
	public static final String TITLE4_6 = "Create Attribute or Features";
	public static final String DESCRIPTION4_6 = "This is help to create the attribute of variation in system.";
	public static final String THUMBNAIL4_6 ="";
	public static final Boolean REMOVE4_6 = false;
	public static final Boolean SHOW4_6 = false;
	
	// Product Edit
	public static final Integer ID5_6 = 21;
	public static final String TYPE5_6 = HOW_TO_USE_TYPE6;
	public static final String LINK5_6 = "-";
	public static final String TITLE5_6 = "Update Entery";
	public static final String DESCRIPTION5_6 = "This is help to edit the entery of the any cateogry in system.";
	public static final String THUMBNAIL5_6 ="";
	public static final Boolean REMOVE5_6 = false;
	public static final Boolean SHOW5_6 = false;
 
	// Variant Edit
	public static final Integer ID6_6 = 22;
	public static final String TYPE6_6 = HOW_TO_USE_TYPE6;
	public static final String LINK6_6 = "-";
	public static final String TITLE6_6 = "Update Variation";
	public static final String DESCRIPTION6_6 = "This is help to edit the variation of any entery in system.";
	public static final String THUMBNAIL6_6 ="";
	public static final Boolean REMOVE6_6 = false;
	public static final Boolean SHOW6_6 = false;
	
	// Attribute Edit
	public static final Integer ID7_6 = 23;
	public static final String TYPE7_6 = HOW_TO_USE_TYPE6;
	public static final String LINK7_6 = "-";
	public static final String TITLE7_6 = "Update Attribute or Features";
	public static final String DESCRIPTION7_6 = "This is help to edit the attribute of variation in system.";
	public static final String THUMBNAIL7_6 ="";
	public static final Boolean REMOVE7_6 = false;
	public static final Boolean SHOW7_6 = false;
	
	// Images Edit
	public static final Integer ID8_6 = 24;
	public static final String TYPE8_6 = HOW_TO_USE_TYPE6;
	public static final String LINK8_6 = "-";
	public static final String TITLE8_6 = "Update Attribute or Features";
	public static final String DESCRIPTION8_6 = "This is help to edit the attribute of variation in system.";
	public static final String THUMBNAIL8_6 ="";
	public static final Boolean REMOVE8_6 = false;
	public static final Boolean SHOW8_6 = false;
	
		
}
