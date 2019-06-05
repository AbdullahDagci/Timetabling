package PROJE;

public class Zaman {
	private final int zamanId;
	private final String zamanAdi;

	public Zaman(int zamanId, String zamanAdi) {
		this.zamanId = zamanId;
		this.zamanAdi = zamanAdi;
	}


	public int getZamanId() {
		return this.zamanId;
	}


	public String getZamanAdi() {
		return this.zamanAdi;
	}
}
