package models;

import com.google.gson.annotations.SerializedName;

public class LabelLocation {
	@SerializedName("latitude")
	double lat;

	@SerializedName("longitude")
	double lon;

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}
}
