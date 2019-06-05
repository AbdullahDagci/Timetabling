package PROJE;

import java.util.HashMap;


public class Veri {
	private final HashMap<Integer, Derslik> derslikler;
	private final HashMap<Integer, Hoca> hocalar;
	private final HashMap<Integer, Ders> dersler;
	private final HashMap<Integer, Sinif> siniflar;
	private final HashMap<Integer, Zaman> zamanlar;
	private Etkinlik etkinliklerListesi[];

	private int dersSayisi = 0;


	public Veri() {
		this.derslikler = new HashMap<Integer, Derslik>();
		this.hocalar = new HashMap<Integer, Hoca>();
		this.dersler = new HashMap<Integer, Ders>();
		this.siniflar = new HashMap<Integer, Sinif>();
		this.zamanlar = new HashMap<Integer, Zaman>();
	}


	public Veri(Veri veri) {
		this.derslikler = veri.getDerslikler();
		this.hocalar = veri.getHocalar();
		this.dersler = veri.getDersler();
		this.siniflar = veri.getSiniflar();
		this.zamanlar = veri.getZamanlar();
	}

	private HashMap<Integer, Sinif> getSiniflar() {
		return this.siniflar;
	}

	private HashMap<Integer, Zaman> getZamanlar() {
		return this.zamanlar;
	}

	private HashMap<Integer, Ders> getDersler() {
		return this.dersler;
	}

	private HashMap<Integer, Hoca> getHocalar() {
		return this.hocalar;
	}
    
	
	public void sil(int key) {
		this.derslikler.remove(key);
	}
	


	public void derslikEkle(int derslikId, String derslikAdi, int derslikKapasite) {
		this.derslikler.put(derslikId, new Derslik(derslikId, derslikAdi, derslikKapasite));
	}


	public void hocaEkle(int hocaId, String hocaAdi) {
		this.hocalar.put(hocaId, new Hoca(hocaId, hocaAdi));
	}
	
	

	public void dersEkle(int dersId, String dersKodu, String dersAdi, int hocaIdListesi[],int dersKredi,int krediSayac) {
		this.dersler.put(dersId, new Ders(dersId, dersKodu, dersAdi, hocaIdListesi,dersKredi,krediSayac));
	}


	public void sinifEkle(int sinifId, int ogrenciSayisi, int dersIdlerListesi[]) {
		this.siniflar.put(sinifId, new Sinif(sinifId, ogrenciSayisi, dersIdlerListesi));
		this.dersSayisi = 0;
	}


	public void zamanEkle(int zamanId, String zamanAdi) {
		this.zamanlar.put(zamanId, new Zaman(zamanId, zamanAdi));
	}

	
	public void setEtkinlik(Kromozom kromozom) {
		Etkinlik etkinliklerListesi[] = new Etkinlik[this.getDersSayisi()];

		int genListesi[] = kromozom.getKromozom();
		int kromozomPozisyonu = 0;
		int etkinlikIndeks = 0;

		for (Sinif sinif : this.getSiniflarinDersListesi()) {
			int dersIdlerListesi[] = sinif.getDersIdleri();
			for (int dersId : dersIdlerListesi) {
				etkinliklerListesi[etkinlikIndeks] = new Etkinlik(etkinlikIndeks, sinif.getSinifId(), dersId);
				

				etkinliklerListesi[etkinlikIndeks].zamanEkle(genListesi[kromozomPozisyonu]);
				kromozomPozisyonu++;

				etkinliklerListesi[etkinlikIndeks].setDerslikId(genListesi[kromozomPozisyonu]);
				kromozomPozisyonu++;

				etkinliklerListesi[etkinlikIndeks].hocaEkle(genListesi[kromozomPozisyonu]);
				kromozomPozisyonu++;

				etkinlikIndeks++;
			}
		}
		this.etkinliklerListesi = etkinliklerListesi;
	}


	public Derslik getDerslik(int derslikId) {		
		return (Derslik) this.derslikler.get(derslikId);
	}

	public HashMap<Integer, Derslik> getDerslikler() {
		return this.derslikler;
	}


	public Derslik getRastgeleDerslik() {
		Object[] dersliklerListesi = this.derslikler.values().toArray();
		Derslik derslik = (Derslik) dersliklerListesi[(int) (dersliklerListesi.length * Math.random())];
		return derslik;
	}

	
	public Hoca getHoca(int hocaId) {
		return (Hoca) this.hocalar.get(hocaId);
	}


	public Ders getDers(int dersId) {
		return (Ders) this.dersler.get(dersId);
	}

	
	
	public int[] getSiniflarinDersleri(int sinifId) {
		Sinif sinif = (Sinif) this.siniflar.get(sinifId);
		return sinif.getDersIdleri();
	}

	
	public Sinif getSinif(int sinifId) {
		return (Sinif) this.siniflar.get(sinifId);
	}

	
	public Sinif[] getSiniflarinDersListesi() {
		return (Sinif[]) this.siniflar.values().toArray(new Sinif[this.siniflar.size()]);
	}

	
	public Zaman getZaman(int zamanId) {
		return (Zaman) this.zamanlar.get(zamanId);
	}

	
	public Zaman getRastgeleZaman() {
		Object[] zamanListesi = this.zamanlar.values().toArray();
		Zaman zaman = (Zaman) zamanListesi[(int) (zamanListesi.length * Math.random())];
		
		return zaman;
	}


	public Etkinlik[] getEtkinlik() {
		return this.etkinliklerListesi;
	}

	
	public int getDersSayisi() {
		if (this.dersSayisi > 0) {
			return this.dersSayisi;
		}

		int dersSayisi = 0;
		Sinif sinifListesi[] = (Sinif[]) this.siniflar.values().toArray(new Sinif[this.siniflar.size()]);
		for (Sinif sinif : sinifListesi) {
			dersSayisi += sinif.getDersIdleri().length;
		}
		this.dersSayisi = dersSayisi;

		return this.dersSayisi;
	}

	
	public int karsilastirDerslikOgrS() {//derslik kapasitesi ve öðrenci sayisi kontrolü yapýlýyor.
		int cakismaSayisi = 0;

		for (Etkinlik Ders1 : this.etkinliklerListesi) {

			int derslikKapasitesi = this.getDerslik(Ders1.getDerslikId()).getderslikKapasitesi();
			int ogrenciSayisi = this.getSinif(Ders1.getSinifId()).getGroupSize();


			if (derslikKapasitesi <= ogrenciSayisi) {
				cakismaSayisi++;
			}


			for (Etkinlik Ders2 : this.etkinliklerListesi) {
				if (Ders1.getDerslikId() == Ders2.getDerslikId() && Ders1.getZamanId() == Ders2.getZamanId()
						&& Ders1.getEtkinlikId() != Ders2.getEtkinlikId()) {
					cakismaSayisi++;
					break;
				}
			}


			for (Etkinlik Ders2 : this.etkinliklerListesi) {
				if (Ders1.getHocaId() == Ders2.getHocaId() && Ders1.getZamanId() == Ders2.getZamanId()
						&& Ders1.getEtkinlikId() != Ders2.getEtkinlikId()) {
					cakismaSayisi++;
					break;
				}
			}

			for (Etkinlik Ders2 : this.etkinliklerListesi) {
				if (Ders1.getSinifId() == Ders2.getSinifId() && Ders1.getZamanId() == Ders2.getZamanId()
						&& Ders1.getEtkinlikId() != Ders2.getEtkinlikId()) {
					cakismaSayisi++;
					break;
				}
			}
		}
		return cakismaSayisi;
	}





	
}