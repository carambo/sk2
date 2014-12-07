package parking.house.model;


public class Lorry extends Vehicle {
	
	int maxLoad;

	public Lorry(DrivingLicenseType dlt, int numberOfWheels,
			String licensePlate, String type, int maxLoad) {
		super(dlt, maxLoad, licensePlate, licensePlate);
		this.maxLoad = maxLoad;
	}
	
	
	

}
