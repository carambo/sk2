package parking.house.model;

public class Motorcycle extends Vehicle {
	int horsepower;

	public Motorcycle(DrivingLicenseType dlt, int numberOfWheels,
			String licensePlate, String type, int horsepower) {
		super(dlt, numberOfWheels, licensePlate, type);
		this.horsepower = horsepower;
	}

	@Override
	public String toString() {
		return "Motorcycle [horsepower=" + horsepower + ", getId()=" + getId()
				+ ", getDlt()=" + getDlt() + ", getNumberOfWheels()="
				+ getNumberOfWheels() + ", getLicensePlate()="
				+ getLicensePlate() + ", getType()=" + getType() + "]";
	}

}

// spytat sa doda ci mam nastavit getters a setters pre premenne specificke pre danu triedu/typ auta