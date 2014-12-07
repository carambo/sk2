package parkovisko_evidencia__package;

public class TypAuta {

	// program este obsahuje String macky, ktory zatial nie je pouzity, je
	// zadefinovany tiez v Kupe a Sedan class

	private boolean zrazaMacky; // :)
	private String macky; // doplnil som String macky, potom sa pomocou
							// ternarneho operatoru rozhodne ci auto zraza macky
							// alebo nie a podla toho sa nastavi hodnota macky,
							// potom sa to na konic vypise na obrazovku
	private int dlzkaStatia;
	private String nazovAuta;
	private String farba;

	public TypAuta(boolean zrazaMacky, String macky, int dlzkaStatia,
			String nazovAuta, String farba) {
		this.zrazaMacky = zrazaMacky;
		this.macky = macky;
		this.dlzkaStatia = dlzkaStatia;
		this.nazovAuta = nazovAuta;
		this.farba = farba;
	}

	// get a set zaciatok

	public boolean getzrazaMacky() {
		return zrazaMacky;
	}

	public void setzrazaMacky(boolean zrazaMacky) {
		this.zrazaMacky = zrazaMacky;
	}

	public int getdlzkaStatia() {
		return dlzkaStatia;
	}

	public void setdlzkaStatia(int dlzkaStatia) {
		this.dlzkaStatia = dlzkaStatia;
	}

	public String getnazovAuta() {
		return nazovAuta;
	}

	public void setnazovAuta(String nazovAuta) {
		this.nazovAuta = nazovAuta;
	}

	public String getfarba() {
		return farba;
	}

	public void setFarba(String farba) {
		this.farba = farba;
	}

	public String getmacky() {
		return macky;
	}

	public void setmacky(String macky) {
		this.macky = macky;
	}

	// get a set koniec

	public void setMackyString() {
		if (zrazaMacky = true)
			macky = " a zraza macky";
		else
			macky = " a nezraza macky";
	}

	@Override
	public String toString() {
		setMackyString();
		return "Prave zaparkovalo " + getnazovAuta() + ", farba je "
				+ getfarba() + " stat by tu malo " + getdlzkaStatia()
				+ " minut" + macky;
	}
}
