package models;

import com.google.gson.annotations.SerializedName;

public class Area {
	@SerializedName("name")
	String name;

	@SerializedName("label_location")
	LabelLocation label_location;

	public String getName() {
		return name;
	}

	public LabelLocation getLabel_location() {
		return label_location;
	}
}
