package models;

import com.google.gson.annotations.SerializedName;

public class API {
	@SerializedName("status")
	String api_info;

	public String getApi_info() {
		return api_info;
	}
}
