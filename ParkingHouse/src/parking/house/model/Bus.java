package parking.house.model;

public class Bus extends Vehicle {
	int busSeats; // number of seats in the bus

	public Bus(DrivingLicenseType dlt, int numberOfWheels, String licensePlate,
			String type, int busSeats) {
		super(dlt, numberOfWheels, licensePlate, type);
		this.busSeats = busSeats;
	}

	@Override
	public String toString() {
		return "Bus [busSeats=" + busSeats + ", getId()=" + getId()
				+ ", getDlt()=" + getDlt() + ", getNumberOfWheels()="
				+ getNumberOfWheels() + ", getLicensePlate()="
				+ getLicensePlate() + ", getType()=" + getType() + "]";
	}

}
