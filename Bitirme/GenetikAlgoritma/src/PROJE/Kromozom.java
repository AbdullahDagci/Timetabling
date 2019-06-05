package PROJE;


public class Kromozom {

	private int[] genListesi;
	private double kromozomUygunlukDegeri = -1;

	
	public Kromozom(Veri veri) {
		int dersSayisi = veri.getDersSayisi();
		
		//kromozomun genleri
		int genSayisi = dersSayisi * 3;
		int genListesi[] = new int[genSayisi];
		int kromozomIndis = 0;
		
		//1-2-3 ve 4. sýnýflara dersler ve zamanlar atanýr.
		for (Sinif sinif : veri.getSiniflarinDersListesi()) {

			for (int dersId : sinif.getDersIdleri()) {
				//Gen içeriði = zaman-derslik-ders
				int zamanId = veri.getRastgeleZaman().getZamanId();
				genListesi[kromozomIndis] = zamanId;
				kromozomIndis++;

				int derslikId = veri.getRastgeleDerslik().getDerslikId();
				genListesi[kromozomIndis] = derslikId;
				kromozomIndis++;

	
				Ders ders = veri.getDers(dersId);
				genListesi[kromozomIndis] = ders.getRastgeleHocaId();
				kromozomIndis++;
			}
		}

		this.genListesi = genListesi;
	}


	public Kromozom(int genSayisi) {
		int[] genListesi;
		genListesi = new int[genSayisi];

		for (int i = 0; i < genSayisi; i++) {
			genListesi[i] = i;
		}

		this.genListesi = genListesi;
	}

	public Kromozom(int[] genListesi) {
		this.genListesi = genListesi;
	}


	public int[] getKromozom() {
		return this.genListesi;
	}


	public int getKromozomUzunlugu() {
		return this.genListesi.length;
	}


	public void setGen(int offset, int i) {
		this.genListesi[offset] = i;
	}


	public int setGen(int indis) {
		return this.genListesi[indis];
	}

	
	public void setUygunluk(double kromozomUygunlukDegeri) {
		this.kromozomUygunlukDegeri = kromozomUygunlukDegeri;
	}

	public double getKromozomUygunluk() {
		return this.kromozomUygunlukDegeri;
	}

	public String kromozomuYazdir() {
		String kromozom = "";
		for (int i = 0; i < this.genListesi.length; i++) {
			kromozom += this.genListesi[i] + " ";
		}
		return kromozom;
	}

	
	public boolean genKontrolu(int i) {
		for (int j = 0; j < this.genListesi.length; j++) {
			if (this.genListesi[i] == j) {
				return true;
			}
		}
		return false;
	}

}
