package utils;

import com.google.gson.Gson;

import domain.Account;

public class JsonUtil {

	private Gson gson;
	
	public JsonUtil() {
		
		this.gson = new Gson();
	}
	
	public String getJsonForObject(Object obj) {
		return gson.toJson(obj);
	}
	
	public Account getObjectForJson(String jSonString, Class<Account> account) {
		return gson.fromJson(jSonString, account);
	}
}
