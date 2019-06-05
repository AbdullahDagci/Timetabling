package PROJE;

public class Etkinlik {
	private final int etkinlikId;
	private final int sinifId;
	private final int dersId;
	private int hocaId;
	private int zamanId;
	private int derslikId;

	public Etkinlik(int etkinlikId, int sinifId, int dersId) {
		this.etkinlikId = etkinlikId;
		this.dersId = dersId;
		this.sinifId = sinifId;
	}

	public void hocaEkle(int hocaId) {
		this.hocaId = hocaId;
	}


	public void zamanEkle(int zamanId) {
		this.zamanId = zamanId;
	}


	public void setDerslikId(int derslikId) {
		this.derslikId = derslikId;
	}

	
	public int getEtkinlikId() {
		return this.etkinlikId;
	}

	
	public int getSinifId() {
		return this.sinifId;
	}


	public int getDersId() {
		return this.dersId;
	}


	public int getHocaId() {
		return this.hocaId;
	}

	
	public int getZamanId() {
		return this.zamanId;
	}

	
	public int getDerslikId() {
		return this.derslikId;
	}
}
