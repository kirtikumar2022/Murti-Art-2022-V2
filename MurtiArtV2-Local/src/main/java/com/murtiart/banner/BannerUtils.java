package com.murtiart.banner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.murtiart.utils.JsonKeysManageGlobally;

public class BannerUtils {

	
	@SuppressWarnings("unchecked")
	public static <T> Map<String, JSONObject>responseBuilder2(List<T> label1, List<T> label2, String moreMessage, String moreStatus) {
		
		Map<String, JSONObject> map = new HashMap<String, JSONObject>();
		
		
		// Label1 Object
		JSONObject labelJsonObject = new JSONObject();
		labelJsonObject.put(JsonKeysManageGlobally.LIST1, label1);
		labelJsonObject.put(JsonKeysManageGlobally.LIST2, label2);
		
		
		// More Object
		JSONObject moreJsonObject = new JSONObject();
		moreJsonObject.put(JsonKeysManageGlobally.MESSAGE, moreMessage);
		moreJsonObject.put(JsonKeysManageGlobally.STATUS, moreStatus);
		
		
		// Response Object
		JSONObject responseJsonObject = new JSONObject();
		responseJsonObject.put(JsonKeysManageGlobally.DATA, labelJsonObject);
		responseJsonObject.put(JsonKeysManageGlobally.MORE, moreJsonObject);
		
	 
		// Parent Object
//		JSONObject parentJsonObject = new JSONObject();
//		parentJsonObject.put(JsonKeysManageGlobally.RESPONSE, responseJsonObject);
		map.put(JsonKeysManageGlobally.RESPONSE, responseJsonObject);
		
		return map;
	}
}
