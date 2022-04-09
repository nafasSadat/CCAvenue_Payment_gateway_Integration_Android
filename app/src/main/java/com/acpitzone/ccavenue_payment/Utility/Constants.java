package com.acpitzone.ccavenue_payment.Utility;

public class Constants {
	public static final String PARAMETER_SEP = "&";
	public static final String PARAMETER_EQUALS = "=";
	public static final String TRANS_URL = "https://secure.ccavenue.com/transaction/initTrans";


	public static final String access_code = "4YRUXLSRO20O8NIH"; // add your access_code
	public static final String merchantId= "2"; // add your merchant_id
	public static final String currency="INR";
	public static final String redirectUrl="http://122.182.6.216/merchant/ccavResponseHandler.jsp"; //this is test url you can modify with your on url, you can use php or jsp, 
	public static final String cancelUrl="http://122.182.6.216/merchant/ccavResponseHandler.jsp"; //this is test url you can modify with your on url
	public static final String rsaKeyUrl="https://secure.ccavenue.com/transaction/jsp/GetRSA.jsp"; //this is test url you can modify with your on url

}
