package models;

import com.google.gson.annotations.SerializedName;

public class Forecast {
	@SerializedName("area")
	String areaname;

	@SerializedName("forecast")
	String forecast;

	public String getAreaname() {
		return areaname;
	}

	public String getForecast() {
		return forecast;
	}
}
