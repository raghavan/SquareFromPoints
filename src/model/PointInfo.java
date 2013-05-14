package model;

import util.Utility;


public class PointInfo {
	private float latitude;
	private float longitude;
	
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public int getLongitudeWoDec() {
		return Utility.getOnlyNumber(getLongitude());
	}
	public int getLatitudeWoDec() {
		return Utility.getOnlyNumber(getLatitude());
	}
	
	@Override
	public String toString() {
		return latitude +","+ longitude;
	}	
	
}
