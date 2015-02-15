package parking.house.model;

public class Lorry extends Vehicle { 
	int maxLoad;

	public Lorry(DrivingLicenseType dlt, int numberOfWheels,
			String licensePlate, String type, int maxLoad) {
		super(dlt, numberOfWheels, licensePlate, type);
		this.maxLoad = maxLoad;
	}

	@Override
	public String toString() {
		return "Lorry [maxLoad=" + maxLoad + ", getId()=" + getId()
				+ ", getDlt()=" + getDlt() + ", getNumberOfWheels()="
				+ getNumberOfWheels() + ", getLicensePlate()="
				+ getLicensePlate() + ", getType()=" + getType() + "]";
	}
} 