package parking.house.model;

public class Vehicle {

	private int id;
	private int stayTime;
	private DrivingLicenseType dlt;
	private String licensePlate;
	private String vehType;
	private String vehColor;

	public Vehicle(int id, DrivingLicenseType dlt, int stayTime,
			String vehType, String vehColor, String licensePlate) {
		this.id = id;
		this.dlt = dlt;
		this.stayTime = stayTime;
		this.vehType = vehType;
		this.vehColor = vehColor;
		this.licensePlate = licensePlate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStayTime() {
		return stayTime;
	}

	public void setStayTime(int stayTime) {
		this.stayTime = stayTime;
	}

	public DrivingLicenseType getDlt() {
		return dlt;
	}

	public void setDlt(DrivingLicenseType dlt) {
		this.dlt = dlt;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getVehType() {
		return vehType;
	}

	public void setVehType(String vehType) {
		this.vehType = vehType;
	}

	public String getVehColor() {
		return vehColor;
	}

	public void setVehColor(String vehColor) {
		this.vehColor = vehColor;
	}

}