package data;


public class CanteenInfo {

	public CanteenInfo(String mName, String phone, double mLatitude,
			double mLongitude) {
		super();
		this.name = mName;
		this.phone = phone;
		this.latitude = mLatitude;
		this.longitude = mLongitude;
	}
	
	public CanteenInfo() {
		super();
		this.name = "";
		this.phone = "";
		this.latitude = 1;
		this.longitude = 1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String name;
	public String phone;
	public double latitude;				//¾«¶È
	public double longitude;				//Î³¶È
	
	
}
