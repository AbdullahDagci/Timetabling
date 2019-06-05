package PROJE;

public class Hoca {
	private final int hocaId;
	private final String hocaAdi;

	public Hoca(int hocaId, String hocaAdi) {
		this.hocaId = hocaId;
		this.hocaAdi = hocaAdi;
	}


	public int getHocaId() {
		return this.hocaId;
	}

	
	public String getHocaAdi() {
		return this.hocaAdi;
	}
}
