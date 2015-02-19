package parking.house.model;

public class Car extends Vehicle {
	public int passengers;

	public Car(DrivingLicenseType dlt, int numberOfWheels, String licensePlate,
			String type, int pocetOsob) {
		super(dlt, numberOfWheels, licensePlate, type);

		this.passengers = pocetOsob;
	}
	
	@Override
	public String toString() {
		return "Car [passengers=" + passengers + ", getId()=" + getId()
				+ ", getDlt()=" + getDlt() + ", getNumberOfWheels()="
				+ getNumberOfWheels() + ", getLicensePlate()="
				+ getLicensePlate() + ", getType()=" + getType() + "]";
	}

	
	

	
}
