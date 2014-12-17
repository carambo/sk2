package parking.house.model;

public class Vehicle {

	private long id;
	private DrivingLicenseType dlt;
	private int numberOfWheels;
	private String licensePlate;
	private String type;

	public Vehicle(DrivingLicenseType dlt, int numberOfWheels,
			String licensePlate, String type) {
		this.dlt = dlt;
		this.numberOfWheels = numberOfWheels;
		this.licensePlate = licensePlate;
		this.type = type;
	}

	// source to generate getters and setters
	// ctrl shift f formatovanie
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DrivingLicenseType getDlt() {
		return dlt;
	}

	public void setDlt(DrivingLicenseType dlt) {
		this.dlt = dlt;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", dlt=" + dlt + ", numberOfWheels="
				+ numberOfWheels + ", licensePlate=" + licensePlate + ", type="
				+ type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dlt == null) ? 0 : dlt.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((licensePlate == null) ? 0 : licensePlate.hashCode());
		result = prime * result + numberOfWheels;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vehicle) {
			if (this.id == ((Vehicle) obj).getId())
				return true;
			else
				return false;
		}
		return false;
	}
}
