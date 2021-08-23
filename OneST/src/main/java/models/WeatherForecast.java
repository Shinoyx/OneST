package models;

import com.google.gson.annotations.SerializedName;

public class WeatherForecast {

	@SerializedName("area_metadata")
	Area[] area_data;
	@SerializedName("items")
	Item[] item_data;
	@SerializedName("api_info")
	API api_info;

	public Area[] getArea_data() {
		return area_data;
	}

	public Item[] getItem_data() {
		return item_data;
	}

	public API getApi_info() {
		return api_info;
	}
}
