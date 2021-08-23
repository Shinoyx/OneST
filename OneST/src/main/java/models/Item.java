package models;

import com.google.gson.annotations.SerializedName;

public class Item {
	@SerializedName("update_timestamp")
	String update_timestamp;
	@SerializedName("timestamp")
	String timestamp;
	@SerializedName("valid_period")
	ValidPeriod valid_period;
	@SerializedName("forecasts")
	Forecast[] forecast_data;

	public String getUpdate_timestamp() {
		return update_timestamp;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public ValidPeriod getValid_period() {
		return valid_period;
	}

	public Forecast[] getForecast_data() {
		return forecast_data;
	}
}
