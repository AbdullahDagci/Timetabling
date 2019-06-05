package PROJE;

public class Derslik {
	private final int derslikId;
	private final String derslikAdi;
	private final int derslikKapasitesi;


	public Derslik(int derslikId, String derslikAdi, int derslikKapasitesi) {
		this.derslikId = derslikId;
		this.derslikAdi = derslikAdi;
		this.derslikKapasitesi = derslikKapasitesi;
	}

	public int getDerslikId() {
		return this.derslikId;
	}

	public String getDerslikAdi() {
		return this.derslikAdi;
	}


	public int getderslikKapasitesi() {
		return this.derslikKapasitesi;
	}
}