package parking.house.model;


public class Lorry extends Vehicle {
	
	int maxLoad;

	public Lorry(DrivingLicenseType dlt, int numberOfWheels,
			String licensePlate, String type, int maxLoad) {
		super(dlt, maxLoad, licensePlate, type);// here were 2 licensePlates,now one is deleted and replaced by type-first bug fixed 
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
