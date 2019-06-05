package PROJE;


public class Sinif {
	private final int sinifId;
	private final int ogrenciSayisi;
	private final int dersIdListesi[];


	public Sinif(int sinifId, int ogrenciSayisi, int dersIdListesi[]) {
		this.sinifId = sinifId;
		this.ogrenciSayisi = ogrenciSayisi;
		this.dersIdListesi = dersIdListesi;
	}

	

	public int getSinifId() {
		return this.sinifId;
	}


	public int getGroupSize() {
		return this.ogrenciSayisi;
	}


	public int[] getDersIdleri() {
		return this.dersIdListesi;
	}
}
