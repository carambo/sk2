package parkovisko_evidencia__package;

public class Kupe extends TypAuta {
	
	private double vykon;
	private boolean maSpoiler;
	
	public Kupe( boolean zrazaMacky, String macky, int dlzkaStatia, String nazovAuta, String farba, double vykon, boolean maSpoiler) {
		super(zrazaMacky, macky, dlzkaStatia, nazovAuta, farba);
		this.vykon = vykon;
		this.maSpoiler = maSpoiler;
		}
 
	// zaciatok get a set
	
	public double getvykon() {
		return vykon;
	}
	
	public void setvykon(double vykon) {
		this.vykon = vykon;
	}
	
	
	public boolean getmaSpoiler() {
		return maSpoiler;
	}
	
	public void setmaSpoiler(boolean maSpoiler) {
	this.maSpoiler = maSpoiler;
	}
	
	// koniec set a get
	
	
	
	@Override
	public String toString() {
		return "Kupe ma vykon " + getvykon() + " koni a ma spoiler : " + getmaSpoiler();
	}
}
