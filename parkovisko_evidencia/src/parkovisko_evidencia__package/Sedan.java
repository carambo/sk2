package parkovisko_evidencia__package;

public class Sedan extends TypAuta { // pise error
	


	private double dlzka;
	private boolean osobnySofer;
	
	public Sedan( boolean zrazaMacky, String macky, int dlzkaStatia, String nazovAuta, String farba, double dlzka, boolean osobnySofer ) {
		super( zrazaMacky, macky, dlzkaStatia, nazovAuta, farba ); // tu som vypisal premenne z triedy TypAuta
		this.dlzka = dlzka;
		this.osobnySofer = osobnySofer;
	}
	
	// zaciatok set a get
	
	public double getdlzka() {
		return dlzka;
	}
	
	public void setdlzka(double dlzka ) {
		this.dlzka = dlzka;
	}
	
	
	public boolean getosobnySofer() {
		return osobnySofer;
	}
	
	public void setosobnySofer( boolean osobnySofer ) {
		this.osobnySofer = osobnySofer;
	}
	
	// koniec set a get
	
	@Override
	public String toString() {
		return "Sedan je dlhy " + getdlzka() + " metrov a ma osobneho sofera : " + getosobnySofer(); // v takomto pripade som este boolean nepozuival, takze neviem co od neho cakat pri vystupe
	}
}
