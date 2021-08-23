package models;

import com.google.gson.annotations.SerializedName;

public class ValidPeriod {
	@SerializedName("start")
	String start;

	@SerializedName("end")
	String end;

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}
}
