package PROJE;

public class GenetikAlgoritma {

	private int populasyonBuyuklugu;
	private double mutasyonOrani;
	private double caprazlamaOrani;
	private int seckinKromozomSayisi;
	protected int turnuvaSecimBoyutu;

	public GenetikAlgoritma(int populasyonBuyuklugu, double mutasyonOrani, double caprazlamaOrani, int seckinKromozomSayisi, int turnuvaSecimBoyutu) {
		this.populasyonBuyuklugu = populasyonBuyuklugu;
		this.mutasyonOrani = mutasyonOrani;
		this.caprazlamaOrani = caprazlamaOrani;
		this.seckinKromozomSayisi = seckinKromozomSayisi;
		this.turnuvaSecimBoyutu = turnuvaSecimBoyutu;
	}


	public Populasyon baslangicPopulasyonuOlustur(Veri veri) {
		Populasyon populasyon = new Populasyon(this.populasyonBuyuklugu, veri);
		return populasyon;
	}

	public boolean sonlanmaKosulu(int nesilSayisi, int maksimumnNesilSayisi) {
		return (nesilSayisi > maksimumnNesilSayisi);
	}

	public boolean sonlanmaKosulu(Populasyon populasyon) {
		return populasyon.getPopulasyonUygunluk(0).getKromozomUygunluk() == 1.0;
	}

	//derslik kapasitesi ve öðrenci sayisi kýsýtý deðerlendirilmesi.
	public double uygunlukDegeriHesapla(Kromozom kromozom, Veri veri) {

		Veri veritabani = new Veri(veri);
		veritabani.setEtkinlik(kromozom);

		int tutarsizlikSayisi = veritabani.karsilastirDerslikOgrS();
		double uygunluk = 1 / (double) (tutarsizlikSayisi + 1);

		kromozom.setUygunluk(uygunluk);
		return uygunluk;
	}

	public void populasyonUygunlukHesapla(Populasyon populasyon, Veri veri) {
		double populasyonUygunlukDegeri = 0;

		for (Kromozom kromozom : populasyon.getKromozomListesi()) {
			populasyonUygunlukDegeri += this.uygunlukDegeriHesapla(kromozom, veri);
			//koromozomlarýn uygunluk deðeri hesaplanýyor ve toplam populasyonun uygunluðu oluþturuluyor.
		}

		populasyon.setPopulasyonUygunlukDegeri(populasyonUygunlukDegeri);
	}

	//turnuva secim boyutu ile ilk 5 kromozomu seçtik.
	public Kromozom ebeveynKromozomSecimi(Populasyon populasyon) {
		
		Populasyon turnuva = new Populasyon(this.turnuvaSecimBoyutu);//5 kromozom içeren populasyon.
		
		populasyon.populasyonSirala();//populasyondaki kromozomlarýn siraladýk.
		
		for (int i = 0; i < this.turnuvaSecimBoyutu; i++) {
			Kromozom k = populasyon.getKromozom(i);//ana populasyondan sýrayla ilk 5 kromozomu çekerek seçim popülasyonumuza ekledik.
			turnuva.setKromozom(i, k);
		}
		return turnuva.getPopulasyonUygunluk(0);
		//seçim populasyonumuzun uygunluðunu hesapladýk. sýfýr indisli olan uygunluk deðeri iyi olandýr.
		//kromozomlarýn uygunluk deðerlerini hesaplayýp en uygununu döndürdük.
	}

	public Populasyon populasyonMutasyonu(Populasyon populasyon, Veri veri) {
		Populasyon yeniOlusanPopulasyon = new Populasyon(this.populasyonBuyuklugu);
		
		for (int kromozomNo = 0; kromozomNo < populasyon.getPopulasyonbuyuklugu(); kromozomNo++) {
			
			Kromozom kromozom = populasyon.getPopulasyonUygunluk(kromozomNo);
			
			Kromozom k = new Kromozom(veri);
			
			for (int i = 0; i < kromozom.getKromozomUzunlugu(); i++) {

				if (kromozomNo > this.seckinKromozomSayisi) {//seçkin kromozomlara mutasyon uygulanmayacak.
					if (this.mutasyonOrani > Math.random()) {
						kromozom.setGen(i, k.setGen(i));//içerdeki get olacak
					}
				}
			}
			yeniOlusanPopulasyon.setKromozom(kromozomNo, kromozom);
		}
		return yeniOlusanPopulasyon;
	}

	public Populasyon populasyonCaprazlama(Populasyon populasyon) {
		
		Populasyon yeniOlusanPopulasyon = new Populasyon(populasyon.getPopulasyonbuyuklugu());

		for (int kromozomNo = 0; kromozomNo < populasyon.getPopulasyonbuyuklugu(); kromozomNo++) {
			
			Kromozom ebeveyn1 = populasyon.getPopulasyonUygunluk(kromozomNo);////Siralama fonksiyonu ile en iyi kromozom ebevayn seçilir....
			
			if (this.caprazlamaOrani > Math.random() && kromozomNo > this.seckinKromozomSayisi) {

				Kromozom cocukKromozom = new Kromozom(ebeveyn1.getKromozomUzunlugu());
				
				Kromozom ebeveyn2 = ebeveynKromozomSecimi(populasyon);//en iyi uygunluk deðerine sahip  ikinci kromozom.

				for (int genNo = 0; genNo < ebeveyn1.getKromozomUzunlugu(); genNo++) {

					if (0.5 > Math.random()) {
						cocukKromozom.setGen(genNo, ebeveyn1.setGen(genNo));
					} else {
						cocukKromozom.setGen(genNo, ebeveyn2.setGen(genNo));
					}
				}

				yeniOlusanPopulasyon.setKromozom(kromozomNo, cocukKromozom);
			} else {

				yeniOlusanPopulasyon.setKromozom(kromozomNo, ebeveyn1);
			}
		}
		return yeniOlusanPopulasyon;
	}

}
